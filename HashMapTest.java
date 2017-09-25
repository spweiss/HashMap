public class HashMapTest {
	
	public void testSetGet() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(4);
		map.set("A", "test1");
		map.set("B", "test2");
		map.set("C", "test3");
		map.set("D", "test4");
		assert ("test1" == map.get("A"));
		assert ("test2" == map.get("B"));
		assert ("test3" == map.get("C"));
		assert ("test4" == map.get("D"));
	}
	
	public void testFixedSize() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(1);
		map.set("A", "test1");
		assert ("test1" == map.get("A"));
		assert (map.set("B", "test2") == false);
	}
	
	public void testUpdateValue() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(2);
		map.set("A", "test1");
		assert ("test1" == map.get("A"));
		map.set("A", "test2");
		assert ("test2" == map.get("A"));
	}
	
	public void testOverCapacity() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(1);
		map.set("A", "test1");
		map.set("B", "test2");
		assert ("test1" == map.get("A"));
		assert (map.get("B") == null);
	}
	
	public void testGetElementNotInMap() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(1);
		map.set("A", "test1");
		assert (map.get("B") == null);
	}
	
	public void testDeleteElementNotInMap() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(1);
		map.set("A", "test1");
		assert ("test1" == map.get("A"));
		assert (map.delete("B") == null);
	}
	
	public void testDelete() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(2);
		map.set("A", "test1");
		map.set("B", "test2");
		assert ("test2" == map.get("B"));
		assert ("test2" == map.delete("B"));
		assert (null == map.get("B"));
	}
	
	public void testDeleteNull() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(2);
		map.set("A", "test1");
		assert (null == map.delete("B"));
	}
	
	public void testNullValue() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(2);
		map.set("A", null);
		assert (map.get("A") == null);
	}
	
	public void testNullKey() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(2);
		assert (map.set(null, "test1") == false);
	}
	
	public void testLoadFactor() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(4);
		map.set("A", "test1");
		assert (map.load() == 0.25);
		map.set("B", "test2");
		assert (map.load() == 0.50);
		map.set("C", "test3");
		assert (map.load() == 0.75);
		map.set("D", "test4");
		assert (map.load() == 1.00);
	}
	
	public void testLoadFactorCollision() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(4);
		map.set("A", "test1");
		map.set("B", "test2");
		map.set("C", "test3");
		map.set("D", "test4");
		map.set("E", "test5");
		map.set("F", "test6");
		map.set("G", "test7");
		map.set("H", "test8");
		assert (map.load() <= 1.0);
	}
	
	public void testDuplicateSize() {
		HashMap<String> temp = new HashMap<String>();
		HashMap<String> map = temp.constructor(4);
		map.set("A", "test1");
		map.set("A", "test1");
		map.set("A", "test1");
		map.set("A", "test1");
		map.set("B", "test2");
		map.set("C", "test3");
		map.set("D", "test4");
		assert (map.load() <= 1.00);
	}
	
	public void testDifferentParameter() {
		HashMap<Integer> temp = new HashMap<Integer>();
		HashMap<Integer> map = temp.constructor(4);
		map.set("A", 1);
		map.set("B", 2);
		map.set("C", 3);
		map.set("D", 4);
		assert (map.load() == 1.00);
	}
	
	public static void main (String args[]) {
		HashMapTest test = new HashMapTest();
		test.testSetGet();
		test.testFixedSize();
		test.testUpdateValue();
		test.testOverCapacity();
		test.testGetElementNotInMap();
		test.testDeleteElementNotInMap();
		test.testDelete();
		test.testDeleteNull();
		test.testNullValue();
		test.testNullKey();
		test.testLoadFactor();
		test.testLoadFactorCollision();
		test.testDuplicateSize();
		test.testDifferentParameter();
		System.out.println("Tests ran successfully!");
	}
	
}
