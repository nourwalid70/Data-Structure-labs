import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class dividetest {
	@Test
	public void dividetest1() {
		Calculator junit = new Calculator();
		float result = junit.divide(50,10);
	    assertEquals(5,result,000);
	}

	
	@Test
	public void dividetest2() {
		Calculator junit = new Calculator();
		float result = junit.divide(5,2);
	    assertEquals(2.5,result,000);
	}
	
	@Test
	public void dividetest3() {
		Calculator junit = new Calculator();
		float result = junit.divide(0,9);
	    assertEquals(0,result,0);
	}
	
	
	@Test
	public void dividetest4() {
		Calculator junit = new Calculator();
		assertThrows(RuntimeException.class, ()->{junit.divide(7,0);});
	}
}
