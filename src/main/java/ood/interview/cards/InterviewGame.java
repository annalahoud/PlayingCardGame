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

    public static final int CARDS_PER_HAND = 3;
    public static final int PLAYERS_PER_HAND = 2;

    private boolean gameStarted = false;
    private Deck deck;
    private final List<Player> playerList;

    public InterviewGame() {
        playerList = new ArrayList<>();
    }

    /**
     * Begin a card game.c
     */
    @Override
    public boolean startGame() {
        if (checkDeck() && checkPlayers()) {
            gameStarted = true;
        }
        else {
            gameStarted = false;
        }
        return gameStarted;
    }

    // see if the deck is ready for a gamep
    private boolean checkDeck() {
        if ((deck != null) && (deck.countRemaining() == SingleDeck.DECK_SIZE)) {
            return true;
        }
        return false;
    }

    // see if there are players ready for a game
    private boolean checkPlayers() {
        if (playerList.size() > 1) {
            return true;
        }
        return false;
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
     * Determine if the card game is started.
     *
     * @return true if the game is started, false otherwise
     */
    public boolean isGameStarted() {
        return gameStarted;
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
        if (playerList.size() > 0) {
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
    */
    @Override
    public void removeDeck() {
        // Since we only allow one deck, we just null the deck if requested.
        if (this.deck != null) {
            this.deck = null;
        }
    }

    /**
     * Return a hand to the deck in play. This transfers the cards to the deck and removes from the hand.
     *
     * @param hand player's hand to be returned to deck
     */
    @Override
    public void returnHand(Collection<Card> hand) {
        if ((hand != null) && (!hand.isEmpty())) {
            deck.returnCards(hand);
            hand.clear();
        }
    }

    /**
     * Deal hands to players based on the game rules.
     */
    public void dealHands() {
        if (checkDeck() && checkPlayers()) {
            deck.shuffle();

            // Deal the cards for a 3-card game, where scores are calculated based on suit and card value.
            // Assume we have at least 2 players and we only let the first two play.
            for (int i = 0; i < CARDS_PER_HAND; i++) {
                for (int j = 0; j < PLAYERS_PER_HAND; j++) {
                    playerList.get(j).acceptCard(deck.drawCard());
                }
            }
        }
        else {
            System.out.println("The game requires a full deck of cards and two players.");
        }
    }

    /**
     * Calculate the scores of the players of a game based on the rules of this game.
     *
     * The rules of this game are to score the player's hands based on the NUMBER in the card. Assume that we can
     * use the values that distinguish face cards from each other (J = 11, Q = 12, K = 13).
     *
     * The number in the card is multiplied by the value of the suit for this game. The value of the suit is one
     * more than the Suits value (CLUBS = 4, HEARTS = 3, DIAMONDS = 2, SPADES = 1).
     *
     * The method calculates the scores for each player in the game with a hand and prints that score with the
     * player's name. It then declares the winner (also printed to the screen).
     */
    @Override
    public void calculateScores() {
        int highScore = -1;
        int playerWithHighScore = -1;
        if (playerList.size() > 1) {
            for (int i = 0; i < playerList.size(); i++) {
                int score = 0;
                Player player = playerList.get(i);
                List<Card> hand = player.getHand();
                if ((hand != null) && (!hand.isEmpty())) {
                    for (Card card : hand) {
                        if (card instanceof RegularPlayingCard) {
                            RegularPlayingCard regCard = (RegularPlayingCard) card;
                            int suitMultiplier = regCard.getSuit().getSuit() + 1;
                            int cardValue = regCard.getCardValue();
                            score += suitMultiplier * cardValue;
                        }
                    }
                }
                System.out.println("Player " + player.getName() + " has a total score of " + score + ".");
                player.setGameScore(score);
                if (score > highScore) {
                    highScore = score;
                    playerWithHighScore = i;
                }
            }
            declareWinner(playerList.get(playerWithHighScore));
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
        InterviewGame game = new InterviewGame();
        HumanPlayer player1 = new HumanPlayer("Random1");
        HumanPlayer player2 = new HumanPlayer("Random2") ;

        // We keep the players in a list in the game AND a reference to the game in the player.
        player1.joinGame(game);
        player2.joinGame(game);
        for (int i = 0; i < game.playerList.size(); i++) {
            System.out.println("Players now part of the game:");
            System.out.println("  Player " + game.playerList.get(i).getName());
        }

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

        // Add the deck to the game and start the game.
        System.out.println("Shuffle the cards again.");
        game.addDeck(singleDeck);
        singleDeck.shuffle();
        game.dealHands();

        // Now the two players of the game each have 3 card hands which needs to be scored.
        game.calculateScores();

        // Now both players leave the game which returns the hands to the deck.
        player1.leaveGame();
        player2.leaveGame();

        // If that worked as intended, we should now have a full deck back in the game.
        assert(singleDeck.countRemaining() == SingleDeck.DECK_SIZE);
    }
}
