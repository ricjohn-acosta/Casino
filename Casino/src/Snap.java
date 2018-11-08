/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricjo
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Snap {

    private int playerTurn = 0;
    int PLAYER_1 = 1;
    int PLAYER_2 = 2;
    private Deck player1Deck;
    private Deck player2Deck;
    private ArrayList<Card> pile;

    public Snap() {
        setupPlayerDecks();
        pile = new ArrayList<>();
    }

    private void setupPlayerDecks() {
        player1Deck = new Deck(true);
        player2Deck = new Deck(true);
        player1Deck.shuffle();
        player2Deck.shuffle();

        while ((player1Deck.getDeckSize() != 26) && (player2Deck.getDeckSize()
                != 26)) {
            Card discard1 = player1Deck.drawCard();
            Card discard2 = player2Deck.drawCard();
        }
    }

    private void pickupPile(int player) {
        if (player == 3) {
            for (int i = 0; i < pile.size(); i++) {
                Card pileCard = pile.get(i);
                player1Deck.placeCard(pileCard);
            }
            pile.clear();
        }

        if (player == 4) {
            for (int i = 0; i < pile.size(); i++) {
                Card pileCard = pile.get(i);
                player2Deck.placeCard(pileCard);
            }
            pile.clear();
        }

    }

    private boolean checkSnap() {
        return ((pile.get(pile.size() - 1).getValue() == (pile.get(pile.size()
                - 2).getValue())));
    }

    // snap method returns whether the snap was successful or not.
    public boolean snap(int player) {
        if (player == 3) {
            if (checkSnap()) {
                pickupPile(3);
                player1Deck.shuffle();
                return true;
            } else {
                pickupPile(4);
                player2Deck.shuffle();
                return false;
            }
        } else if (player == 4) {
            if (checkSnap()) {
                pickupPile(4);
                player2Deck.shuffle();
                return true;
            } else {
                pickupPile(3);
                player1Deck.shuffle();
                return false;
            }
        } else {
            return false;
        }
    }

    // drawCard method is where the player places card on the center.
    public Card drawCard(int player) {
        if (player == PLAYER_1) {
            Card p1Card = player1Deck.drawCard();
            if (player1Deck.getDeckSize() == 1) {
                System.out.println("Player 1 drew: " + p1Card + "\nPlayer 1 has "
                        + "one card remaining");
            } else {
                System.out.println("Player 1 drew: " + p1Card + "\nPlayer 1 has "
                        + player1Deck.getDeckSize() + " cards left!");
            }
            pile.add(p1Card);
            System.out.println("\nNumber of cards in pile: " + pile.size());
            playerTurn = PLAYER_2;
        }

        if (player == PLAYER_2) {
            Card p2Card = player2Deck.drawCard();
            if (player2Deck.getDeckSize() == 1) {
                System.out.println("Player 2 drew: " + p2Card + "\nPlayer 2 has "
                        + "one card remaining");
            } else {
                System.out.println("Player 2 drew: " + p2Card + "\nPlayer 2 has "
                        + "" + player2Deck.getDeckSize() + " cards left!");
            }
            pile.add(p2Card);
            System.out.println("\nNumber of cards in pile: " + pile.size());
            playerTurn = PLAYER_1;
        }
        return pile.get(pile.size() - 1);
    }

    public boolean hasGameFinished() {
        return ((player1Deck.getDeckSize() == 0) || (player2Deck.getDeckSize()
                == 0));
    }

    public boolean isWinner() {
        return getPlayerCardsRemaining(1) == 0;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public int getPlayerCardsRemaining(int player) {
        int size;

        if (player == PLAYER_1) {
            return size = player1Deck.getDeckSize();
        } else {
            return size = player2Deck.getDeckSize();
        }
    }

    public static void main(String[] args) {
        int player = 0;
        boolean isPlaying = true;

        Snap s = new Snap();
        Scanner input = new Scanner(System.in);

        System.out.println("==Player 1==\n1 - draw\n3 - snap\n\n==Player 2==\n2 "
                + "- draw\n4 - snap");

        while (isPlaying) {
            player = input.nextInt();

            if (player >= 5 || player <= 0) {
                System.out.println("Please pick valid number.");
            }

            // draw
            if ((player == 1) && (s.getPlayerTurn() == 0)) {
                s.drawCard(player);
            } else if ((player == 1) && (s.getPlayerTurn() == 1)) {
                s.drawCard(player);
            } else if ((player == 1) && (s.getPlayerTurn() == 2)) {
                System.out.println("Not your turn.");
            }

            if ((player == 2) && (s.getPlayerTurn() == 0)) {
                s.drawCard(player);
            } else if ((player == 2) && (s.getPlayerTurn() == 2)) {
                s.drawCard(player);
            } else if ((player == 2) && (s.getPlayerTurn() == 1)) {
                System.out.println("Not your turn.");
            }

            // snap
            if ((player == 3)) {
                boolean temp = s.snap(player);
                if (temp) {
                    System.out.println("Player 1 snapped correctly!\nPick up "
                            + "the pile player 1!");
                    System.out.println("Player 1 now has "
                            + s.getPlayerCardsRemaining(1) + " cards remaining");
                } else {
                    System.out.println("Player 1 snapped incorrectly!\nPick up "
                            + "the pile player 2!");
                    System.out.println("Player 2 now has "
                            + s.getPlayerCardsRemaining(2) + " cards remaining");
                }
            }
            if ((player == 4)) {
                boolean temp = s.snap(player);
                if (temp) {
                    System.out.println("Player 2 snapped correctly!\nPick up the"
                            + " pile player 2!");
                    System.out.println("Player 2 now has "
                            + s.getPlayerCardsRemaining(2) + " cards remaining");
                } else {
                    System.out.println("Player 2 snapped incorrectly!\nPick up "
                            + "the pile player 1!");
                    System.out.println("Player 1 now has "
                            + s.getPlayerCardsRemaining(1) + " cards remaining");
                }
            }

            // check if someone won
            if (s.hasGameFinished()) {
                if (s.isWinner()) {
                    System.out.println("Player 2 won!");
                    break;
                } else if (!s.isWinner()) {
                    System.out.println("Player 1 won!");
                    break;
                } else if (s.getPlayerCardsRemaining(1)
                        == s.getPlayerCardsRemaining(2)) {
                    System.out.println("Tie!");
                    break;
                }
            }

        }
    }
}
