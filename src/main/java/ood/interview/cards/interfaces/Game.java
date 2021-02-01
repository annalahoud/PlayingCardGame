package ood.interview.cards.interfaces;

import ood.interview.cards.HumanPlayer;

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
    public void startGame();

    /**
     * End a card game.
     */
    public void endGame();

    /**
     * Add a player to the card game.
     */
    public void addPlayer(Player player);

    /**
     * Remove player from the card game.
     *
     * @param player to be removed
     */
    public void removePlayer(Player player);

    /**
     * Get the number of players in this game.
     *
     * @return count of players in this game
     */
    public int getPlayerCount();

    /**
     * Get the i-th player in this game.
     *
     * @param index zero-based index of player in the list
     * @return player object, if it exists, null otherwise
     */
    public Player getPlayer(int index);

    /**
     * Add a card deck to the game.
     *
     * @param deck cards to be added to the game
     */
    public void addDeck(Deck deck);

    /**
     * Remove card deck from the game.
     *
     * @param deck to be removed from the game
     */
    public void removeDeck(Deck deck);

    /**
     * Return a hand to the deck in play.
     *
     * @param hand player's hand to be returned to deck
     */
    public void returnHand(Collection<Card> hand);

    /**
     * Calculate the scores of the players of a game based on the rules of this game.
     */
    public void calculateScores();

    /**
     * Declare the Player that wins the game.
     *
     * @param player the winning player
     */
    public void declareWinner(Player player);

}
