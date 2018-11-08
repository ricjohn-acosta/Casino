/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricjo
 */
import java.util.Scanner;
import java.util.ArrayList;

public class DrinkingGame {

    private static ArrayList<Card> pile;

    public static void main(String[] args) {

        // Create a stack of cards and shuffle it
        Deck d = new Deck(true);
        d.shuffle();

        // Take an input from user to start the game and basic user controls
        Scanner input = new Scanner(System.in);
        int player1Score = 0;
        int player2Score = 0;
        int playerTurn = 0;
        int player;
        ;
        pile = new ArrayList<>();

        // Keep on running the program until cards run out
        while (d.hasCardsRemaining()) {
            System.out.println("Enter:\n1 - Player 1\n2 - Player 2");
            player = input.nextInt();

            if (player == 1 && (playerTurn == 0 || playerTurn == 1)) {
                Card p1Card = d.drawCard();
                pile.add(p1Card);
                System.out.println("Player 1 drew: " + p1Card);
                playerTurn = 2;
            } else if (player == 1 && playerTurn == 2) {
                System.out.println("Not your turn!\n");
            }

            if (player == 2 && (playerTurn == 0 || playerTurn == 2)) {
                Card p2Card = d.drawCard();
                pile.add(p2Card);
                System.out.println("Player 2 drew: " + p2Card);
                playerTurn = 1;
            } else if (player == 2 && playerTurn == 1) {
                System.out.println("Not your turn!\n");
            }

            if (pile.size() == 2) {
                if (player == 2) {
                    if (pile.get(0).compareTo(pile.get(1)) > 0) {
                        System.out.println(pile.get(0) + " won!");
                        System.out.println("Drink up player 2!\n");
                        player1Score++;
                    } else if (pile.get(0).compareTo(pile.get(1)) < 0) {
                        System.out.println(pile.get(1) + " won!");
                        System.out.println("Drink up player 1!\n");
                        player2Score++;
                    }
                }
                
                if (player == 1) {
                    if (pile.get(1).compareTo(pile.get(0)) > 0) {
                        System.out.println(pile.get(1) + " won!");
                        System.out.println("Drink up player 2!\n");
                        player1Score++;
                    } else if (pile.get(1).compareTo(pile.get(0)) < 0) {
                        System.out.println(pile.get(0) + " won!");
                        System.out.println("Drink up player 1!\n");
                        player2Score++;
                    }
                }
                pile.clear();
            }

        }

        System.out.println("\nPlayer 1 drank a total of " + player1Score + " shots."
                + "\nPlayer 2 drank a total of " + player2Score + " shots.\n\n"
                + "Thank you for playing!\nDon't drink and drive!");
    }
}
