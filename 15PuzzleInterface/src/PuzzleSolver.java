

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuzzleSolver {

	private Puzzle initialState;
	private Queue<Puzzle> statesQueue = new LinkedList<Puzzle>();
	
	private Puzzle finalState = null;

	public Puzzle getInitialState() {
		return initialState;
	}

	public void setInitialState(Puzzle initialState) {
		this.initialState = initialState;
	}

	public Puzzle solve(Puzzle initialState) {
		this.initialState = initialState;
		statesQueue.add(initialState);
		nextStates();//initialState);
		
		
		return finalState;
	}

	private void nextStates(){//Puzzle state) {
		while(statesQueue.size()>0){
			Puzzle state = statesQueue.poll();
//			if(state.isSolved()){
//				finalState = state;
//				return;
//			}
//			//TODO: check another way to stop
//			if(finalState != null){
//				return;
//			}

			
			int freeRow = 0, freeCol = 0;
			boolean freeCellFound = false;
			for (int rowIndex = 0; (rowIndex < state.getGridWidth())
					&& (!freeCellFound); rowIndex++) {
				for (int colIndex = 0; (colIndex < state.getGridWidth())
						&& (!freeCellFound); colIndex++) {
					if (state.getGrid()[rowIndex][colIndex] == -1) {
						freeRow = rowIndex;
						freeCol = colIndex;
						freeCellFound = true;
					}
				}
			}

			// TODO: generate 4 new states
			//state.setChildren(getChildren(state, freeRow, freeCol));
			List<Puzzle> children = getChildren(state, freeRow, freeCol);
			for(Puzzle child : children){
				if(child.isSolved()){
					finalState = child;
					return;
				}
				
			}
			statesQueue.addAll(children);
//			nextStates(statesQueue.poll());	
			
		}

		
//		for(Puzzle child : state.getChildren()){
//			nextStates(child);
//		}
	}

	private List<Puzzle> getChildren(Puzzle currentState, int freeRow,
			int freeCol) {

		boolean rightOk = true;
		boolean leftOk = true;
		boolean topOk = true;
		boolean bottomOk = true;

		Puzzle rightState = null;
		Puzzle leftState = null;
		Puzzle topState = null;
		Puzzle bottomState = null;

		List<Puzzle> availableChildren = new ArrayList<Puzzle>();
		
		// SWAP Right
		if (freeCol == (currentState.getGridWidth() - 1)) {
			rightOk = false;
		}
		// SWAP Left
		if (freeCol == 0) {
			leftOk = false;
		}
		// SWAP Top
		if (freeRow == 0) {
			topOk = false;
		}
		// SWAP Bottom
		if (freeRow == (currentState.getGridWidth() - 1)) {
			bottomOk = false;
		}

		if (rightOk) {
			rightState = new Puzzle(currentState);
			rightState.getGrid()[freeRow][freeCol] = rightState.getGrid()[freeRow][freeCol + 1];
			rightState.getGrid()[freeRow][freeCol + 1] = -1;
			rightState.setParent(currentState);
			if(!rightState.duplicated()){
				availableChildren.add(rightState);				
			}
		}

		if (leftOk) {
			leftState = new Puzzle(currentState);
			leftState.getGrid()[freeRow][freeCol] = leftState.getGrid()[freeRow][freeCol - 1];
			leftState.getGrid()[freeRow][freeCol - 1] = -1;
			leftState.setParent(currentState);
			if(!leftState.duplicated()){
				availableChildren.add(leftState);				
			}
		}

		if (topOk) {
			topState = new Puzzle(currentState);
			topState.getGrid()[freeRow][freeCol] = topState.getGrid()[freeRow - 1][freeCol];
			topState.getGrid()[freeRow - 1][freeCol] = -1;
			topState.setParent(currentState);
			if(!topState.duplicated()){
				availableChildren.add(topState);				
			}
		}
		
		if (bottomOk) {
			bottomState = new Puzzle(currentState);
			bottomState.getGrid()[freeRow][freeCol] = bottomState.getGrid()[freeRow + 1][freeCol];
			bottomState.getGrid()[freeRow + 1][freeCol] = -1;
			bottomState.setParent(currentState);
			if(!bottomState.duplicated()){
				availableChildren.add(bottomState);				
			}
		}

		return availableChildren;
	}
}
