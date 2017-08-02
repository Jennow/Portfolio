package flappyBird;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ReplayDialog extends JDialog{

	private int score;
	
	public ReplayDialog(int score) {
		this.score = score;
		setLayout(new GridLayout(0,1));
		add(new JLabel ("Punktzahl: "+score ));
		
		JButton btn = new JButton("Nochmal");
		add(btn);
		
		btn.addActionListener(e -> {
			dispose();
			Controller ctrl = new Controller();
		});
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(200,100);
		setVisible(true);
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
