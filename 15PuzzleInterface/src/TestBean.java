import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class TestBean {
	Puzzle currentState;
	int currentIndex;
	List<Puzzle> r;

	String c00 = "0";
	String c01 = "0";
	String c02 = "0";

	String c10 = "0";
	String c11 = "0";
	String c12 = "0";

	String c20 = "0";
	String c21 = "0";
	String c22 = "0";

	public String startAction() {
		System.out.println("Start at: " + new Date());
		Puzzle initialState = new Puzzle();
		initialState.getGrid()[0][0] = 3;
		initialState.getGrid()[0][1] = 2;
		initialState.getGrid()[0][2] = 8;
		// initialState.getGrid()[0][3] = 12;

		initialState.getGrid()[1][0] = 4;
		initialState.getGrid()[1][1] = 7;
		initialState.getGrid()[1][2] = 6;
		// initialState.getGrid()[1][3] = 7;

		initialState.getGrid()[2][0] = -1;
		initialState.getGrid()[2][1] = 1;
		initialState.getGrid()[2][2] = 5;
		// initialState.getGrid()[2][3] = 5;

		// initialState.getGrid()[3][0] = 6;
		// initialState.getGrid()[3][1] = 8;
		// initialState.getGrid()[3][2] = -1;
		// initialState.getGrid()[3][3] = 10;

		PuzzleSolver puzzleSolver = new PuzzleSolver();
		Puzzle finalState = puzzleSolver.solve(initialState);

		// System.out.println(initialState.isSolved());

		// System.out.println(finalState.isSolved());

		Puzzle printState = finalState;
		r = new LinkedList<Puzzle>();

		while (printState != null) {
			r.add(printState);
			// System.out.println(printState.toString());
			printState = printState.getParent();
			// System.out.println("________________________");
		}
		Collections.reverse(r);
		currentIndex = 0;
		currentState = r.get(currentIndex);

		c00 = String.valueOf(currentState.getGrid()[0][0]);
		c01 = String.valueOf(currentState.getGrid()[0][1]);
		c02 = String.valueOf(currentState.getGrid()[0][2]);

		c10 = String.valueOf(currentState.getGrid()[1][0]);
		c11 = String.valueOf(currentState.getGrid()[1][1]);
		c12 = String.valueOf(currentState.getGrid()[1][2]);

		c20 = String.valueOf(currentState.getGrid()[2][0]);
		c21 = String.valueOf(currentState.getGrid()[2][1]);
		c22 = String.valueOf(currentState.getGrid()[2][2]);

		return "index";

		// for (Puzzle o : r) {
		// System.out.println(o.toString());
		// System.out.println("________________________");
		// }
		// System.out.println("End at: " + new Date());

	}

	public String next() {
		if ((currentIndex + 1) < r.size()) {
			currentState = r.get(++currentIndex);

			c00 = String.valueOf(currentState.getGrid()[0][0]);
			c01 = String.valueOf(currentState.getGrid()[0][1]);
			c02 = String.valueOf(currentState.getGrid()[0][2]);

			c10 = String.valueOf(currentState.getGrid()[1][0]);
			c11 = String.valueOf(currentState.getGrid()[1][1]);
			c12 = String.valueOf(currentState.getGrid()[1][2]);

			c20 = String.valueOf(currentState.getGrid()[2][0]);
			c21 = String.valueOf(currentState.getGrid()[2][1]);
			c22 = String.valueOf(currentState.getGrid()[2][2]);

		}
		return "index";
	}

	public String previous() {
		if ((currentIndex - 1) >= 0) {
			currentState = r.get(--currentIndex);

			c00 = String.valueOf(currentState.getGrid()[0][0]);
			c01 = String.valueOf(currentState.getGrid()[0][1]);
			c02 = String.valueOf(currentState.getGrid()[0][2]);

			c10 = String.valueOf(currentState.getGrid()[1][0]);
			c11 = String.valueOf(currentState.getGrid()[1][1]);
			c12 = String.valueOf(currentState.getGrid()[1][2]);

			c20 = String.valueOf(currentState.getGrid()[2][0]);
			c21 = String.valueOf(currentState.getGrid()[2][1]);
			c22 = String.valueOf(currentState.getGrid()[2][2]);

		}
		return "index";
	}

	public Puzzle getCurrentState() {
		return currentState;
	}

	public void setCurrentState(Puzzle currentState) {
		this.currentState = currentState;
	}

	public String getC00() {
		return c00;
	}

	public void setC00(String c00) {
		this.c00 = c00;
	}

	public String getC01() {
		return c01;
	}

	public void setC01(String c01) {
		this.c01 = c01;
	}

	public String getC02() {
		return c02;
	}

	public void setC02(String c02) {
		this.c02 = c02;
	}

	public String getC10() {
		return c10;
	}

	public void setC10(String c10) {
		this.c10 = c10;
	}

	public String getC11() {
		return c11;
	}

	public void setC11(String c11) {
		this.c11 = c11;
	}

	public String getC12() {
		return c12;
	}

	public void setC12(String c12) {
		this.c12 = c12;
	}

	public String getC20() {
		return c20;
	}

	public void setC20(String c20) {
		this.c20 = c20;
	}

	public String getC21() {
		return c21;
	}

	public void setC21(String c21) {
		this.c21 = c21;
	}

	public String getC22() {
		return c22;
	}

	public void setC22(String c22) {
		this.c22 = c22;
	}

}
