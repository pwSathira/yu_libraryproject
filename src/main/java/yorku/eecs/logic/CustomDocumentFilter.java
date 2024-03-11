package yorku.eecs.logic;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CustomDocumentFilter extends DocumentFilter {
    private static final int MAX_CHARACTERS = 9;

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) {
            return;
        }
        replace(fb, offset, 0, string, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        String newText = text.replaceAll("[^-\\d]", ""); // Remove non-digit, non-dash characters
        StringBuilder fullText = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        fullText.replace(offset, offset + length, newText); // Replace the text in the builder

        // Remove existing dashes for reformatting
        String digitsOnly = fullText.toString().replaceAll("-", "");
        if (digitsOnly.length() > MAX_CHARACTERS) {
            return; // Exit if result exceeds max length
        }

        // Insert dashes appropriately
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < digitsOnly.length(); i++) {
            if (i > 0 && i % 3 == 0) {
                formatted.append("-");
            }
            formatted.append(digitsOnly.charAt(i));
        }

        // Replace the entire document's text with the newly formatted string
        super.replace(fb, 0, fb.getDocument().getLength(), formatted.toString(), attrs);
    }
}
