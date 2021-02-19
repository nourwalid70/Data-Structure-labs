package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

	@Test
	void test0() {
		DoublyLinkedList L = new DoublyLinkedList();
		assertEquals(0, L.size());
		assertEquals(true, L.isEmpty());
		
		L.add("Hello world!");
		Point x = new Point(-5,30);
		L.add(x);
		L.add(523);
		L.add('c');
		L.add(52369.1023);
		L.add(20.5f);
		L.add(true);
		assertFalse(L.isEmpty());
		assertEquals(7,L.size());
		assertThrows(RuntimeException.class, ()->{L.add(null);});		 
		assertEquals(7,L.size());
		
		assertFalse(L.contains(2000));
		assertFalse(L.contains(null));
		assertTrue(L.contains(x));
		assertTrue(L.contains('c'));
		
		assertEquals(null,L.get(-5));
		assertEquals("Hello world!",L.get(0));
		assertEquals(x , L.get(1));
		assertEquals(523 , L.get(2));
		assertEquals(true , L.get(6));
		assertEquals(null,L.get(7));
		
		
		L.add(0, "Data");
		assertThrows(RuntimeException.class, ()->{L.add(20,5);});
		assertEquals(8,L.size());
		assertEquals("Data",L.get(0));
		assertEquals("Hello world!",L.get(1));
		assertEquals(x , L.get(2));
		
		assertEquals(20.5f , L.get(6));
		assertEquals(true , L.get(7));
		
		
		L.add(5,"Class");
		L.set(5,"Object");
		assertEquals("Object", L.get(5));
		assertThrows(RuntimeException.class, ()->{L.set(20,5);});
		
		L.remove(0);
		L.remove(0);
		assertEquals(x, L.get(0));
		assertThrows(RuntimeException.class, ()->{L.remove(-1);});
		
		assertEquals(false, L.isEmpty());
		L.clear();
		assertEquals(null,L.get(0));
		assertEquals(true, L.isEmpty());
		assertEquals(0, L.size());
		
	}
	
	@Test
	void test1() {
		
		DoublyLinkedList L = new DoublyLinkedList();
		L.add("Hello world!");
		Point x = new Point(-5,30);
		L.add(x);
		L.add(523);
		L.add('c');
		L.add(52369.1023);
		L.add(20.5f);
		L.add(true);
		
		DoublyLinkedList M = (DoublyLinkedList) L.sublist(1, 4);
		assertEquals(4,M.size());
		assertEquals(x,M.get(0));
		assertEquals(52369.1023,M.get(3));
		assertEquals(true,M.contains('c'));
	}
	

}