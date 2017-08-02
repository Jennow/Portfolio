package flappyBird;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

	private Rectangle bird;
	Bird flappy;
	 Rectangle gras = new Rectangle(0,Values.FRAMEHEIGHT-Values.FRAMEHEIGHT/5,Values.FRAMEWIDTH,Values.FRAMEHEIGHT/7);
	private int score;
	public boolean jumping;
	private ImageIcon upper= new ImageIcon(getClass().getResource("upper.png"));
	private ImageIcon lower= new ImageIcon(getClass().getResource("lower.png"));
	private ImageIcon flap = new ImageIcon(getClass().getResource("flappy.png"));
	private ImageIcon background = new ImageIcon(getClass().getResource("background.png"));
	
	
	ArrayList<Pipe> pipes;
	PipeManager pipeManager;
	
	public GamePanel(){
		this.pipeManager = new PipeManager();
		this.pipes = pipeManager.getPipes();
		this.flappy = new Bird();
		this.bird = flappy.getBird();
		this.jumping = false;
		this.score =0;
		
		
		
		MouseListener birdListener = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jumping = true;
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				jumping = false;
			}
			
		};
		
		setLayout(null);
		addMouseListener(birdListener);
		setVisible(true);
		setSize(Values.FRAMEWIDTH,Values.FRAMEHEIGHT);
		
	}
	
	@Override
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect(getBird().x, getBird().y, getBird().width, getBird().height);
		g.drawImage(background.getImage(), -200,-40,null);
		
		for(Pipe i : pipeManager.getPipes()){
		g.drawRect(i.getUpper().x+2, i.getUpper().y-1, i.getUpper().width, i.getUpper().height);
		g.drawImage(upper.getImage(), i.getUpper().x, i.getUpper().y ,null);
		
		g.drawRect(i.getLower().x+2, i.getLower().y, i.getLower().width, i.getLower().height);
		g.drawImage(lower.getImage(), i.getLower().x, i.getLower().y,null);
		}
		
		g.setColor(new Color(197,231,70));
		g.drawRect(gras.x, gras.y, gras.width, gras.height);
		g.fillRect(gras.x, gras.y, gras.width, gras.height);
		
		g.drawString(("Score: " + score), 650, 20);
		
		
		
		
		g.drawImage(flap.getImage(), getBird().x, getBird().y, null);
		g.dispose();
		
	}
	
	public int getScore() {
		return score;
	}
	
	public void setBird(Rectangle bird){
		this.bird  = bird;
	}
	
	public void setPipes (ArrayList<Pipe> pipes){
		this.pipes = pipes;
	}
	
	public void setScore(int score){
		this.score = score;
		
	}

	public Rectangle getBird() {
		return bird;
	}
}
