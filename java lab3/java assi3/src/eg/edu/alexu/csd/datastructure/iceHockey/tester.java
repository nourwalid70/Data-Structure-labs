package eg.edu.alexu.csd.datastructure.iceHockey;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import java.awt.Point;



  public  class tester {
	  PlayersFinder test = new PlayersFinder();
	@Test
	  public void test1() {
		 String[] photo = {"33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3",
				 "VNDSD333", "OINFD33X" };
		  int team = 3;
		  int threshold = 16;
		 Point[] center = test.findPlayers(photo, team, threshold);
		 int numOfpoint = 3;
		 Point[] compare = new Point[numOfpoint];
		 compare[0] = new Point(4,5);
		 compare[1] = new Point(13,9);
		 compare[2] = new Point(14,2);
		 Assert.assertArrayEquals(center, compare);
	 }
	  @Test
	  public void test2() {
		  String[] photo = {"44444H44S4",
				  "K444K4L444",
				  "4LJ44T44XH",
				  "444O4VIF44",
				  "44C4D4U444",
				  "4V4Y4KB4M4",
				  "G4W4HP4O4W",
				  "4444ZDQ4S4",
				  "4BR4Y4A444",
		  "4G4V4T4444" };
		   int team = 4;
		   int threshold = 16;
		  Point[] center = test.findPlayers(photo, team, threshold);
		   int numOfPoint = 6;
		  Point[] compare = new Point[ numOfPoint];
		  compare[0] = new Point(3,8);
		  compare[1] = new Point(4,16);
		  compare[2] = new Point(5,4);
		  compare[3] = new Point(16,3);
		  compare[4] = new Point(16,17);
		  compare[5] = new Point(17,9);
		  Assert.assertArrayEquals(center, compare);
	  }
    @Test	
     public void test3() {
    	String[] photo = {"11111",
    			"1AAA1",
    			"1A1A1",
    			"1AAA1",
    	"11111" };
    	 int team = 1;
    	 int threshold = 3;
    	Point[] center = test.findPlayers(photo, team, threshold);
    	 int numOfPoint =2;
    	Point[] compare = new Point[numOfPoint];
    	compare[0] = new Point(5,5);
    	compare[1] = new Point(5,5);
    	Assert.assertArrayEquals(center, compare);
    }

    @Test	
    public void test4() {
   	String[] photo = {};
   	 int team = 0;
   	 int threshold = 0;
   	Point[] center = test.findPlayers(photo, team, threshold);
   	Assert.assertArrayEquals(center, null);
   }
    
    
    @Test 
    public void test5() {
    	
   String[] photo = {
		   "8D88888J8L8E888",
		   "88NKMG8N8E8JI88",
		   "888NS8EU88HN8EO",
		   "LUQ888A8TH8OIH8",
		   "888QJ88R8SG88TY",
		   "88ZQV88B88OUZ8O",
		   "FQ88WF8Q8GG88B8",
		   "8S888HGSB8FT8S8",
		   "8MX88D88888T8K8",
		   "8S8A88MGVDG8XK8",
		   "M88S8B8I8M88J8N",
		   "8W88X88ZT8KA8I8",
		   "88SQGB8I8J88W88",
		   "U88H8NI8CZB88B8",
		   "8PK8H8T8888TQR8"
		   };
   int team = 8;
 	 int threshold = 9;
 	Point[] center = test.findPlayers(photo, team, threshold);
 	 int numOfPoint =19;
 	Point[] compare = new Point[numOfPoint];
 	compare[0] = new Point(1,17);
 	compare[1] = new Point(3,3);
 	compare[2] = new Point(3,10);
 	compare[3] = new Point(3,25);
 	compare[4] = new Point(5,21);
 	compare[5] = new Point(8,17);
 	compare[6] = new Point(9,2);
 	compare[7] = new Point(10,9);
 	compare[8] = new Point(12,23);
 	compare[9] = new Point(17,16);
 	compare[10] = new Point(18,3);
 	compare[11] = new Point(18,11);
 	compare[12] = new Point(18,28);
 	compare[13] = new Point(22,20);
 	compare[14] = new Point(23,26);
 	compare[15] = new Point(24,15);
 	compare[16] = new Point(27,2);
 	compare[17] = new Point(28,26);
 	compare[18] = new Point(29,16);
 	Assert.assertArrayEquals(center, compare);
    }
    
    @Test
	  public void test6() {
		 String[] photo = {"VEJUBUPI", "QUSO11HU", "O1NPH1NB", "P1D1S1HF",
				 "11N1DRBN", "OINCF111" };
		  int team = 1;
		  int threshold = 20;
		 Point[] center = test.findPlayers(photo, team, threshold);
		 Assert.assertArrayEquals(center,null);
	 }
  
    @Test
	  public void test7() {
		 String[] photo = {"VEJUBUPI", "QUSOADHU", "OUNPHENB", "P1DNSKHF"};
		  int team = 1;
		  int threshold = 20;
		 Point[] center = test.findPlayers(photo, team, threshold);
		 Assert.assertArrayEquals(center,null);
	 }
    
    @Test
	  public void test8() {
		 String[] photo = {"VEJUBUPI", "QUSO11HU", "O1NPH1NB", "P1D1S1HF",
				 "11N1DRBN", "OIN1F111" };
		  int team = 5;
		  int threshold = 2;
		 Point[] center = test.findPlayers(photo, team, threshold);
		 Assert.assertArrayEquals(center,null);
	 }
  }
