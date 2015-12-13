package tetofedes;

import java.awt.AWTEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class OnlyNumberTextField extends JTextField {
	
	private static final long serialVersionUID = 1L;
	
	private int columns;

	public OnlyNumberTextField(int columns) {
		super(columns);
		this.columns = columns;
		enableEvents(AWTEvent.KEY_EVENT_MASK);
	}

	public void processKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_TYPED) {
			char c = e.getKeyChar();
			if ((c < '0' || c > '9') & (c != KeyEvent.VK_BACK_SPACE) || (getText().length() == (columns)))
				e.consume();
		}
		else
			if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				e.consume();
		super.processKeyEvent(e);
	}
	
}
