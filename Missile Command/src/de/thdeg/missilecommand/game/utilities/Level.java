package de.thdeg.missilecommand.game.utilities;

import de.thdeg.missilecommand.graphics.staticobjects.Background;

/**
 * A level of the game.
 */
public class Level {
    /**
     * Name of the level.
     */
    public final String name;
    /**
     * Background of the level.
     */
    public final Background background;
    /**
     * Number of Planes in the level.
     */
    public final int numberOfPlanes;
    /**
     * Number of Missiles in the level.
     */
    public final int numberOfMissiles;

    /**
     * Creates a level
     *
     * @param name              Name of the level.
     * @param background        Background of the level
     * @param numberOfPlanes    Number of Planes in the level.
     * @param numberOfMissiles  Number of Missiles in the level.
     */
    public Level(String name, Background background, int numberOfPlanes, int numberOfMissiles) {
        this.name = name;
        this.background = background;
        this.numberOfPlanes = numberOfPlanes;
        this.numberOfMissiles = numberOfMissiles;
    }
}