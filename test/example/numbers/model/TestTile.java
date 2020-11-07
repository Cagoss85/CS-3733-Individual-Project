package example.numbers.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTile {

	@Test
	void testConstruction() {
		Tile tile = new Tile(1);
		assertEquals (1,tile.width);
		assertEquals(1,tile.height);
	}
	
	
	/**
	 * (0,0)(1,0)(2,0)
	 * (0,1)(1,1)(2,1)
	 * (0,2)(1,2)(2,2)
	 */
	@Test
	void testContains() {
		Tile t = new Tile(2);
		t.setCol(0);
		t.setRow(0);
		System.out.print(t.height);
		assertTrue(t.contains(new Coordinate(0,0)));
		assertTrue(t.contains(new Coordinate(0,1)));
		
		assertFalse(t.contains(new Coordinate(1,1)));
	}
}
