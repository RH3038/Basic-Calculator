import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextField extends JTextField {
	
	JTextField field;
	
	public TextField() {
		field = new JTextField();
	}
	
	public TextField(int size) {
		field = new JTextField(size);
	}
	
	
}
