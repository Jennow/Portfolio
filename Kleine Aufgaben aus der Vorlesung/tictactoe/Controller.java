package tictactoe;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Controller {

	private View view;
	private GameField gameField;
	private String symbol;
	
	public Controller(){
		init();
	}
	
	private void init(){
		this.view = new View();
		this.gameField = new GameField();
		symbol = GameField.SYMBOL_X;
		view.setSymbol(symbol);
		
		JButton[] fieldBtn = view.getFieldBtn();
		for( int i =0; i < fieldBtn.length; i++){
			fieldBtn[i].addActionListener(e -> {
				try {
					int index = Integer.valueOf(e.getActionCommand());
					
					if(gameField.addSymbol(index, symbol)){
						fieldBtn[index].setText(symbol);
						if (hasWon(symbol)){
							JOptionPane.showMessageDialog(null, "Der Spieler mit Symbol "+symbol+" hat gewonnen" );
							init();
						}
						
						else if(isFinish()){
							JOptionPane.showMessageDialog(null, "Unentschieden");
							init();
						}
						
						switchSymbol();
						view.setSymbol(symbol);
					}
					
				} catch (NumberFormatException ex){
					ex.printStackTrace();
				}
			});
		}	
	}
	
	private void switchSymbol(){
		if(symbol.equals(GameField.SYMBOL_O)){
			symbol = GameField.SYMBOL_X;
		} else {symbol = GameField.SYMBOL_O;}
	}
	
	private boolean hasWon(String symbol){
		String [] fields = gameField.getField();
		
		for (int i =0; i < 3; i++){
			if(fields[ 3*i ]!= null && fields[ 3*i ].equals(symbol) && 
			   fields[3*i+1]!= null && fields[3*i+1].equals(symbol) &&
			   fields[3*i+2]!= null && fields[3*i+2].equals(symbol)){
				return true;
			}
			else if (fields[i] != null && fields[i].equals(symbol) &&
					fields[3+i] != null && fields[3+i].equals(symbol) &&
					fields[6+i] != null && fields[6+i].equals(symbol) ){
				return true;
			}
		}
		
		if(fields[0] != null && fields[0].equals(symbol)&&
		fields[4] != null && fields[4].equals(symbol)&&	
		fields[8] != null && fields[8].equals(symbol)){
			return true;
		}
		
		if(fields[2] != null && fields[2].equals(symbol)&&
			fields[4] != null && fields[4].equals(symbol)&&	
			fields[6] != null && fields[6].equals(symbol)){
			return true;
		}
		
		return false;	
	}
	
	private boolean isFinish(){
		if(gameField.getSymCnt() < 9){
			return false;
		}
		return true;
	}
}

