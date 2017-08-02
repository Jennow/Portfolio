package RosaPartyRechteck;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class DrawTest extends JPanel {

	Rectangle rect = new Rectangle(1279, 150, 101, 201);
	Rectangle fillRect = new Rectangle(1280, 151, 100, 200);
	int red, green, blue = 0;
	Color color = new Color(red,green,blue);
	boolean changeDir =false;
	
	public DrawTest (){	
		
		
		Timer t = new Timer(10, new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 if (rect.x > -100){
					 rect.x -=5;
				 fillRect.x -=5;
					 
					 if(!changeDir){
						red += 10;
						blue +=5;
						green +=2;
						color = new Color(red,green,blue);
						if(red >= 235){ 
						 changeDir = true; 
						}
					 }
					 
					 else if(changeDir){
						 red -=10;
						blue -=5;
						green-=2;
						color = new Color(red,green,blue);
						if(red <= 21){
						 changeDir = false; 
						}
					 }
				 }
				 
				 
				 else if(rect.x <= -100 ){	
					 rect.x = 1279;
					 fillRect.x = 1280;
				 }
				 
				 repaint();
			 }
			});
		t.setRepeats(true);
		t.setCoalesce(true);
		t.start();
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(rect.x, rect.y , rect.width, rect.height);
		g.setColor(color);
		g.fillRect(fillRect.x, fillRect.y, fillRect.width, fillRect.height);
		g.dispose();
	}	
}
