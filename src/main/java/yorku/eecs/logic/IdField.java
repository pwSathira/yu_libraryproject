package yorku.eecs.logic;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

public class IdField extends JTextField {
    public IdField() {
        super();
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new CustomDocumentFilter());
    }

    @Override
    public String getText() {
        return super.getText().replaceAll("-", "");
    }
}
