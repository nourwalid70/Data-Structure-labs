package eg.edu.alexu.csd.datastructure.linkedList;

import java.awt.Point;

public class PolynomialSolver implements IPolynomialSolver {

	SingleLinkedList[] polynomials = { new SingleLinkedList(), new SingleLinkedList(), new SingleLinkedList(),
			new SingleLinkedList() }; // 0 >> A , 1 >> B , 2 >> C , 3 >> R

	public void removeDuplicates(SingleLinkedList L) {
		for (int i = 0; i < L.size() - 1; i++) {
			if (((Point) L.get(i)).y == ((Point) L.get(i + 1)).y) {
				L.set(i, new Point(((Point) L.get(i)).x + ((Point) L.get(i + 1)).x, ((Point) L.get(i)).y));
				L.remove(i + 1);
				i--;
			}
		}
	}

	public void listToArray(SingleLinkedList L, int[][] arr) {
		for (int i = 0; i < L.size(); i++) {
			arr[i][0] = (int) ((Point) L.get(i)).getX();
			arr[i][1] = (int) ((Point) L.get(i)).getY();
		}
	}

	public void arrayToList(SingleLinkedList L, int[][] arr) {
		// list of points (coefficients,exponents)
		for (int i = 0; i < arr.length; i++) {
			Point p = new Point(arr[i][0], arr[i][1]);
			L.add(p);
		}
	}

