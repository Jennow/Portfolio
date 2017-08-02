package tictactoe;

public class GameField {

	private String[] field = new String[9];
	public static final String SYMBOL_X = "X";
	public static final String SYMBOL_O = "O";
	private int symCnt= 0;
	
	public boolean addSymbol(int index, String symbol){
		
		
		if(symbol.equals(SYMBOL_O) || symbol.equals(SYMBOL_X)){
			
			if(field[index] == null){
			field[index] = new String(symbol);		
			symCnt ++;
			return true;
			}	
		}
		return false;
	}
	
	public String[] getField() {
		return field;
	}
	
	public int getSymCnt() {
		return symCnt;
	}
}
