package test;

import java.util.Stack;

public class test {
	public static int[] nextSmallerNumber(int[] array) {
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		int size = array.length;
		int[] arr = new int[size];
		s.push(array[0]);
		index.push(0);
		//int j = 0;
		for (int i = 1; i < size; i++) {

			if (s.isEmpty()) { // true
				s.push(array[i]);
				index.push(i);
				continue;
			}

			while (!s.isEmpty() && (Integer) s.peek() > array[i]) {
				// index
				s.pop();
				arr[index.pop()] = i;
				//j++;
			}
			s.push(array[i]);
			index.push(i);
		}
		while (!s.isEmpty()) {
			// -1
			s.pop();
			arr[index.pop()] = -1;
			//j++;
		}
		for (int x = 0; x < size; x++) {
			System.out.print(arr[x] + ", ");
		}
		return arr;
	}
	
	public static void main(String[] args){
	int[] arr = new int[7];
	arr[0]=5;
	arr[1]=4;
	arr[2]=8;
	arr[3]=9;
	arr[4]=10;
	arr[5]=1;
	arr[5]=0;
	System.out.println(nextSmallerNumber(arr));}}