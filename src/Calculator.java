import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Calculator implements ActionListener {

	JFrame frame;
	JPanel panel;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	
	Font myFont = new Font("MV Boli", Font.PLAIN, 36);
	
	double num1 = 0, num2 = 0, result= 0;
	char operator;
	
	Calculator() {
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i = 0; i < 9; i++) {
			
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(Color.lightGray);
			functionButtons[i].setBorder(BorderFactory.createEtchedBorder());
			functionButtons[i].addActionListener(this);
			
		}
		
		for(int i = 0; i < 10; i++) {
			
//			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i] = new JButton("" + i);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(Color.lightGray);
			numberButtons[i].setBorder(BorderFactory.createEtchedBorder());
			numberButtons[i].addActionListener(this);
			
		}
		
		delButton.setBounds(50, 100, 109, 71);
		clrButton.setBounds(164, 100, 109, 71);
		negButton.setBounds(278, 100, 71, 71);
		
		panel = new JPanel();
		panel.setBounds(49, 176, 301, 300);
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		panel.setBackground(Color.black);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,550);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		
		frame.add(textfield);
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(negButton);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
//				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				textfield.setText(textfield.getText() + i);
			}
		}
		
		if(e.getSource() == decButton) {
			
			if(!textfield.getText().contains(".")) {
				textfield.setText(textfield.getText() + ".");
			}
			
		}
		
		if(e.getSource() == addButton) {
			
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
			
		}
		
		if(e.getSource() == subButton) {
			
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
			
		}

		if(e.getSource() == mulButton) {
			
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
			
		}
		
		if(e.getSource() == divButton) {
			
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
			
		}
		
		if(e.getSource() == equButton) {
			
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			
			case '+': 
				result = num1 + num2;
				break;
			case '-': 
				result = num1 - num2;
				break;
			case '*': 
				result = num1 * num2;
				break;
			case '/': 
				result = num1 / num2;
				break;
			default: 
				result = num2;
			
			}
			
			textfield.setText("" + result);
			
		}
		
		if(e.getSource() == delButton) {
			
			String str = textfield.getText();
			
			if(str.length() > 0) {
				textfield.setText(str.substring(0, str.length() -1));
			}
			
		}
		
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText("" + temp);
		}
		
	}

}
