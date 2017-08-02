package RosaPartyRechteck;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	DrawTest drawPanel;

	public MyFrame () {
		setTitle("Rosa Party Rechteck");
		setLayout (null);

		drawPanel = new DrawTest();
		add (drawPanel);
		drawPanel.setBounds(0, 100, 1351, 760);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1351,760);
	}
	
	public static void main(String[] args) {
		MyFrame myFrame= new MyFrame();
	}

}


