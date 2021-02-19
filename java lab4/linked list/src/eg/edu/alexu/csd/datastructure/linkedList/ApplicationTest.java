package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplicationTest {

	@Test
	void test1() {
		int[][] A = { { -1, 1 }, { 1, 0 } };
		int[][] B = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 0 } };
		PolynomialSolver p = new PolynomialSolver();
		p.setPolynomial('A', A);
		p.setPolynomial('B', B);
		int[][] R1 = p.add('A', 'B');
		int[][] R2 = p.subtract('A', 'B');
		int[][] R3 = p.multiply('A', 'B');
		int[][] r1 = { { 1, 3 }, { 1, 2 }, { 0, 1 }, { 2, 0 } };
		int[][] r2 = { { -1, 3 }, { -1, 2 }, { -2, 1 }, { 0, 0 } };
		int[][] r3 = { { -1, 4 }, { 0, 3 }, { 0, 2 }, { 0, 1 }, { 1, 0 } };
		assertEquals(1f, p.evaluatePolynomial('A', 0));
		assertEquals(1f, p.evaluatePolynomial('B', 0));
		assertArrayEquals(r1, R1);
		assertArrayEquals(r2, R2);
		assertArrayEquals(r3, R3);
	}

	@Test
	void test2() {
		int[][] A = { { 3, 10 }, { 20, 9 }, { 1, 0 }, { 3, -2 }, { 5, 3 } };
		int[][] B = { { 3, 10 }, { 20, 7 }, { 1, 0 }, { 3, -1 }, { 2, 3 } };
		PolynomialSolver p = new PolynomialSolver();
		p.setPolynomial('A', A);
		p.setPolynomial('B', B);
		int[][] R1 = p.add('A', 'B');
		int[][] R2 = p.subtract('A', 'B');
		int[][] R3 = p.multiply('A', 'B');
		int[][] r1 = { { 6, 10 }, { 20, 9 }, { 20, 7 }, { 7, 3 }, { 2, 0 }, { 3, -1 }, { 3, -2 } };
		int[][] r2 = { { 0, 10 }, { 20, 9 }, { -20, 7 }, { 3, 3 }, { 0, 0 }, { -3, -1 }, { 3, -2 } };
		int[][] r3 = { { 9, 20 }, { 60, 19 }, { 60, 17 }, { 400, 16 }, { 21, 13 }, { 40, 12 }, { 106, 10 }, { 29, 9 },
				{ 69, 8 }, { 20, 7 }, { 10, 6 }, { 60, 5 }, { 7, 3 }, { 15, 2 }, { 6, 1 }, { 1, 0 }, { 3, -1 },
				{ 3, -2 }, { 9, -3 } };
		assertEquals(32, p.evaluatePolynomial('A', 1));
		assertEquals(29, p.evaluatePolynomial('B', 1));
		assertArrayEquals(r1, R1);
		assertArrayEquals(r2, R2);
		assertArrayEquals(r3, R3);
	}

	@Test
	void test3() {
		int[][] A = { { 0, 0 } };
		int[][] C = { { 2, 3 }, { 3, -1 } };
		PolynomialSolver p = new PolynomialSolver();
		p.setPolynomial('A', A);
		p.setPolynomial('C', C);
		int[][] R1 = p.add('A', 'C');
		int[][] R2 = p.subtract('A', 'C');
		int[][] R3 = p.multiply('A', 'C');
		int[][] r1 = { { 2, 3 }, { 0, 0 }, { 3, -1 } };
		int[][] r2 = { { -2, 3 }, { 0, 0 }, { -3, -1 } };
		int[][] r3 = { { 0, 3 }, { 0, -1 } };
		assertEquals(0, p.evaluatePolynomial('A', 0));
		assertEquals(55, p.evaluatePolynomial('C', 3));
		assertArrayEquals(r1, R1);
		assertArrayEquals(r2, R2);
		assertArrayEquals(r3, R3);
	}

	@Test
	void test4() {
		int[][] A = { { 0, 1 }, { 1, 1 }, { -1, 1 }, { 5, 1 }, { -10, 1 } };
		int[][] C = { { 0, -2 }, { 1, -2 }, { -1, -2 }, { 5, -2 }, { -10, -2 } };
		PolynomialSolver p = new PolynomialSolver();
		p.setPolynomial('A', A);
		p.setPolynomial('C', C);
		int[][] R1 = p.add('A', 'C');
		int[][] R2 = p.subtract('A', 'C');
		int[][] R3 = p.multiply('A', 'C');
		int[][] r1 = { { -5, 1 }, { -5, -2 } };
		int[][] r2 = { { -5, 1 }, { 5, -2 } };
		int[][] r3 = { { 25, -1 } };
		assertEquals(0, p.evaluatePolynomial('A', 0));
		assertEquals(-5, p.evaluatePolynomial('C', 1));
		for (int i = 0; i < R1.length; i++) {
			System.out.printf("(%d,%d)\n", R1[i][0], R1[i][1]);
		}
		assertArrayEquals(r1, R1);
		assertArrayEquals(r2, R2);
		assertArrayEquals(r3, R3);
	}

}
