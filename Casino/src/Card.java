/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricjo
 */
public class Card implements Comparable<Card> {
    private Integer suit;
    private Integer value;
    String suit1;
    String value1;
    
    public Card(int value, int suit) {
        this.suit = suit;
        this.value = value;
    }
    
    @Override
    public int compareTo(Card other) {
        if(this.value == other.value) {
            return suit.compareTo(other.suit);
        } else {
            return this.value - other.value;
        }
    }
    
    public int getValue() {
        return this.value;
    }
    
    public int getSuit() {
        return this.suit;
    }
    
    @Override
    public String toString() {   
        
        if (this.suit == 1) {
            suit1 = "S";
        } else if (this.suit == 2) {
            suit1 = "C";
        } else if (this.suit == 3) {
            suit1 = "D";
        } else if (this.suit == 4) {
            suit1 = "H";
        }
        
        if (this.value == 1) {
            value1 = "A";
        } else if (this.value == 11) {
            value1 = "J";
        } else if (this.value == 12) {
            value1 = "Q";
        } else if (this.value == 13) {
            value1 = "K";
        } else if (this.value == 10) {
            value1 = "10";
        } else {
            value1 = Integer.toString(this.value);
        }    
        return "[" + value1 + suit1 + "]";
    } 
}
