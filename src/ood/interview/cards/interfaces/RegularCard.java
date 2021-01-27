package ood.interview.cards.interfaces;

import ood.interview.cards.interfaces.Card;

/**
 * This is the interface for a standard playing card. Contains face values Ace, 2-10, Jack, Queen, King
 * together in four sets of suits Spades, Hearts, Clubs, and Diamonds.
 *
 * @author Anna M. Lahoud
 * @version 0.1
 */
public interface RegularCard extends Card {

    /**
     * Obtain the value of the card (used mostly in sorting).
     *
      * @return count Integer value of the card (A=1, 2=2, ..., J=11, Q=12, K=13)
     */
    public int getCardValue();

    /**
     * Obtain the face value of the card (A=1, 2=2, ..., J=10, Q=10, K=10)
     *
     * @return value of card's face value
     */
    public int getFaceValue();

    /**
     * Obtain the sort value of the card (face card value multiplied by the value assigned for the suit).
     *
     * @return count the sort value of the card
     */
    public int getSortValue();

}
