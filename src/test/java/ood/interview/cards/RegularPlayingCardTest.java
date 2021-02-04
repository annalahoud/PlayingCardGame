package ood.interview.cards;

import ood.interview.cards.interfaces.CardValue;
import ood.interview.cards.interfaces.RegularCard;
import ood.interview.cards.interfaces.Suits;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RegularPlayingCardTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // we use RegularCard because the interface Card can have no-value cards
    private RegularCard king = new RegularPlayingCard(Suits.CLUBS, CardValue.King);
    private RegularCard queen = new RegularPlayingCard(Suits.CLUBS, CardValue.Queen);
    private RegularCard jack = new RegularPlayingCard(Suits.CLUBS, CardValue.Jack);
    private RegularCard ten = new RegularPlayingCard(Suits.CLUBS, CardValue.Ten);
    private RegularCard nine = new RegularPlayingCard(Suits.CLUBS, CardValue.Nine);
    private RegularCard eight = new RegularPlayingCard(Suits.CLUBS, CardValue.Eight);
    private RegularCard seven = new RegularPlayingCard(Suits.CLUBS, CardValue.Seven);
    private RegularCard six = new RegularPlayingCard(Suits.CLUBS, CardValue.Six);
    private RegularCard five = new RegularPlayingCard(Suits.CLUBS, CardValue.Five);
    private RegularCard four = new RegularPlayingCard(Suits.CLUBS, CardValue.Four);
    private RegularCard three = new RegularPlayingCard(Suits.CLUBS, CardValue.Three);
    private RegularCard two = new RegularPlayingCard(Suits.CLUBS, CardValue.Two);
    private RegularCard ace = new RegularPlayingCard(Suits.CLUBS, CardValue.Ace);

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void getCardValue() {
        assertEquals(13, king.getCardValue());
        assertEquals(12, queen.getCardValue());
        assertEquals(11, jack.getCardValue());
        assertEquals(10, ten.getCardValue());
        assertEquals(9, nine.getCardValue());
        assertEquals(8, eight.getCardValue());
        assertEquals(7, seven.getCardValue());
        assertEquals(6, six.getCardValue());
        assertEquals(5, five.getCardValue());
        assertEquals(4, four.getCardValue());
        assertEquals(3, three.getCardValue());
        assertEquals(2, two.getCardValue());
        assertEquals(1, ace.getCardValue());
    }

    @Test
    void getFaceValue() {
        assertEquals(10, king.getFaceValue());
        assertEquals(10, queen.getFaceValue());
        assertEquals(10, jack.getFaceValue());
        assertEquals(10, ten.getFaceValue());
        assertEquals(9, nine.getFaceValue());
        assertEquals(8, eight.getFaceValue());
        assertEquals(7, seven.getFaceValue());
        assertEquals(6, six.getFaceValue());
        assertEquals(5, five.getFaceValue());
        assertEquals(4, four.getFaceValue());
        assertEquals(3, three.getFaceValue());
        assertEquals(2, two.getFaceValue());
        assertEquals(1, ace.getFaceValue());
    }

    @Test
    void getSortValue() {
        RegularCard kingClubs = new RegularPlayingCard(Suits.CLUBS, CardValue.King);
        RegularCard kingHearts = new RegularPlayingCard(Suits.HEARTS, CardValue.King);
        RegularCard kingDiamonds = new RegularPlayingCard(Suits.DIAMONDS, CardValue.King);
        RegularCard kingSpades = new RegularPlayingCard(Suits.SPADES, CardValue.King);

        // formula is cardValue + suitValue*13 where SPADES=0, DIAMONDS=1, HEARTS=2, CLUBS=3
        assertEquals( 13+(3*13), kingClubs.getSortValue());
        assertEquals( 13+(2*13), kingHearts.getSortValue());
        assertEquals( 13+(1*13), kingDiamonds.getSortValue());
        assertEquals( 13+(0*13), kingSpades.getSortValue());
    }

    @Test
    void display() {
        char clubs = (char)'\u2663';
        king.display();

        String value = new String("K" + clubs);
        assertEquals(value, outputStreamCaptor.toString().trim());

    }

}