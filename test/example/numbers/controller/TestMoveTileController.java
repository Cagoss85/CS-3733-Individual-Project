package example.numbers.controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import example.numbers.model.Coordinate;
import example.numbers.model.MoveType;

public class TestMoveTileController extends AppTestCase{
	
	@Test
	public void testMove() {
		SelectTileController stc = new SelectTileController(model, app);
		Point pt = coordinateToPoint(new Coordinate(2,1));
		assertEquals(new Coordinate(2,1), app.getPuzzlePanel().pointToCoordinate(pt));
		
		stc.process(pt);
		
		MoveTileController mtc = new MoveTileController(model, app);
		assertTrue(mtc.move(MoveType.Up));
		
		assertEquals(16, model.getPuzzle().getTile(2, 0).getNumber());
	}

}
