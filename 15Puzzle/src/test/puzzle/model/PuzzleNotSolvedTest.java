package test.puzzle.model;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.puzzle.model.Puzzle;

public class PuzzleNotSolvedTest {

	private Puzzle puzzle;

	@Before
	public void setUp() throws Exception {
		puzzle = new Puzzle();
		int counter = 0;
		int gridWidth = puzzle.getGridWidth();
		int[] numbers = new int[((gridWidth * gridWidth) - 1)];
		for (int reversedIndex = (numbers.length - 1); reversedIndex >= 0; reversedIndex--) {
			numbers[reversedIndex] = (numbers.length - 1 - reversedIndex);
		}

		int[][] grid = puzzle.getGrid();
		for (int rowIndex = 0; rowIndex < gridWidth; rowIndex++) {
			for (int colIndex = 0; colIndex < gridWidth; colIndex++) {
				if ((counter + 1) < (gridWidth * gridWidth)) {
					grid[rowIndex][colIndex] = numbers[counter];
				}
				counter++;
			}
		}
		grid[gridWidth - 1][gridWidth - 1] = -1;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		if (puzzle.isSolved()) {
			fail("Not yet implemented");
		}
	}

}
