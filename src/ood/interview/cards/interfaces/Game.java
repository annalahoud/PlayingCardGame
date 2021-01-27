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
     * Return a hand to the deck in play.
     *
     * @param hand player's hand to be returned to deck
     */
    public void returnHand(Collection<Card> hand);

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
     * Declare the Player that wins the game.
     *
     * @param player the winning player
     */
    public void declareWinner(Player player);

}
