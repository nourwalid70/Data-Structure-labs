package eg.edu.alexu.csd.datastructure.queue;


import java.util.LinkedList;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class LinkedListQueue implements IQueue , ILinkedBased{

	int counter = 0;
	LinkedList<Object> s = new LinkedList<Object> ();
	
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		s.addLast(item);
		counter ++ ;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(s.isEmpty()) {
			throw new RuntimeException();
		}
		else {	
		Object x = s.removeFirst();	
		counter--;	
		return x;}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(counter ==0) {
			return true;
		}
		else {	
		return false;}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return counter;
	}

}
