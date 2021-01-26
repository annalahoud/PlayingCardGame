package ood.interview.cards;

public enum Suits {

    SPADES(1, (char)'\u2660'),
    DIAMONDS(2, (char)'\u2666'),
    HEARTS(3, (char)'\u2764'),
    CLUBS(4, (char)'\u2663');

    private final int theSuit;
    private final char display;
    Suits(int i, char display) { this.theSuit = i; this.display = display; }
    public char getDisplay() { return display; }

}
