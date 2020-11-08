package example.numbers.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Puzzle puzzle;
	Tile selectedTile;
	int numMoves = 0;
	boolean gameOver;
	boolean isWon = false;
	
	//checks to see if the game is won
	public void isGameWon() {
		if(checkPerimeter()) {
			gameOver = true;
			isWon = true;
		}
		else if(centerMoved() || checkCorners() || sidesLocked()){
			gameOver = true;
			isWon = false;
		}
		else {}
	}
	
	//Checks if the top or right tile is locked
	public boolean sidesLocked() {
		float x = (float)puzzle.getTile(1, 1).getNumber() / (float)puzzle.getTile(1, 0).getNumber();
		if(cornersGone()) {
			//top and side locked
			if(numMoves == 6 && puzzle.getTile(0, 1).isBlank() &&
					puzzle.getTile(1, 2).isBlank() &&
					puzzle.getTile(1, 1).getNumber() - puzzle.getTile(2, 1).getNumber() < 0 &&
					(x != (int)x)) {
				return true;
			}
			if(numMoves == 7) {
				//top Locked
				if(puzzle.getTile(0, 1).isBlank() &&
						puzzle.getTile(1, 2).isBlank() &&
						puzzle.getTile(2, 1).isBlank() &&
						(x != (int)x)) {
					return true;
				}
				//side Locked
				if(puzzle.getTile(0, 1).isBlank() &&
						puzzle.getTile(1, 0).isBlank() &&
						puzzle.getTile(1, 2).isBlank() &&
						puzzle.getTile(1, 1).getNumber() - puzzle.getTile(2, 1).getNumber() < 0){
					return true;
				}
			}
		}
		return false;
	}
	
	//Checks if every corner tile is blank
	public boolean cornersGone() {
		if(puzzle.getTile(0,0).isBlank() &&
				puzzle.getTile(0,2).isBlank() &&
				puzzle.getTile(2,0).isBlank() &&
				puzzle.getTile(2,2).isBlank()){
			return true;
		}
		return false;
	}

	//determines if any corner is isolated and has no neighbors
	private boolean checkCorners() {
		if(checkACorner(CornerTiles.TopLeft) ||
				checkACorner(CornerTiles.TopRight) ||
				checkACorner(CornerTiles.BottomLeft) ||
				checkACorner(CornerTiles.BottomRight)
				){
			return true;
		}
		return false;
	}
	
	//checks each corner tile to see if its locked
	private boolean checkACorner(CornerTiles t) {
		int col = t.getCol();
		int row = t.getRow();
		if(t == CornerTiles.TopLeft) {
			if((puzzle.getTile(col,row).isBlank == false) && puzzle.getTile(col, row + 1).isBlank() && puzzle.getTile(col + 1, row).isBlank()) {
				System.out.println("TL Isolated");
				return true;
			}
		}
		if(t == CornerTiles.TopRight) {
			if((puzzle.getTile(col,row).isBlank == false) && puzzle.getTile(col, row + 1).isBlank() && puzzle.getTile(col - 1, row).isBlank()) {
				System.out.println("TR Isolated");
				return true;
			}
		}
		if(t == CornerTiles.BottomLeft) {
			if((puzzle.getTile(col,row).isBlank == false) && puzzle.getTile(col, row - 1).isBlank() && puzzle.getTile(col + 1, row).isBlank()) {
				System.out.println("BL Isolated");
				return true;
			}
		}
		if(t == CornerTiles.BottomRight) {
			if((puzzle.getTile(col,row).isBlank == false) && puzzle.getTile(col, row - 1).isBlank() && puzzle.getTile(col - 1, row).isBlank()) {
				System.out.println("BR Isolated");
				return true;
			}
		}
		return false;
	}

	private boolean centerMoved() {
		if(puzzle.getTile(1,1).isBlank()){
			System.out.println("center is gone");
			return true;
		}
		return false;
	}

	public boolean getIsWon() {return isWon;}
	public void setIsWon(boolean flag) {this.isWon = flag;}
	
	public boolean getGameOver() {return gameOver;}
	public void setGameOver(boolean flag) {this.gameOver = flag;}
	
	//Looks for winning condition
	private boolean checkPerimeter() {
		if(puzzle.getTile(0,0).isBlank() &&
			puzzle.getTile(0,1).isBlank() &&
			puzzle.getTile(0,2).isBlank() &&
			
			puzzle.getTile(1,0).isBlank() &&
			puzzle.getTile(1,2).isBlank() &&
			
			puzzle.getTile(2,0).isBlank() &&
			puzzle.getTile(2,1).isBlank() &&
			puzzle.getTile(2,0).isBlank()) {
			return true;
		}
		return false;
	}
	
	
	public List<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();
		if(selectedTile == null) {return moves;}
		return determineValidMoves(selectedTile);
	}
	

	public List<MoveType> determineValidMoves(Tile t) {
		ArrayList<MoveType> moves = new ArrayList<>();
		Coordinate coord = t.getLocation();
		if(selectedTile == null) {return moves;}
		if(this.selectedTile.isBlank() == false) {
			//Left Validity
			if(coord.col > 0) {	
				boolean available = true;
				for(int r = 0 ; r < t.height ; r++) {
					if(((puzzle.getTile(coord.col - 1,coord.row).getNumber() - t.getNumber()) < 0)) {
						available = false;
					}
					if(puzzle.getTile(coord.col - 1, coord.row).isBlank()) {
						available = false;
					}
				}
				if(available) {moves.add(MoveType.Left);}
			}
			
			//Right Validity
			if(coord.col  + t.width < puzzle.numCols) {
				boolean available = true;
				for(int r = 0 ; r < t.height ; r++) {
					if(puzzle.getTile(coord.col + 1, coord.row).getNumber() + t.getNumber() < 0) {
						available = false;
					}
					if(puzzle.getTile(coord.col + 1, coord.row).isBlank()) {
						available = false;
					}
				}
				if(available) {moves.add(MoveType.Right);}
			}
			
			//Up Validity
			if(coord.row > 0) {			
				boolean available = true;
				for(int c = 0 ; c < t.width ; c++) {
					if((puzzle.getTile(coord.col, coord.row - 1).getNumber() * t.getNumber() < 0)) {
						available = false;
					}
					if(puzzle.getTile(coord.col, coord.row - 1).isBlank()) {
						available = false;
					}				
				}
				if(available) {moves.add(MoveType.Up);}
			}
			
			//Down Validity
			if(coord.row + t.height < puzzle.numRows) {
				boolean available = true;
				for(int c = 0 ; c < t.width ; c++) {
					float x = ((float)puzzle.getTile(coord.col, coord.row + 1).getNumber() / (float)t.getNumber());
					if(x != (int)x) {
						available = false;
					}
					if(puzzle.getTile(coord.col, coord.row + 1).isBlank()) {
						available = false;
					}
				}
				if(available) {moves.add(MoveType.Down);
				}
			}
		}
		else{}
		return moves;
	}
	
	public boolean combineTile(MoveType dir) {
		if(selectedTile == null) {return false;	}
		for(MoveType move : availableMoves()) {
			if(dir == move) {
				if(dir == MoveType.Right) {
					puzzle.getTile(selectedTile.col + 1, selectedTile.row).setNumber(puzzle.getTile(selectedTile.col + 1, selectedTile.row).getNumber() + selectedTile.getNumber());
				}
				else if(dir == MoveType.Left) {
					puzzle.getTile(selectedTile.col - 1, selectedTile.row).setNumber(puzzle.getTile(selectedTile.col - 1, selectedTile.row).getNumber() - selectedTile.getNumber());
				}
				else if(dir == MoveType.Up) {
					puzzle.getTile(selectedTile.col, selectedTile.row - 1).setNumber(puzzle.getTile(selectedTile.col, selectedTile.row - 1).getNumber() * selectedTile.getNumber());
				}
				else if(dir == MoveType.Down) {
					puzzle.getTile(selectedTile.col, selectedTile.row + 1).setNumber(puzzle.getTile(selectedTile.col, selectedTile.row + 1).getNumber() / selectedTile.getNumber());
				}
				selectedTile.setBlank(true);
				numMoves++;
				clearSelTile();
				return true;
			}
		}
		return true;
	}
	
	public void resetPuzzle() {
		puzzle.resetPuzzle();
		selectedTile = null;
		numMoves = 0;
		gameOver = false;
		isWon = false;
	}

	public Puzzle getPuzzle() {return puzzle;}
	public void setPuzzle(Puzzle p) {
		puzzle = p;
		numMoves = 0;
		gameOver = false;
		isWon = false;
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

	public int getNumMoves() {
		return numMoves;
	}
}  