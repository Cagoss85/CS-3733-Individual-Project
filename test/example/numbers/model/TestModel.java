package example.numbers.model;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestModel extends ModelTestCase{
	
	@Test
	public void testInit() {
		assertEquals(0, model.getNumMoves());
	}
	
	@Test
	public void moveCenterLost() {
		Tile t = model.getPuzzle().getTile(1, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
	}
	
	@Test
	public void testGame() {
		Tile t = model.getPuzzle().getTile(0, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Down));
		
		t = model.getPuzzle().getTile(1, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(2, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		
		t = model.getPuzzle().getTile(2, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Down));
		
		t = model.getPuzzle().getTile(0, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(1, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		
		t = model.getPuzzle().getTile(0, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(2, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Left));	
	}
	
	@Test
	public void resetPuzzle() {
		assertFalse(model.combineTile(MoveType.Left));
		Tile t = model.getPuzzle().getTile(1, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		model.resetPuzzle();
		assertEquals(0,model.getNumMoves());
		assertFalse(model.combineTile(MoveType.Left));
		assertFalse(model.getGameOver());
	}
	
	@Test
	public void lockTL() {
		Tile t = model.getPuzzle().getTile(1, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(0, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		assertTrue(model.checkCorners());
		
	}
	
	@Test
	public void lockTR() {
		Tile t = model.getPuzzle().getTile(1, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(2, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		assertTrue(model.checkCorners());
	}
	
	@Test
	public void lockBL() {
		Tile t = model.getPuzzle().getTile(0, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		
		t = model.getPuzzle().getTile(1, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		assertTrue(model.checkCorners());
	}
	
	@Test
	public void lockBR() {
		Tile t = model.getPuzzle().getTile(2, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		
		t = model.getPuzzle().getTile(1, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		assertTrue(model.checkCorners());
		
	}

}
