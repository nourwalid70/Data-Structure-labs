package project2;

import java.util.Arrays;

public class HashTableDictionary<K,V> implements IDictionary<K,V>{
	

    private class both{  
		K key;
		V value;
	both(K key,V value){
    	this.key = key;
    	this.value = value;
     }
   }
    
	private int N; // size of array 
	private both[] arr; // array of hash table
	private int counter; // check is Empty
	
	public HashTableDictionary(int max_size) {
		this.N = max_size;
		Object[] temp = new Object[max_size];
		this.arr =Arrays.copyOf(temp,max_size,both[].class);
		this.counter = 0;        
		}
	
	private int get_index(K key) {
	
	   return (Math.abs(key.hashCode())& 0x7fffffff) % N;  // get index in array
	 } 
	/**
	* Retrieves the value corresponding to the specified key.
	* Returns null if the key doesn’t exist in the dictionary.
	* @param key: key.
	* @throws: Throws Exception if the key is null.
	* */
	@Override
	public V get(K key) {
		
		if(key == null) 
		throw new RuntimeException();
		
		int index = get_index(key); // index of array 
        
        while(arr[index] != null) {
        if(arr[index].key.equals(key)) {
        	return arr[index].value;
        }
        index = (index+1)%N;
        }
      return null;  
	} 
	/**
	* Inserts a new pair of the key and value in the dictionary.
	* If the key already exists, the old value is returned.
	* If the key doesn't exist the, null is returned,
	* @param key: key.
	* @param value: value.
	* @throws: Throws an exception if the key or the value is
	null.
	* */
	@Override
	public V set(K key, V value) {
		if(key == null || value == null) {
			throw  new RuntimeException();	
		}
		int index = get_index(key);
		int check = index;
		do {
	        if(arr[check] == null) {
	       both t = new both(key,value);
	        	arr[check] = t;
	        	counter++;
	        	return value;
	        }
	        if(arr[check].key.equals(key)) { //key already exists
	        	V s = arr[check].value;
	           arr[check].value = value;
	        	return s;
	        }
		check = (check+1) % N;
		}
		while(check != index);
		
	   return null;	 
	}
	/**
	* Removes the key and returns its value.
	* @param key: key
	* @throws: throws exception if the key is null
	*
	* */
	@Override
	public V remove(K key) {
		if(key == null) 
			throw new RuntimeException();	
		
	  int index = get_index(key);
	  
	  while(arr[index] != null) {
	        if(arr[index].key.equals(key)) {
	        	V r = arr[index].value;
	        	arr[index] = null;
	        	counter--;
	        	return r;
	        }
	        index = (index+1)%N;
	    }
	      return null;  // not found 
	}
	/**
	* Returns true if the dictionary is empty and false otherwise.
	* */	
	@Override
	public boolean isEmpty() {
		return counter == 0;  
	}

}