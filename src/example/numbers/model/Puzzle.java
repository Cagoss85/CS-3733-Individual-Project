package example.numbers.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Tile>{
	ArrayList<Tile> tiles = new ArrayList<>();
	ArrayList<Tile> originals = new ArrayList<>();
	public final int numRows;
	public final int numCols;
	MoveType dir;
	
	public Puzzle(int numRows, int numCols	) {
		this.numRows = numRows;
		this.numCols = numCols;
	}
	
	public void addTile(Tile t, int col, int row) {
		t.setCol(col);
		t.setRow(row);
				
		tiles.add(t);
		originals.add(t.copy());
	}
	
	public Tile getTile(int c, int r) {
		for(Tile t : tiles) {
			if((t.getCol() == c && t.getRow() == r)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}

	public void resetPuzzle() {
		tiles.clear();
		for(Tile t : originals) {
			tiles.add(t.copy());
		}
	}
}