	public void sortpoint(int[][] terms) {
		boolean sorted = true;
		int tempX; // ***********************************************
		int tempY;
		for (int i = 0; i < terms.length; i++) {
			for (int j = 0; j < terms.length - i - 1; j++) {
				if (terms[j][1] < terms[j + 1][1]) {
					sorted = false;
					tempX = terms[j][0];
					tempY = terms[j][1];
					terms[j][0] = terms[j + 1][0];
					terms[j][1] = terms[j + 1][1];
					terms[j + 1][0] = tempX;
					terms[j + 1][1] = tempY;
				}
			}
			if (sorted) {
				break;
			}
		}
	}

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		// TODO Auto-generated method stub
		sortpoint(terms);
		if (terms.length == 0 || terms == null) {
			throw new RuntimeException();
		} else {
			clearPolynomial(poly);
			poly = Character.toLowerCase(poly);
			int p = (int) poly - 97;
			arrayToList(polynomials[p], terms);
			removeDuplicates(polynomials[p]);
		}
	}

	@Override
	public String print(char poly) {
		// TODO Auto-generated method stub
		String S = "";
		poly = Character.toLowerCase(poly);
		if (poly == 'r') {
			poly = 'd';
		}
		int p = (int) poly - 97;
		if (polynomials[p].size() == 0) {
			throw new RuntimeException();
		}
		for (int i = 0; i < polynomials[p].size(); i++) {

			if (((Point) polynomials[p].get(i)).x < 0) {

				if (((Point) polynomials[p].get(i)).y == 0) {
					S = S + ((Point) polynomials[p].get(i)).x;
				} else if (((Point) polynomials[p].get(i)).y == 1 && ((Point) polynomials[p].get(i)).x == -1) {
					S = S + "-" + "x";
				} else if (((Point) polynomials[p].get(i)).y == 1) {
					S = S + ((Point) polynomials[p].get(i)).x + "x";

				} else if (((Point) polynomials[p].get(i)).x == -1) {
					S = S + "-" + "x^" + ((Point) polynomials[p].get(i)).y;
				} else {
					S = S + ((Point) polynomials[p].get(i)).x + "x^" + ((Point) polynomials[p].get(i)).y;
				}

			} else {

				if (((Point) polynomials[p].get(i)).x == 0) {
					continue;
				} else if (((Point) polynomials[p].get(i)).y == 0) {
					S = S + "+" + ((Point) polynomials[p].get(i)).x;
				} else if (((Point) polynomials[p].get(i)).y == 1 && ((Point) polynomials[p].get(i)).x == 1) {
					S = S + "+" + "x";
				} else if (((Point) polynomials[p].get(i)).y == 1) {
					S = S + "+" + ((Point) polynomials[p].get(i)).x + "x";

				} else if (((Point) polynomials[p].get(i)).x == 1) {
					S = S + "+" + "x^" + ((Point) polynomials[p].get(i)).y;
				} else {
					S = S + "+" + ((Point) polynomials[p].get(i)).x + "x^" + ((Point) polynomials[p].get(i)).y;
				}

			}

		}
		if (S.charAt(0) == '+') {
			S = S.substring(1, S.length());
		}
		return S;
	}

	@Override
	public void clearPolynomial(char poly) {
		// TODO Auto-generated method stub
		poly = Character.toLowerCase(poly);
		int p = (int) poly - 97;
		polynomials[p].clear();
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		// TODO Auto-generated method stub
		poly = Character.toLowerCase(poly);
		int p = (int) poly - 97;
		if (polynomials[p].size() == 0) {
			throw new RuntimeException();
		}
		float output = 0f;
		for (int i = 0; i < polynomials[p].size(); i++) {
			output += ((Point) polynomials[p].get(i)).x * Math.pow(value, ((Point) polynomials[p].get(i)).y);
		}
		return output;

	}

	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		poly1 = Character.toLowerCase(poly1);
		int p1 = (int) poly1 - 97;
		poly2 = Character.toLowerCase(poly2);
		int p2 = (int) poly2 - 97;
		if (polynomials[p1].size() == 0 || polynomials[p2].size() == 0) {
			throw new RuntimeException();
		}
		clearPolynomial('d');
		int i = 0; // >>> p1
		int j = 0; // >>> p2
		while (i != polynomials[p1].size() && j != polynomials[p2].size()) {
			if (((Point) polynomials[p1].get(i)).y == ((Point) polynomials[p2].get(j)).y) {
				polynomials[3].add(new Point(((Point) polynomials[p1].get(i)).x + ((Point) polynomials[p2].get(j)).x,
						((Point) polynomials[p1].get(i)).y));
				i++;
				j++;
			} else if (((Point) polynomials[p1].get(i)).y < ((Point) polynomials[p2].get(j)).y) {
				polynomials[3].add(new Point(((Point) polynomials[p2].get(j)).x, ((Point) polynomials[p2].get(j)).y));
				j++;
			} else {
				polynomials[3].add(new Point(((Point) polynomials[p1].get(i)).x, ((Point) polynomials[p1].get(i)).y));
				i++;
			}

		}

		if (i == polynomials[p1].size() && j != polynomials[p2].size()) {
			while (j != polynomials[p2].size()) {
				polynomials[3].add(new Point(((Point) polynomials[p2].get(j)).x, ((Point) polynomials[p2].get(j)).y));
				j++;
			}
		}

		if (j == polynomials[p2].size() && i != polynomials[p1].size()) {
			while (i != polynomials[p1].size()) {
				polynomials[3].add(new Point(((Point) polynomials[p1].get(i)).x, ((Point) polynomials[p1].get(i)).y));
				i++;
			}
		}

		int[][] arr = new int[polynomials[3].size()][2]; // *******************max size ?
		listToArray(polynomials[3], arr);
		return arr;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		poly1 = Character.toLowerCase(poly1);
		int p1 = (int) poly1 - 97;
		poly2 = Character.toLowerCase(poly2);
		int p2 = (int) poly2 - 97;

		if (polynomials[p1].size() == 0 || polynomials[p2].size() == 0) {
			throw new RuntimeException("polynomial is empty!");
		}
		clearPolynomial('d');
		int i = 0; // >>> p1
		int j = 0; // >>> p2
		while (i != polynomials[p1].size() && j != polynomials[p2].size()) {
			if (((Point) polynomials[p1].get(i)).y == ((Point) polynomials[p2].get(j)).y) {
				polynomials[3].add(new Point(((Point) polynomials[p1].get(i)).x - ((Point) polynomials[p2].get(j)).x,
						((Point) polynomials[p1].get(i)).y));
				i++;
				j++;
			} else if (((Point) polynomials[p1].get(i)).y < ((Point) polynomials[p2].get(j)).y) {
				polynomials[3].add(new Point(-((Point) polynomials[p2].get(j)).x, ((Point) polynomials[p2].get(j)).y));
				j++;
			} else {
				polynomials[3].add(new Point(((Point) polynomials[p1].get(i)).x, ((Point) polynomials[p1].get(i)).y));
				i++;
			}

		}

		if (i == polynomials[p1].size() && j != polynomials[p2].size()) {
			while (j != polynomials[p2].size()) {
				polynomials[3].add(new Point(-((Point) polynomials[p2].get(j)).x, ((Point) polynomials[p2].get(j)).y));
				j++;
			}
		}

		if (j == polynomials[p2].size() && i != polynomials[p1].size()) {
			while (i != polynomials[p1].size()) {
				polynomials[3].add(new Point(((Point) polynomials[p1].get(i)).x, ((Point) polynomials[p1].get(i)).y));
				i++;
			}
		}

		int[][] arr = new int[polynomials[3].size()][2]; // *******************max size ?
		listToArray(polynomials[3], arr);
		return arr;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		poly1 = Character.toLowerCase(poly1);
		int p1 = (int) poly1 - 97;
		poly2 = Character.toLowerCase(poly2);
		int p2 = (int) poly2 - 97;

		if (polynomials[p1].size() == 0 || polynomials[p2].size() == 0) {
			throw new RuntimeException("polynomial is empty!");
		}
		clearPolynomial('d');
		for (int i = 0; i < polynomials[p1].size(); i++) {
			for (int j = 0; j < polynomials[p2].size(); j++) {
				polynomials[3].add(new Point(((Point) polynomials[p1].get(i)).x * ((Point) polynomials[p2].get(j)).x,
						((Point) polynomials[p1].get(i)).y + ((Point) polynomials[p2].get(j)).y));
			}
		}

		// ******************function remove
		// duplicates***************************************
		int[][] arr = new int[polynomials[3].size()][2];
		listToArray(polynomials[3], arr);
		sortpoint(arr);
		polynomials[3].clear();
		arrayToList(polynomials[3], arr);
		removeDuplicates(polynomials[3]);
		arr = new int[polynomials[3].size()][2];
		listToArray(polynomials[3], arr);
		return arr;
	}

}
