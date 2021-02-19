import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class test{


public static void main (String[] args)throws IOException {
	
	int size = 15;
	String words[] = new String [size];
	
	try{ BufferedReader br = new BufferedReader(new FileReader("dic.txt"));
	    String line = br.readLine();
	    int i=0;
		while (line != null && i<size){
			
				words[i]=  line;
			line = br.readLine();
			i++;
	    }br.close();
		}
     catch (IOException e) {
    	 e.printStackTrace();
     }
	
	
	System.out.println(words[14]);
	
    Random rand = new Random ();
    int word = rand.nextInt(size);
    
if (word<=size) {
		System.out.println(words[word]);
	}
	else
	     {System.out.println("null");}
	
}}
