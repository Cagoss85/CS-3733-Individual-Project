package example.numbers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import example.numbers.boundary.NumberPuzzleApp;
import example.numbers.controller.ExitController;
import example.numbers.model.Model;
import example.numbers.model.Puzzle;
import example.numbers.model.Tile;

public class Main {
	public static void main(String[] args) {
		Model m = new Model();
		Puzzle puzzle = new Puzzle(3,3);
		NumberPuzzleApp app = new NumberPuzzleApp(m);
		
		puzzle.addTile(new Tile(3), 0, 0);
		puzzle.addTile(new Tile(9), 0, 1);
		puzzle.addTile(new Tile(4), 0, 2);
		
		puzzle.addTile(new Tile(6), 1, 0);
		puzzle.addTile(new Tile(1), 1, 1);
		puzzle.addTile(new Tile(5), 1, 2);
		
		puzzle.addTile(new Tile(8), 2, 0);
		puzzle.addTile(new Tile(2), 2, 1);
		puzzle.addTile(new Tile(7), 2, 2);
		
		m.setPuzzle(puzzle);
			
		app.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
		});
		
		m.isGameWon();
		app.setVisible(true);
	}
}
