package ood.interview.cards;

import ood.interview.cards.interfaces.Card;
import ood.interview.cards.interfaces.Game;
import ood.interview.cards.interfaces.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        player1 = new HumanPlayer("Browns");
        player2 = new HumanPlayer("Jones");

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void constructor_setEmptyName() {
        Player player = new HumanPlayer("");
        assertNull(player.getName());
    }

    @Test
    void constructor_setNonEmptyName() {
        assertEquals("Browns", player1.getName());
    }

    @Test
    void constructor_reuseNameField() {
        // First we check the player's name.
        assertEquals("Browns", player1.getName());

        // Now we re-use player, but we first set its name
        player1.setName("John");
        assertEquals("John", player1.getName());
    }

    @Test
    void constructor_overwriteNameField() {
        // First we check the player's name.
        assertEquals("Browns", player1.getName());

        // Now we re-use player, but we use an empty name
        player1.setName("");

        // The empty/null name is ignored so we get the previous name
        assertEquals("Browns", player1.getName());
    }

    @Test
    void joinGame_zeroPlayers() {
        assertNull(player1.getGame());
    }

    @Test
    void joinGame_onePlayer() {
        Game game = Mockito.mock(InterviewGame.class);
        player1.joinGame(game);
        assertEquals(game, player1.getGame());
    }

    @Test
    void joinGame_twoPlayers() {
        Game game = Mockito.mock(InterviewGame.class);
        player1.joinGame(game);
        player2.joinGame(game);
        assertEquals(game, player1.getGame());
        assertEquals(game, player2.getGame());
    }

    @Test
    void leaveGame_startAndLeave() {
        Game game = new InterviewGame();
        player1.joinGame(game);
        player2.joinGame(game);

        // Before we can start a game, we have to have 1 or more players and a deck of cards.
        SingleDeck deck = new SingleDeck();
        game.addDeck(deck);

        // And the game can be, and MUST BE, started before you try to leave the game.
        game.startGame();

        // We still have 2 players and a deck and maybe one or more of the players have their hands
        player1.leaveGame();
        assertEquals(1, game.getPlayerCount());
    }

    @Test
    void acceptCard_validCard() {
        // player has no cards in hand
        assertEquals(0, player1.getHand().size());

        Card card = Mockito.mock(RegularPlayingCard.class);
        player1.acceptCard(card);

        // player has one card now
        assertEquals(1, player1.getHand().size());
    }

    @Test
    void acceptCard_invalidCard() {
        // player has no cards in hand
        assertEquals(0, player1.getHand().size());

        Card card = null;
        player1.acceptCard(card);

        // player still has no cards
        assertEquals(0, player1.getHand().size());
    }

    @Test
    void displayHand_empty() {
        player1.displayHand();
        String value = "Player " + player1.getName() + " has no cards to display.";
        assertEquals(value, outputStreamCaptor.toString().trim());
    }

    @Test
    void returnHand() {
        Game game = Mockito.mock(InterviewGame.class);

        Card card1 = Mockito.mock(RegularPlayingCard.class);
        Card card2 = Mockito.mock(RegularPlayingCard.class);
        Card card3 = Mockito.mock(RegularPlayingCard.class);

        player1.joinGame(game);

        player1.acceptCard(card1);
        player1.acceptCard(card2);
        player1.acceptCard(card3);

        assertEquals(3, player1.getHand().size());

        player1.returnHand();
        assertEquals(0, player1.getHand().size());
    }

    @Test
    void getHand_empty() {
        // first verify that an empty hand is returned
        List<Card> hand = player1.getHand();
        assertEquals(0, hand.size());
    }

    @Test
    void getHand_threeCards() {
        Card card1 = Mockito.mock(RegularPlayingCard.class);
        Card card2 = Mockito.mock(RegularPlayingCard.class);
        Card card3 = Mockito.mock(RegularPlayingCard.class);

        player1.acceptCard(card1);
        player1.acceptCard(card2);
        player1.acceptCard(card3);

        // first verify that an empty hand is returned
        List<Card> hand = player1.getHand();
        assertEquals(3, hand.size());
    }

    @Test
    void setGameScore() {
        // we start at 0 on initialization
        assertEquals(0, player1.getGameScore());

        player1.setGameScore(99);
        assertEquals(99, player1.getGameScore());
    }

    @Test
    void getGameScore() {
        // we start at 0 on initialization
        assertEquals(0, player1.getGameScore());

        player1.setGameScore(-2);
        assertEquals(-2, player1.getGameScore());
    }

}