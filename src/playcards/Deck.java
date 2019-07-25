/**
 * Name: Quang Bui
 * Due date: Tuesday, April 3rd, 2018
 *  CLASS DESCRIPTION: A Deck consists of 52 playing cards
 comprised of 2 - Ace (int value 2 - 14) of 4 suits (clubs, diamonds, 
 hearts, and spades) The user can construct a deck, deal a card, 
 and shuffle a deck, and display the deck using its toString method
*
* program started by: CSC-122
* program completed by: Quang Bui
* date: Thursday, March 29th, 2018

 */

package playcards;

import java.util.Random;

/**
 *
 * @author prof aw
 */

public class Deck {
    private int topCard;
    private Card[] deck;
    final int SIZE = 52;
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: the topCard and deck variable must be declared.
     * Post-condition: This method will be initialize all the variables
     * (properties) of the Deck class. The deck will be initialize in an
     * array with 52 (SIZE) element <=> 52 cards in the deck.
     * Each suit (spades, hearts, diamonds, and clubs) have 13 cards, 
     * So the programmers declare int suit = i / 13; 
     * int val = (i % 13) + 2;
     * If i = 32, val = 32 % 13 + 2 = 8, 32 / 13 = 2 => Suit.clubs
     * => 8 clubs
     * If i = 23, val = 23 % 13 + 2 = 12, 23 / 13 = 1 => Suit.diamonds
     * => 12 => Q clubs
     */
    public Deck(){
        topCard = 0;
        deck = new Card[SIZE];
        
        for(int i = 0; i < SIZE; i++){
            int suit = i / 13; 
            Suit theSuit = Suit.spades;
            switch(suit){
                case 0:{
                    theSuit = Suit.hearts; // 0 - 12
                    break;
                }
                case 1:{
                    theSuit = Suit.diamonds; // 13 - 25
                    break;
                }
                case 2:{
                    theSuit = Suit.clubs; // 26 - 38
                    break;
                }
                case 3:{
                    theSuit = Suit.spades; // 39 - 51
                    break;
                }
            }
            
            int val = (i % 13) + 2; // for value 2 - A
            deck[i] = new Card(val, theSuit);
        }
    }
    
    /**
     * Accessor: toString()
     * @return the entire 52 cards of the deck as one string
     */
    
    public String toString(){
        String out = "";
        
        for(int i = 0; i < SIZE; i++){
            if(i % 4 == 0){
                out += "\n";
            }
            out += deck[i].toString() + "\t";
        }
        out += "\n";
        return out;
    }
    
    /**
     * shuffle()  -- mixes up the cards in the deck
     * preconditions: none
     * postconditions:  mixes up the cards (shuffles them) and reset
     *                  topCard to 0
     */
    public void shuffle(){
        Random rand = new Random();
        Card temp = new Card();
        int n = 0;
        for (int i = 0; i < 3; i++)
        {
            for ( int c = 0; c < SIZE; c++)
            {
                int itemp = rand.nextInt(SIZE);
                temp = deck[c];
                deck[c] = deck[itemp];
                deck[itemp] = temp;
                
            }
        }
        topCard = 0;
    }
    
    /**
    * Mutator: dealACard() Deal one card from the top of the deck
    * @return top Card on the deck
    * preconditions:  none
    * postconditions: if there are cards left in the deck, the top card
    *                 is returned; otherwise for an empty deck (all cards 
    *                 were already dealt) the deck is shuffled and top card
    *                 is dealt; topCard indicator is incremented by one
    *                 by one
    */
    
    public Card dealACard()
    {
        if(topCard < SIZE){
            return deck[topCard];
        }else{
            shuffle();
            return deck[topCard++]; // increament before return 
        }
    }
    
    /**
     * Mutator: dealACard(int whichCard)
     * @param whichCard (a specific card from the deck)
     * @return Card
     * Pre-condition: The whichCard must in the range [0 to SIZE - 1]
     * Post-condition: This method return a card from the deck
     * with a specific card from the deck based on the whichCard
     * parameter if whichCard in the range [0 to SIZE - 1]. If
     * whichCard is not in the range [0 to SIZE - 1], the topCard
     * position in the deck is returned.
     */
    public Card dealACard(int whichCard)
    {
        if(0 <= whichCard && whichCard < SIZE){
            return deck[whichCard];
        }else{
            shuffle();
            return deck[topCard];
        }
    }
    
    /**
     * Mutator: displayDeckInformation()
     * Pre-condition: the Card class must be defined.
     * Post-condition: The displayDeckInformation() will create 3 cards,
     * 3 cards will be assigned to dealACard(), dealACard(12), and
     * dealACard(0), respectively, and them output their status about
     * comparing two cards.
     */
    public void displayDeckInformation(){
        Card cardA = new Card();
        Card cardB = new Card();
        Card cardC = new Card();
        cardA = this.dealACard();
        cardB = this.dealACard(12);
        cardC = this.dealACard(0);
        System.out.println("The Card A: " + cardA);
        System.out.println("The Card B: " + cardB);
        System.out.println("The Card C: " + cardC);
        cardA.displayInfomation(cardB);
        cardA.displayInfomation(cardC);
    }
}
