package de.thdeg.missilecommand.graphics.base;

import de.thdeg.missilecommand.game.managers.GamePlayManager;
import de.thdeg.missilecommand.gameview.GameView;

/**
 * Represents a new object
 *
 * @author Olha Solodovnyk
 */
public abstract class GameObject {

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
     * Draws an object to the canvas
     */
    public abstract void addToCanvas();

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
    protected abstract void updateStatus();

    /**
     * Updates the position for {@link MovingGameObject}
     */
    public void update() {
        if (this instanceof MovingGameObject) {
            ((MovingGameObject) this).updatePosition();
        }
        updateStatus();
    }

    /**
     * Adapts the position of this game object, in case the whole game world is moved.
     *
     * @param adaptX Adaption to the right.
     * @param adaptY Adaption downwards.
     */
    public void adaptPosition(double adaptX, double adaptY) {
        position.x += adaptX;
        position.y += adaptY;
    }
}

