/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgofish;

import java.util.Scanner;

/**
 *
 * @author Mani Ubhi
 */
public class Game {
        private String gameName;   
    public Game(String givenName)
    {
        gameName = givenName;
    }
    public String getGameName() 
    {
        return gameName;
    }
    public void setGameName(String gameName) 
    {
        this.gameName = gameName;
    }
    public void play(Player player1, Player player2, GroupOfCards groupOfCards) 
    {
        OUT:
        while (groupOfCards.getDeck().size() > 1) {
            player1.haveTurn();
            Scanner scan = new Scanner(System.in);
            boolean run = true;
            IN:
            while (run) 
            {
                System.out.println("Enter 0 to Exit and declare winner or 1 to continue.");
                int choose = scan.nextInt();
                switch (choose) 
                {
                    case 1:
                        break IN; 
                    case 0:
                        break OUT; 
                    default:
                        System.out.println("Please select an valid option!\n");
                }
            }
            player2.haveTurn();
        }
        findWinner(player1, player2);
    }
    public void findWinner(Player player1, Player player2) 
    {
        if (player1.getScore() > player2.getScore())
        {
            System.out.println("You won the game!");
        } 
        else if (player1.getScore() == player2.getScore()) 
        {
            System.out.println("There is a tie, You both scored equal! ");
        } 
        else 
        {
            System.out.println("You Lost,CPU has won the game!");
        }
    }
    
}
