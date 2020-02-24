/**
 * @author Hansen Li
 *
 * @date Jul 27, 2019
*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;


public class Calculator implements ActionListener {

	private JFrame frame;
	JLabel historyLabel;
	boolean operator;
	JLabel NumberArea;
	JLabel HexLabel;
	JLabel DecLabel;
	JLabel BinLabel;
	JLabel OctLabel;
    private boolean isDouble = false;
    JRadioButton HexButton;
    JRadioButton DecButton;
    JRadioButton BinButton;
    JRadioButton OctButton;
    JLabel textField = new JLabel("DEC");
    JLabel memoryField = new JLabel("");
    JButton btnWord;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private Stack<Character> inputStack = new Stack<>();

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 712);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{73, 73, 73, 73, 73, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 50, 68, 0, 0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 60, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnLsh = new JButton("Lsh");
		btnLsh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel labelHamburger = new JLabel();
		GridBagConstraints gbc_labelHamburger = new GridBagConstraints();
		gbc_labelHamburger.anchor = GridBagConstraints.WEST;
		gbc_labelHamburger.insets = new Insets(0, 0, 0, 0);
		gbc_labelHamburger.gridx = 0;
		gbc_labelHamburger.gridy = 0;
		frame.getContentPane().add(labelHamburger, gbc_labelHamburger);
		labelHamburger.setIcon(new ImageIcon("bars.JPG"));
		
		
		JLabel lblProgrammer = new JLabel("Programmer");
		lblProgrammer.setFont(new Font("Calibri", Font.PLAIN, 23));
		GridBagConstraints gbc_lblProgrammer = new GridBagConstraints();
		gbc_lblProgrammer.anchor = GridBagConstraints.WEST;
		gbc_lblProgrammer.gridwidth = 2;
		gbc_lblProgrammer.insets = new Insets(0, 0, 0, 0);
		gbc_lblProgrammer.gridx = 1;
		gbc_lblProgrammer.gridy = 0;
		frame.getContentPane().add(lblProgrammer, gbc_lblProgrammer);
		
		historyLabel = new JLabel("");
		historyLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		historyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_historyLabel = new GridBagConstraints();
		gbc_historyLabel.gridwidth = 5;
		gbc_historyLabel.fill = GridBagConstraints.BOTH;
		gbc_historyLabel.insets = new Insets(0, 0, 0, 0);
		gbc_historyLabel.gridx = 0;
		gbc_historyLabel.gridy = 1;
		frame.getContentPane().add(historyLabel, gbc_historyLabel);
		
		NumberArea = new JLabel("", JLabel.RIGHT);
		NumberArea.setFont(new Font("Calibri", Font.PLAIN, 49));
		GridBagConstraints gbc_NumberArea = new GridBagConstraints();
		gbc_NumberArea.gridheight = 2;
		gbc_NumberArea.anchor = GridBagConstraints.EAST;
		gbc_NumberArea.gridwidth = 5;
		gbc_NumberArea.insets = new Insets(0, 0, 0, 0);
		gbc_NumberArea.gridx = 0;
		gbc_NumberArea.gridy = 2;
		frame.getContentPane().add(NumberArea, gbc_NumberArea);
		
		JRadioButton HexButton = new JRadioButton("HEX");
		GridBagConstraints gbc_HexButton = new GridBagConstraints();
		gbc_HexButton.insets = new Insets(0, 0, 0, 0);
		gbc_HexButton.gridx = 0;
		gbc_HexButton.gridy = 4;
		frame.getContentPane().add(HexButton, gbc_HexButton);
		
		HexLabel = new JLabel("");
		GridBagConstraints gbc_HexLabel = new GridBagConstraints();
		gbc_HexLabel.insets = new Insets(0, 0, 0, 0);
		gbc_HexLabel.gridx = 1;
		gbc_HexLabel.gridy = 4;
		frame.getContentPane().add(HexLabel, gbc_HexLabel);
		
		JRadioButton DecButton = new JRadioButton("DEC");
		GridBagConstraints gbc_DecButton = new GridBagConstraints();
		gbc_DecButton.insets = new Insets(0, 0, 0, 0);
		gbc_DecButton.gridx = 0;
		gbc_DecButton.gridy = 5;
		frame.getContentPane().add(DecButton, gbc_DecButton);
		DecButton.setSelected(true);
		
		DecLabel = new JLabel("");
		GridBagConstraints gbc_DecLabel = new GridBagConstraints();
		gbc_DecLabel.insets = new Insets(0, 0, 0, 0);
		gbc_DecLabel.gridx = 1;
		gbc_DecLabel.gridy = 5;
		frame.getContentPane().add(DecLabel, gbc_DecLabel);
		
		JRadioButton OctButton = new JRadioButton("OCT");
		GridBagConstraints gbc_OctButton = new GridBagConstraints();
		gbc_OctButton.insets = new Insets(0, 0, 0, 0);
		gbc_OctButton.gridx = 0;
		gbc_OctButton.gridy = 6;
		frame.getContentPane().add(OctButton, gbc_OctButton);
		
		OctLabel = new JLabel("");
		GridBagConstraints gbc_OctLabel = new GridBagConstraints();
		gbc_OctLabel.insets = new Insets(0, 0, 0, 0);
		gbc_OctLabel.gridx = 1;
		gbc_OctLabel.gridy = 6;
		frame.getContentPane().add(OctLabel, gbc_OctLabel);
		
		JRadioButton BinButton = new JRadioButton("BIN");
		GridBagConstraints gbc_BinButton = new GridBagConstraints();
		gbc_BinButton.insets = new Insets(0, 0, 0, 0);
		gbc_BinButton.gridx = 0;
		gbc_BinButton.gridy = 7;
		frame.getContentPane().add(BinButton, gbc_BinButton);
		
		BinLabel = new JLabel("");
		GridBagConstraints gbc_BinLabel = new GridBagConstraints();
		gbc_BinLabel.insets = new Insets(0, 0, 0, 0);
		gbc_BinLabel.gridx = 1;
		gbc_BinLabel.gridy = 7;
		frame.getContentPane().add(BinLabel, gbc_BinLabel);
		
		JLabel labelDots1 = new JLabel();
		GridBagConstraints gbc_labelDots1 = new GridBagConstraints();
		gbc_labelDots1.insets = new Insets(0, 0, 0, 0);
		gbc_labelDots1.gridx = 0;
		gbc_labelDots1.gridy = 8;
		frame.getContentPane().add(labelDots1, gbc_labelDots1);
		labelDots1.setIcon(new ImageIcon("keypad1.png"));
		

		
		JLabel labelDots2 = new JLabel();
		GridBagConstraints gbc_labelDots2 = new GridBagConstraints();
		gbc_labelDots2.insets = new Insets(0, 0, 0, 0);
		gbc_labelDots2.gridx = 1;
		gbc_labelDots2.gridy = 8;
		frame.getContentPane().add(labelDots2, gbc_labelDots2);
		labelDots2.setIcon(new ImageIcon("keypad2.png"));

		
		btnWord = new JButton("QWORD");
		GridBagConstraints gbc_btnWord = new GridBagConstraints();
		gbc_btnWord.fill = GridBagConstraints.BOTH;
		gbc_btnWord.gridwidth = 2;
		gbc_btnWord.insets = new Insets(0, 0, 0, 0);
		gbc_btnWord.gridx = 2;
		gbc_btnWord.gridy = 8;
		frame.getContentPane().add(btnWord, gbc_btnWord);
		btnWord.addActionListener(this);
		
		JLabel labelMS = new JLabel("MS");
		labelMS.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_labelMS = new GridBagConstraints();
		gbc_labelMS.insets = new Insets(0, 0, 0, 0);
		gbc_labelMS.gridx = 4;
		gbc_labelMS.gridy = 8;
		frame.getContentPane().add(labelMS, gbc_labelMS);
		
		JLabel labelMcaron = new JLabel("M⌄");
		labelMcaron.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 8;
		frame.getContentPane().add(labelMcaron, gbc_lblNewLabel);
		GridBagConstraints gbc_btnLsh = new GridBagConstraints();
		gbc_btnLsh.fill = GridBagConstraints.BOTH;
		gbc_btnLsh.insets = new Insets(0, 0, 0, 0);
		gbc_btnLsh.gridx = 0;
		gbc_btnLsh.gridy = 9;
		frame.getContentPane().add(btnLsh, gbc_btnLsh);
		
		JButton btnRsh = new JButton("Rsh");
		GridBagConstraints gbc_btnRsh = new GridBagConstraints();
		gbc_btnRsh.fill = GridBagConstraints.BOTH;
		gbc_btnRsh.insets = new Insets(0, 0, 0, 0);
		gbc_btnRsh.gridx = 1;
		gbc_btnRsh.gridy = 9;
		frame.getContentPane().add(btnRsh, gbc_btnRsh);
		
		JButton btnOr = new JButton("Or");
		GridBagConstraints gbc_btnOr = new GridBagConstraints();
		gbc_btnOr.fill = GridBagConstraints.BOTH;
		gbc_btnOr.insets = new Insets(0, 0, 0, 0);
		gbc_btnOr.gridx = 2;
		gbc_btnOr.gridy = 9;
		frame.getContentPane().add(btnOr, gbc_btnOr);
		
		JButton btnXor = new JButton("Xor");
		GridBagConstraints gbc_btnXor = new GridBagConstraints();
		gbc_btnXor.fill = GridBagConstraints.BOTH;
		gbc_btnXor.insets = new Insets(0, 0, 0, 0);
		gbc_btnXor.gridx = 3;
		gbc_btnXor.gridy = 9;
		frame.getContentPane().add(btnXor, gbc_btnXor);
		
		JButton btnNot = new JButton("Not");
		GridBagConstraints gbc_btnNot = new GridBagConstraints();
		gbc_btnNot.fill = GridBagConstraints.BOTH;
		gbc_btnNot.insets = new Insets(0, 0, 0, 0);
		gbc_btnNot.gridx = 4;
		gbc_btnNot.gridy = 9;
		frame.getContentPane().add(btnNot, gbc_btnNot);
		
		JButton btnAnd = new JButton("And");
		GridBagConstraints gbc_btnAnd = new GridBagConstraints();
		gbc_btnAnd.insets = new Insets(0, 0, 0, 0);
		gbc_btnAnd.fill = GridBagConstraints.BOTH;
		gbc_btnAnd.gridx = 5;
		gbc_btnAnd.gridy = 9;
		frame.getContentPane().add(btnAnd, gbc_btnAnd);
		
		JButton buttonExponent = new JButton("^");
		GridBagConstraints gbc_buttonUpArrow = new GridBagConstraints();
		gbc_buttonUpArrow.fill = GridBagConstraints.BOTH;
		gbc_buttonUpArrow.insets = new Insets(0, 0, 0, 0);
		gbc_buttonUpArrow.gridx = 0;
		gbc_buttonUpArrow.gridy = 10;
		frame.getContentPane().add(buttonExponent, gbc_buttonUpArrow);
		buttonExponent.addActionListener(this);
		
		JButton btnMod = new JButton("%");
		GridBagConstraints gbc_btnMod = new GridBagConstraints();
		gbc_btnMod.fill = GridBagConstraints.BOTH;
		gbc_btnMod.insets = new Insets(0, 0, 0, 0);
		gbc_btnMod.gridx = 1;
		gbc_btnMod.gridy = 10;
		frame.getContentPane().add(btnMod, gbc_btnMod);
		btnMod.addActionListener(this);
		
		JButton btnCe = new JButton("CE");
		btnCe.setFont(new Font("calibri", Font.BOLD, 14));
		GridBagConstraints gbc_btnCe = new GridBagConstraints();
		gbc_btnCe.fill = GridBagConstraints.BOTH;
		gbc_btnCe.insets = new Insets(0, 0, 0, 0);
		gbc_btnCe.gridx = 2;
		gbc_btnCe.gridy = 10;
		frame.getContentPane().add(btnCe, gbc_btnCe);
		btnCe.addActionListener(this);
		
		JButton btnCLR = new JButton("CLR");
		btnCLR.setFont(new Font("calibri", Font.BOLD, 14));
		GridBagConstraints gbc_btnCLR = new GridBagConstraints();
		gbc_btnCLR.fill = GridBagConstraints.BOTH;
		gbc_btnCLR.insets = new Insets(0, 0, 0, 0);
		gbc_btnCLR.gridx = 3;
		gbc_btnCLR.gridy = 10;
		frame.getContentPane().add(btnCLR, gbc_btnCLR);
		btnCLR.addActionListener(this);
		
		JButton buttonBackspace = new JButton("⌫");
		GridBagConstraints gbc_buttonBackspace = new GridBagConstraints();
		gbc_buttonBackspace.fill = GridBagConstraints.BOTH;
		gbc_buttonBackspace.insets = new Insets(0, 0, 0, 0);
		gbc_buttonBackspace.gridx = 4;
		gbc_buttonBackspace.gridy = 10;
		frame.getContentPane().add(buttonBackspace, gbc_buttonBackspace);
		buttonBackspace.addActionListener(this);
		
		JButton buttonDivide = new JButton("/");
		GridBagConstraints gbc_buttonDivide = new GridBagConstraints();
		gbc_buttonDivide.fill = GridBagConstraints.BOTH;
		gbc_buttonDivide.insets = new Insets(0, 0, 0, 0);
		gbc_buttonDivide.gridx = 5;
		gbc_buttonDivide.gridy = 10;
		frame.getContentPane().add(buttonDivide, gbc_buttonDivide);
		buttonDivide.addActionListener(this);
		
		JButton btnA = new JButton("A");
		GridBagConstraints gbc_btnA = new GridBagConstraints();
		gbc_btnA.fill = GridBagConstraints.BOTH;
		gbc_btnA.insets = new Insets(0, 0, 0, 0);
		gbc_btnA.gridx = 0;
		gbc_btnA.gridy = 11;
		frame.getContentPane().add(btnA, gbc_btnA);
		btnA.addActionListener(this);
		
		JButton btnB = new JButton("B");
		GridBagConstraints gbc_btnB = new GridBagConstraints();
		gbc_btnB.fill = GridBagConstraints.BOTH;
		gbc_btnB.insets = new Insets(0, 0, 0, 0);
		gbc_btnB.gridx = 1;
		gbc_btnB.gridy = 11;
		frame.getContentPane().add(btnB, gbc_btnB);
		btnB.addActionListener(this);
		
		JButton button7 = new JButton("7");
		button7.setFont(new Font("calibri", Font.BOLD, 14));
		button7.setBackground(Color.WHITE);
		GridBagConstraints gbc_button7 = new GridBagConstraints();
		gbc_button7.fill = GridBagConstraints.BOTH;
		gbc_button7.insets = new Insets(0, 0, 0, 0);
		gbc_button7.gridx = 2;
		gbc_button7.gridy = 11;
		frame.getContentPane().add(button7, gbc_button7);
		button7.addActionListener(this);
		
		
		JButton button8 = new JButton("8");
		button8.setFont(new Font("calibri", Font.BOLD, 14));
		button8.setBackground(Color.WHITE);
		GridBagConstraints gbc_button8 = new GridBagConstraints();
		gbc_button8.fill = GridBagConstraints.BOTH;
		gbc_button8.insets = new Insets(0, 0, 0, 0);
		gbc_button8.gridx = 3;
		gbc_button8.gridy = 11;
		frame.getContentPane().add(button8, gbc_button8);
		button8.addActionListener(this);
		
		JButton button9 = new JButton("9");
		button9.setFont(new Font("calibri", Font.BOLD, 14));
		button9.setBackground(Color.WHITE);
		GridBagConstraints gbc_button9 = new GridBagConstraints();
		gbc_button9.fill = GridBagConstraints.BOTH;
		gbc_button9.insets = new Insets(0, 0, 0, 0);
		gbc_button9.gridx = 4;
		gbc_button9.gridy = 11;
		frame.getContentPane().add(button9, gbc_button9);
		button9.addActionListener(this);
		
		JButton buttonMultiply = new JButton("*");
		GridBagConstraints gbc_buttonMultiply = new GridBagConstraints();
		gbc_buttonMultiply.fill = GridBagConstraints.BOTH;
		gbc_buttonMultiply.insets = new Insets(0, 0, 0, 0);
		gbc_buttonMultiply.gridx = 5;
		gbc_buttonMultiply.gridy = 11;
		frame.getContentPane().add(buttonMultiply, gbc_buttonMultiply);
		buttonMultiply.addActionListener(this);
		
		JButton btnC = new JButton("C");
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.fill = GridBagConstraints.BOTH;
		gbc_btnC.insets = new Insets(0, 0, 0, 0);
		gbc_btnC.gridx = 0;
		gbc_btnC.gridy = 12;
		btnC.addActionListener(this);
		frame.getContentPane().add(btnC, gbc_btnC);
		
		JButton btnD = new JButton("D");
		GridBagConstraints gbc_btnD = new GridBagConstraints();
		gbc_btnD.fill = GridBagConstraints.BOTH;
		gbc_btnD.insets = new Insets(0, 0, 0, 0);
		gbc_btnD.gridx = 1;
		gbc_btnD.gridy = 12;
		frame.getContentPane().add(btnD, gbc_btnD);
		btnD.addActionListener(this);
		
		JButton button4 = new JButton("4");
		button4.setFont(new Font("calibri", Font.BOLD, 14));
		button4.setBackground(Color.WHITE);
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.fill = GridBagConstraints.BOTH;
		gbc_button4.insets = new Insets(0, 0, 0, 0);
		gbc_button4.gridx = 2;
		gbc_button4.gridy = 12;
		frame.getContentPane().add(button4, gbc_button4);
		button4.addActionListener(this);
		
		JButton button5 = new JButton("5");
		button5.setFont(new Font("calibri", Font.BOLD, 14));
		button5.setBackground(Color.WHITE);
		GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.fill = GridBagConstraints.BOTH;
		gbc_button5.insets = new Insets(0, 0, 0, 0);
		gbc_button5.gridx = 3;
		gbc_button5.gridy = 12;
		frame.getContentPane().add(button5, gbc_button5);
		button5.addActionListener(this);
		
		JButton button6 = new JButton("6");
		button6.setFont(new Font("calibri", Font.BOLD, 14));
		button6.setBackground(Color.WHITE);
		GridBagConstraints gbc_button6 = new GridBagConstraints();
		gbc_button6.fill = GridBagConstraints.BOTH;
		gbc_button6.insets = new Insets(0, 0, 0, 0);
		gbc_button6.gridx = 4;
		gbc_button6.gridy = 12;
		frame.getContentPane().add(button6, gbc_button6);
		button6.addActionListener(this);
		
		JButton buttonMinus = new JButton("-");
		GridBagConstraints gbc_buttonMinus = new GridBagConstraints();
		gbc_buttonMinus.fill = GridBagConstraints.BOTH;
		gbc_buttonMinus.insets = new Insets(0, 0, 0, 0);
		gbc_buttonMinus.gridx = 5;
		gbc_buttonMinus.gridy = 12;
		frame.getContentPane().add(buttonMinus, gbc_buttonMinus);
		buttonMinus.addActionListener(this);
		
		JButton btnE = new JButton("E");
		GridBagConstraints gbc_btnE = new GridBagConstraints();
		gbc_btnE.fill = GridBagConstraints.BOTH;
		gbc_btnE.insets = new Insets(0, 0, 0, 0);
		gbc_btnE.gridx = 0;
		gbc_btnE.gridy = 13;
		frame.getContentPane().add(btnE, gbc_btnE);
		btnE.addActionListener(this);
		
		JButton btnF = new JButton("F");
		GridBagConstraints gbc_btnF = new GridBagConstraints();
		gbc_btnF.fill = GridBagConstraints.BOTH;
		gbc_btnF.insets = new Insets(0, 0, 0, 0);
		gbc_btnF.gridx = 1;
		gbc_btnF.gridy = 13;
		frame.getContentPane().add(btnF, gbc_btnF);
		btnF.addActionListener(this);
		
		JButton button1 = new JButton("1");
		button1.setFont(new Font("calibri", Font.BOLD, 14));
		button1.setBackground(Color.WHITE);
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.fill = GridBagConstraints.BOTH;
		gbc_button1.insets = new Insets(0, 0, 0, 0);
		gbc_button1.gridx = 2;
		gbc_button1.gridy = 13;
		frame.getContentPane().add(button1, gbc_button1);
		button1.addActionListener(this);
		
		JButton button2 = new JButton("2");
		button2.setFont(new Font("calibri", Font.BOLD, 14));
		button2.setBackground(Color.WHITE);
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.fill = GridBagConstraints.BOTH;
		gbc_button2.insets = new Insets(0, 0, 0, 0);
		gbc_button2.gridx = 3;
		gbc_button2.gridy = 13;
		frame.getContentPane().add(button2, gbc_button2);
		button2.addActionListener(this);
		
		JButton button3 = new JButton("3");
		button3.setFont(new Font("calibri", Font.BOLD, 14));
		button3.setBackground(Color.WHITE);
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.fill = GridBagConstraints.BOTH;
		gbc_button3.insets = new Insets(0, 0, 0, 0);
		gbc_button3.gridx = 4;
		gbc_button3.gridy = 13;
		frame.getContentPane().add(button3, gbc_button3);
		button3.addActionListener(this);
		
		JButton buttonAdd = new JButton("+");
		GridBagConstraints gbc_buttonAdd = new GridBagConstraints();
		gbc_buttonAdd.fill = GridBagConstraints.BOTH;
		gbc_buttonAdd.insets = new Insets(0, 0, 0, 0);
		gbc_buttonAdd.gridx = 5;
		gbc_buttonAdd.gridy = 13;
		frame.getContentPane().add(buttonAdd, gbc_buttonAdd);
		buttonAdd.addActionListener(this);
		
		JButton buttonRightParenthesis = new JButton("(");
		buttonRightParenthesis.setFont(new Font("calibri", Font.BOLD, 14));
		GridBagConstraints gbc_buttonRightParenthesis = new GridBagConstraints();
		gbc_buttonRightParenthesis.fill = GridBagConstraints.BOTH;
		gbc_buttonRightParenthesis.insets = new Insets(0, 0, 0, 0);
		gbc_buttonRightParenthesis.gridx = 0;
		gbc_buttonRightParenthesis.gridy = 14;
		frame.getContentPane().add(buttonRightParenthesis, gbc_buttonRightParenthesis);
		buttonRightParenthesis.addActionListener(this);
		
		JButton buttonLeftParenthesis = new JButton(")");
		buttonLeftParenthesis.setFont(new Font("calibri", Font.BOLD, 14));
		GridBagConstraints gbc_buttonLeftParenthesis = new GridBagConstraints();
		gbc_buttonLeftParenthesis.fill = GridBagConstraints.BOTH;
		gbc_buttonLeftParenthesis.insets = new Insets(0, 0, 0, 0);
		gbc_buttonLeftParenthesis.gridx = 1;
		gbc_buttonLeftParenthesis.gridy = 14;
		frame.getContentPane().add(buttonLeftParenthesis, gbc_buttonLeftParenthesis);
		buttonLeftParenthesis.addActionListener(this);
		
		JButton buttonPlusMinus = new JButton("±");
		GridBagConstraints gbc_buttonPlusMinus = new GridBagConstraints();
		gbc_buttonPlusMinus.fill = GridBagConstraints.BOTH;
		gbc_buttonPlusMinus.insets = new Insets(0, 0, 0, 0);
		gbc_buttonPlusMinus.gridx = 2;
		gbc_buttonPlusMinus.gridy = 14;
		frame.getContentPane().add(buttonPlusMinus, gbc_buttonPlusMinus);
		buttonPlusMinus.addActionListener(this);
		
		JButton button0 = new JButton("0");
		button0.setFont(new Font("calibri", Font.BOLD, 14));
		button0.setBackground(Color.WHITE);
		GridBagConstraints gbc_button0 = new GridBagConstraints();
		gbc_button0.fill = GridBagConstraints.BOTH;
		gbc_button0.insets = new Insets(0, 0, 0, 0);
		gbc_button0.gridx = 3;
		gbc_button0.gridy = 14;
		frame.getContentPane().add(button0, gbc_button0);
		button0.addActionListener(this);
		
		JButton buttonGrayDot = new JButton(".");
		buttonGrayDot.setForeground(Color.GRAY);
		GridBagConstraints gbc_buttonGrayDot = new GridBagConstraints();
		gbc_buttonGrayDot.fill = GridBagConstraints.BOTH;
		gbc_buttonGrayDot.insets = new Insets(0, 0, 0, 0);
		gbc_buttonGrayDot.gridx = 4;
		gbc_buttonGrayDot.gridy = 14;
		frame.getContentPane().add(buttonGrayDot, gbc_buttonGrayDot);
		buttonGrayDot.addActionListener(this);
		
		JButton buttonEquals = new JButton("=");
		GridBagConstraints gbc_buttonEquals = new GridBagConstraints();
		gbc_buttonEquals.fill = GridBagConstraints.BOTH;
		gbc_buttonEquals.gridx = 5;
		gbc_buttonEquals.gridy = 14;
		frame.getContentPane().add(buttonEquals, gbc_buttonEquals);
		buttonEquals.addActionListener(this);
		
        ButtonGroup formatGroup = new ButtonGroup();
        formatGroup.add(HexButton);
        formatGroup.add(DecButton);
        formatGroup.add(OctButton);
        formatGroup.add(BinButton);

        // action listeners to set mode for hex, dec, bin, or oct
       
        HexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("HEX");
    			NumberArea.setText(HexLabel.getText());

            }
        });
        DecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("DEC");
    			NumberArea.setText(DecLabel.getText());

            }
        });
        OctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("OCT");
    			NumberArea.setText(OctLabel.getText());

            }
        });
        BinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("BIN");
    			NumberArea.setText(BinLabel.getText());

            }
        });
	}
	
	// function to check if string is double
	private boolean checkDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	// hex, bin, oct, dec updater
    private void updateLabel(){
    	
    	// checks of Dec button selected
    	if (textField.getText().equals("DEC")){
			// checks if active expression is a double or else won't update
			if (checkDouble(NumberArea.getText())) {
				String newDec = NumberArea.getText();
				DecLabel.setText(newDec);
			}
			// checks to see if declabel is currently a whole number and not a double
			if (Double.parseDouble(DecLabel.getText()) % 1 == 0 && !isDouble) {
				// converts declabel values to other labels
				HexLabel.setText(Integer.toHexString(Integer.parseInt(DecLabel.getText())));
				BinLabel.setText(Integer.toBinaryString(Integer.parseInt(DecLabel.getText())));
				OctLabel.setText(Integer.toOctalString(Integer.parseInt(DecLabel.getText())));
			}
			// declabel is a double and doesn't convert neatly to Hex or Bin or Oct
			else {
				HexLabel.setText("");
				BinLabel.setText("");
				OctLabel.setText("");
			}
    	}
    	// checks if Hex button selected
    	else if (textField.getText().equals("HEX")) {
    		String newHex = NumberArea.getText();
    		HexLabel.setText(newHex);
    		// converts to dec first and uses that to convert to others
			DecLabel.setText(Integer.toString(Integer.parseInt(HexLabel.getText(),16)));
			BinLabel.setText(Integer.toBinaryString(Integer.parseInt(DecLabel.getText())));
			OctLabel.setText(Integer.toOctalString(Integer.parseInt(DecLabel.getText())));
			}
    	// checks if Bin button selected
    	else if (textField.getText().equals("BIN")) {
    		String newBin = NumberArea.getText();
    		BinLabel.setText(newBin);
    		// converts to dec first and uses that to convert to others
    		DecLabel.setText(Integer.toString(Integer.parseInt(BinLabel.getText(),2)));
    		HexLabel.setText(Integer.toHexString(Integer.parseInt(DecLabel.getText())));
			OctLabel.setText(Integer.toOctalString(Integer.parseInt(DecLabel.getText())));
    	}
    	// checks of Oct button selected
    	else if (textField.getText().equals("OCT")) {
    		String newOct = NumberArea.getText();
    		OctLabel.setText(newOct);
    		// converts to dec first and uses that to convert to others
    		DecLabel.setText(Integer.toString(Integer.parseInt(OctLabel.getText(),8)));
    		BinLabel.setText(Integer.toBinaryString(Integer.parseInt(DecLabel.getText())));
			HexLabel.setText(Integer.toHexString(Integer.parseInt(DecLabel.getText())));
    	}	

    }
    
    // clears conversion labels
    private void clearLabel() {
		DecLabel.setText("");
		HexLabel.setText("");
		BinLabel.setText("");
		OctLabel.setText("");
    }

    @Override
	public void actionPerformed(ActionEvent e) {

		String buttonEntry = e.getActionCommand();

		// switch structure for button entry
		switch (buttonEntry) {
		
		// clear entry
		case "CE":
			NumberArea.setText("");
			clearLabel();


			// full clear
		case "CLR":
			NumberArea.setText("");
			memoryField.setText("");
			historyLabel.setText("");
			inputStack.clear();
			clearLabel();
			break;

		// backspace
		case "⌫":

			// input stack has values and the first element of input stack is not a digit
			if (!inputStack.isEmpty() && !Character.isDigit(inputStack.peek())) {
				// string is written to labels without last three chars which are the operator and white space
				NumberArea.setText(NumberArea.getText().substring(0, NumberArea.getText().length() - 3));
				memoryField.setText(NumberArea.getText());
				inputStack.pop();
			} 
			else if (inputStack.size() == 1) {
				NumberArea.setText(NumberArea.getText().substring(0, NumberArea.getText().length() - 1));
				memoryField.setText(NumberArea.getText());
				inputStack.pop();
				clearLabel();
			}
			
			else {
				// string is written into labels without last char and last char is removed
				NumberArea.setText(NumberArea.getText().substring(0, NumberArea.getText().length() - 1));
				memoryField.setText(NumberArea.getText());
				inputStack.pop();
			}
			
			updateLabel();

			break;

		// operator functions

		case "%":
		case "^":
		case "*":
		case "/":
		case "+":
		case "-":
			// used to make sure no operators without numbers
			// input stack has values and the first element of input stack is not a number value
			// will replace most recent operator
			if (!inputStack.isEmpty() && !Character.isDigit(inputStack.peek()) && !inputStack.peek().equals('A')
					&& !inputStack.peek().equals('B') && !inputStack.peek().equals('C') && !inputStack.peek().equals('D')
					&& !inputStack.peek().equals('E') && !inputStack.peek().equals('F')) {
				// creates string for calculator entries from 
				String activeSentence = NumberArea.getText().substring(0, NumberArea.getText().length() - 2);
				// removes whitespace
				activeSentence.trim();
				// updates active sentence with the operation and white space
				NumberArea.setText(activeSentence + " " + buttonEntry + " ");
				memoryField.setText(NumberArea.getText());
				// removes top entry from input stack
				inputStack.pop();
				// pushes entry onto stack
				inputStack.push(buttonEntry.charAt(0));
				break;
			}
			// active expression isn't empty
			if (NumberArea.getText().length() > 0 && (Character.isDigit(inputStack.peek()) || inputStack.peek().equals('A')
					|| inputStack.peek().equals('B') || inputStack.peek().equals('C') || inputStack.peek().equals('D')
					|| inputStack.peek().equals('E') || inputStack.peek().equals('F'))) {
				// pushes entry onto stack
				inputStack.push(buttonEntry.charAt(0));
				// updates active expression
				NumberArea.setText(NumberArea.getText() + " " + buttonEntry + " ");
				memoryField.setText(NumberArea.getText());
			}
			
			break;

		// equals button
		case "=":
			
			Double result;
			
			// rounds to hundredth for decimal values
			DecimalFormat format = new DecimalFormat("0.##");
			
			String inputEquation = "";
			
			if (textField.getText() == "DEC") {
				inputEquation = NumberArea.getText();
			}
			
			else {
					
				for (String token : NumberArea.getText().split("\\s")) {
					
					String convertedLine = token;
					
					if (token.equals("^") || token.contentEquals("%") || token.equals("*") 
							|| token.equals("/") || token.equals("+") || token.equals("-")) {
						inputEquation = inputEquation + " " + token + " ";
					}
					else {
						if (textField.getText() == "HEX") {
							convertedLine = Integer.toString(Integer.parseInt(token, 16));
							inputEquation = inputEquation + convertedLine;

						}
						else if (textField.getText() == "BIN") {
							convertedLine = Integer.toString(Integer.parseInt(token, 2));
							inputEquation = inputEquation + convertedLine;

						}
						else if (textField.getText() == "OCT") {
							convertedLine = Integer.toString(Integer.parseInt(token, 8));
						inputEquation = inputEquation + convertedLine;
						}
					}
				}
			}
			
			// calls conversion function to convert to post fix notation
			String postfix = CalculationStack.conversion(inputEquation);

			result = CalculationStack.postfixEval(postfix);
			
			String finalResult = result.toString();
						
			// does conversions depending on mode
			
			if (textField.getText() == "HEX") {
				// converts double to int to erase decimal
				int finalInt = result.intValue();
				// converts int to string 
				finalResult = Integer.toString(finalInt);
				// converts string to hex string
				finalResult = Integer.toHexString(Integer.parseInt(finalResult));

				NumberArea.setText("" + finalResult);
				memoryField.setText(NumberArea.getText());
				historyLabel.setText("" + finalResult);
				}
			else if (textField.getText() == "BIN") {
				int finalInt = result.intValue();
				finalResult = Integer.toString(finalInt);
				finalResult = Integer.toBinaryString(Integer.parseInt(finalResult));

				NumberArea.setText("" + finalResult);
				memoryField.setText(NumberArea.getText());
				historyLabel.setText("" + finalResult);	
			}
			else if (textField.getText() == "OCT") {
				int finalInt = result.intValue();
				finalResult = Integer.toString(finalInt);
				finalResult = Integer.toOctalString(Integer.parseInt(finalResult));

				NumberArea.setText("" + finalResult);
				memoryField.setText(NumberArea.getText());
				historyLabel.setText("" + finalResult);
			}
			else {
				NumberArea.setText("" + format.format(result));
				memoryField.setText(NumberArea.getText());
				historyLabel.setText("" + format.format(result));
			}
			updateLabel();

			break;

		// digits added or decimal
		case "0":
			// stops 0 if no other values
			if (inputStack.size() != 0) {
				// updates active expression
				NumberArea.setText(NumberArea.getText() + buttonEntry);
				memoryField.setText(NumberArea.getText());
				// numbers added to stack
				inputStack.push(buttonEntry.charAt(0));

				updateLabel();
			}
			break;
			
		case "1":
			// updates active expression
			NumberArea.setText(NumberArea.getText() + buttonEntry);
			memoryField.setText(NumberArea.getText());
			// numbers added to stack
			inputStack.push(buttonEntry.charAt(0));

			updateLabel();

			break;
			
		// prevent if Bin mode
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
			
			if (textField.getText() != "BIN") {

				// updates active expression
				NumberArea.setText(NumberArea.getText() + buttonEntry);
				memoryField.setText(NumberArea.getText());
				// numbers added to stack
				inputStack.push(buttonEntry.charAt(0));

				updateLabel();
			}
			break;
			
			
		// prevent if Bin or Oct mode
		case "8":
		case "9":	
		case ".":
			
			if (textField.getText() != "BIN" && textField.getText() != "OCT") {

				// updates active expression
				NumberArea.setText(NumberArea.getText() + buttonEntry);
				memoryField.setText(NumberArea.getText());
				// numbers added to stack
				inputStack.push(buttonEntry.charAt(0));

				updateLabel();
			}
			break;
		
		// case if Hex is actively selected
		case "A":
		case "B":
		case "C":
		case "D":
		case "E":
		case "F":
			
			if (textField.getText() == "HEX") {
				// updates active expression
				NumberArea.setText(NumberArea.getText() + buttonEntry);		
				memoryField.setText(NumberArea.getText());
				// numbers added to stack
				inputStack.push(buttonEntry.charAt(0));
			
				updateLabel();
			}
			
			break;
			
		// change button text
		case "QWORD":
			JButton btnWord = (JButton)e.getSource();
            btnWord.setText("DWORD");
            break;
		case "DWORD":
			btnWord = (JButton)e.getSource();
            btnWord.setText("WORD");
            break;
		case "WORD":
			btnWord = (JButton)e.getSource();
            btnWord.setText("BYTE");
            break;
		case "BYTE":
			btnWord = (JButton)e.getSource();
            btnWord.setText("QWORD");
            
		// default empty to prevent other text from being updated
		default:
			
			break;
		}
	}
    
    

}
