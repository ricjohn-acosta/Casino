/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricjo
 */
public class Deck {

    private Card[] deck;
    private int deckSize;
    public int MAX_SIZE = 52;

    public Deck() {
        initialiseFullDeck();
    }

    public Deck(boolean fullDeck) {
        if (fullDeck) {
            initialiseFullDeck();
        } else {
            deck = new Card[52];
            deckSize = 0;
        }
    }

    private void initialiseFullDeck() {
        int i = 0;
        deck = new Card[MAX_SIZE];
        while (i != MAX_SIZE) {
            for (int j = 1; j < 14; j++) {
                for (int k = 1; k < 5; k++) {
                    deck[i] = new Card(j, k);
                    i++;
                }
            }
        }
        deckSize = MAX_SIZE;
    }

    // method of type Card (String type)
    public Card drawCard() {
        Card currentCard = deck[deckSize - 1];
        deckSize--;

        return currentCard;
    }

    public void placeCard(Card card) {
        deck[deckSize + 1] = card;
        deckSize++;

    }

    public void shuffle() {
        int randomCard;
        Card temp;

        for (int i = 0; i < deckSize; i++) {
            randomCard = (int) (Math.random() * deckSize);
            temp = deck[i];
            deck[i] = deck[randomCard];
            deck[randomCard] = temp;
        }
    }

    public int getDeckSize() {
        return deckSize;
    }

    public boolean hasCardsRemaining() {
        return deckSize > 0;
    }

    @Override
    public String toString() {
        String cards = " ";
        int nextLine = 0;

        for (int i = 0; i < deckSize; i++) {
            cards += deck[i];
            cards += " ";
            nextLine++;

            if (nextLine == 10) {
                cards += "\n";
                nextLine = 0;
            }
        }
        return cards;
    }
}
