import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.lang.Math;

public class Calc {
	
	static Container pane;
	static JFrame frame;
	static JPanel panel;
	static JPanel cPanel;
	static JButton[] button;
	static JTextField field;
	static Font font;
	static String tValue;
	static String bValue;

	
	public Calc() {
		frame = new JFrame("Calculator");
		panel = new JPanel();
		cPanel = new JPanel();
		button = new JButton[24];
		field = new JTextField(10);
		font = new Font("Sans Seriff", Font.PLAIN, 30);
	}	
	
	public void setField() {
		field.addKeyListener(new delText());
		field.addActionListener(new FieldSize() {});
		field.setFont(font);
		field.setHorizontalAlignment(SwingConstants.RIGHT);	
		field.setText("");
	}
	
	public void setPanel() {
		panel.add(field);
		panel.add(cPanel);
	}
	
	public void setCPanel() {
		cPanel.setLayout(new GridLayout(6,4));
		cPanel.setBorder(new EmptyBorder(10,30,30,30));
		cPanel.setPreferredSize(new Dimension(300,400));
		cPanel.setMinimumSize(new Dimension(300,400));
		cPanel.setMaximumSize(new Dimension(300,400));
	}
	
	public void setPane() {
		pane = frame.getContentPane();	
		pane.setLayout(new BorderLayout());
		pane.add(panel, BorderLayout.NORTH);
		pane.add(cPanel, BorderLayout.CENTER);
	}
	
	public void buttonLayout() {
		buttonLayout(cPanel, button);
	}
	
