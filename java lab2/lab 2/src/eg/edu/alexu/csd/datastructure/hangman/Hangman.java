package eg.edu.alexu.csd.datastructure.hangman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Hangman implements IHangman{
    int size = 16;
    int max;
	String words[] = new String [size];
	
	@Override
	public void setDictionary(String[] words) {
		try{ BufferedReader br = new BufferedReader(new FileReader("dic.txt"));
	    String line = br.readLine();
	    int i=0;
		while (line != null && i<size){
			
				words[i]= line;
			line = br.readLine();
			i++;
	    }br.close();
		}
     catch (IOException e) {
    	 e.printStackTrace();
     }
	} 

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		Random rand = new Random ();
		int word = rand.nextInt(size);
		
			return words[word];
	}

	@Override
	public String guess(Character c) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		
		
	}
}
