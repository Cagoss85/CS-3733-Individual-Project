package example.numbers.controller;

import example.numbers.boundary.NumberPuzzleApp;
import example.numbers.model.Model;

public class StatusController {
	Model model;
	NumberPuzzleApp app;
	
	public StatusController(Model m, NumberPuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void check() {
		model.isGameWon();
		app.repaint();
		
	}
	
	

}
