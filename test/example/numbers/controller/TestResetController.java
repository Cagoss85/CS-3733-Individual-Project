package example.numbers.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import example.numbers.model.MoveType;
import example.numbers.model.Tile;

public class TestResetController extends AppTestCase{
	
	@Test
	public void testReset() {
		Tile t = model.getPuzzle().getTile(1,0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		assertEquals(1, model.getNumMoves());
		assertTrue(model.getPuzzle().getTile(1, 0).isBlank());
		
		ResetController rc = new ResetController(model, app);
		rc.reset();
		
		assertEquals(0, model.getNumMoves());
		assertFalse(model.getPuzzle().getTile(1, 0).isBlank());
	}

}
