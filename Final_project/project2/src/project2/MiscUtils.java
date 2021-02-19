package project2;

import java.util.ArrayList;
import java.util.List;

public class MiscUtils implements IMiscUtils {
	
	public List<Integer> L = new ArrayList<Integer>();
	
	public void get(BinaryTreeNode root) {
		if(root!= null) {
			L.add((Integer)root.element);
			get(root.left);
			get(root.right);
		}
	}
	/**
	* Inserts an integer value in a BST of integers.
	* Result should be a valid BST.
	* BST has no duplicates.
	*
	*@param root: BST root, a valid BST of integers
	*@param element: integer value to insert.
	*
	* */
	@Override
	public BinaryTreeNode insert(BinaryTreeNode root, int element) {
		if(root == null)
			return new BinaryTreeNode(element);

			if(element < (Integer)root.element)
			{ root.left = insert(root.left,element);}
			
			else if(element > (Integer)root.element)
			{root.right = insert(root.right,element);}
			
			else{
			// element = root.element
		        return root; 
			}
			return root;
	}
	/**
	* Returns the sum of the elements in the tree in
	* the specified range [low, high] inclusive.
	*
	*@param root: BST root, a valid BST of integers.
	*@param low: range lower limit.
	*@param high: range upper limit.
	*
	* */
	@Override
	public int sumRange(BinaryTreeNode root, int low, int high) {
		
        int sum = 0;
        if(root == null || high<low)
             return sum;
        
        Stack s = new Stack();
        
        s.push(root);
        
        while(!s.isEmpty()){
        BinaryTreeNode current = (BinaryTreeNode) s.pop();   
         if((Integer)current.element >= low && (Integer)current.element <= high){
             sum += (Integer)current.element;
         }
           if((Integer)current.element > low && current.left != null){
               s.push(current.left);   
           } 
            
           if((Integer)current.element< high && current.right !=null){
               s.push(current.right);   
           }  
        }
       return sum;
	}
	/**
	* Returns true if the input is a valid BST, false otherwise
	* @param root: Tree root.
	*
	* */
	@Override
	public boolean isValidBST(BinaryTreeNode root) {
	        if(root == null) return true;
	        return isBstValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }
	/**
	* Returns true if the input is a valid BST, false otherwise
	* @param root: Tree root.
	* @param minValiue = -2147483648
	* @param minValiue =  2147483648 
	*
	* */
    private boolean isBstValid(BinaryTreeNode root, Integer minValue, Integer maxValue) {
	 
	        if(root == null) return true;
	        if((Integer)root.element > minValue && (Integer)root.element < maxValue
	                && isBstValid(root.left, minValue, (Integer) root.element)
	                && isBstValid(root.right, (Integer)root.element, maxValue)) {
	            return true;
	        } else {
	            return false;
	        }
	        }
    /**
    * Given an array of integers, return an array containing
    * the indices of the next smaller number of every number
    * or -1 if the next smaller number does not exist. .
    * @param array: array of numbers.
    * @throws: throws an exception in the input array is null.
    * */
	@Override
	public int[] nextSmallerNumber(int[] array) {
		int size = array.length;
		if(array == null || size == 0) {
			throw new RuntimeException();	
		}
		Stack index = new Stack(); // To push in new array 
		int[] arr = new int[size]; //  return  
		index.push(0);  // push first element in array [0]
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
	return arr;
	}
}