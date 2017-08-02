package flappyBird;

import java.awt.Rectangle;
import javax.swing.JPanel;

public class Pipe extends JPanel{
		
	private Rectangle upper, lower;
	
	public Pipe(){
		
		int upperY =  (int) ((Math.random()*-220)-60);
		int lowerY = upperY+ 320 + Values.PIPE_GAP;
		
		upper = new Rectangle(Values.FRAMEWIDTH,upperY,40,320);
		lower = new Rectangle(Values.FRAMEWIDTH,lowerY,40,320);
	}	
	
	public void decreaseUpperX(int i) {
		upper.x -= i;
	}
	
	public void decreaseLowerX(int i) {
		lower.x -= i;
	}
	
	public Rectangle getUpper(){
		return upper;
	}
	
	public Rectangle getLower() {
		return lower;
	}
}
