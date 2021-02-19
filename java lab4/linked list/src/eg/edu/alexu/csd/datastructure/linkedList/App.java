package eg.edu.alexu.csd.datastructure.linkedList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	static PolynomialSolver p = new PolynomialSolver();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1 - Set a polynomial variable\n" + "2 - Print the value of a polynomial variable\n"
				+ "3 - Add two polynomials\n" + "4 - Subtract two polynomials\n" + "5 - Multiply two polynomials\n"
				+ "6 - Evaluate a polynomial at some point\n" + "7 - Clear a polynomial variable\n" + "8 - Exit\n "
				+ "====================================================================");

		Scanner input = new Scanner(System.in);
		String temp = input.next();
		int n = 0;
		try {
			n = Integer.parseInt(temp);
		} catch (NumberFormatException ex) {
			System.out.println("Invalid! You must enter an integer value from 1 to 8.");
			main(null);
		}
		switch (n) {

		case 1: // set polynomial
			char c;
			while (true) {
				System.out.println("Insert the variable name: A, B or C");
				c = (input.next()).charAt(0);
				if (c >= 'A' && c <= 'C' || c >= 'a' && c <= 'c') {
					break;
				}
				System.out.println("Invalid character!");
			}
			System.out.println("Insert the polynomial terms in the form:\n(coeff1, exponent1), (coeff2, exponent2), ..");
			String s = input.next();
			Pattern patt = Pattern.compile("[\\s()*.&%@#$^_+=]");
			Matcher mat = patt.matcher(s);
			s = mat.replaceAll("");
			String[] arrayOfString = s.split(",", 0);
			if(arrayOfString.length%2 != 0) {
				System.out.println("Invalid Input!");
				main(null);
				break;
			}
			int[][] arr = new int[arrayOfString.length / 2][2];

			for (int i = 0; i < arrayOfString.length / 2; i++) {
				try {
					arr[i][0] = Integer.parseInt(arrayOfString[2 * i]);
					arr[i][1] = Integer.parseInt(arrayOfString[2 * i + 1]);
				}catch(NumberFormatException e) {
					System.out.println("Invalid Input!");
					main(null);
				}	
			}
			try {
				p.setPolynomial(c, arr);
				System.out.printf("polynomial %c is set.\n", c);
			} catch (RuntimeException ex1) {
				System.out.println("Empty input!");
			}

			main(null);
			break;

		case 2: // print polynomial
			char c1;
			while (true) {
				System.out.println("Insert the variable name: A, B, C or R ");
				c1 = (input.next()).charAt(0);
				if (c1 >= 'A' && c1 <= 'C' || c1 >= 'a' && c1 <= 'c' || c1 == 'r' || c1 == 'R') {
					break;
				}
				System.out.println("Invalid character!");
			}

			try {
				System.out.println(p.print(c1));
			} catch (RuntimeException ex1) {
				System.out.printf("Polynomial is Empty!\n", c1);
			}
			main(null);
			break;

		case 3: // add two polynomials

			char first, second;
			while (true) {
				System.out.println("Insert first operand variable name: A, B or C");
				first = (input.next()).charAt(0);
				if (first >= 'A' && first <= 'C' || first >= 'a' && first <= 'c') {
					break;
				}
				System.out.println("Invalid character!");
			}

			while (true) {
				System.out.println("Insert second operand variable name: A, B or C");
				second = (input.next()).charAt(0);
				if (second >= 'A' && second <= 'C' || second >= 'a' && second <= 'c') {
					break;
				}
				System.out.println("Invalid character!");
			}

			try {

				int[][] arr1 = p.add(first, second);
				System.out.println("Result set in R:");
				for (int i = 0; i < arr1.length; i++) {
					System.out.printf("(%d,%d) ", arr1[i][0], arr1[i][1]);
				}
				System.out.println();
			} catch (RuntimeException ex1) {
				System.out.println("Invalid!");
			}
			main(null);
			break;

		case 4: // Subtract two polynomials

			char first1, second1;
			while (true) {
				System.out.println("Insert first operand variable name: A, B or C");
				first1 = (input.next()).charAt(0);
				if (first1 >= 'A' && first1 <= 'C' || first1 >= 'a' && first1 <= 'c') {
					break;
				}
				System.out.println("Invalid character!");
			}

			while (true) {
				System.out.println("Insert second operand variable name: A, B or C");
				second1 = (input.next()).charAt(0);
				if (second1 >= 'A' && second1 <= 'C' || second1 >= 'a' && second1 <= 'c') {
					break;
				}
				System.out.println("Invalid character!");
			}

			try {

				int[][] arr2 = p.subtract(first1, second1);
				System.out.println("Result set in R:");
				for (int i = 0; i < arr2.length; i++) {
					System.out.printf("(%d,%d) ", arr2[i][0], arr2[i][1]);
				}
				System.out.println();
			} catch (RuntimeException ex1) {
				System.out.println("Invalid!");
			}
			main(null);

			break;

		case 5: // Multiply two polynomials

			char first2, second2;
			while (true) {
				System.out.println("Insert first operand variable name: A, B or C");
				first2 = (input.next()).charAt(0);
				if (first2 >= 'A' && first2 <= 'C' || first2 >= 'a' && first2 <= 'c') {
					break;
				}
				System.out.println("Invalid character!");
			}

			while (true) {
				System.out.println("Insert second operand variable name: A, B or C");
				second2 = (input.next()).charAt(0);
				if (second2 >= 'A' && second2 <= 'C' || second2 >= 'a' && second2 <= 'c') {
					break;
				}
				System.out.println("Invalid character!");
			}

			try {

				int[][] arr3 = p.multiply(first2, second2);
				System.out.println("Result set in R:");
				for (int i = 0; i < arr3.length; i++) {
					System.out.printf("(%d,%d) ", arr3[i][0], arr3[i][1]);
				}
				System.out.println();
			} catch (RuntimeException ex1) {
				System.out.println("Invalid!");
			}
			main(null);
			break;

		case 6: // Evaluate a polynomial

			char c3;
			while (true) {
				System.out.println("Insert the variable name: A, B or C");
				c3 = (input.next()).charAt(0);
				if (c3 >= 'A' && c3 <= 'C' || c3 >= 'a' && c3 <= 'c') {
					break;
				}
				System.out.println("Invalid character!");
			}

			System.out.println("Enter value : ");
			float value = input.nextFloat();

			try {

				float result = p.evaluatePolynomial(c3, value);
				System.out.printf("Result = %f\n", result);

			} catch (RuntimeException ex1) {
				System.out.println("Polynomial is empty!");
			}

			main(null);
			break;

		case 7: // Clear

			char c4;
			while (true) {
				System.out.println("Insert the variable name: A, B or C");
				c4 = (input.next()).charAt(0);
				if (c4 >= 'A' && c4 <= 'C' || c4 >= 'a' && c4 <= 'c') {
					break;
				}
				System.out.println("Invalid character!");
			}

			p.clearPolynomial(c4);
			main(null);
			break;

		case 8: // Exit
			System.out.println("program terminated.");
			break;

		default:
			System.out.println("Invalid choice!");
			main(null);

		}
	}

}
