package example.numbers.controller;

import example.numbers.boundary.NumberPuzzleApp;
import example.numbers.boundary.UpdateButtons;
import example.numbers.model.Coordinate;
import example.numbers.model.Model;
import example.numbers.model.MoveType;
import example.numbers.model.Puzzle;
import example.numbers.model.Tile;

public class ResetController {
	Model model;
	NumberPuzzleApp app;
	
	public ResetController(Model m, NumberPuzzleApp app ) {
		this.model = m;
		this.app = app;
	}

	public void reset() {
		model.resetPuzzle();
		UpdateButtons.enableButtons(app, model.availableMoves());
		
		app.getActualNumMovesLabel().setText("" + model.getNumMoves());
		app.repaint();
	}
}