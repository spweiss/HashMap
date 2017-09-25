/**
 * A fixed-size hash map implemented using primitive types to associate string
 * keys with arbitrary object references
 * @author Spencer Weiss
 *
 * @param <E> - The type extending Object to be stored in the HashMap
 */

public class HashMap<E> {

	private int volume;
    private int capacity;
    private Object[] hashmap;
    
    /**
     * Creates a an empty HashMap. This cannot be used, since it has a fixed size of zero,
     * besides to call the constuctor() method to generate a HashMap of the desired size.
     */
	public HashMap () {
    		volume = 0;
        capacity = 0;
        hashmap = new Object[0];
    }
    
    /**
     * Private method to generate a HashMap of the desired size when the constructor() method
     * is called.
     * @param size - final int which determines the desired size of the HashMap
     */
	private HashMap (final int size) {
    		volume = 0;
        capacity = size;
        hashmap = new Object[size];
    }
    
    /**
     * Creates and returns a HashMap of the desired size.
     * @param size - final int which determines the desired size of the HashMap
     * @return instance of the HashMap class with the desired capacity
     */
    public final HashMap<E> constructor (final int size) {
        return new HashMap<E>(size);
    }
   
    /**
     * Inserts the given key/value into the HashMap and returns true if successful.
     * @param key - Key associated with the input value
     * @param value - Value to be added to the HashMap
     * @return True if successful and false otherwise
     */
    public final boolean set (final String key, final E value) {
        if (volume >=  capacity || key == null) {
            return false;
        } else {
            int hashcode = key.hashCode();
            int index = hashcode % capacity;
            Node<E> node = new Node<E>(key, value);
            if (hashmap[index] == null) {
            		hashmap[index] = new LinkedList();
            }
            @SuppressWarnings("unchecked")
			LinkedList list = (LinkedList) hashmap[index];
            list.add(node);
            volume++;
            return true;
        }
    }

    /**
     * Returns the value associated with the given key in the HashMap or null if
     * it does not exist.
     * @param key - Key associated with the value of interest
     * @return the value of interest or null if it does not exist
     */
    public final E get (String key) {
        int hashcode = key.hashCode();
        int index = hashcode % capacity;
        @SuppressWarnings("unchecked")
		LinkedList list = (LinkedList) hashmap[index];
        if (list.size() == 0) {
        		return null;
        }
		Node<E> node = list.get(key);
        if (node != null) {
        		return node.getValue();
        }
        return null;
    }

    /**
     * Returns the value associated with the given key in the HashMap and deletes it
     * or returns null if it does not exist.
     * @param key - Key associated with the value of interest
     * @return the value of interest or null if it does not exist
     */
    public final E delete (String key) {
    		int hashcode = key.hashCode();
        int index = hashcode % capacity;
        @SuppressWarnings("unchecked")
		LinkedList list = (LinkedList) hashmap[index];
        if (list == null) {
        		return null;
        }
		Node<E> node = list.delete(key);
        if (node != null) {
        		volume--;
        		return node.getValue();
        }
        return null;
    }

    /**
     * Returns the load factor of the HashMap, determined by the number of items
     * in the HashMap divided by the size of the HashMap
     * @return the load factor of the HashMap
     */
    public final float load () {
        return (float) volume / (float) capacity;
    }
    
    /**
     * Implementation of LinkedList to accommodate key collisions in the HashMap
     * @author SpencerWeiss
     */
    private class LinkedList {
    	
    		private int size;
    		private Node<E> head;
    		private Node<E> tail;
    		
    		/**
    		 * Constructor for a LinkedList, beginning empty
    		 */
    		LinkedList() {
    			size = 0;
    			head = null;
    			tail = null;
    		}
    		
    		/**
    		 * Adds the given Node to the LinkedList if it is not present or updates its value
    		 * if it already is.
    		 * @param input - Node to be added
    		 */
    		void add (final Node<E> input) {
    			if (size == 0) {
    				head = input;
    				tail = input;
    				size++;
    			} else {
    				Node<E> temp = get(input.getKey());
    				if (temp == null) {
    					input.setPrev(tail);
    					tail.setNext(input);
    					tail = input;
    					size++;
    				} else {
    					temp.setValue(input.getValue());
    				}
    			}
    		}
    		
    		/**
    		 * Retrieves the Node with a particular key from the LinkedList or null if the
    		 * desired node does not exist
    		 * @param key - Key corresponding to the Node of interest
    		 * @return Node associated with the given Key or null if none exists
    		 */
    		Node<E> get (final String key) {
    			Node<E> temp = head;
    			while (temp != null && temp.getKey() != key && !temp.getKey().equals(key)) {
    				temp = temp.getNext();
    			}
    			return temp;
    		}
    		
    		/**
    		 * Deletes the Node associated with the given key and returns the node or null
    		 * if it does not exist
    		 * @param key - the Key of the Node to be deleted
    		 * @return the deleted Node or null if it does not exist
    		 */
    		Node<E> delete (final String key) {
    			Node<E> temp = get(key);
    			if (temp == null) {
    				return null;
    			}
    			Node<E> tempnext = temp.getNext();
    			Node<E> tempprev = temp.getPrev();
    			if (tempnext != null && tempprev != null) {
    				tempnext.setPrev(tempprev);
    				tempprev.setNext(tempnext);
    			} else if (tempprev != null) {
    				tempprev.setNext(null);
    				tail = tempprev;
    			} else if (tempnext != null) {
    				head = tempnext;
    			} else {
    				head = null;
    				tail = null;
    				size = 0;
    			}
    			size--;
    			return temp;
    		}
    		
    		/**
    		 * Returns the number of elements in the LinkedList
    		 * @return the number of elements
    		 */
    		int size () {
    			return size;
    		}
    		
    		/**
    		 * Generates a String representation of a linked list for testing and debugging.
    		 * @return a String representation of a linked list
    		 */
    		@SuppressWarnings("unused")
		String stringLL() {
    			String result = "";
    			Node<E> temp = head;
    			while (temp != null) {
    				result = result + "[key: " + temp.getKey() + ", value: " + temp.getValue() + "]";
    				if (temp.getNext() != null) {
    					result += ", ";
    				}
    				temp = temp.getNext();
    			}
    			return result;
    		}
    	
    }
    
    /**
     * An implementation of a Node wrapper class for use in LinkedList
     * @author SpencerWeiss
     *
     * @param <E>
     */
    @SuppressWarnings("hiding")
	private class Node<E> {
    
    		private String key;
    		private E value;
    		private Node<E> next;
    		private Node<E> prev;
    		
    		Node (final String key, final E value) {
    			this.key = key;
    			this.value = value;
    		}
    		
    		E getValue() {
    			return this.value;
    		}
    		
    		String getKey() {
    			return this.key;
    		}
    		
    		Node<E> getNext() {
    			return this.next;
    		}
    		
    		Node<E> getPrev() {
    			return this.prev;
    		}
    		
    		void setValue(E value) {
    			this.value = value;
    		}
    		
    		void setNext(Node<E> next) {
    			this.next = next;
    		}
    		
    		void setPrev(Node<E> prev) {
    			this.prev = prev;
    		}
    	
    }
	
}