package eg.edu.alexu.csd.datastructure.linkedList;

public class DoublyLinkedList implements ILinkedList {

	private class NodeDoubly {

		public Object value;
		public NodeDoubly next = null;
		public NodeDoubly prev = null;

		// constructor
		public NodeDoubly(Object value) {
			this.value = value;
		}
	}

	// the linked list class starts from here
	private NodeDoubly head; // starts with a dummy header node
	private int size;

	// constructor
	public DoublyLinkedList() {
		this.size = 0;
		this.head = new NodeDoubly(-1); // set the value of the dummy node = -1
	}

	@Override
	public void add(int index, Object element) { // index starts from 0 //insert anywhere except the end
		// TODO Auto-generated method stub
		if (index < size && index >= 0 && element != null) { 
			NodeDoubly node = head;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			NodeDoubly newNode = new NodeDoubly(element);
			newNode.prev = node;
			newNode.next = node.next;
			node.next.prev = newNode;
			node.next = newNode;
			this.size++;
		} else {
			throw null;
		}
	}

	@Override
	public void add(Object element) { // insert at the end
		// TODO Auto-generated method stub
		if (element != null) {
			NodeDoubly node = head;
			while (node.next != null) {
				node = node.next;
			}
			NodeDoubly newNode = new NodeDoubly(element);
			node.next = newNode;
			newNode.prev = node;
			this.size++;
		} else {
			throw null;
		}
	}

	@Override
	public Object get(int index) { // return the element at the specified index.
		// TODO Auto-generated method stub
		if (index < size && index >= 0) {
			NodeDoubly node = head;
			for (int i = 0; i <= index; i++) {
				node = node.next;
			}
			return node.value;
		}
		return null;
	}

	@Override
	public void set(int index, Object element) { // Replaces the element at the specified position with the specified
													// element.
		// TODO Auto-generated method stub
		if (index < size && index >= 0) {
			NodeDoubly node = head;
			for (int i = 0; i <= index; i++) {
				node = node.next;
			}
			node.value = element;
		} else {
			throw null;
		}
	}

	@Override
	public void clear() { // Removes all of the elements from this list.
		// TODO Auto-generated method stub
		this.head.next = null;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() { // returns true if this list contains no element
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(int index) { // Removes the element at the specified position in this list
		// TODO Auto-generated method stub
		if (index < size && index >= 0) { // should I throw an exception if the index is out of range ?********
			NodeDoubly node = head;
			for (int i = 0; i <= index; i++) {
				node = node.next;
			}
			// now we have the node to be removed
			if (index == size - 1) {
				node.prev.next = null;
			} else {
				node.next.prev = node.prev;
				node.prev.next = node.next;
			}
			this.size--;
		} else {
			throw null;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex <= toIndex && fromIndex < size && fromIndex >= 0 && toIndex < size && toIndex >= 0) {
			DoublyLinkedList sublist = new DoublyLinkedList();
			NodeDoubly node = head;
			for (int i = 0; i <= fromIndex; i++) {
				node = node.next;
			}
			for (int i = fromIndex; i <= toIndex; i++) {
				sublist.add(node.value);
				node = node.next;
			}
			return sublist;
		}
		throw null;
	}

	@Override
	public boolean contains(Object o) { // true if this list contains an element with the same value as the specified
										// element
		// TODO Auto-generated method stub
		NodeDoubly node = head;
		for (int i = 0; i < size; i++) {
			node = node.next;
			if (node.value.equals(o)) {
				return true;
			}
		}
		return false;
	}

	// additional methods
	public void printList() {
		NodeDoubly node = head.next;
		for (int i = 0; i < size; i++) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

}