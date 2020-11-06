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
		
		puzzle.add(new Tile(1,1,3), 0, 0);
		puzzle.add(new Tile(1,1,1), 0, 1);
		puzzle.add(new Tile(1,1,2), 0, 2);
		
		puzzle.add(new Tile(1,1,4), 1, 0);
		puzzle.add(new Tile(1,1,5), 1, 1);
		puzzle.add(new Tile(1,1,6), 1, 2);
		
		puzzle.add(new Tile(1,1,7), 2, 0);
		puzzle.add(new Tile(1,1,4), 2, 1);
		puzzle.add(new Tile(1,1,8), 2, 2);
		
		m.setPuzzle(puzzle);
			
		app.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
		});
		
		app.setVisible(true);

	}
}
