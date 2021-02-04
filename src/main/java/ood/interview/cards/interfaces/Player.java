package ood.interview.cards.interfaces;


import java.util.List;

/**
 * This is the interface for a player.
 *
 * @author Anna M. Lahoud
 * @version 0.1
 *
 */
public interface Player {

    /**
     * Set a player's name.
     *
     * @param name The name to be associated with the player.
     */
    void setName(String name);

    /**
     * Get a player's name.
     *
     * @return String name associated with the player
     */
    String getName();

    /**
     * Join a card game.
     */
    void joinGame(Game game);

    /**
     * Return a game that the player belongs to, or null if none.
     *
     * @return game that the player has joined
     */
    Game getGame();

    /**
     * Leave a card game.
     */
    void leaveGame();

    /**
     * Accept a card into hand.
     *
     * @param card add the passed card to the player's hand
     */
    void acceptCard(Card card);

    /**
     * Display the player's card hand.
     */
    void displayHand();

    /**
     * Return the player's card hand.
     */
    List<Card> getHand();

    /**
     * Return the player's card hand to the deck.
     */
    void returnHand();

    /**
     * Set the score for the player for this game.
     *
     * @param score for the game played
     */
    void setGameScore(int score);

    /**
     * Get the score for the game.
     *
     * @return score of the game played, zero if none played
     */
    int getGameScore();

}