package project2;
public class test {
	public static int[] nextSmallerNumber(int[] array) {
		Stack index = new Stack();
		int size = array.length;
		int[] arr = new int[size];
		index.push(0);
		for (int i = 1; i < size; i++) {

			if (index.isEmpty()) { // true
				index.push(i);
				continue;
			}

			while (!index.isEmpty() && array[(int) index.peek()] > array[i]) {
				// index
				arr[(int) index.pop()] = i;
			}
			index.push(i);
		}
		while (!index.isEmpty()) {
			// -1
			arr[(int) index.pop()] = -1;
		}
		for (int x = 0; x < size; x++) {
			System.out.print(arr[x] + ", ");
		}
		return arr;
	}
	public static void main(String[] args){
	int[] arr = {10, 9, 2, 7, 6, 1, 2};
	System.out.println(nextSmallerNumber(arr));
	
	
	/*@SuppressWarnings("unused")
	HashTableDictionary<Integer, Integer> n = new HashTableDictionary<Integer, Integer>(5);
	System.out.println(n.isEmpty());
	n.set(3, 55); // xxxx
	n.set(4, 50); // xxxx
	n.set(2, 9); // xxxx
	System.out.println(n.set(2, 8));
	System.out.println(n.remove(3));
	System.out.println(n.remove(2));
	System.out.println(n.remove(4));
	System.out.println(n.isEmpty());
	System.out.println(n.remove(4));
	System.out.println(n.set(0, 100));
	System.out.println(n.set(0, 101));
	System.out.println(n.get(0));
	System.out.println(n.set(3, 17));
	System.out.println(n.remove(3));
	System.out.println(n.remove(3));
	System.out.println(n.get(4));
	System.out.println(n.get(0));
	System.out.println(n.isEmpty());
	
	n.set(4, 10);
	System.out.println(n.set(9, 5));
	System.out.println(n.get(4));
	System.out.println(n.get(9));*/
	
	TreeDictionary<Integer, Integer> m = new TreeDictionary<Integer, Integer>();
	System.out.println(m.isEmpty());
	System.out.println(m.set(5, 50));
	System.out.println(m.get(5));
	System.out.println(m.isEmpty());
	//System.out.println(m.set(9, 50));
	//System.out.println(m.get(9));
	System.out.println(m.remove(5));
	System.out.println(m.isEmpty());
	System.out.println(m.remove(4));
	System.out.println(m.remove(null));
	/*System.out.println(m.set(1, 55));
	System.out.println(m.set(2, 50));
	System.out.println(m.set(3, 5));
	System.out.println(m.set(4, 99));
	System.out.println(m.isEmpty());
	System.out.println(m.remove(3));
	System.out.println(m.remove(1));
	System.out.println(m.remove(3));
	System.out.println(m.isEmpty());
	System.out.println(Integer.MAX_VALUE);*/
	 }
	    }