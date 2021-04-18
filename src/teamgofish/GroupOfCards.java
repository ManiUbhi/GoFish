/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgofish;

/**
 *
 *@author Mandeep singh
 * @author Nitin minhas
 * @author Shreya patel
 * @author Sukhpreet kaur
 */
import java.util.ArrayList;
import java.util.Random;

public class GroupOfCards 
{
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> deck = new ArrayList<>();
    private int size;
    public GroupOfCards(int givenSize) 
    {
        size = givenSize;
    }

    public GroupOfCards()
    {
    
    }
    public int getSize() 
    {
        return size;
    }
    public void setSize(int givenSize) 
    {
        size = givenSize;
    }
    public ArrayList<Card> getDeck()
    {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) 
    {
        this.deck = deck;
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public void setCards(ArrayList<Card> cards)
    {
        this.cards = cards;
    }

    public Card get(int Index)
    {
        if (Index <= cards.size())
        {
            return cards.get(Index);
        } 
        else
        {
            return null;
        }
    }
    public void add(Card card)
    {
        cards.add(card);
    }
    public void remove(Card card)
    {
        cards.remove(card);
    }
    public void generateDeck()
    {
        for (Card.Suit s : Card.Suit.values())
        {
            for (Card.Value v : Card.Value.values())
            {
                Card c = new Card(s, v);
                this.deck.add(c);
            }
        }
    }
    public void distributeCards(Player player, int numCards)
    {
        for (int i = 0; i < numCards; i++) 
        {
            Random rn = new Random();
            //randomly select a card from the deck
            int rand = rn.nextInt(deck.size() - 1) + 1;
            player.getHand().add((deck.get(rand))); // adding the card to players hand
            player.getHand().setSize(player.getHand().getSize() + 1); // increasing the size of players hand
            deck.remove(rand);//removing the card from the deck
        }
    }

    public void goFish(Player player) {
        if (deck.size() > 0) {
            Random rn = new Random();
            int rand = rn.nextInt(deck.size() - 1) + 1;
            player.getHand().add(deck.get(rand));
            player.getHand().setSize(player.getHand().getSize() + 1);
            deck.remove(rand);

        } 
        else 
        {
            System.out.println("Card deck is empty");
        }
    }
}
