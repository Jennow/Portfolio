package flappyBird;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

public class Bird {

	public static int velocity;
	private Rectangle rect;
	private int score;
	public boolean jumping = false;
	
	
	
	public Bird(){
		velocity = 4;
		rect = new Rectangle(Values.FRAMEWIDTH/5,Values.FRAMEHEIGHT/2,30,24);
		score = 0;
	}
	
	public void fallDown(){
		int vel = Values.FALLVELOSITY;
		rect.y += vel;
		
		if (vel <10){
			vel++;
		}
		
		
	}
	
	public void jump(){
		int vel = Values.JUMPHEIGHT;
		rect.y -= vel ;
		
		if (vel < 10){
			vel++;
		}
			
			
			
	}
	
	public void increaseScore(){
		score++;
	}
	
	public int getScore(){
		return score;
	}
	
	public Rectangle getBird(){
		return rect;
	}
	
	public static int getVelocity(){
		return velocity;
	}
}
