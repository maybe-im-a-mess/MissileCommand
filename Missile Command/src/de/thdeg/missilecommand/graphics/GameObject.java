package de.thdeg.missilecommand.graphics;

import de.thdeg.missilecommand.gameview.GameView;

/**
 * Represents a new object
 *
 * @author Olha Solodovnyk
 */
class GameObject {

    protected final GameView gameView;
    protected Position position;
    protected double size;
    protected double speedInPixel;
    protected double rotation;
    protected int width;
    protected int height;

    /**
     * Creates a new game object
     */
    public GameObject(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position();
    }

    /**
     * Updates the position of an object
     */
    public void updatePosition() {
    }

    /**
     * Draws an object to the canvas
     */
    public void addToCanvas() {
    }

    /**
     * Shows the current position of an object
     *
     * @return the current position
     * Link to a class "Position" {@link Position}
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

}
