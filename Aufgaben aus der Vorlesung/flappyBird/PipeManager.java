package flappyBird;

import java.util.ArrayList;

public class PipeManager {

	private static ArrayList<Pipe> list = new ArrayList<Pipe>();

	PipeManager(){
		list = new ArrayList<Pipe>();
	}
	
	public void movePipes(){
		for(Pipe i: list){
			i.decreaseUpperX(Bird.getVelocity());
			i.decreaseLowerX(Bird.getVelocity());
		}
	}
	
	public void addPipe(){
		list.add(new Pipe());
	}
	
	public void removePipe(){
		getPipes();
		ArrayList<Pipe>rem = new ArrayList<Pipe>(); // neue ArrayList erstellen, in der effektiv immer die zu entfernende Pipe enthalten ist
		
		for (Pipe i: list){
			if(i.getUpper().x < -100){
				rem.add(i);
			}
		}
		list.removeAll(rem);
	}
	
	public static ArrayList<Pipe> getPipes(){
		return list;
	}
}
