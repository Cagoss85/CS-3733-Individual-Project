package example.numbers.model;

public enum CornerTiles {
	TopLeft(0,0), 
	TopRight(2,0), 
	BottomLeft(0,2), 
	BottomRight(2,2);
	
	final int col;
	final int row;
	
	CornerTiles(int col, int row){
		this.col = col;
		this.row = row;
	}
	
	public int getCol() {return this.col;}
	public int getRow() {return this.row;}
}
