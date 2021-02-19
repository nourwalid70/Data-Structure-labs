package eg.edu.alexu.csd.datastructure.queue;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class ArrayQueue implements  IQueue,IArrayBased  {

	int max_len;
	Object[] arr;
	
	public ArrayQueue ( int max_size) {
		this.max_len = max_size;
		this.arr = new Object[max_len];
	}
	
	int first = -1;
    int last = -1;	
	int counter=0;
    
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if(isFull()) {
			throw new RuntimeException();
		}
		else {
		last = (last+1) % arr.length;	//circular array 
		arr[last]=item;	
		counter++;
		}
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new RuntimeException();	
		}
		else {	
			first = (first + 1) % arr.length;
			Object x = arr[first]; 
			counter--;
			if(first == last) {
				first = last = -1;
			}
		return x;}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(first == -1 && last == -1) {
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

	public boolean isFull() {
		if((first==-1 && last == arr.length-1)|| (first == last && first != -1)) {
			return true;
		}
		else { return false;}	
	}
}
