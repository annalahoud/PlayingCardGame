package ood.interview.cards.interfaces;

import java.util.Collection;

/**
 * This is the interface superclass for all games.
 *
 * @author Anna M. Lahoud
 * @version 0.1
 *
 */
public interface Game {

    /**
     * Begin a card game.
     */
    boolean startGame();

    /**
     * End a card game.
     */
    void endGame();

    /**
     * Determine if a game is started.
     *
     * @return true if the game is started, false otherwise
     */
    boolean isGameStarted();

    /**
     * Add a player to the card game.
     */
    void addPlayer(Player player);

    /**
     * Remove player from the card game.
     *
     * @param player to be removed
     */
    void removePlayer(Player player);

    /**
     * Get the number of players in this game.
     *
     * @return count of players in this game
     */
    int getPlayerCount();

    /**
     * Get the i-th player in this game.
     *
     * @param index zero-based index of player in the list
     * @return player object, if it exists, null otherwise
     */
    Player getPlayer(int index);

    /**
     * Add a card deck to the game.
     *
     * @param deck cards to be added to the game
     */
    void addDeck(Deck deck);

    /**
     * Remove card deck from the game.
     */
    void removeDeck();

    /**
     * Return a hand to the deck in play.
     *
     * @param hand player's hand to be returned to deck
     */
    void returnHand(Collection<Card> hand);

    /**
     * Deal hands to players based on the game rules.
     */
    void dealHands();

    /**
     * Calculate the scores of the players of a game based on the rules of this game.
     */
    void calculateScores();

    /**
     * Declare the Player that wins the game.
     *
     * @param player the winning player
     */
    void declareWinner(Player player);

}
