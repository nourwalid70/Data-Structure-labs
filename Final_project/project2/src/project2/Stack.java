package project2;

public class Stack {
  
	public class Node {

		public Node next = null;
		public Object value;

		public Node(Object element) {
			this.value = element;
		}
	}
	 // stack empty
     Node top = null; 
     int len = 0;
     
     /**
     * Removes the element at the top of stack and returns that element.
     *
     * @return top of stack element, or through exception if empty
     */
	public Object pop() {
		// TODO Auto-generated method stub
		if(len>0) {
		Object p = top.value; // get value 
		top = top.next;  // remove this element
		len--;  
		return p;}
		else {
			throw new RuntimeException(); // stack is Empty
		}
	}
	/**
	* Get the element at the top of stack without removing it from stack.
	*
	* @return top of stack element, or through exception if empty
	*/
	public Object peek() {
		// TODO Auto-generated method stub
		if(len>0) {
			Object p = top.value;	// get value without removing it
			return p;
			}
			else {
				throw new RuntimeException(); // stack is Empty
			}
	}
	/**
	* Pushes an item onto the top of this stack.
	*
	* @param element
	* to insert
	*/
	public void push(Object element) {
		// TODO Auto-generated method stub
		Node i = new Node(element);
		i.next = top;
		i.value = element; // Take the value
		top = i ;  // Add it 
		len ++;
	}
	/**
	* Tests if this stack is empty
	*
	* @return true if stack empty
	*/
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(len==0) { // Empty
			return true;
		}
		else {	//Not Empty
		return false;
		}
	}
}
