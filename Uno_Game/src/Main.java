import com.google.common.collect.ArrayListMultimap;

public class Main {

	static String color_red = "red";
	static String color_blue = "blue";
	static String color_yellow = "yellow";
	static String color_green = "green";

	public static void main(String[] args) {
		System.out.println("heklo");
		ArrayListMultimap<String, Integer> red = ArrayListMultimap.create();
		ArrayListMultimap<String, Integer> blue = ArrayListMultimap.create();
		ArrayListMultimap<String, Integer> yellow = ArrayListMultimap.create();
		ArrayListMultimap<String, Integer> green = ArrayListMultimap.create();
		addNUmbersFromZero(red, color_red);
		addNUmbersFromOne(red, color_red);
		addNUmbersFromZero(blue, color_blue);
		addNUmbersFromOne(blue, color_blue);
		addNUmbersFromZero(yellow, color_yellow);
		addNUmbersFromOne(yellow, color_yellow);
		addNUmbersFromZero(green, color_green);
		addNUmbersFromOne(green, color_green);
		System.out.println(red);
		System.out.println(blue);
		System.out.println(yellow);
		System.out.println(green);
	}

	public static void addNUmbersFromZero(ArrayListMultimap<String, Integer> mm, String color) {
		int firstround = 14;
		for (int i = 0; i <= firstround; i++) {
			mm.put(color, i);
		}
	}

	public static void addNUmbersFromOne(ArrayListMultimap<String, Integer> mm, String color) {
		int firstround = 14;
		for (int i = 1; i <= firstround; i++) {
			mm.put(color, i);
		}
	}

}
