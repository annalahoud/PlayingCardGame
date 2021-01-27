package ood.interview.cards;

import java.util.*;

/**
 * Concrete class for single card deck implementation.
 *
 * @author Anna M. Lahoud
 * @version 0.1
 *
 */
public class SingleDeck implements Deck {

    private final int DECK_SIZE = 52;
    public List<RegularPlayingCard> deck;

    public SingleDeck() {
        deck = new ArrayList<>(DECK_SIZE);
        initialize();
    }

    private void initialize() {
        for (Suits suit : Suits.values()) {
            for (CardValue value : CardValue.values()) {
                RegularPlayingCard card = new RegularPlayingCard(suit, value);
                deck.add(card);
            }
        }
        System.out.println("Deck initialized with " + countRemaining() + " cards.");
    }

    @Override
    public void shuffle() {
        Collections.shuffle(deck);
        display();
    }

    /**
     * Display the cards in the deck.
     */
    @Override
    public void display() {
        if ((deck != null) && (!deck.isEmpty())) {
            for (int i = 0; i < deck.size(); i++) {
                Card card = deck.get(i);
                card.display();
            }
        }
    }

    @Override
    public Card drawCard() {
        if (countRemaining() > 1) {
            return deck.remove(0);
        }
        return null;
    }

    @Override
    public void returnCard(Card card) {
        if ((card != null) && (countMissing() > 1)) {
            if (card instanceof RegularPlayingCard) {
                deck.add((RegularPlayingCard) card);
            }
        }
    }

    @Override
    public void returnCards(Collection<Card> cards) {
        if ((cards != null) && !cards.isEmpty()) {
            for (Card card : cards) {
                if (card instanceof RegularPlayingCard) {
                    returnCard(card);
                }
            }
        }
    }

    @Override
    public int countRemaining() {
        return deck.size();
    }

    @Override
    public int countMissing() {
        return DECK_SIZE - countRemaining();
    }

    /**
     * Sort the cards in specified ascending or descending order.
     *
     * The cardinal value of cards Ace through King are 1 through 13. These are used for sorting only. The
     * formula to get sort values is the ordinal value of the card (1-13) times the value of the suit
     * (Clubs = 4, Hearts = 3, Diamonds = 2, Spades = 1). As examples, Ace of Spades is 1 times 1, King of
     * Hearts is 13 times 3.
     *
     * @param sortAscending flag TRUE for ascending order, FALSE for descending order.
     */
    @Override
    public void sort(boolean sortAscending) {
        if (sortAscending) {
            Collections.sort(deck);
        }
        else {
            Collections.sort(deck, Collections.reverseOrder());
        }
    }
}
