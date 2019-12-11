import java.io.FileWriter;
import java.io.IOException;

//Problem 1

public class TestDLL {
	static FileWriter out;

	public static void main(String[] args) throws IOException {
		DLList<String> strList = new DLList<String>();
		DLList<Integer> intList = new DLList<Integer>();
		out = new FileWriter("out.txt");

		for (int i = 0; i < 10; i++) {
			strList.add(String.valueOf((char) ('a' + i)));
			intList.add(i);
		}

		System.out.printf("Size: %s%n", strList.size());
		print(strList);

		strList.set(5, "z");
		System.out.print("Replacing:\n");
		print(strList);

		strList.remove("z");
		strList.remove(0);
		System.out.print("After removing:\n");
		print(strList);

		System.out.printf("Size: %s%n%nSize: %s%n", strList.size(), intList.size());
		print(intList);

		intList.set(4, -8);
		System.out.print("Replacing:\n");
		print(intList);

		intList.remove(Integer.valueOf(-8));
		intList.remove(1);
		System.out.print("After removing:\n");
		print(intList);

		System.out.printf("Size: %s%n", intList.size());
		out.close();
	}

	private static void print(DLList<?> list) throws IOException {
		list.reset();
		while (list.hasNext())
			out.append(String.format("%s ", list.next()));
		out.append("\n");
	}
}
