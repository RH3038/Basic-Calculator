 import java.awt.event.*;

public class delText implements KeyListener{

	public void keyPressed(KeyEvent e) {
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		e.consume();	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
	}
}
