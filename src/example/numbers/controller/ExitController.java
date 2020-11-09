package example.numbers.controller;

import javax.swing.JOptionPane;

import example.numbers.boundary.NumberPuzzleApp;
import example.numbers.boundary.UpdateButtons;
import example.numbers.model.Coordinate;
import example.numbers.model.Model;
import example.numbers.model.MoveType;
import example.numbers.model.Puzzle;
import example.numbers.model.Tile;

public class ExitController {
	NumberPuzzleApp app;
	
	public ExitController(NumberPuzzleApp app ) {
		this.app = app;
	}

	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you want to Exit?");
		if(c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
	
	public void exitTest() {
		int c = 0;
		if(c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
}