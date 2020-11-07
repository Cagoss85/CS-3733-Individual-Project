package example.numbers.model;

public class Tile {
	public final int height = 1;	//height of a tile
	public final int width = 1;		//width of a tile
	int number;						//number to be represented by tile
	int row;						//y location on puzzle
	int col;						//x location on puzzle
	boolean hideNum = false;
	boolean isSelectable = true;
	
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
	
	public boolean getIsSelectable() {
		return this.isSelectable;
	}
	
	public void setIsSelectable(boolean flag) {
		this.isSelectable = flag;
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
	
	public boolean isNumHid() {return this.hideNum;}
	public void setIsEmpty(boolean flag) {this.hideNum = flag;}
	
	
	
	public Coordinate getLocation() {return new Coordinate(col,row);}
	
	public boolean contains(Coordinate c) {
		if(c.col >= col && c.col < col + width && c.row >= row && c.row < row + height) {
			return true;
		}
		return false;	
	}

	//what needs to happen in the move function
	//tile.setIsEmpty() == true; DONE
	//update second tile number
	
	
	public void move(MoveType dir) {
		if(dir == MoveType.None) {return;}
		//this.row += dir.deltaR;
		//this.col += dir.deltaC;
	}


}