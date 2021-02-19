package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testSingle {

	@Test
	public void testingInsertion() {
		SingleLinkedList testSingle = new SingleLinkedList();
		testSingle.add(0, 'a');
		testSingle.add(1, 'b');
		testSingle.add(2, 'c');
		testSingle.add(3, 'd');
		assertEquals('a', testSingle.get(0));
		assertEquals('b', testSingle.get(1));
		assertEquals('c', testSingle.get(2));
		assertEquals('d', testSingle.get(3));

	}

	@Test
	public void testingSetMethod() {
		SingleLinkedList testSingle = new SingleLinkedList();
		testSingle.add(0, 'a');
		testSingle.add(1, 'b');
		testSingle.add(2, 'c');
		testSingle.add(3, 'd');
		testSingle.set(2, 'z');
		assertEquals('z', testSingle.get(2));
	}

	@Test
	public void testSubLists() {
		SingleLinkedList testSingle = new SingleLinkedList();

		testSingle.add(0, "my");
		testSingle.add(1, "name");
		testSingle.add(2, "is");
		testSingle.add(3, "malk");
		testSingle.add(4, "waled");
		testSingle.add(5, "ali");
		ILinkedList sublist = new SingleLinkedList();
		sublist = testSingle.sublist(3, 5);
		assertEquals("malk", sublist.get(0));
		assertEquals("waled", sublist.get(1));
		assertEquals("ali", sublist.get(2));
		assertEquals(3, sublist.size());
	}

	@Test
	public void testingRemoving() {
		SingleLinkedList testSingle = new SingleLinkedList();
		testSingle.add(0, 'a');
		testSingle.add(1, 'b');
		testSingle.add(2, 'c');
		testSingle.add(3, 'd');
		assertEquals(4, testSingle.size());
		assertEquals('c', testSingle.get(2));
		testSingle.remove(2);
		assertEquals('d', testSingle.get(2));
		assertEquals(3, testSingle.size());
	}

	@Test
	public void testingsize() {
		SingleLinkedList testSingle = new SingleLinkedList();
		testSingle.add(0, 'n');
		testSingle.add(1, 'o');
		testSingle.add(2, 'u');
		testSingle.add(3, 'r');
		testSingle.add(3, 'i');
		assertEquals(5, testSingle.size());
	}

	@Test
	public void testingclear() {
		SingleLinkedList testSingle = new SingleLinkedList();
		testSingle.add(0, 'n');
		testSingle.add(1, 'o');
		testSingle.add(2, 'p');
		testSingle.add(3, 'q');
		testSingle.add(3, 'r');
		assertFalse(testSingle.isEmpty());
		testSingle.clear();
		assertTrue(testSingle.isEmpty());
		assertEquals(0, testSingle.size());
	}

	@Test
	public void testcontains() {
		SingleLinkedList testSingle = new SingleLinkedList();
		testSingle.add(0, 11);
		testSingle.add(1, 22);
		testSingle.add(2, 33);
		testSingle.add(3, 55);
		assertTrue(testSingle.contains(33));
		assertFalse(testSingle.contains(44));
	}

}
