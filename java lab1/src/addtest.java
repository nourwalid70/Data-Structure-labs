import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class addtest {

	@Test
	public void myaddtest1() {
		Calculator junit = new Calculator();
		int result = junit.add(2,5);
		assertEquals(7,result);
	}

	@Test
	public void myaddtest2() {
		Calculator junit = new Calculator();
		int result = junit.add(0,5);
		assertEquals(5,result);
	}
	
	@Test
	public void myaddtest3() {
		Calculator junit = new Calculator();
		int result = junit.add(100,-100);
		assertEquals(0,result);
	}
	
	
	
	
	
	
}