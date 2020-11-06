package example.numbers.controller;

import java.awt.Point;
import java.util.List;

import example.numbers.boundary.NumberPuzzleApp;
import example.numbers.boundary.UpdateButtons;
import example.numbers.model.Coordinate;
import example.numbers.model.Model;
import example.numbers.model.MoveType;
import example.numbers.model.Puzzle;
import example.numbers.model.Tile;

public class SelectTileController {
	Model model;
	NumberPuzzleApp app;
	
	public SelectTileController(Model m, NumberPuzzleApp app ) {
		this.model = m;
		this.app = app;
	}

	public void process(Point point) {
		Coordinate c = app.getPuzzlePanel().pointToCoordinate(point);
		System.out.print(c);
		Puzzle puzzle = model.getPuzzle();
		
		for(Tile t : puzzle) {
			if(t.contains(c)) {
				model.clearSelTile();
				model.setSelTile(t);
				
				List<MoveType>moves = model.availableMoves(t);
				UpdateButtons.enableButtons(app, moves);
				app.repaint();
			}
		}
	}
}