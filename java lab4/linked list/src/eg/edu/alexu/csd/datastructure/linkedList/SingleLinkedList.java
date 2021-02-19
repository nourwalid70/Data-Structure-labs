package eg.edu.alexu.csd.datastructure.linkedList;

public class SingleLinkedList implements ILinkedList {

	public class Node {

		public Node next = null;
		public Object value;

		public Node(Object element) {
			this.value = element;
		}
	}

	Node head = null;
	int size = 0;

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		if (head == null && index != 0 || index > size || index < 0) {
			throw null;
		}
		Node node = new Node(element);
		Node i = head;
		int j;
		if (index == 0) {
			node.next = head;
			head = node;
		} else {
			for (j = 0; j < index - 1; j++) {
				i = i.next;
			}
			if (j == index - 1) {
				node.next = i.next;
				i.next = node;
			}
		}
		size++;
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		Node node = new Node(element);
		Node i = head;
		int counter = 0;
		if (head == null) {
			node.next = head;
			head = node;
		} else {
			while (i != null) {
				i = i.next;
				counter++;
			}
			i = head;
			for (int j = 0; j < counter - 1; j++) {
				i = i.next;
			}
			node.next = i.next;
			i.next = node;
		}
		size++;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if (head == null && index != 0 || index > size || index < 0) {
			throw null;
		} else {
			int counter = 0;
			Node i = head;
			while (counter < index) {
				counter++;
				i = i.next;
			}
			return i.value;
		}
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if (head == null && index != 0 || index > size || index < 0) {
			throw null;
		}
		Node i = head;
		for (int j = 0; j < index; j++) {
			i = i.next;
		}
		i.value = element;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		if (head == null || index < 0 || index >= size) {
			throw null;
		} else {
			int counter;
			if (index == 0) {
				head = head.next;

			} else {
				Node i = head;
				Node j = i.next;
				for (counter = 0; counter < index - 1 && i != null; counter++) {
					i = i.next;
					j = j.next;
				}
				i.next = j.next;
				j.next = null;
			}
		}
		size--;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if (head == null) {
			return 0;
		} else {
			Node i = head;
			int counter = 0;
			while (i != null) {
				counter++;
				i = i.next;
			}
			return counter;
		}
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		SingleLinkedList sublist = new SingleLinkedList();
		if (fromIndex < 0 || toIndex > size || fromIndex > size) {
			return sublist;
		}
		Node i = head;
		for (int j = 0; j < fromIndex; j++) {
			i = i.next;
		}
		for (int j = fromIndex; j <= toIndex; j++) {
			sublist.add(i.value);
			i = i.next;
		}

		return sublist;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if (head == null) {
			return false;
		} else {
			int find = 0;
			Node i = head;
			while (find == 0 && i != null) {
				if (o.equals(i.value)) {
					find = 1;
				} else {
					i = i.next;
				}
			}

			if (find == 1) {
				return true;
			} else {
				return false;
			}
		}
	}

}
