
public class TestLLists {
	public static void main(String[] args) {
		final int NUM_DATA = 100000;
		DLList<Double> dblList = new DLList<Double>();
		DLList<String> strList = new DLList<String>();

		// First we will be inserting in the front
		// First for the Doubly Linked List
		long start = System.currentTimeMillis(); // for the DLList
		for (int i = 0; i < NUM_DATA; i++)
			dblList.add(0, i * 1.5);
		long elapsed = System.currentTimeMillis() - start;
		System.out.printf("Doubly Linked List when adding to front: %d ms\n", elapsed);

		// Now for the Doubly Linked List of type String
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_DATA; i++)
			strList.add(0, String.valueOf((char) ('a' + i)));
		elapsed = System.currentTimeMillis() - start;
		System.out.printf("Doubly Linked List of type String when adding to front: %d ms\n", elapsed);

		// Now we are inserting at the rear
		// First the Doubly Linked List
		dblList.clear();
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_DATA; i++)
			dblList.add(i * 1.5);
		elapsed = System.currentTimeMillis() - start;
		System.out.printf("Doubly Linked List when adding to rear: %d ms\n", elapsed);

		// Now the Doubly Linked List of type String
		strList.clear();
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_DATA; i++)
			strList.add(String.valueOf((char) ('a' + i)));
		elapsed = System.currentTimeMillis() - start;
		System.out.printf("Doubly Linked List of type String when adding to rear: %d ms\n", elapsed);
	}
}
