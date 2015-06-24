package validacao.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LengthRestrictedDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;
	private int limite;
	
	public LengthRestrictedDocument(int limite) {
	    this.limite = limite;
	}

	@Override
	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if ((getLength() + str.length()) <= limite) {
			super.insertString(offs, str, a);
		}
	}
}
