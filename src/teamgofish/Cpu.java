/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgofish;

import java.util.Random;

/**
 *
 * @author Mandeep singh
 * @author Nitin minhas
 * @author Shreya patel
 * @author Sukhpreet kaur
 */
public class Cpu extends Player {
    public Cpu(String name) 
    {
        super(name);
    }
    public Cpu() 
    {
        
    }
    @Override
    public void haveTurn() {
        boolean changeTurn = false;
        do {
            Random rn = new Random();
            int random = rn.nextInt(hand.getSize() - 1) + 1;
            Card.Value value = hand.get(random).getValue();
            changeTurn = TeamGoFish.users[1].askFor(value, TeamGoFish.users[0], TeamGoFish.gOfc);
            TeamGoFish.users[1].checkNumOfBooks(); // checking number of book
        } while (!changeTurn);
    }
}
