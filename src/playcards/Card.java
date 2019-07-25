/**
 * Name: Quang Bui
 * Due date: Tuesday, April 3rd, 2018
 * The sample of A. Wright teacher.
 * Class Description:  A Card has an int value (2 .. 14) that corresponds
 * to its face value for 2 - 10; J= 11, Q= 12; K = 13; A = 14. Each card
 * also has a Suit: diamonds, hearts, spades, or clubs.  The user can set/get
 * the value and the suit.
 */

package playcards;
// 2 - 10, 11 is J, 12 is Q, 13 is K, 14 is A
/**
 *
 * @author A. Wright
 * Color-coding updates by Brad Odenath and John Miller 9-8-2015
 */
public class Card {
    private Suit suit;
    private Color color;
    private int value; // from 2 to 14
    private static final char diamondsChar = ('\u2666');
    private static final char heartsChar = ('\u2665');
    private static final char clubsChar = ('\u2663');
    private static final char spadesChar = ('\u2660');
    private static final String red = (char)27 + "[31m";
    private static final String reset = (char)27 + "[0m";
    
    /**
    * default constructor -- Creates a 7 of hearts
    */ 
    public Card(){
        value = 13;
        suit = Suit.hearts;
        color = Color.red;
    }
    
    /**
    * conversion constructor 
    * preconditions: input v is 2..14 and (valid Suit)
    * postconditions: set the value to input v if valid and suit to input s
    *                 otherwise exit the program
    */ 
    public Card(int v, Suit s){
        // v (2 - 14), S la chon co, ro, chuon, bich
        if(v < 15 && v > 1){
            // 2 <= v <= 14
            value = v;
            suit = s;
            if(suit == Suit.hearts || suit == Suit.diamonds){
                color = Color.red;
            }else{
                color = Color.black;
            }
        }else{
            System.out.println("Invalid card construction attempted");
            System.exit(1);
        }
    }
    
    /**
    * void setValue():  mutator method
    * @param v is input value for the Card (range must be 2 - 14)
    * preconditions: input v  is 2 .less or equal. v .less or equal. 14 
    * postconditions: if v is valid; change the value, otherwise ignore input
    */
    public void setValue(int v){
        if(2 <= v && v <= 14){
            value = v;
        }
    }
    
    /**
    * int getValue(): Accessor
    * @return int value -- face value of the card (2..10) J:11, Q:12, K:13, A:14
    */
    public int getValue(){
        return this.value;
    }
    
    /**
    * void setSuit(): Mutator: used to change a Card's suit
    * @param s suit for card {must be Suit. hearts, diamonds, spades, or clubs)
    * preconditions: none
    * postconditions: changes the suit of the card to input s
    */
    public void setSuit(Suit s){
        suit = s;
        
        if(suit == Suit.diamonds || suit == Suit.hearts){
            color = Color.red;
        }else{
            color = Color.black;
        }
    }
    
    /**
    * Suit getSuit(): Accessor - returns a copy of the Card's suit
    * @return suit of the card
    * preconditions: none
    * postconditions: returns the suit of the card to caller
    */ 
    public Suit getSuit(){
        return this.suit;
    }
    
     /**
    * Suit getColor(): Accessor - returns a copy of the Card's color (red/black)
    * @return Color of the card
    * preconditions: none
    * postconditions: returns the color of the card to caller
    */ 
    public Color getColor(){
        return this.color;
    }
    
    /**
    * String toString() : Accessor
    * @return A String output for the Card..
    */  
    public String toString(){
        String cVal = "";
        String cShape = "";
        
        switch(value){
            case 11:{
                cVal += "J";
                break;
            }
            case 12:{
                cVal += "Q";
                break;
            }
            case 13:{
                cVal += "K";
                break;
            }
            case 14:{
                cVal += "A";
                break;
            }
            default:{
                cVal += value;
                break;
            }
        }
        
        if(suit == Suit.hearts){
            cShape += red + heartsChar + reset;
        }else if(suit == Suit.diamonds){
            cShape += red + diamondsChar + reset;
        }else if(suit == Suit.clubs){
            cShape += clubsChar;
        }else{
            cShape += spadesChar;
        }
        
        cVal = cVal + cShape;
        
        return cVal;
    }
    
    /** Accessor: equals()
     * if the comp card and the current card have the same value
     * return true; otherwise return false
     * @param comp card to compare for equal value
     * @return boolean true or false
     */
    
    public boolean equals(Card comp){
        boolean flag = false;
        
        if(value == comp.value && suit == comp.suit){
            flag = true;
        }else{
            flag = false;
        }
        
        return flag;
    }
    
    /**
     * Mutator: displayInfomation(Card comp)
     * @param comp (comp parameter will be use to compare with another
     * card)
     * Pre-condition: the equals(Card comp) method must be defined
     * Post-condition: Just output the information about comparing
     * two cards. If equals(Card comp) method is return true, two
     * cards are the same value and suit; otherwise, two cards
     * are not the same value and suit.
     */
    public void displayInfomation(Card comp){
        if(equals(comp) == true){
            System.out.println(this.toString() + " and " + comp.toString() 
                    + " are THE SAME "
                    + "VALUE and SUIT.");
        }else{
            System.out.println(this.toString() + " and " + comp.toString() 
                    + " are NOT THE SAME "
                    + "VALUE and SUIT.");
        }
    }
}
