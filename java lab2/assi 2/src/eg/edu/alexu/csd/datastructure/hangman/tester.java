package eg.edu.alexu.csd.datastructure.hangman;

import java.util.Scanner;

public class tester {
public static void main (String[] args)throws Exception{
    Hangman x = new Hangman();
       x.setMaxWrongGuesses(8);
       System.out.println("Enter your frist letter");
       try (Scanner sc = new Scanner(System.in)) {
		char c = sc.next().charAt(0);  
		 x.guess(c);
	}
}}