package example.numbers.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Puzzle puzzle;
	boolean gameOver;
	Tile selectedTile;
	int numMoves = 0;
	
	public Model() {
				
	}
	
	public void resetPuzzle() {
		puzzle.reset();
		selectedTile = null;
		numMoves = 0;
		gameOver = false;
		
	}
	
	public boolean tryMove(MoveType dir) {
		if(selectedTile == null) {return false;	}
		for(MoveType move : availableMoves()) {
			if(dir == move) {
				selectedTile.move(dir);
				numMoves++;
				return true;
			}
		}
		return true;
	}
	
	public List<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();
		if(selectedTile == null) {
			return moves;
		}
		return availableMoves(selectedTile);
	}
	
	public List<MoveType> availableMoves(Tile t) {
		ArrayList<MoveType> moves = new ArrayList<>();
		
		Coordinate coord = t.getLocation();
		
		//left
		if(coord.col > 0) {			
			boolean available = true;
			for(int r = 0 ; r < t.height ; r++) {
				System.out.print("tt");
				if((puzzle.findTile(coord.col-1,coord.row) - t.getNumberInt()) < 0) {
					available = false;
				}
			}
			if(available) {
				moves.add(MoveType.Left);
			}
		}
		
		//right
		if(coord.col  + t.width < puzzle.numCols) {
			boolean available = true;
			for(int r = 0 ; r < t.height ; r++) {
				if(puzzle.findTile(coord.col + 1, coord.row) + t.getNumberInt() < 0) {
					available = false;
				}
			}
			if(available) {
				moves.add(MoveType.Right);
			}
		}
		
		//Up
		if(coord.row > 0) {			
			boolean available = true;
			for(int c = 0 ; c < t.width ; c++) {
				if(puzzle.findTile(coord.col, coord.row - 1) * t.getNumberInt() < 0) {
					available = false;
				}
			}
			if(available) {
				moves.add(MoveType.Up);
			}
		}
		
		//Down
		if(coord.row + t.height < puzzle.numRows) {
			boolean available = true;
			for(int c = 0 ; c < t.width ; c++) {
				float x = ((float)puzzle.findTile(coord.col, coord.row + 1) / (float)t.getNumberInt());
				System.out.print(x);
				if(x != (int)x) {
					available = false;
				}
			}
			if(available) {
				moves.add(MoveType.Down);
			}
		}
		
		return moves;
	}
	
	/**
	 * (0,0)(1,0)(2,0)
	 * (0,1)(1,1)(2,1)
	 * (0,2)(1,2)(2,2)
	 */

	public Puzzle getPuzzle() {return puzzle;}
	public void setPuzzle(Puzzle p) {
		puzzle = p;
		numMoves = 0;
		gameOver = false;
		selectedTile = null;
	}

	
	public void setSelTile (Tile t) {selectedTile = t;}
	public Tile getSelTile() {return selectedTile;}
	public void clearSelTile() { selectedTile = null;}
	
	public boolean isGameOver() { return gameOver;	}
	public void setGameOver(boolean flag) { gameOver = flag;}

	public int getNumMoves() {
		return numMoves;
	}
}  