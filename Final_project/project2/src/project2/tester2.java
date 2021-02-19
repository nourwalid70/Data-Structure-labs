package project2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class tester2 {

	@Test
	void test() {
		TreeDictionary<Integer, String> s = new TreeDictionary<Integer, String>();
		    
		    s.set(50, "50");
		    s.set(45, "45");
		    s.set(55, "55");
		    
		    assertEquals(s.get(50), "50");
		    assertEquals(s.get(45), "45");
		    assertEquals(s.get(55), "55");
		    assertFalse(s.isEmpty());
		    assertEquals(s.remove(50),"50");
		    assertEquals(s.remove(45), "45");
		    assertEquals(s.remove(55), "55");
		    assertTrue(s.isEmpty());    
		    
	}
}
