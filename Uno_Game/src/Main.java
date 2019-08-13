import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

    /*
     * Number codes for text card: 10: Skip 11: Draw two 12: Reverse 13: Wild Color
     * choosing 14: Wild draw four
     */

    static ArrayList<Card> player1 = new ArrayList<>();
    static ArrayList<Card> player2 = new ArrayList<>();
    static ArrayList<Card> drawn_cards = new ArrayList<>();
    static ArrayList<Card> deck = new ArrayList<>();
    static boolean won = false;

    public static void main(String[] args) {
        //System.out.println("hello");


        createDeck();

        /*for (Card content : deck) {
            System.out.println(content.toString());
        }*/

        //System.out.println();

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

        // Initial dealing of 7 cards
        dealCards(player1);
        dealCards(player2);


        System.out.println("Player1's cards:  \n");
        for (Card c : player1) {
            System.out.println(c.toString());
        }
        System.out.println("\n Player2's cards:  \n");
        for (Card c : player2) {
            System.out.println(c.toString());
        }

        System.out.println();
        while (!won) {
            putCard(player1);
            putCard(player2);
            //System.out.println(drawn_cards);
            //System.out.println(deck);
            checkWinner();
        }
        // refillDeck();

    }

    // Refills the deck once there is no more card in it
    // Getting checked after every card pulling event
    public static void refillDeck() {
        ArrayList<Card> temp = new ArrayList<>();

        // Get the last card on top of the played cards
        Iterator<Card> i = drawn_cards.iterator();
        Card lastDrawnCard = null;
        while (i.hasNext()) {
            lastDrawnCard = i.next();
            if (!i.hasNext()) {
                temp.add(lastDrawnCard);
            }

        }

        //System.out.println(temp);
        drawn_cards.remove(drawn_cards.size() - 1);
        //System.out.println(drawn_cards);
        Collections.shuffle(drawn_cards);
        deck.addAll(drawn_cards);
        //System.out.println(deck);
        drawn_cards = temp;
        System.out.println(drawn_cards);

    }

    // Pulls a card from the deck
    public static Card pullCard() {

        return deck.remove(deck.size() - 1);
    }

    //Creates the deck for the game with all the possible cards
    //as a last step shuffles the deck
    public static ArrayList<Card> createDeck() {
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
                // In the deck the 0 cards are present only once
                if (i != 0) {
                    deck.add(new Card(currentColor, i));
                }
            }
        }
        for (int i = 1; i <= 4; i++) {
            //deck.add(new Card(Color.black, 13));
            deck.add(new Card(Color.black, 14));

        }
        Collections.shuffle(deck);
        return deck;
    }


    public static ArrayList<Card> dealCards(ArrayList<Card> player) {
        int deal = 1;
        while (deal <= 7) {
            player.add(pullCard());
            deal++;
        }
        return player;
    }


    // Player specific function to put a card if possible
    // or pull one if necessary
    public static ArrayList<Card> putCard(ArrayList<Card> player) {
        ArrayList<Card> toAdd = new ArrayList<>();
        ArrayList<Card> addToPlayer = new ArrayList<>();
        ArrayList<Card> toRemove =  new ArrayList<>();

        Iterator<Card> i = drawn_cards.iterator();
        Card lastDrawnCard = null;
        boolean playerHasMove = true;
        while (playerHasMove) {
            while (i.hasNext()) {
                lastDrawnCard = i.next();
                if (lastDrawnCard.getColor().equals(Color.black) && lastDrawnCard.getValue() == 14) {
                    for (int j = 0; j <= 3; j++) {
                        player.add(pullCard());
                    }
                    playerHasMove = false;
                    break;
                } else {
                    continue;
                }
            }
            System.out.println("\n" + lastDrawnCard);

            Iterator<Card> it = player.iterator();
            Card player_CurrentCards = null;
            while (it.hasNext()) {
                player_CurrentCards = it.next();
                System.out.println("Actual card from" + player.toString() + ": " + player_CurrentCards.toString());
                // if the color or the number is matching
                // player puts the card
                if (player_CurrentCards.getColor().equals(lastDrawnCard.getColor())
                        || player_CurrentCards.getValue() == lastDrawnCard.getValue()
                        || player_CurrentCards.getColor().equals(Color.black)) {
                    toAdd.add(player_CurrentCards);
                    it.remove();

                    System.out.println("Drawn cards deck: ");
                    for (Card c : drawn_cards) {
                        System.out.println(c.toString());
                    }

                    System.out.println(player.toString() + "'s cards: ");
                    for (Card c : player) {
                        System.out.println(c.toString());
                    }
                    playerHasMove = false;
                    break;

                }
                // if player doesn't have any valid move, pulls a new card
                else if (!it.hasNext()) {
                    playerHasMove = false;
                    // if Deck is empty it gets refilled before pulling a card
                    if (deck.size() < 1) {
                        refillDeck();
                        addToPlayer.add(pullCard());
                    } else {
                        addToPlayer.add(pullCard());
                        System.out.println("Card to be added: " + addToPlayer.toString());
                    }
                }
            }
            drawn_cards.addAll(toAdd);
            System.out.println("Drawn cards deck after putting one: ");
            for (Card c : drawn_cards) {
                System.out.println(c.toString());
            }
            player.addAll(addToPlayer);
            System.out.println(player.toString() + "'s cards after putting/pulling one: \n");
            for (Card c : player) {
                System.out.println(c.toString());
            }

        }
        return player;
    }


    public static boolean checkWinner() {
        if (player1.size() == 1) {
            System.out.println("Player1 says : UNO!");
        } else if (player2.size() == 1) {
            System.out.println("Player2 says: UNO!");
        } else if (player1.size() == 0) {
            System.out.println("Player1 has won!");
            won = true;
        } else if (player1.size() == 0) {
            System.out.println("Player1 has won!");
            won = true;
        }
        return won;
    }

    public static void wildBlackFour() {

    }
}
