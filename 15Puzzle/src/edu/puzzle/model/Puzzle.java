package edu.puzzle.model;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {

	private Puzzle parent;

	private List<Puzzle> children = new ArrayList<Puzzle>();

	private int gridWidth = 4;

	private int[][] grid = new int[gridWidth][gridWidth];

	public Puzzle() {
	}

	public Puzzle(Puzzle state) {
		for (int rowIndex = 0; rowIndex < gridWidth; rowIndex++) {
			for (int colIndex = 0; colIndex < gridWidth; colIndex++) {
				grid[rowIndex][colIndex] = state.getGrid()[rowIndex][colIndex];
			}
		}
	}

	public int getGridWidth() {
		return gridWidth;
	}

	public void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	public Puzzle getParent() {
		return parent;
	}

	public void setParent(Puzzle parent) {
		this.parent = parent;
	}

	public List<Puzzle> getChildren() {
		return children;
	}

	public void setChildren(List<Puzzle> children) {
		this.children = children;
	}

	public boolean isSolved() {
		int counter = 0;
		for (int rowIndex = 0; rowIndex < gridWidth; rowIndex++) {
			for (int colIndex = 0; colIndex < gridWidth; colIndex++) {
				counter++;
				if (counter < (gridWidth * gridWidth)) {
					if (grid[rowIndex][colIndex] != counter) {
						return false;
					}
				}
			}
		}
		return true;
	}

	// Search if this state is in parent tree
	public boolean duplicated() {
		Puzzle currentParent = parent;
		while (currentParent != null) {
			if (this.equals(currentParent)) {
				return true;
			} else {
				currentParent = currentParent.getParent();
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		int[][] objGrid = ((Puzzle) obj).getGrid();
		for (int rowIndex = 0; rowIndex < gridWidth; rowIndex++) {
			for (int colIndex = 0; colIndex < gridWidth; colIndex++) {
				if (grid[rowIndex][colIndex] != objGrid[rowIndex][colIndex]) {
					return false;
				}
			}
		}
		return true;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int rowIndex = 0; rowIndex < gridWidth; rowIndex++) {
			str.append("-------------\n");
			for (int colIndex = 0; colIndex < gridWidth; colIndex++) {
				if (grid[rowIndex][colIndex] != -1) {
					str.append("| " + grid[rowIndex][colIndex] + " ");
				}else {
					str.append("|   ");
				}
			}
			str.append("|\n");
		}
		str.append("-------------");
		return str.toString();

	}
}
