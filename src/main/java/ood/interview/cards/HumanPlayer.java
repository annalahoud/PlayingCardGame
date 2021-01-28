package ood.interview.cards;

import ood.interview.cards.interfaces.Card;
import ood.interview.cards.interfaces.Game;
import ood.interview.cards.interfaces.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete player class for card games.
 *
 * @author Anna M. Lahoud
 * @version 0.1
 *
 */
public class HumanPlayer implements Player {

    // A player can have one (or no) card hands.
    private List<Card> hand;

    // A player can play, at most, one game at a time
    private Game game;

    // A name (any string) to be associated with the player.
    private String name;

    /**
     * Construct a player with the given name.
     *
     * @param name identifying the players' name (this can be any handle)
     */
    public HumanPlayer(String name) {
        setName(name);
    }

    /**
     * Set a player's name.
     *
     * @param name The name to be associated with the player.
     */
    @Override
    public void setName(String name) {
        if ((name != null) && (!name.isEmpty())) {
            this.name = name;
        }
    }

    /**
     * Get a player's name.
     *
     * @return String name associated with the player
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void joinGame(Game game) {
        this.game = game;
    }

    @Override
    public void leaveGame() {
        game.returnHand(hand);

        this.game = null;
        hand.clear();
    }

    @Override
    public void acceptCard(Card card) {
        if (card != null) {
            if (hand == null) {
               hand = new ArrayList<>();
            }
            hand.add(card);
        }
    }

    @Override
    public void displayHand() {
        if ((hand != null) && (!hand.isEmpty())) {
            for (Card card : hand) {
                card.display();
            }
        }
    }

    /**
     * Return the player's card hand to the deck.
     *
     * @param hand the player's hand to be returned.
     */
    @Override
    public void returnHand(List<Card> hand) {
        if ((hand != null) && (!hand.isEmpty())) {
            game.returnHand(hand);
            hand.clear();
        }
    }

}