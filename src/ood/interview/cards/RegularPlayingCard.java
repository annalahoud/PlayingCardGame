package ood.interview.cards;

/**
 * Regular playing card imlementation class.
 *
 * @author Anna M. Lahoud
 * @version 0.1
 *
 */
public class RegularPlayingCard implements RegularCard {

    private final Suits suit;
    private final CardValue cardValue;
    private final int sortValue;

    public RegularPlayingCard(Suits suit, CardValue cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
        this.sortValue = getSortValue();
    }

    @Override
    public int getCardValue() {
        return cardValue.ordinal();
    }

    @Override
    public int getFaceValue() {
        return cardValue.getFaceValue();
    }

    /**
     * Get the value for the card that is equal to its ordinal card value multiplied times the suit's ordinal value.
     *
     * @return int unique sort value for this card
     * @see
     */
    @Override
    public int getSortValue() {
        return cardValue.ordinal() * suit.ordinal();
    }

    @Override
    public void display() {
        System.out.print(cardValue.getDisplay());
        System.out.println(suit.getDisplay());
    }
}
