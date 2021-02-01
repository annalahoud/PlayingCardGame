package ood.interview.cards;

import ood.interview.cards.interfaces.CardValue;
import ood.interview.cards.interfaces.RegularCard;
import ood.interview.cards.interfaces.Suits;

/**
 * Regular playing card imlementation class.
 *
 * @author Anna M. Lahoud
 * @version 0.1
 *
 */
public class RegularPlayingCard implements RegularCard, Comparable<RegularPlayingCard> {

    private final Suits suit;
    private final CardValue cardValue;
    private final int sortValue;
    private final int SUIT_SIZE = 13;

    public RegularPlayingCard(Suits suit, CardValue cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
        this.sortValue = cardValue.getCardValue() + (suit.getSuit() * SUIT_SIZE);
    }

    @Override
    public int getCardValue() {
        return cardValue.getCardValue();
    }

    @Override
    public int getFaceValue() {
        return cardValue.getFaceValue();
    }

    /**
     * Get the sort value for the card. It is equal to its card value + (SUIT_SIZE * the suit's value).
     * This formula results in the sort values being between 1 and DECK_SIZE.
     *
     * @return int unique sort value for this card
     * @see
     */
    @Override
    public int getSortValue() {
        return sortValue;
    }

    @Override
    public void display() {
        System.out.print(cardValue.getDisplay());
        System.out.println(suit.getDisplay());
    }

    /**
     * Get the suit of the playing card.
     *
     * @return suit of the card
     */
    public Suits getSuit() {
        Suits cardSuit = null;
        if (suit != null) {
            cardSuit = suit;
        }
        return cardSuit;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(RegularPlayingCard o) {
        if (this.sortValue > o.sortValue) {
            return -1;
        }
        else if (this.sortValue < o.sortValue) {
            return 1;
        }
        // this last return should never happen since all the cards are unique
        return 0;
    }
}
