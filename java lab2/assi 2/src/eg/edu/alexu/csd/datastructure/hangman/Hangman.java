package eg.edu.alexu.csd.datastructure.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Hangman implements IHangman{
	int size = 63;
	 int p = 0;
	String read[] = new String [size];
	String words[] = new String [size];
	int word;
	public void Read (String[] read) {
		try{ BufferedReader br = new BufferedReader(new FileReader("dic.txt"));
	    String line = br.readLine();
	    int i=0;
		while (line != null && i<size){
			
			read[i]= line;
			line = br.readLine();
			i++;
	    }br.close();
		}
     catch (IOException e) {
    	 e.printStackTrace();
     }}
	
	@Override
	public void setDictionary(String[] words) {
		Read(words);
	} 
	
	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		setDictionary(words);
		Random rand = new Random ();
		word = rand.nextInt(size);
			return words[word];
	}

	@Override
	public String guess(Character c) throws Exception {
		// TODO Auto-generated method stub
	  String s = selectRandomSecretWord();
		 int y = s.length();
		 char[] x = new char[y];
		 for(int i=0;i<y;i++) {
			x[i]='-'; 
			}
		 int check=0;
		 int q = p;
		 while (q!=0) {
			 if(c!= null) {
		 for(int j=0;j<y;j++) {
		if(s.charAt(j)==c) {
		    x[j]=c;
		    check++;}
		} 
		if(check==0) {
			q--;
		}
	check=0;	
		}
		String f = String.copyValueOf(x); 	 
		System.out.println(f);
		if(f.contains("-")) {}
		 else {
			  System.out.println(" YOU WIN ");break;	  
		  }	
		
		   if (q==0) {
		throw new Exception(" YOU LOST ");	  
		  }
		   System.out.println(" Enter another letter ");	 
		   Scanner sc = new Scanner(System.in); 
		    c = sc.next().charAt(0);
		   
		}
		 String u = String.copyValueOf(x); 
		 return u;
		 }

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
			       p=max;
		
		       }
	}
	
 