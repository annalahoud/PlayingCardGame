package ood.interview.cards;

public enum CardValue {

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

    CardValue(int i, int faceValue, char display) {
        this.cardValue = i;
        this.faceValue = faceValue;
        this.display = display;
    };
    public char getDisplay() { return display; }
    public int getFaceValue() { return faceValue; }
    public int getCardSortValue() { return cardValue; }


}
