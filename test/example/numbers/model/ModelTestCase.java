package example.numbers.model;

import org.junit.Before;

public abstract class ModelTestCase {
	
	protected Model model;
	
	@Before
	public void setUp() {
		
		model = new Model();
		Puzzle puzzle = new Puzzle(3,3);

		puzzle.addTile(new Tile(3), 0, 0);
		puzzle.addTile(new Tile(9), 0, 1);
		puzzle.addTile(new Tile(4), 0, 2);
		
		puzzle.addTile(new Tile(6), 1, 0);
		puzzle.addTile(new Tile(1), 1, 1);
		puzzle.addTile(new Tile(5), 1, 2);
		
		puzzle.addTile(new Tile(8), 2, 0);
		puzzle.addTile(new Tile(2), 2, 1);
		puzzle.addTile(new Tile(7), 2, 2);
		
		model.setPuzzle(puzzle);
		
	}

}
