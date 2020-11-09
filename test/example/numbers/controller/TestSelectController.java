package example.numbers.controller;

import static org.junit.Assert.*;

import java.awt.Point;
import example.numbers.model.Coordinate;
import example.numbers.model.Tile;

import org.junit.Test;

public class TestSelectController extends AppTestCase{
	
	@Test
	public void testSelect() {
		SelectTileController stc = new SelectTileController(model, app);
		Point pt = coordinateToPoint(new Coordinate(0,0));
		assertEquals(new Coordinate(0,0), app.getPuzzlePanel().pointToCoordinate(pt));
		
		stc.process(pt);
		
		Tile t = model.getPuzzle().getTile(0, 0);
		assertEquals(t, model.getSelTile());
		
		assertTrue(app.getRightButton().isEnabled());
		assertTrue(app.getDownButton().isEnabled());
		assertFalse(app.getLeftButton().isEnabled());
		assertFalse(app.getUpButton().isEnabled());
	}
}
