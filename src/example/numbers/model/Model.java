package example.numbers.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Puzzle puzzle;
	Tile selectedTile;
	int numMoves = 0;
	boolean gameOver;
	
	public void resetPuzzle() {
		puzzle.reset();
		selectedTile = null;
		numMoves = 0;
		gameOver = false;
	}
	
	public boolean combineTile(MoveType dir) {
		if(selectedTile == null) {return false;	}
		for(MoveType move : availableMoves()) {
			if(dir == move) {
				if(dir == MoveType.Right) {
					puzzle.findTile(selectedTile.col + 1, selectedTile.row).setNumber(puzzle.findTile(selectedTile.col + 1, selectedTile.row).getNumber() + selectedTile.getNumber());
				}
				else if(dir == MoveType.Left) {
					puzzle.findTile(selectedTile.col - 1, selectedTile.row).setNumber(puzzle.findTile(selectedTile.col - 1, selectedTile.row).getNumber() - selectedTile.getNumber());
				}
				else if(dir == MoveType.Up) {
					puzzle.findTile(selectedTile.col, selectedTile.row - 1).setNumber(puzzle.findTile(selectedTile.col, selectedTile.row - 1).getNumber() * selectedTile.getNumber());
				}
				else if(dir == MoveType.Down) {
					puzzle.findTile(selectedTile.col, selectedTile.row + 1).setNumber(puzzle.findTile(selectedTile.col, selectedTile.row + 1).getNumber() / selectedTile.getNumber());
				}
				selectedTile.setBlank(true);
				numMoves++;
				clearSelTile();
				return true;
			}
		}
		return true;
	}
	
	public List<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();
		if(selectedTile == null) {return moves;}
		return determineValidMoves(selectedTile);
	}

	public List<MoveType> determineValidMoves(Tile t) {
		ArrayList<MoveType> moves = new ArrayList<>();
		Coordinate coord = t.getLocation();
		//Left Validity
		if(coord.col > 0) {	
			boolean available = true;
			for(int r = 0 ; r < t.height ; r++) {
				if(((puzzle.findTile(coord.col - 1,coord.row).getNumber() - t.getNumber()) < 0)) {
					available = false;
				}
				if(puzzle.findTile(coord.col - 1, coord.row).isBlank()) {
					available = false;
				}
			}
			if(available) {moves.add(MoveType.Left);}
		}
		
		//Right Validity
		if(coord.col  + t.width < puzzle.numCols) {
			boolean available = true;
			for(int r = 0 ; r < t.height ; r++) {
				if(puzzle.findTile(coord.col + 1, coord.row).getNumber() + t.getNumber() < 0) {
					available = false;
				}
				if(puzzle.findTile(coord.col + 1, coord.row).isBlank()) {
					available = false;
				}
			}
			if(available) {moves.add(MoveType.Right);}
		}
		
		//Up Validity
		if(coord.row > 0) {			
			boolean available = true;
			for(int c = 0 ; c < t.width ; c++) {
				if((puzzle.findTile(coord.col, coord.row - 1).getNumber() * t.getNumber() < 0)) {
					available = false;
				}
				if(puzzle.findTile(coord.col, coord.row - 1).isBlank()) {
					available = false;
				}				
			}
			if(available) {moves.add(MoveType.Up);}
		}
		
		//Down Validity
		if(coord.row + t.height < puzzle.numRows) {
			boolean available = true;
			for(int c = 0 ; c < t.width ; c++) {
				float x = ((float)puzzle.findTile(coord.col, coord.row + 1).getNumber() / (float)t.getNumber());
				if(x != (int)x) {
					available = false;
				}
				if(puzzle.findTile(coord.col, coord.row + 1).isBlank()) {
					available = false;
				}
			}
			if(available) {moves.add(MoveType.Down);
			}
		}
		return moves;
	}

	public Puzzle getPuzzle() {return puzzle;}
	public void setPuzzle(Puzzle p) {
		puzzle = p;
		numMoves = 0;
		gameOver = false;
		selectedTile = null;
	}

	public Tile getSelTile() {return selectedTile;}
	public void clearSelTile() { selectedTile = null;}
	public void setSelTile (Tile t) {
		if(t.isBlank() == false) {
			selectedTile = t;
		}
		else {}
	}
	
	public boolean isGameOver() { return gameOver;	}
	public void setGameOver(boolean flag) { gameOver = flag;}

	public int getNumMoves() {
		return numMoves;
	}
}  