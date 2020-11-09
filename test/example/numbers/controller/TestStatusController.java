package example.numbers.controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;

import org.junit.Test;

import example.numbers.model.Coordinate;
import example.numbers.model.MoveType;
import example.numbers.model.Tile;

public class TestStatusController extends AppTestCase{
	
	@Test
	public void testMove2() {
		SelectTileController stc = new SelectTileController(model,app);
		Point pt = coordinateToPoint(new Coordinate(1,1));
		assertEquals(new Coordinate(1,1), app.getPuzzlePanel().pointToCoordinate(pt));
		
		stc.process(pt);
		
		MoveTileController mtc = new MoveTileController(model, app);
		StatusController sc = new StatusController(model, app);
		assertTrue(mtc.move(MoveType.Right));
		sc.check();
		
		assertTrue(model.getGameOver());
		assertFalse(model.getIsWon());
	}
}
