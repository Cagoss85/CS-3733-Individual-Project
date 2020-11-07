package example.numbers.model;

public class Tile {
	public final int height = 1;	//height of a tile
	public final int width = 1;		//width of a tile
	int number;						//number to be represented by tile
	int row;						//y location on puzzle
	int col;						//x location on puzzle
	boolean isBlank = false;
	
	//Tile constructor
	public Tile(int number) {
		this.number = number;
	}
	
	public Tile copy() {
		Tile t = new Tile(number);
		t.setCol(col);
		t.setRow(row);
		return t;
	}
	
	public boolean isBlank() {return this.isBlank;}
	public void setBlank(boolean flag) {this.isBlank = flag;}
	
	public void setNumber(int x) {this.number = x;}
	public int getNumber() {return this.number;}
	
	public int getRow() {return this.row;}
	public void setRow(int y) {this.row = y;}
	
	public int getCol() {return this.col;}
	public void setCol(int x) {this.col = x;}
	
	public Coordinate getLocation() {return new Coordinate(col,row);}
	
	public boolean contains(Coordinate c) {
		if(c.col >= col && c.col < col + width && c.row >= row && c.row < row + height) {
			return true;
		}
		return false;	
	}
}