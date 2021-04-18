/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgofish;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mandeep singh
 * @author Nitin minhas
 * @author Shreya patel
 * @author Sukhpreet kaur
 */
public class TeamGoFish {

    /**
     * @param args the command line arguments
     */
        public static Player[] users;
        public static GroupOfCards gOfc; 
        public static void main(String[] args) {
            Game goFish = new Game("GO FISH");
            System.out.println("\n------- HELLO! WELCOME TO THE GAME - " + goFish.getGameName() + "-----");
            boolean startPlay = true;
            while (startPlay) 
            {
                    System.out.println("\nPlease enter your name");
                    Scanner scan = new Scanner(System.in);
                    String name = scan.nextLine();
                    User user = new User(name);
                    Cpu computer = new Cpu();
                    users = new Player[]{user, computer};
                    boolean begin = false;
                    while (!begin) {
                        System.out.println("\n Press 1 to start the game");
                        int startGame = scan.nextInt();
                        if (startGame == 1)
                        {
                            begin = true;
                            gOfc = new GroupOfCards();
                            gOfc.generateDeck();
                            users[0].getHand().setSize(0);
                            users[1].getHand().setSize(0);
                            gOfc.distributeCards(users[0], 10);
                            gOfc.distributeCards(users[1], 10);
                            boolean error = false;
                            while (!error) 
                            {
                                try 
                                {
                                    goFish.play(users[0], users[1], gOfc);
                                    error = true;
                                }
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("Faulty Input!");
                                    error = false;
                                }
                            }
                            int answer = 0;
                            boolean correct = false;
                            while (!correct) 
                            {
                                try {
                                    System.out.println("\nWanna Play Again?");
                                    System.out.println("1.YES\n2.NO");
                                    answer = scan.nextInt();
                                    if (answer != 0 && answer != 1)
                                    {
                                        System.out.println("Please choose a correct option");
                                        correct = false;
                                    }
                                    else
                                    {
                                        correct = true;
                                    }
                                } 
                                catch (InputMismatchException e) {
                                    System.out.println("ERROR: Invalid input!");
                                    scan.nextLine();
                                }
                            }
                            if (answer == 1)
                            {
                                startPlay = true;
                            } 
                            else 
                            {
                                startPlay = false;
                            }
                        } 
                        else 
                        {
                            System.out.println("\n Please Enter 1 to start");
                            begin = false;
                        }
                    }
            }
        }
}
