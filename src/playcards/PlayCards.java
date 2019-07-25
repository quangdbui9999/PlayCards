/**
 * Name: Quang Bui
 * Due date: Tuesday, April 3rd, 2018
 * CSC-122 Spring 2017 Week #7/8
 *  This project consists of the following files:
 *    1.  PlayCards.java (this file) driver to instantiate and test Deck
 *    2.  Deck.java - the deck of 52 Cards that can be used to play card games
 *    3.  Card.java - defines an individual playing Card  
 *    4.  PinochleDeck.java - defines an individual playing Card  
 */

package playcards;

/**
 * Shell created by:  prof aw
 * @author Quang Bui
 */

public class PlayCards {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
        deck.displayDeckInformation();
        
        PinochleDeck pinochleDeck = new PinochleDeck();
        System.out.println(pinochleDeck);
        pinochleDeck.shuffle();
        System.out.println(pinochleDeck);
        pinochleDeck.displayPinochleDeckInformation();
    }
}
