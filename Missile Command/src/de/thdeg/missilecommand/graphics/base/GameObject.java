package de.thdeg.missilecommand.graphics.base;

import de.thdeg.missilecommand.game.managers.GamePlayManager;
import de.thdeg.missilecommand.gameview.GameView;

import java.util.Objects;

/**
 * Represents a new object
 *
 * @author Olha Solodovnyk
 */
public abstract class GameObject implements Cloneable {

    protected final GameView gameView;
    protected GamePlayManager gamePlayManager;
    protected Position position;
    protected double size;
    protected double speedInPixel;
    protected double rotation;
    protected int width;
    protected int height;

    /**
     * Creates a new game object
     *
     * @param gameView Window to show the GameObject on.
     */
    public GameObject(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position();
    }

    /**
     * Updates the game object.
     */
    public void update() {
        if (this instanceof MovingGameObject) {
            ((MovingGameObject) this).updatePosition();
        }
        updateStatus();
    }

    /**
     * Updates status of an object
     */
    protected abstract void updateStatus();

    /**
     * Draws an object to the canvas of GameView.
     */
    public abstract void addToCanvas();

    /**
     * Sets the GamePlayManager, so the game object is able call game-play methods.
     */
    public void setGamePlayManager(GamePlayManager gamePlayManager) {
        this.gamePlayManager = gamePlayManager;
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

    @Override
    public GameObject clone() {
        GameObject gameObject = null;
        try {
            gameObject = (GameObject) super.clone();
            gameObject.position = position.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return gameObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return Double.compare(that.speedInPixel, speedInPixel) == 0
                && Double.compare(that.size, size) == 0 && width == that.width
                && height == that.height && position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, speedInPixel, rotation, size, width, height);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + position;
    }

}

