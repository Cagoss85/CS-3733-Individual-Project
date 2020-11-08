package example.numbers.controller;

import example.numbers.boundary.NumberPuzzleApp;
import example.numbers.boundary.UpdateButtons;
import example.numbers.model.Model;
import example.numbers.model.MoveType;

public class MoveTileController {
	Model model;
	NumberPuzzleApp app;
	
	public MoveTileController(Model m, NumberPuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public boolean move(MoveType dir) {
		if(model.getSelTile() == null) {return false;}
		
		if(model.combineTile(dir)) {
			UpdateButtons.enableButtons(app, model.availableMoves());
			app.getActualNumMovesLabel().setText("" + model.getNumMoves());
			app.repaint();
		}
		return true;
	}

}
