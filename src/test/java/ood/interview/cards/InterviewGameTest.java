package ood.interview.cards;

import ood.interview.cards.interfaces.Deck;
import ood.interview.cards.interfaces.Game;
import ood.interview.cards.interfaces.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class InterviewGameTest {

    private Player playerA;
    private Player playerB;

    private Deck deck;

    /**
     * Start a game with the deck and two players
     *
     * @param game the game to be played
     */
    private void startGameForTest(Game game) {
        game.addDeck(deck);
        game.addPlayer(playerA);
        game.addPlayer(playerB);
        game.startGame();
    }

    @BeforeEach
    void setUp() {
        playerA = Mockito.mock(Player.class);
        playerB = Mockito.mock(Player.class);
        deck = Mockito.mock(Deck.class);

        when(deck.countRemaining()).thenReturn(SingleDeck.DECK_SIZE);
    }

    @Test
    void startGame_noPlayers() {
        Game game = new InterviewGame();
        game.addDeck(deck);

        assertFalse(game.startGame());
    }

    @Test
    void startGame_noDeck() {
        Game game = new InterviewGame();
        game.addPlayer(playerA);
        game.addPlayer(playerB);

        assertFalse(game.startGame());
    }

    @Test
    void startGame_success() {
        Game game = new InterviewGame();
        game.addDeck(deck);
        game.addPlayer(playerA);
        game.addPlayer(playerB);

        assertTrue(game.startGame());
    }

    @Test
    void endGame_notStarted() {
        Game game = new InterviewGame();
        game.endGame();

        assertFalse(game.isGameStarted());
    }

    @Test
    void endGame_startedAndStopped() {
        Game game = new InterviewGame();
        startGameForTest(game);

        // game is started so true
        assertTrue(game.isGameStarted());

        game.endGame();

        // game is stopped so false
        assertFalse(game.isGameStarted());
    }

    @Test
    public void getPlayerCount_none() {
        Game game = new InterviewGame();

        assertEquals(0, game.getPlayerCount());
    }

    @Test
    public void getPlayerCount_onePlayer() {
        Game game = new InterviewGame();
        game.addPlayer(playerA);

        assertEquals(1, game.getPlayerCount());
    }

    @Test
    public void getPlayerCount_twoPlayer() {
        Game game = new InterviewGame();
        game.addPlayer(playerA);
        game.addPlayer(playerB);

        assertEquals(2, game.getPlayerCount());
    }

    @Test
    public void getPlayer_noneExist() {
        Game game = new InterviewGame();

        assertNull(game.getPlayer(0));
    }

    @Test
    public void getPlayer_onePlayerExists() {
        Game game = new InterviewGame();
        game.addPlayer(playerA);

        assertEquals(playerA, game.getPlayer(0));
    }

    @Test
    public void getPlayer_twoPlayersExist() {
        Game game = new InterviewGame();
        game.addPlayer(playerA);
        game.addPlayer(playerB);

        assertEquals(playerB, game.getPlayer(1));
    }

    @Test
    void addPlayer_nullPlayer() {
        Game game = new InterviewGame();
        Player playerNull = null;
        game.addPlayer(playerNull);

        assertNull(game.getPlayer(0));
        assertEquals(0, game.getPlayerCount());
    }

    @Test
    void addPlayer_valid() {
        Game game = new InterviewGame();
        game.addPlayer(playerA);

        assertEquals(playerA, game.getPlayer(0));
    }

    @Test
    void removePlayer_invalid() {
        Game game = new InterviewGame();
        game.addPlayer(playerA);
        assertEquals(1, game.getPlayerCount());

        // now request removal of the other player not in the game
        game.removePlayer(playerB);

        assertEquals(1, game.getPlayerCount());
    }

    @Test
    void removePlayer_success() {
        Game game = new InterviewGame();
        game.addPlayer(playerA);
        game.addPlayer(playerB);
        assertEquals(2, game.getPlayerCount());

        // now request removal of the other player not in the game
        game.removePlayer(playerA);

        assertEquals(1, game.getPlayerCount());
    }

    @Test
    void dealHand_success() {
        Game game = new InterviewGame();
        Deck realDeck = new SingleDeck();
        game.addDeck(realDeck);

        Player playerX = new HumanPlayer("X");
        Player playerY = new HumanPlayer("Y");
        game.addPlayer(playerX);
        game.addPlayer(playerY);

        game.dealHands();

        assertEquals(InterviewGame.CARDS_PER_HAND, playerX.getHand().size());
        assertEquals(InterviewGame.CARDS_PER_HAND, playerY.getHand().size());
    }

    @Test
    void dealHand_notReady() {
        Game game = new InterviewGame();
        Deck realDeck = new SingleDeck();
        game.addDeck(realDeck);

        Player playerX = new HumanPlayer("X");
        game.addPlayer(playerX);

        game.dealHands();

        assertEquals(0, playerX.getHand().size());
    }

    @Test
    void returnHand() {
        Game game = new InterviewGame();
        Deck realDeck = new SingleDeck();
        game.addDeck(realDeck);

        Player playerX = new HumanPlayer("X");
        Player playerY = new HumanPlayer("Y");
        game.addPlayer(playerX);
        game.addPlayer(playerY);

        game.dealHands();

        assertEquals(InterviewGame.CARDS_PER_HAND, playerX.getHand().size());
        assertEquals(InterviewGame.CARDS_PER_HAND, playerY.getHand().size());

        game.returnHand(playerX.getHand());
        assertEquals(0, playerX.getHand().size());
        game.returnHand(playerY.getHand());
        assertEquals(0, playerY.getHand().size());
    }

    @Test
    void addDeck() {
        Game game = new InterviewGame();
        Deck realDeck = new SingleDeck();
        game.addDeck(realDeck);
        game.addPlayer(playerA);
        game.addPlayer(playerB);

        // to verify: check if you can start a game
        assertTrue(game.startGame());
    }

    @Test
    void removeDeck() {
        Game game = new InterviewGame();
        Deck realDeck = new SingleDeck();
        game.addDeck(realDeck);
        game.addPlayer(playerA);
        game.addPlayer(playerB);

        // to verify the deck is in the game: check if you can start a game
        assertTrue(game.startGame());

        game.removeDeck();
        assertFalse(game.startGame());
    }

    @Test
    public void calculateScores() {
        Game game = new InterviewGame();
        Deck realDeck = new SingleDeck();
        game.addDeck(realDeck);

        Player playerX = new HumanPlayer("X");
        Player playerY = new HumanPlayer("Y");
        game.addPlayer(playerX);
        game.addPlayer(playerY);

        game.dealHands();

        game.calculateScores();

        assert(playerX.getGameScore() > 0);
        assert(playerY.getGameScore() > 0);

    }

}