import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.puzzle.model.Puzzle;
import edu.puzzle.solver.PuzzleSolver;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start at: " + new Date());
		Puzzle initialState = new Puzzle();
		initialState.getGrid()[0][0] = 5;
		initialState.getGrid()[0][1] = 9;
		initialState.getGrid()[0][2] = 2;
		initialState.getGrid()[0][3] = 6;

		initialState.getGrid()[1][0] = 12;
		initialState.getGrid()[1][1] = 7;
		initialState.getGrid()[1][2] = 10;
		initialState.getGrid()[1][3] = 15;

		initialState.getGrid()[2][0] = 11;
		initialState.getGrid()[2][1] = 4;
		initialState.getGrid()[2][2] = 13;
		initialState.getGrid()[2][3] = 3;

		initialState.getGrid()[3][0] = 14;
		initialState.getGrid()[3][1] = -1;
		initialState.getGrid()[3][2] = 1;
		initialState.getGrid()[3][3] = 8;

		PuzzleSolver puzzleSolver = new PuzzleSolver();
		Puzzle finalState = puzzleSolver.solve(initialState);

		System.out.println(initialState.isSolved());

		System.out.println(finalState.isSolved());

		Puzzle printState = finalState;
		List<Puzzle> r = new LinkedList<Puzzle>();

		while (printState != null) {
			r.add(printState);
			// System.out.println(printState.toString());
			printState = printState.getParent();
			// System.out.println("________________________");
		}
		Collections.reverse(r);
		for (Puzzle o : r) {
			System.out.println(o.toString());
			System.out.println("________________________");
		}
		System.out.println("End at: " + new Date());
	}

}
