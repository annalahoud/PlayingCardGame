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
    public void setName(String name);

    /**
     * Get a player's name.
     *
     * @return String name associated with the player
     */
    public String getName();

    /**
     * Join a card game.
     */
    public void joinGame(Game game);

    /**
     * Leave a card game.
     */
    public void leaveGame();

    /**
     * Accept a card into hand.
     *
     * @param card add the passed card to the player's hand
     */
    public void acceptCard(Card card);

    /**
     * Display the player's card hand.
     */
    public void displayHand();

    /**
     * Return the player's card hand.
     */
    public List<Card> getHand();

    /**
     * Return the player's card hand to the deck.
     */
    public void returnHand();

    /**
     * Set the score for the player for this game.
     *
     * @param score for the game played
     */
    public void setGameScore(int score);

    /**
     * Get the score for the game.
     *
     * @return score of the game played, zero if none played
     */
    public int getGameScore();


}