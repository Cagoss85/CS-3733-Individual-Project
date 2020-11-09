package example.numbers.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTile {

	@Test
	void testConstruction() {
		Tile tile = new Tile(1);
		assertEquals (1,tile.width);
		assertEquals(1,tile.height);
		assertFalse(tile.isBlank());
	}
	
	@Test
	void testCopy() {
		Tile t = new Tile(5);
		Tile tileCopy = t.copy();
		assertEquals(t.getCol(), tileCopy.getCol());
		assertEquals(t.getRow(), tileCopy.getRow());
	}
	
	@Test
	void testNumber() {
		Tile t = new Tile(5);
		assertEquals(5,t.getNumber());
		t.setNumber(7);
		assertEquals(7,t.getNumber());
	}
	
	@Test
	void testContains() {
		Tile t = new Tile(2);
		t.setCol(0);
		t.setRow(0);
		System.out.print(t.height);
		assertTrue(t.contains(new Coordinate(0,0)));
		assertFalse(t.contains(new Coordinate(0,1)));
		
		assertFalse(t.contains(new Coordinate(1,1)));
	}
	
	@Test
	void setBlank()	{
		Tile t = new Tile(2);
		t.setBlank(true);
		assertTrue(t.isBlank());
	}
	
	@Test
	void testCoordinate() {
		Tile t = new Tile(2);
		t.setCol(3);
		t.setRow(3);
		assertEquals(new Coordinate(3,3), t.getLocation());
		
	}
}
