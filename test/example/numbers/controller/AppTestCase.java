package example.numbers.controller;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;

import example.numbers.boundary.NumberPuzzleApp;
import example.numbers.boundary.PuzzlePanel;
import example.numbers.model.Coordinate;
import example.numbers.model.ModelTestCase;


public class AppTestCase extends ModelTestCase{
	
	protected NumberPuzzleApp app;
	
	@Before
	public void createApp()	{
		app = new NumberPuzzleApp(model);
		app.setVisible(true);
	}
	
	@After
	public void tearDown() throws Exception{
		app.setVisible(false);
	}
	
	public static Point coordinateToPoint(Coordinate c) {
		return new Point(c.col * PuzzlePanel.tileSize + PuzzlePanel.tileSize/2, c.row * PuzzlePanel.tileSize + PuzzlePanel.tileSize/2);
	}

}
