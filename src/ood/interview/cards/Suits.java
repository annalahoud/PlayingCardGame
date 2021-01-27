package ood.interview.cards;

public enum Suits {

    SPADES(0, (char)'\u2660'),
    DIAMONDS(1, (char)'\u2666'),
    HEARTS(2, (char)'\u2764'),
    CLUBS(3, (char)'\u2663');

    private final int theSuit;
    private final char display;
    Suits(int i, char display) { this.theSuit = i; this.display = display; }
    public char getDisplay() { return display; }
    public int getSuit() { return theSuit; }

}
