package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;

public class main {
	public static void main (String[] args){
	  PlayersFinder x = new  PlayersFinder();
	  String[] photo = {"VEJUBUPI", "QUSO11HU", "O1NPH1NB", "P1D1S1HF",
				 "11N1DRBN", "OINCF111" };
		  int team = 1;
		  int threshold = 20;
		x.findPlayers(photo, team, threshold);
		//System.out.println("");
	    
}}
