package test;

import ood.interview.cards.HumanPlayer;
import ood.interview.cards.InterviewGame;
import ood.interview.cards.SingleDeck;
import ood.interview.cards.interfaces.Game;
import ood.interview.cards.interfaces.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    Player player1 = new HumanPlayer("Browns");
    Player player2 = new HumanPlayer("Jones");

    @Test
    public void constructor_setEmptyName() {
        Player player = new HumanPlayer("");
        assertEquals(null, player.getName());
    }

    @Test
    void constructor_setNonEmptyName() {
        Player player = new HumanPlayer("Browns");
        assertEquals("Browns", player.getName());
    }

    @Test
    void constructor_reuseNameField() {
        // First we set the player's name and check we got it.
        Player player = new HumanPlayer("Browns");
        assertEquals("Browns", player.getName());

        // Now we re-use player, but we first set its name
        player.setName("John");
        assertEquals("John", player.getName());
    }

    @Test
    void constructor_overwriteNameField() {
        // First we set the player's name and check we got it.
        Player player = new HumanPlayer("Browns");
        assertEquals("Browns", player.getName());

        // Now we re-use player, but we use an empty name
        player.setName("");

        // The empty/null name is ignored so we get the previous name
        assertEquals("Browns", player.getName());
    }

    @Test
    void joinGame_zeroPlayers() {
        Game game = new InterviewGame();
        assertEquals(0, game.getPlayerCount());
    }

    @Test
    void joinGame_onePlayer() {
        Game game = new InterviewGame();
        Player player = new HumanPlayer("Browns");

        game.addPlayer(player);
        assertEquals(1, game.getPlayerCount());
    }

    @Test
    void joinGame_twoPlayers() {
        Game game = new InterviewGame();
        Player player1 = new HumanPlayer("Browns");
        Player player2 = new HumanPlayer("Jones");

        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(2, game.getPlayerCount());
    }

    @Test
    void leaveGame_startAndLeave() {
        Game game = new InterviewGame();
        Player player1 = new HumanPlayer("Browns");
        Player player2 = new HumanPlayer("Jones");

        game.addPlayer(player1);
        game.addPlayer(player2);

        // Before we can start a game, we have to have 1 or more players and a deck of cards.
        SingleDeck deck = new SingleDeck();
        // And the game can be, and MUST BE, started before you try to leave the game.
        game.startGame();

        // We still have 2 players and a deck and maybe one or more of the players have their hands
        game.endGame();
        assertEquals(2, game.getPlayerCount());
    }

    @Test
    void acceptCard() {
    }

    @Test
    void displayHand() {
    }

    @Test
    void returnHand() {
    }
}