package eg.edu.alexu.csd.datastructure.iceHockey;


import org.junit.jupiter.api.Test;
import org.junit.Assert;
import java.awt.Point;



  public  class IPlayersFindertest {
	  PlayersFinder test = new PlayersFinder();
	@Test
	 public void test1() {
		 String[] photo = {"33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3",
				 "VNDSD333", "OINFD33X" };
		 final int team = 3;
		 final int threshold = 16;
		 Point[] center = test.findPlayers(photo, team, threshold);
		 Point[] compare = new Point[team];
		 compare[0] = new Point(4,5);
		 compare[1] = new Point(13,9);
		 compare[2] = new Point(14,2);
		 Assert.assertArrayEquals(center, compare);
	 }
}
