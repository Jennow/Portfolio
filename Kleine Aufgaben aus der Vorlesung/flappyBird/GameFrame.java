package flappyBird;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	
	
	ArrayList<Pipe> pipes;
	static GamePanel gp;
	
	public GameFrame(){
		
		setTitle("Flappy Bird");
		setLayout(null);
		add(new JLabel("Score: "), BorderLayout.NORTH);
		gp = new GamePanel();
		add(gp, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(Values.FRAMEWIDTH,Values.FRAMEHEIGHT);
	}
	
	public static GamePanel getGamePanel(){
		return gp;
	}
	
}
