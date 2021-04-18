/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgofish;

/**
 *
 * @author Mani Ubhi
 */
public class Card {
    public enum Suit
    {
        HEARTS, CLUBS, DIAMONDS, SPADES;
    };
    public enum Value 
    {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
    };

    private Value value;
    private Suit suit;
    private final int deckSize = 52;
    public Card(Suit s, Value v) 
    {
        suit = s;
        value = v;
    }
    public boolean equals(Card card) 
    {
        return this.getValue().equals(card.getValue());
    }
    public Value getValue() 
    {
        return value;
    }

    public void setValue(Value value) 
    {
        this.value = value;
    }
    public Suit getSuit() 
    {
        return suit;
    }
    public void setSuit(Suit suit) 
    {
        this.suit = suit;
    }

    @Override
    public String toString() {

        return getValue() + " Of The " + getSuit();

    }
}

