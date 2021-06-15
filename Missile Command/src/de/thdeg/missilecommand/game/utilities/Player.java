package de.thdeg.missilecommand.game.utilities;

/**
 * The current player.
 */
public class Player {
    /**
     * The number of lives, the player starts with.
     */
    public static final int MAXIMUM_NUMBER_OF_LIVES = 6;
    /**
     * Current number of lives of the player.
     */
    public int lives;
    /**
     * Current score of the player.
     */
    public int score;
    /**
     * Current level of the player.
     */
    public Level level;
    /**
     * Difficulty of the game.
     */
    public boolean difficultyIsSetToEasy;


    /**
     * Creates a player with lives set to maximum an a score of 0.
     */
    public Player() {
        this.lives = MAXIMUM_NUMBER_OF_LIVES;
    }
}
