package eg.edu.alexu.csd.datastructure.queue;

public class test {
	public static void main(String[] args) {
		/*int n = 5;
		ArrayQueue a = new ArrayQueue(n);
		System.out.println(a.isEmpty());
		a.enqueue(10);
		System.out.println(a.isEmpty());
		System.out.println(a.size());
		System.out.println(a.dequeue());
		System.out.println(a.size());
		a.enqueue(10);
		a.enqueue(1);
		a.enqueue(11);
		a.enqueue(0);
		a.enqueue(111);
		System.out.println(a.size());
		System.out.println(a.isFull());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());*/
		LinkedListQueue a = new LinkedListQueue();
		a.enqueue(10);
		a.enqueue(1);
		a.enqueue(11);
		a.enqueue(0);
		a.enqueue(111);
	//	System.out.println(a.size());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		
		
		
		
		
	}
}
