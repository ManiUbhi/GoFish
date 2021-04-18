/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgofish;
import teamgofish.Card.Value;
/**
 *
 * @author Mandeep singh
 * @author Nitin minhas
 * @author Shreya patel
 * @author Sukhpreet kaur
 */
public abstract class Player 
{
    protected GroupOfCards hand = new GroupOfCards();
    private String name;
    private int score;
    public Player(String name) 
    {
        this.name = name;
    }
    public Player()
    {
        
    }
    
    public GroupOfCards getHand() 
    {
        return hand;
    }
    
    public void setHand(GroupOfCards hand) 
    {
        this.hand = hand;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    public void addScore() 
    {
        score++;
    }
    protected boolean askFor(Value value, Player otherPlayer, GroupOfCards gOfc) 
    {
        boolean compContains = false;
        boolean userContains = false;
        boolean changeTurn = false;
        for (int i = 0; i < this.getHand().getSize(); i++) 
        {
            if (this.getHand().get(i).getValue().equals(value)) 
            {
                userContains = true;
            }
        }
        if (userContains) {
            int enteredLoop = 0;
            for (int j = 0; j < otherPlayer.getHand().getSize(); j++) {
                if (otherPlayer.getHand().get(j).getValue().equals(value)) {
                    enteredLoop++;
                    if (enteredLoop == 1) {
                        if (this instanceof User) {
                            System.out.println("Computer has the requested card!\nYour hand is updated!!\n");
                        } else {
                            System.out.println("Computer asks for " + value);
                            System.out.println("You contain the requested card!\nYou lose all the cards matching requested card!:(\n");
                        }
                    }
                    this.getHand().add(otherPlayer.getHand().get(j));
                    otherPlayer.getHand().remove(otherPlayer.getHand().get(j));
                    otherPlayer.getHand().setSize(otherPlayer.getHand().getSize() - 1);
                    this.getHand().setSize(this.getHand().getSize() + 1);

                    compContains = true;
                }
            }
            if (!compContains)
            {
                if (this instanceof User) 
                {
                    System.out.println("Computer says: GO FISH!!");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("You lose your turn! It's computer turn!:(\n");
                } 
                else 
                {
                    System.out.println("Computer asks for " + value);
                    System.out.println("Computer goes FISHING! ;)");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Your turn! YAYYY!\n");
                }
                gOfc.goFish(this);
                changeTurn = true; 
            }
        }
        if (!userContains)
        {
            System.out.println("You don't have the requested card in your" + " hand.Please ask card that you have in your hand");
        }
        return changeTurn;
    }
    public boolean checkNumOfBooks() {
        boolean hasBook = false;
        for (int i = 0; i < this.getHand().getSize(); i++) {
            int sameCard = 0;
            Card sameValue[] = new Card[4]; 
            for (int j = 0; j < this.getHand().getSize(); j++) {
                if (this.getHand().get(i).getValue().equals(this.getHand().get(j).getValue())) {
                    sameValue[sameCard] = this.getHand().get(j);
                    sameCard++;
                    if (sameCard == 4) 
                    {
                        addScore();
                        hasBook = true;
                        if (this instanceof User) 
                        {
                            System.out.println("\nYou got a book of:" + this.getHand().get(i).getValue()
                                    + "\nYour score is updated.");
                        } 
                        else 
                        {
                            System.out.println("\nComputer got a book of:" + this.getHand().get(i).getValue()
                                    + "\nComputer's score is updated");
                        }
                        for (int k = 0; k < 4; k++) 
                        {
                            this.getHand().remove(sameValue[k]);
                            this.getHand().setSize(this.getHand().getSize() - 1);
                        }
                    }
                }
            }
        }
        return hasBook;
    }
    public abstract void haveTurn();
}
