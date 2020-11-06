package example.numbers.model;

public class Tile {
	public final int height;	//height of a tile
	public final int width;		//width of a tile
	int number;					//number to be represented by tile
	int row;					//y location on puzzle
	int col;					//x location on puzzle
	boolean isCenter = false;
	boolean hasNumber = true;
	
	//Tile constructor
	public Tile(int width, int height, int number) {
		this.width = width;
		this.height = height;
		this.number = number;
	}
	
	public Tile copy() {
		Tile t = new Tile(width, height, number);
		t.setCol(col);
		t.setRow(row);
		return t;
	}
	
	//Returns number stored for a Tile
	public String getNumber() {return String.valueOf(this.number);}
	//sets number stored for a Tile
	public void setNumber(int x) {this.number = x;}

	public int getNumberInt() {return this.number;}
	//Returns the row coordinate for a Tile
	public int getRow() {return this.row;}
	//Sets a new row coordinate for the Tile
	public void setRow(int y) {this.row = y;}
	
	//Returns the column coordinate for a Tile
	public int getCol() {return this.col;}
	//Sets a new column coordinate for the Tile
	public void setCol(int x) {this.col = x;}
	
	public Coordinate getLocation() {return new Coordinate(col,row);}
	
	public boolean getCenter() {return this.isCenter;}
	public void setCenter(boolean flag) {this.isCenter = flag;}
	
	public boolean contains(Coordinate c) {
		if(c.col >= col && c.col < col + width && c.row >= row && c.row < row + height) {
			return true;
		}
		return false;	
	}

	public void move(MoveType dir) {
		if(dir == MoveType.None) {return;}
		this.row += dir.deltaR;
		this.col += dir.deltaC;	
	}


}