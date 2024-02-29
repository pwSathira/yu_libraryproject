package yorku.eecs.logic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.swing.ImageIcon;

public class ImageProcessor {
    public static ImageIcon darkenImageIcon(ImageIcon originalIcon, float scaleFactor) {
        BufferedImage originalImage = new BufferedImage(
                originalIcon.getIconWidth(),
                originalIcon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = originalImage.createGraphics();
        originalIcon.paintIcon(null, g, 0, 0);
        g.dispose();
        float[] scales = { scaleFactor, scaleFactor, scaleFactor, 1.0f };
        float[] offsets = new float[4];
        RescaleOp rescaleOp = new RescaleOp(scales, offsets, null);
        BufferedImage darkenedImage = rescaleOp.filter(originalImage, null);
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

