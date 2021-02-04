package ood.interview.cards.interfaces;

import java.util.Collection;

/**
 * This is the interface for a standard deck of cards.
 *
 * @author Anna M. Lahoud
 * @version 0.1
 *
 */

public interface Deck {

    /**
     * Shuffle single deck of cards, reordering them in a random fashion.
     */
    void shuffle();

    /**
     * Display the cards in the deck.
     */
    void display();

    /**
     * Draw a card from the top of the deck.
     *
     * @return Card issued from top of deck, null if there are no cards in the deck
     */
    Card drawCard();

    /**
     * Return the card to the deck at the bottom.
     *
     * @param card to return to deck. Ignores null.
     */
    void returnCard(Card card);

    /**
     * Return the collection of cards to the deck.
     *
     * @param cards Collection of cards to be returned. Empty/null records are ignored.
     */
    void returnCards(Collection<Card> cards);

    /**
     * Count the cards remaining in the deck.
     *
     * @return the number of cards remaining in the deck
     */
    int countRemaining();

    /**
     * Count the number of cards 'missing' from the deck, which is the standard deck count
     * minus the cards remaining.
     *
     * @return the number of cards missing from the deck.
     */
    int countMissing();

    /**
     * Sort the cards in specified ascending or descending order.
     *
     * @param sortAscending flag TRUE for ascending order, FALSE for descending order.
     */
    void sort(boolean sortAscending);
}
