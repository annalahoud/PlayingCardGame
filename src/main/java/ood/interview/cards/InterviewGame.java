package ood.interview.cards;

import ood.interview.cards.interfaces.Card;
import ood.interview.cards.interfaces.Deck;
import ood.interview.cards.interfaces.Game;
import ood.interview.cards.interfaces.Player;

import java.util.ArrayList;
import java.util.Collection;
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
     * @param player to be added to this game
     */
    @Override
    public void addPlayer(Player player) {
        if (player != null) {
            playerList.add(player);
        }
    }

    /**
     * Remove player from the card game.
     *
     * @param player to be removed from this game
     */
    @Override
    public void removePlayer(Player player) {
        if ((player != null) && (playerList.size() > 0)) {
            playerList.remove(player);
        }
    }

    /**
     * Get the number of players in this game.
     *
     * @return count of players in this game
     */
    @Override
    public int getPlayerCount() {
        return playerList.size();
    }

    /**
     * Get the i-th player in this game.
     *
     * @param index zero-based index of player in the list
     * @return player object, if it exists, null otherwise
     */
    @Override
    public Player getPlayer(int index) {
        Player player = null;
        if ((index >= 0) && (index < playerList.size())) {
            player = playerList.get(index);
        }
        return player;
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
     * Currently there is only one deck allowed per game.
     *
     * @param deck cards to be added to the game
     */
    @Override
    public void addDeck(Deck deck) {
        // Seems like we should require more than 1 card but technically that is all that is required.
        if ((deck != null) && (deck.countRemaining() > 1)) {
            this.deck = deck;
        }
    }

    /**
     * Remove card deck from the game.
     *
     * @param deck to be removed from the game
     */
    @Override
    public void removeDeck(Deck deck) {
        // Since we only allow one deck, we just null the deck if requested.
        if (this.deck != null) {
            this.deck = deck;
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
        // Begin with a game and two players
        InterviewGame game1 = new InterviewGame();
        HumanPlayer player1 = new HumanPlayer("Player 1");
        HumanPlayer player2 = new HumanPlayer("Player 2") ;

        player1.joinGame(game1);
        player2.joinGame(game1);

        // Create a single deck of RegularPlayingCards and add to the game.
        SingleDeck singleDeck = new SingleDeck();

        // Show what the deck looks like before, and after, the shuffle
        System.out.println("Show the deck before and after the shuffle.");
        singleDeck.display();
        singleDeck.shuffle();
        singleDeck.display();

        System.out.println("Sort the deck and show the cards.");
        singleDeck.sort(true);
        singleDeck.display();

        System.out.println("Shuffle and display the deck.");
        singleDeck.shuffle();

        // Add the deck to the game and start the game.
        game1.addDeck(singleDeck);
        game1.startGame();
    }
}
