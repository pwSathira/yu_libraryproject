package yorku.eecs.logic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.swing.ImageIcon;

public class ImageProcessor {
    public static ImageIcon darkenImageIcon(ImageIcon originalIcon, float scaleFactor) {
        BufferedImage originalImage = toBufferedImage(originalIcon.getImage());
        RescaleOp op = new RescaleOp(scaleFactor, 0, null);
        BufferedImage darkenedImage = op.filter(originalImage, null);
        return new ImageIcon(darkenedImage);
    }
    private static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
            Image img = icon.getImage();
            Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
    }
}

