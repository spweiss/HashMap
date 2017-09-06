// Attribution information

public class HashMap<E> {
    
    private int volume;
    private int capacity;
    private Object[] HashMap;
    
    public HashMap (final int size) {
        HashMap = new Object[size];
    }
    
    public constructor (final int size) {
        volume = 0;
        capacity = size;
        return new HashMap(size);
    }
   
    public boolean set (final String key, final E value) {
        if (volume >=  capacity) {
            return false;
        } else {
            int hashcode = key.hashCode();
            int index = hashcode % capacity;
    }

    public void get (String key) {
    }

    public void delete (String key) {
    }

    public float load () {
    }
  
}
