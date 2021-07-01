package de.thdeg.missilecommand.game.utilities;

/**
 * The current player.
 */
public class Player {
    /**
     * The number of lives, the player starts with.
     */
    public static final int MAXIMUM_NUMBER_OF_CITIES = 6;
    /**
     * The number of defenders, the player starts with.
     */
    public static final int MAXIMUM_NUMBER_OF_DEFENDERS = 30;
    /**
     * Current number of lives of the player.
     */
    public int citiesLeft;
    /**
     * Current number of defenders of the player.
     */
    public int defendersLeft;
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
        this.citiesLeft = MAXIMUM_NUMBER_OF_CITIES;
    }
}