	public void setFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.add(panel);
		frame.setResizable(false);
		frame.setVisible(true);		
	}
	
	public void buttonClick() {
		 
		button[0].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn0(e);}});
		button[1].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn1(e);}});
		button[2].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn2(e);}});
		button[3].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn3(e);}});
		button[4].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn4(e);}});
		button[5].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn5(e);}});
		button[6].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn6(e);}});
		button[7].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn7(e);}});
		button[8].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn8(e);}});
		button[9].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn9(e);}});
		button[10].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn10(e);}});
		button[11].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn11(e);}});
		button[12].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn12(e);}});
		button[13].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn13(e);}});
		button[14].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn14(e);}});
		button[15].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn15(e);}});
		button[16].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn16(e);}});
		button[17].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn17(e);}});
		button[18].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn18(e);}});
		button[19].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn19(e);}});
		button[20].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn20(e);}});
		button[21].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn21(e);}});
		button[22].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn22(e);}});
		button[23].addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {btn23(e);}});
	}
	
	private Component buttonLayout(JPanel cPanel, JButton[] button) {
		
		button[0] = new JButton("%");button[1] = new JButton("CE");button[2] = new JButton("C");button[3] = new JButton("<");
		button[4] = new JButton("1/x");button[5] = new JButton("sqr");button[6] = new JButton("sqrt");button[7] = new JButton("/");
		button[8] = new JButton("7");button[9] = new JButton("8");button[10] = new JButton("9");button[11] = new JButton("+");
		button[12] = new JButton("4");button[13] = new JButton("5");button[14] = new JButton("6");button[15] = new JButton("X");
		button[16] = new JButton("1");button[17] = new JButton("2");button[18] = new JButton("3");button[19] = new JButton("-");
		button[20] = new JButton("+/-");button[21] = new JButton("0");button[22] = new JButton(".");button[23] = new JButton("=");
		
		
		for (int i = 0; i < 24; i++) {
			cPanel.add(button[i]);
		}
		
		return cPanel;
	}
	
	private void btn0 (ActionEvent e) {
		String text = field.getText();
		float fNum;
		float sum;
		
		if (text.equals("") || text.equals(".")) {
			field.setText(text);
		}
		else  {
			fNum = Float.parseFloat(text.substring(0, text.length()));
			sum = (fNum) / (100);
			text = String.format("%.1g%n", sum);
			field.setText(text);
		}
	}
	private void btn1 (ActionEvent e) {
		field.setText("");
	}
	private void btn2 (ActionEvent e) {
		field.setText("");
	}
	private void btn3 (ActionEvent e) {
		bValue = field.getText();
		tValue = bValue.substring(0, bValue.length() - 1);
		field.setText(tValue);
	}
	private void btn4 (ActionEvent e) {
		double x = 0;
		bValue = field.getText().toString();
		x = 1 / Double.parseDouble(bValue);
		x = Math.round(x);
		bValue = String.valueOf(x);
		field.setText(bValue);
	}
	private void btn5 (ActionEvent e) {
		double x = 0;
		bValue = field.getText().toString();
		x = Math.pow(Double.parseDouble(bValue),2);
		bValue = String.valueOf(x);
		field.setText(bValue);
	}
	private void btn6 (ActionEvent e) {
		double x = 0;
		bValue = field.getText().toString();
		x = Math.sqrt(Double.parseDouble(bValue));
		x = Math.round(x);
		bValue = String.valueOf(x);
		field.setText(bValue);
	}
	private void btn7 (ActionEvent e) {
		
	String temp = field.getText();
	
		if (field.getText().equals("") || temp.endsWith(".") || temp.contains("+") || temp.endsWith("-") 
		|| temp.contains("/") || temp.contains("x")) {
	
		}
		else {
			bValue = button[7].getText().toString();
			tValue = field.getText() + bValue;
			field.setText(tValue);
		}
	}
	private void btn8 (ActionEvent e) {
		bValue = button[8].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	private void btn9 (ActionEvent e) {
		bValue = button[9].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	private void btn10 (ActionEvent e) {
		bValue = button[10].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	private void btn11 (ActionEvent e) {
		
	String temp = field.getText();
		
	if (field.getText().equals("") || temp.endsWith(".") || temp.contains("+") || temp.endsWith("-") 
			|| temp.contains("/") || temp.contains("x")) {
			
		}
		else { 
			bValue = button[11].getText().toString();
			tValue = field.getText() + bValue;
			field.setText(tValue);
		}	
	}
	private void btn12 (ActionEvent e) {
		bValue = button[12].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	private void btn13 (ActionEvent e) {
		bValue = button[13].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	private void btn14 (ActionEvent e) {
		bValue = button[14].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	public void btn15 (ActionEvent e) {
		
		String temp = field.getText();
	
		if (field.getText().equals("") || temp.endsWith(".") || temp.contains("+") || temp.endsWith("-") 
				|| temp.contains("/") || temp.contains("x")) {
			
		}
		else { 
			bValue = button[15].getText().toString();
			tValue = field.getText() + bValue;
			field.setText(tValue.toLowerCase());
		}
	}
	public void btn16 (ActionEvent e) {
		bValue = button[16].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	public void btn17 (ActionEvent e) {
		bValue = button[17].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	public void btn18 (ActionEvent e) {
		bValue = button[18].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	public void btn19 (ActionEvent e) {

		String temp = field.getText();
		
		if (field.getText().equals("") || temp.endsWith(".") || temp.contains("+") || temp.endsWith("-") 
				|| temp.contains("/") || temp.contains("x")) {
			
		}
		else {
			bValue = button[19].getText().toString();
			tValue = field.getText() + bValue;
			field.setText(tValue);
		}
	}
	public void btn20 (ActionEvent e) {
		
		String fNum;
		String sNum;
		String temp = field.getText();
		
		if (temp.equals("")) {
			field.setText("-");
		}
		if (temp.contentEquals("-")) {
			field.setText("");
		}
		else if (temp.equals("-") || temp.endsWith(".")) {
			field.setText(temp);
		}
		else if (!temp.contains("-") && !temp.contains("+") && !temp.contains("x")
				&& !temp.contains("/")) {
			field.setText("-" + temp);
		}
		else if (temp.substring(0, 1).equals("-") && !temp.contains("+") && !temp.contains("/") &&
				!temp.contains("x") && temp.indexOf("-", 1) <= 0) {
			temp = temp.substring(1, temp.length());
			field.setText(temp);
		}
		
		else if (temp.contains("+") && !temp.contains("+-") && !temp.endsWith("+")) {
			fNum = temp.substring(0, temp.indexOf("+"));
			sNum = temp.substring(temp.indexOf("+", 1) + 1, temp.length());
			field.setText(fNum + "+-" + sNum);
		}
		else if (temp.contains("+-")) {
			fNum = temp.substring(0, temp.indexOf("+"));
			sNum = temp.substring(temp.indexOf("+") + 2, temp.length());
			field.setText(fNum + "+" + sNum);
		}
		
		else if (temp.contains("x") && !temp.contains("x-") && !temp.endsWith("x")) {
			fNum = temp.substring(0, temp.indexOf("x"));
			sNum = temp.substring(temp.indexOf("x", 1) + 1, temp.length());
			field.setText(fNum + "x-" + sNum);
		}
		else if (temp.contains("x-")) {
			fNum = temp.substring(0, temp.indexOf("x"));
			sNum = temp.substring(temp.indexOf("x") + 2, temp.length());
			field.setText(fNum + "+" + sNum);
		}
		
		else if (temp.contains("/") && !temp.contains("/-") && !temp.endsWith("/")) {
			fNum = temp.substring(0, temp.indexOf("/"));
			sNum = temp.substring(temp.indexOf("/", 1) + 1, temp.length());
			field.setText(fNum + "/-" + sNum);
		}
		else if (temp.contains("/-")) {
			fNum = temp.substring(0, temp.indexOf("/"));
			sNum = temp.substring(temp.indexOf("/") + 2, temp.length());
			field.setText(fNum + "/" + sNum);
		}
		
		else if (temp.indexOf("-", 1) > 0 && !temp.contains("--") && !temp.endsWith("-")) {
			fNum = temp.substring(0, temp.indexOf("-", 1));
			sNum = temp.substring(temp.indexOf("-", 1) + 1, temp.length());
			field.setText(fNum + "+" + sNum);
		}
		else if (temp.contains("--")) {
			fNum = temp.substring(0, temp.indexOf("--"));
			sNum = temp.substring(temp.indexOf("--") + 1, temp.length());
			field.setText(fNum + "-" + sNum);
		}
		
	}
	public void btn21 (ActionEvent e) {
		bValue = button[21].getText().toString();
		tValue = field.getText() + bValue;
		field.setText(tValue);
	}
	public void btn22 (ActionEvent e) {
	
		String temp = field.getText();
		
		if (temp.endsWith(".")) {
			
		}
		else {		
			bValue = button[22].getText().toString();
			tValue = field.getText() + bValue;
			field.setText(tValue);
		}
	}
	public void btn23 (ActionEvent e) {

		String text = field.getText();
		float fNum;
		float sNum;
		float sum;
		
		if (text.contains("+") && !text.contains("-")) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("+")));
			sNum = Float.parseFloat(text.substring(text.indexOf("+") + 1, text.length()));
			sum = fNum + sNum;
			field.setText(String.valueOf(sum));
		}
		else if (text.contains("+-") && text.indexOf("-") != 0) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("+")));
			sNum = Float.parseFloat(text.substring(text.indexOf("+") + 2, text.length()));
			sum = (fNum) - (sNum);
			field.setText(String.valueOf(sum));
		}
		else if (text.indexOf("-") == 0 && text.contains("+")) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("+")));
			sNum = Float.parseFloat(text.substring(text.indexOf("+") + 1, text.length()));
			sum = (fNum) + (sNum);
			field.setText(String.valueOf(sum));
		}
		
		else if (text.contains("-") && text.indexOf("-") != 0) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("-")));
			sNum = Float.parseFloat(text.substring(text.indexOf("-") + 1, text.length()));
			sum = (fNum) - (sNum);
			field.setText(String.valueOf(sum));
		}
		else if (text.contains("--") && text.indexOf("-") != 0) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("-")));
			sNum = Float.parseFloat(text.substring(text.indexOf("-") + 2, text.length()));
			sum = (fNum) - (sNum);
			field.setText(String.valueOf(sum));
		}
		else if (text.indexOf("-") == 0 && !text.contains("x") && !text.contains("/") && !text.contains("+")) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("-",1)));
			sNum = Float.parseFloat(text.substring(text.indexOf("-", 1) + 1, text.length()));
			sum = (fNum) - (sNum);
			field.setText(String.valueOf(sum));
		}
		
		else if (text.contains("x")) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("x")));
			sNum = Float.parseFloat(text.substring(text.indexOf("x") + 1, text.length()));
			sum = (fNum) * (sNum);
			field.setText(String.valueOf(sum));
		}
		else if (text.contains("x-") && text.indexOf("-") != 0) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("x")));
			sNum = Float.parseFloat(text.substring(text.indexOf("x") + 1, text.length()));
			sum = (fNum) * (sNum);
			field.setText(String.valueOf(sum));
		}
		else if (text.indexOf("-") == 0 && text.contains("x")) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("x")));
			sNum = Float.parseFloat(text.substring(text.indexOf("x") + 1, text.length()));
			sum = (fNum) * (sNum);
			field.setText(String.valueOf(sum));
		}
		
		else if (text.contains("/")) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("/")));
			sNum = Float.parseFloat(text.substring(text.indexOf("/") + 1, text.length()));
			sum = (fNum) / (sNum);
			field.setText(String.valueOf(sum));
		}
		else if (text.contains("/-") && text.indexOf("-") != 0) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("-")));
			sNum = Float.parseFloat(text.substring(text.indexOf("-") + 2, text.length()));
			sum = (fNum) - (sNum);
			field.setText(String.valueOf(sum));
		}
		else if (text.indexOf("-") == 0 && text.contains("/")) {
			fNum = Float.parseFloat(text.substring(0, text.indexOf("/")));
			sNum = Float.parseFloat(text.substring(text.indexOf("/") + 1, text.length()));
			sum = (fNum) * (sNum);
			field.setText(String.valueOf(sum));
		}
	}
}
	


