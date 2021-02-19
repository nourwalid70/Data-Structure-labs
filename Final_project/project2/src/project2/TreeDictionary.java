package project2;

public class TreeDictionary<K extends Comparable <K>, V> implements IDictionary<K,V>{
	
     private int counter = 0; // check size
     private Node root;

     private class Node{
    	private K key; 
    	private V value; 
    	private Node left,right; 
    	public Node(K key,V value) {
    		this.key=key;
    		this.value=value;
    	}
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
		
		Node x = root;
		while (x != null)
		{
		int check = key.compareTo((K)x.key); // check >> key in root 
		if(check < 0) {
			x = x.left;
		}
		else if(check > 0) {
			x = x.right;
		}
		else if (check == 0) {
			return x.value;
		   }
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
		if(root == null) {
		root = new Node(key,value);
		counter++;
		return value;
		  }
	return put(root,key,value);	
	}
	/**
	* Inserts a new pair of the key and value in the dictionary.
	* If the key doesn't exist the, null is returned,
	* @param key: key.
	* @param value: value.
	* @param Node: n
	* return value in node 
	* */
	private V put(Node n , K key ,V value) {
		 int check = key.compareTo(n.key);

		    if (check < 0) {
		        if (n.left == null) {
		            n.left = new Node(key, value);
		            counter++;
		            return value;
		        } else {
		            return put(n.left, key, value);
		        }
		    }
		    if (check > 0) {
		        if (n.right == null) {
		            n.right = new Node(key, value);
		            counter++;
		            return value;
		        } else {
		            return put(n.right, key, value);
		        }
		    }
		    V p = n.value;
		    n.value = value;
		    return p;
	  }
	/**
	* Removes the key and returns its value.
	* @param key: key
	* @throws: throws exception if the key is null
	*
	* */	
	@Override
	public V remove(K key) {
		if(key == null) {
			throw new RuntimeException();	
			}
		 Node removed = this.findKey(key,root);
	        if (removed==null) {  
	            return null;
	        } else {
	            V val = removed.value;
	            counter--;
	            root = remover(key,root);
	            return val;
	       }
	}
	
	public Node remover(K key, Node r) {        
        if (r==null) {
            return r;
        }
        int check = key.compareTo(r.key);
        if (check < 0) {
            r.left = remover(key, r.left);
        } else if (check > 0) {
            r.right = remover(key, r.right);
        } else { 
            if (r.left==null) {
                r = r.right;
            } else if (r.right==null) { 
                r = r.left;
            } else {
                Node min = r.right;
                while (min.left != null) {
                    min = min.left;
                }
                r.key = min.key;
                r.value = min.value;
                r.right = remover(min.key, r.right);
            }
        }
        return r; 
    }
	private Node findKey(K key, Node r) {
        if (r==null) {
            return r;
        }
        int check = key.compareTo(r.key);
        if (check < 0) {
            return findKey(key, r.left);
        } else if (check > 0) {
            return findKey(key, r.right);
        } else {
            return r;
        }
    }
	
	@Override
	public boolean isEmpty() {

		return counter == 0;
	}

}
