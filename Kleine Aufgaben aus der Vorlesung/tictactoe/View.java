package tictactoe;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class View extends JFrame {

	
	private JButton [] fieldBtn = new JButton[9];
	private JLabel symbolLabel = new JLabel("X");
	
	public View(){
		
		JPanel btnPanel = new JPanel();
		
		btnPanel.setLayout(new GridLayout(3,3));
		for( int i = 0; i < fieldBtn.length; i++){
			fieldBtn[i] = new JButton();
			fieldBtn[i].setActionCommand(String.valueOf(i));
			fieldBtn[i].setOpaque(true);
			fieldBtn[i].setBorder(LineBorder.createBlackLineBorder());;
			btnPanel.add(fieldBtn[i]);
		}
		
		symbolLabel.setHorizontalAlignment(JLabel.CENTER);
		add(btnPanel, BorderLayout.CENTER);
		add(symbolLabel, BorderLayout.NORTH);
		
		setSize(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public JButton[] getFieldBtn() {
		return fieldBtn;
	}
	
	public void setSymbol(String symbol) {
		this.symbolLabel.setText(symbol);
	}
}
