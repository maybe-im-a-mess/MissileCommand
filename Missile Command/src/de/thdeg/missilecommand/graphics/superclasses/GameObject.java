package de.thdeg.missilecommand.graphics.superclasses;

import de.thdeg.missilecommand.game.managers.GamePlayManager;
import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;

/**
 * Represents a new object
 *
 * @author Olha Solodovnyk
 */
public class GameObject {

    protected final GameView gameView;
    protected Position position;
    protected double size;
    protected double speedInPixel;
    protected double rotation;
    protected int width;
    protected int height;
    protected GamePlayManager gamePlayManager;

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

    /**
     * Setter for a game play manager
     */
    public void setGamePlayManager(GamePlayManager gamePlayManager) {
        this.gamePlayManager = gamePlayManager;
    }

    /**
     * Updates status of an object
     */
    public void updateStatus() {

    }

}
