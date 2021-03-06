package test.puzzle.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.puzzle.model.Puzzle;

public class PuzzleNotEqualTest {

	private Puzzle puzzle1;
	private Puzzle puzzle2;

	@Before
	public void setUp() throws Exception {
		puzzle1 = new Puzzle();
		int counter = 0;
		int gridWidth = puzzle1.getGridWidth();
		int[][] grid = puzzle1.getGrid();
		for (int rowIndex = 0; rowIndex < gridWidth; rowIndex++) {
			for (int colIndex = 0; colIndex < gridWidth; colIndex++) {
				counter++;
				if (counter < (gridWidth * gridWidth)) {
					grid[rowIndex][colIndex] = counter;
				}
			}
		}
		grid[gridWidth - 1][gridWidth - 1] = -1;
		/////////////////////////////
		puzzle2 = new Puzzle();
		counter = 0;
		gridWidth = puzzle2.getGridWidth();
		int[] numbers = new int[((gridWidth * gridWidth) - 1)];
		for (int reversedIndex = (numbers.length - 1); reversedIndex >= 0; reversedIndex--) {
			numbers[reversedIndex] = (numbers.length - 1 - reversedIndex);
		}

		grid = puzzle2.getGrid();
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
		if(puzzle1.equals(puzzle2)){
			fail("Not yet implemented");
		}
	}

}
