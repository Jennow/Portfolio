package flappyBird;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Controller {
	ReplayDialog replay;
	GameFrame gameFrame;
	Rectangle bird;
	ArrayList<Pipe> pipes;
	int pipeTimer =0;
	int jumpTimer =0;
	Timer timer;
	private int score = 0;
	
	public Controller(){
		
		gameFrame = new GameFrame();
		timer = new Timer(15, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				update();
				
				gameFrame.getGamePanel().repaint();
			}
			
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.start();
	}
	
	public boolean checkCollision(){ // Hier muss später gecheckt werden, ob flappy gegen eine Pipe oder den Boden geflogen ist
		for(Pipe p : gameFrame.getGamePanel().pipes){
			if(isColliding(gameFrame.getGamePanel().getBird(), p.getUpper())|| isColliding(gameFrame.getGamePanel().getBird(), p.getLower()) || isColliding(gameFrame.getGamePanel().gras,gameFrame.getGamePanel().getBird())){
			return true;
			}	
		}
		return false;
	}
	
	public static boolean isColliding(Rectangle a, Rectangle b) {
	      if (a.intersects(b)) {
	         return true;
	      } else {
	         return false;
	      }
	   }
	
	public void update(){
		
		//Update des Flappys
		bird = gameFrame.getGamePanel().getBird();
		
		if(gameFrame.getGamePanel().jumping){
			gameFrame.getGamePanel().flappy.jump();
			jumpTimer ++;
			if(jumpTimer >= Values.JUMPLENGTH){
				gameFrame.getGamePanel().jumping = false;
			}
			}
		else {
			gameFrame.getGamePanel().flappy.fallDown();
			jumpTimer =0;
		}
		gameFrame.getGamePanel().setBird(bird);
			
		
		// Update der Pipes
		pipes = gameFrame.getGamePanel().pipes;
		gameFrame.getGamePanel().pipeManager.movePipes();
		gameFrame.getGamePanel().pipeManager.removePipe();
		
		pipeTimer ++;
		if(pipeTimer == Values.PIPETIMER){
			gameFrame.getGamePanel().pipeManager.addPipe();
			pipeTimer =0;
		}
		
		
		
		GameFrame.getGamePanel().setPipes(pipes);
		
		//Update des Scores
		for(int i =0; i< gameFrame.getGamePanel().pipeManager.getPipes().size();i++){
			if(gameFrame.getGamePanel().flappy.getBird().x == gameFrame.getGamePanel().pipeManager.getPipes().get(i).getUpper().x){
			score ++;
			gameFrame.getGamePanel().setScore(score);
			}	
			
		}
		if(checkCollision()){
			timer.stop();
			replay = new ReplayDialog(score);
			
		}
		 // Hier wird später der Score geupdated
		
		
		gameFrame.getGamePanel().repaint();
	}

	public static void main(String[] args) {
		Controller ctrl = new Controller();
	}
}


