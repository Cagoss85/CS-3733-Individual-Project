package example.numbers.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Tile>{
	ArrayList<Tile> tiles = new ArrayList<>();
	
	ArrayList<Tile> originals = new ArrayList<>();
	
	public final int numRows;	//number of rows in the puzzle
	public final int numCols;	//number of columns in the puzzle
	int winRow;					//the row that the winning tile must be on
	int winCol;					//the column that the winning tile must be on
	MoveType dir;				//dont think i actually need this (see below)
	

	
	public Puzzle(int numRows, int numCols	) {
		this.numRows = numRows;
		this.numCols = numCols;
	}
	
	//Get the row of the winner Tile
	public int getWinRow() {return winRow;}
	//Set the row of the winner Tile
	public void setWinRow(int r) {this.winRow = r;}
	
	//Get the column of the winner Tile
	public int getWinCol()	{return winCol;}
	//Set the column of the Winning Tile
	public void setWinCol(int c) {this.winCol = c;}

	public void setDir(MoveType direction) {dir = direction;}
	public MoveType getDir()	{return dir;}
	
	public void add(Tile t, int col, int row) {
		t.setCol(col);
		t.setRow(row);
				
		tiles.add(t);
		originals.add(t.copy());
	}
	
	
	/**
	 * Search the list of tiles and return the one that is in the specified location
	 */
	public Tile findTile(int c, int r) {
		for(Tile t : tiles) {
			if((t.getCol() == c && t.getRow() == r)) {
				return t;
			}
		}
		return null;
	}
	
	
	
	public boolean isCovered(Coordinate coord) {
		for(Tile t : tiles) {
			if(t.contains(coord)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}

	public void reset() {
		tiles.clear();
		for(Tile t : originals) {
			tiles.add(t.copy());
		}
		
	}
}
