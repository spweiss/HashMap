// Attribution information

public class HashMap<E> {
    
    private int volume;
    private int capacity;
    private Object[] HashMap;
    
    public HashMap (final int size) {
        HashMap = new Object[size];
    }
    
    public final constructor (final int size) {
        volume = 0;
        capacity = size;
        return new HashMap(size);
    }
   
    public final boolean set (final String key, final E value) {
        if (volume >=  capacity) {
            return false;
        } else {
            int hashcode = key.hashCode();
            int index = hashcode % capacity;
            hashMap[index] = value;
            return true;
        }
    }

    public final E get (String key) {
        int hashcode = key.hashCode();
        int index = hashcode % capacity;
        return hashMap[index];
    }

    public final E delete (String key) {
        int hashcode = key.hashCode();
        int index = hashcode % capacity;
        E target = hashMap[index];
        hashMap[index] = null;
        return target;
    }

    public final float load () {
    }
  
}
