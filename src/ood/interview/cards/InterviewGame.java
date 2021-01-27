package ood.interview.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Interface for the Interview games.
 *
 * @author Anna M. Lahoud
 * @version 0.1
 *
 */
public class InterviewGame implements Game {

    private boolean gameStarted = false;
    private Deck deck;
    private List<Player> playerList;

    public InterviewGame() {
        playerList = new ArrayList<>();
    }

    /**
     * Begin a card game.
     */
    @Override
    public void startGame() {
        gameStarted = true;
    }

    /**
     * End a card game.
     */
    @Override
    public void endGame() {
        if (gameStarted) {
            gameStarted = false;
        }
    }

    /**
     * Add a player to the card game.
     *
     * @param player
     */
    @Override
    public void addPlayer(Player player) {
        playerList.add(player);
    }


    /**
     * Remove player from the card game.
     *
     * @param player to be removed
     */
    @Override
    public void removePlayer(Player player) {
        if ((player != null) && (playerList.size() > 0)) {
            playerList.remove(player);
        }
    }

    /**
     * Return a hand to the deck in play.
     *
     * @param hand player's hand to be returned to deck
     */
    @Override
    public void returnHand(Collection<Card> hand) {

    }

    /**
     * Add a card deck to the game.
     *
     * @param deck cards to be added to the game
     */
    @Override
    public void addDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Remove card deck from the game.
     *
     * @param deck to be removed from the game
     */
    @Override
    public void removeDeck(Deck deck) {
        if ((this.deck != null) && (deck != null)) {
            deck = null;
        }
    }

    /**
     * Declare the Player that wins the game.
     *
     * @param player the winning player
     */
    @Override
    public void declareWinner(Player player) {
        System.out.println("Player " + player.getName() + " is the WINNER!!!");
    }

    public static void main(String[] args) {
        InterviewGame game1 = new InterviewGame();
        HumanPlayer player1 = new HumanPlayer("Player 1");
        HumanPlayer player2 = new HumanPlayer("Player 2") ;

        player1.joinGame(game1);
        player2.joinGame(game1);

        SingleDeck deck = new SingleDeck();
        deck.display();
        deck.shuffle();
        deck.display();

        System.out.println("Sorting the deck ....");
        deck.sort(true);
        deck.display();

        deck.shuffle();
        game1.addDeck(deck);
        deck.sort(true);

        game1.startGame();
    }
}
