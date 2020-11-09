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
	public void testIsWon() {
		model.setIsWon(true);
		assertTrue(model.getIsWon());
	}
	
	@Test
	public void testGameOver() {
		model.setGameOver(true);
		assertTrue(model.getGameOver());
	}
	
	@Test
	public void moveCenterLost() {
		Tile t = model.getPuzzle().getTile(1, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		model.isGameWon();
		assertFalse(model.getIsWon());
		assertTrue(model.getGameOver());
	}
	
	
	@Test
	public void winGame() {
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
		model.isGameWon();
	}
	
	@Test
	public void bothLocked() {
		Tile t = model.getPuzzle().getTile(0, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		
		t = model.getPuzzle().getTile(0, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(2, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Left));
		
		t = model.getPuzzle().getTile(2, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		
		t = model.getPuzzle().getTile(0, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(1, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
	
		model.isGameWon();
		assertTrue(model.sidesLocked());
	}
	
	@Test
	public void topLocked() {
		Tile t = model.getPuzzle().getTile(2, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		
		t = model.getPuzzle().getTile(0, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		
		t = model.getPuzzle().getTile(0, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(2, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Left));
		
		t = model.getPuzzle().getTile(0, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(2, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Left));
		
		t = model.getPuzzle().getTile(1, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
	
		model.isGameWon();
		assertTrue(model.sidesLocked());
	}
	
	@Test
	public void sideLocked() {
		Tile t = model.getPuzzle().getTile(0, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(1, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(2, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		
		t = model.getPuzzle().getTile(0, 1);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(0, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(2, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Left));
		
		t = model.getPuzzle().getTile(1, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Down));
	
		model.isGameWon();
		assertTrue(model.sidesLocked());
	}
	
	@Test
	public void cornersGone() {
		Tile t = model.getPuzzle().getTile(0, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(0, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Right));
		
		t = model.getPuzzle().getTile(2, 0);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Left));
		
		t = model.getPuzzle().getTile(2, 2);
		model.setSelTile(t);
		assertTrue(model.combineTile(MoveType.Up));
		assertTrue(model.cornersGone());
		
			
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
	public void isolateCorner() {
		
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
