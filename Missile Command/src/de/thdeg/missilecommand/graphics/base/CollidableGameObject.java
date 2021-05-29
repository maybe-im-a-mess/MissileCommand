package de.thdeg.missilecommand.graphics.base;

import de.thdeg.missilecommand.gameview.GameView;

import java.awt.*;

/**
 * Represents all game objects that are able to collide with something.
 */
public abstract class CollidableGameObject extends GameObject {

    protected Rectangle hitBox;

    protected CollidableGameObject(GameView gameView) {
        super(gameView);
        this.hitBox = new Rectangle(-100_000, -100_000, 0, 0);
    }

    @Override
    public void update() {
        super.update();
        updateHitBoxPosition();
    }

    /**
     * Used to update the HitBox position of the game object.
     */
    protected abstract void updateHitBoxPosition();

    /**
     * If a GameObject has collided with something, it is able to react to the collision.
     *
     * @param otherObject The other GameObject that is involved in the collision.
     */
    public abstract void reactToCollision(CollidableGameObject otherObject);

    @Override
    public void adaptPosition(double adaptX, double adaptY) {
        super.adaptPosition(adaptX, adaptY);
        updateHitBoxPosition();
    }
}
