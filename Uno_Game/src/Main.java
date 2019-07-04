import com.google.common.collect.ArrayListMultimap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collections.*;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {

	/*
	 * static String color_red = "red"; static String color_blue = "blue"; static
	 * String color_yellow = "yellow"; static String color_green = "green";
	 */

	static ArrayList<Card> player1 = new ArrayList<>();
	static ArrayList<Card> player2 = new ArrayList<>();
	static ArrayList<Card> drawn_cards = new ArrayList<>();

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
				if (i != 0) {
					deck.add(new Card(currentColor, i));
				}
			}
		}

		for (int i = 1; i <= 4; i++) {
			deck.add(new Card(Color.black, 13));
			deck.add(new Card(Color.black, 14));

		}

		for (Card content : deck) {
			System.out.println(content.toString());
		}

		Collections.shuffle(deck);

		System.out.println();

		for (Card content : deck) {
			System.out.println(content.toString());
		}

		System.out.println(deck.size());

		System.out.println();
		drawn_cards.add(pullCard());
		for (Card c : drawn_cards) {
			System.out.println("The first card is: " + c.toString());
		}

		System.out.println(deck.size());

		int deal = 1;
		while (deal <= 7) {
			player1.add(pullCard());
			player2.add(pullCard());
			deal++;
		}

		System.out.println("Player1 \n");
		for (Card c : player1) {
			System.out.println(c.toString());
		}
		System.out.println("\n Player2 \n");
		for (Card c : player2) {
			System.out.println(c.toString());
		}

		System.out.println();
		//putCard1();
		putCardtest();
		

	}

	public static Card pullCard() {
		return deck.remove(deck.size() - 1);
	}

	public static void putCardtest() {

		
		Iterator<Card> i = drawn_cards.iterator();
		Card lastDrawnCard = null;
		while (i.hasNext()) {
			lastDrawnCard = i.next();
		}
		System.out.println(lastDrawnCard);

		ArrayList<Card> toAdd = new ArrayList<>();
		ArrayList<Card> addToPlayer = new ArrayList<>();
		
		Iterator<Card> it = player1.iterator();
		Card pl1_CurrentCards = null;
		while (it.hasNext()) {
			pl1_CurrentCards = it.next();
			if (pl1_CurrentCards.getColor().equals(lastDrawnCard.color)
					|| pl1_CurrentCards.getValue() == lastDrawnCard.value) {
				toAdd.add(pl1_CurrentCards);
				it.remove();
				

				System.out.println("Drawn cards deck: ");
				for (Card c : drawn_cards) {
					System.out.println(c.toString());
				}

				System.out.println("Player1's cards: ");
				for (Card c : player1) {
					System.out.println(c.toString());
				}

				break;

			} else {
				addToPlayer.add(pullCard());
				continue;
			}
		}
		drawn_cards.addAll(toAdd);
		player1.addAll(addToPlayer);


	}

	public static void putCard1() {

		Iterator<Card> i = drawn_cards.iterator();
		Card lastDrawnCard = null;
		while (i.hasNext()) {
			lastDrawnCard = i.next();
		}
		System.out.println(lastDrawnCard);

		Iterator<Card> it = player1.iterator();
		Card pl1_CurrentCards = null;
		while (it.hasNext()) {
			pl1_CurrentCards = it.next();
			if (pl1_CurrentCards.getColor().equals(lastDrawnCard.color)
					|| pl1_CurrentCards.getValue() == lastDrawnCard.value) {
				drawn_cards.add(pl1_CurrentCards);
				player1.remove(pl1_CurrentCards);

				System.out.println("Drawn cards deck: ");
				for (Card c : drawn_cards) {
					System.out.println(c.toString());
				}

				System.out.println("Player1's cards: ");
				for (Card c : player1) {
					System.out.println(c.toString());
				}

				break;

			} else {
				player1.add(pullCard());
				continue;
			}
		}

	}

	public static void putCard2() {

		Iterator<Card> i = drawn_cards.iterator();
		Card lastDrawnCard = null;
		while (i.hasNext()) {
			lastDrawnCard = i.next();
		}
		System.out.println(lastDrawnCard);

		Iterator<Card> it = player2.iterator();
		Card pl2_CurrentCards = null;
		while (it.hasNext()) {
			pl2_CurrentCards = it.next();
			if (pl2_CurrentCards.getColor().equals(lastDrawnCard.color)
					|| pl2_CurrentCards.getValue() == lastDrawnCard.value) {
				drawn_cards.add(pl2_CurrentCards);
				player1.remove(pl2_CurrentCards);

				System.out.println("Drawn cards deck: ");
				for (Card c : drawn_cards) {
					System.out.println(c.toString());
				}

				System.out.println("Player1's cards: ");
				for (Card c : player1) {
					System.out.println(c.toString());
				}

				break;

			} else {
				player2.add(pullCard());
				continue;
			}
		}

	}

}
