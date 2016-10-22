package test.puzzle.model;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.puzzle.model.Puzzle;

public class PuzzleSolvedTest {
	
	private Puzzle puzzle;

	@Before
	public void setUp() throws Exception {
		puzzle = new Puzzle();
		int counter = 0;
		int gridWidth = puzzle.getGridWidth();
		int[][] grid = puzzle.getGrid();
		for (int rowIndex = 0; rowIndex < gridWidth; rowIndex++) {
			for (int colIndex = 0; colIndex < gridWidth; colIndex++) {
				counter++;
				if (counter < (gridWidth * gridWidth)) {
					grid[rowIndex][colIndex] = counter;
				}
			}
		}
		grid[gridWidth - 1][gridWidth - 1] = -1;
	}

	
	@Test
	public void test() {

		if (!puzzle.isSolved()) {
			fail("Not yet implemented");
		}
	}
	
	@After
	public void tearDown() throws Exception {
	}


}
