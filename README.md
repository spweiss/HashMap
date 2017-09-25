Author: Spencer Weiss - UPenn M&T

# HashMap
A fixed-size hash map using primitive types to associate string keys with object references

## Usage Information
`HashMap.java` and `HashMapTest.java` can be used by running the following in command line:

1. Run `cd /YourDirectory/` on the directory where the `HashMap.java` and `HashMapTest.java` are stored.
2. Compile HashMap and HashMapTest by running `javac HashMap.java` then` javac HashMapTest.java`.
2. Execute the tests by running `java -ea HashMapTest`.

## Time Complexities
The average and worst-case time complexities of the top-level operations are:

| Case          | Constructor   | Set   | Get   | Load  |
| ------------- |:-------------:|:-----:|:-----:|:-----:|
| Average       | O(n)          | O(1)  | O(1)  | O(1)  |
| Worst         | O(n)          | O(n)  | O(n)  | O(1)  |

Where the worst case runtime occurs when all n elements collide into the same bucket in the HashMap and the data structure operates as a de facto LinkedList.

## Implementation

* The method `set(String key, E value)` returns `true` if the item was added successfully and `false` if it was not. Thus, false is returned if the number of elements that the HashMap already contains is equal to the user-defined maximum when `set` is called or if the item to be added is `null`.
* HashMap has an underlying array of `LinkedList`s that are used to handle key collisions based on Java's `hashCode()` method and the size of the HashMap defined by the user.
* The method `stringLL()` generates a string representation of a `LinkedList` and is included for testing and debugging purposes.

The HashMap includes implementations for the following operations:

**constructor(size):** return an instance of the class with pre-allocated space for the given number of objects.

**boolean set(key, value):** stores the given key/value pair in the hash map. Returns a boolean value indicating success / failure of the operation.

**get(key):** return the value associated with the given key, or null if no value is set.

**delete(key):** delete the value associated with the given key, returning the value on success or null if the key has no value.

**float load():** return a float value representing the load factor (`(items in hash map)/(size of hash map)`) of the data structure. Since the size of the dat structure is fixed, this should never be greater than 1.
