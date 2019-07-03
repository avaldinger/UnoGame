import com.google.common.collect.ArrayListMultimap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collections.*;
import java.util.List;
import java.util.Random;

public class Main {

	static String color_red = "red";
	static String color_blue = "blue";
	static String color_yellow = "yellow";
	static String color_green = "green";
	

	static ArrayList<Card> player1 = new ArrayList<>();
	static ArrayList<Card> player2 = new ArrayList<>();

	static ArrayList<Card> deck = new ArrayList<>();
	
	
	Random rand = new Random();
	int deck_volume = rand.nextInt(108);

	public static void main(String[] args) {
		System.out.println("hello");
	

		

		for (int i = 0; i <= 12; i++) {
			for (int j = 0; j <= 3; j++) {
				Color currentColor = Color.red;
				switch (j) {
				case 0:
					currentColor = Color.red;
					break;
				case 1:
					currentColor = Color.blue;
					break;
				case 2:
					currentColor = Color.yellow;
					break;
				case 3:
					currentColor = Color.green;
					break;
				default:
					// code block
				}
				deck.add(new Card(currentColor, i));
				if(i != 0) {
					deck.add(new Card(currentColor, i));
				}
			}
		}
		
		for(int i =1; i<=4; i++) {
			deck.add(new Card(Color.black, 13));
			deck.add(new Card(Color.black, 14));
			
		}
		
		for(Card content : deck) {
			System.out.println(content.toString());
		}
		
		Collections.shuffle(deck);
		
		System.out.println();
		
		for(Card content : deck) {
			System.out.println(content.toString());
		}
		
		System.out.println(deck.size());

		
		System.out.println();
		System.out.println(pullCard());
		
		System.out.println(deck.size());
		
		int deal = 1;
		while(deal <=7) {
			player1.add(pullCard());
			player2.add(pullCard());
			deal++;
		}
		
		System.out.println("Player1 \n");
		for(Card c : player1) {
			System.out.println(c.toString());
		}
		System.out.println("Player2 \n");
		for(Card c : player2) {
			System.out.println(c.toString());
		}
	

		
		
		

		/*
		 * Number codes for text card: 10: Skip 11: Draw two 12: Reverse 13: Wild 14:
		 * Wild draw four
		 */
/*
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i <= 14; i++) {
			ls.add(i);
		}
		;

		System.out.println(ls.get(0));
		Collections.shuffle(ls);
		System.out.println("\n" + ls);

		ArrayListMultimap<String, Integer> test = ArrayListMultimap.create();
		testingIt(test, color_red, ls);

		System.out.println("\n test list: " + test);

		test.remove("red", 0);

		System.out.println(test);

		ArrayListMultimap<String, Integer> red = ArrayListMultimap.create();
		ArrayListMultimap<String, Integer> blue = ArrayListMultimap.create();
		ArrayListMultimap<String, Integer> yellow = ArrayListMultimap.create();
		ArrayListMultimap<String, Integer> green = ArrayListMultimap.create();
		// ArrayListMultimap<String, Integer> deck = ArrayListMultimap.create();
		addNUmbersFromZero(red, color_red);
		addNUmbersFromOne(red, color_red);
		addNUmbersFromZero(blue, color_blue);
		addNUmbersFromOne(blue, color_blue);
		addNUmbersFromZero(yellow, color_yellow);
		addNUmbersFromOne(yellow, color_yellow);
		addNUmbersFromZero(green, color_green);
		addNUmbersFromOne(green, color_green);

		// List ls = new List();
		// java.util.Collections.shuffle(red);
		System.out.println(red);
		System.out.println(blue);
		System.out.println(yellow);
		System.out.println(green);

		// Unite the different colors into the final Deck
		/*
		 * deck.putAll(red); deck.putAll(blue); deck.putAll(yellow); deck.putAll(green);
		 * 
		 * System.out.println("\n" + deck);
		 */
	}
	
	
	
	
	public static Card pullCard() {
		return deck.remove(deck.size()-1);
			}
	
	

	public static void testingIt(ArrayListMultimap<String, Integer> mm, String color, ArrayList<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			int nm = numbers.get(i);
			mm.put(color, nm);
		}
	}

	// creates the first round of the deck for every color
	// with cards from 0 to 14
	public static void addNUmbersFromZero(ArrayListMultimap<String, Integer> mm, String color) {
		int firstround = 14;
		for (int i = 0; i <= firstround; i++) {
			mm.put(color, i);
		}
	}

	// creates the first round of the deck for every color
	// with cards from 1 to 14
	public static void addNUmbersFromOne(ArrayListMultimap<String, Integer> mm, String color) {
		int firstround = 12;
		for (int i = 1; i <= firstround; i++) {
			mm.put(color, i);
		}
	}

	// Draws the initial 7 cards for the players
	public void drawInitialCards() {
		// draw 7 from the original deck

	}

	// put a card
	public void putCard() {

	}

}
