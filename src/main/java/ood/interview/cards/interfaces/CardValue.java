package ood.interview.cards.interfaces;

public enum CardValue {

    /** The values of the cards have three components: the sort value (K=13), the face value (K=10), and
     * the character that will be displayed for the card's value.
     */
    Ace(1, 1, 'A'),
    Two(2,2, '2'),
    Three(3, 3, '3'),
    Four(4, 4, '4'),
    Five(5, 5, '5'),
    Six(6, 6, '6'),
    Seven(7, 7, '7'),
    Eight(8, 8, '8'),
    Nine(9, 9, '9'),
    Ten(10, 10, 'T'),
    Jack(11, 10, 'J'),
    Queen(12, 10, 'Q'),
    King(13, 10, 'K');

    private final int cardValue;
    private final int faceValue;
    private final char display;

    /** Constructor for card values that includes the three values it uses.
     *
     * @param i the sort value of the card
     * @param faceValue the face value of the card
     * @param display the character to display for the card valued
     */
    CardValue(int i, int faceValue, char display) {
        this.cardValue = i;
        this.faceValue = faceValue;
        this.display = display;
    }

    public char getDisplay() { return display; }
    public int getFaceValue() { return faceValue; }
    public int getCardValue() { return cardValue; }

}
