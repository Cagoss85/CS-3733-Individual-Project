package example.numbers.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPuzzle {
	
	@Test
	public void testConst() {
		Puzzle p = new Puzzle(2,5);
		assertEquals(2, p.numCols);
		assertEquals(5, p.numRows);
	}

}
