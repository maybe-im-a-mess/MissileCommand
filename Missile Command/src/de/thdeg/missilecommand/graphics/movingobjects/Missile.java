package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;
import java.util.Random;

/**
 * Represents a new missile.
 */
public class Missile extends CollidableGameObject implements MovingGameObject {

    private final String objectID;


    /**
     * Creates a new missile.
     *
     * @param gameView Window to show the GameObject on.
     */
    public Missile(GameView gameView) {
        super(gameView);
        Random random = new Random();
        this.position = new Position(random.nextInt(GameView.WIDTH), 1);
        this.size = 1;
        this.rotation = 0;
        this.width = (int) (3 * size);
        this.height = (int) (3 * size);
        this.objectID = "Missile" + position.x + position.y;
    }


    /**
     * Updates the current or start position of the missile
     */
    @Override
    public void updatePosition() {
    }

    @Override
    public void updateStatus() {
        if (gameView.timerExpired("Shoot", objectID)) {
            gameView.setTimer("Shoot", objectID, 8000);
            gamePlayManager.shootMissileShot(position);
            gamePlayManager.destroy(this);
        }
    }

    @Override
    protected void updateHitBoxPosition() {
        hitBox.x = (int) position.x;
        hitBox.y = (int) position.y;
    }

    @Override
    public void reactToCollision(CollidableGameObject otherObject) {
        gamePlayManager.destroy(this);
        int number = gameView.playSound("explode.wav", false);
    }

    /**
     * Draws the missile to the canvas.
     */
    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.x, position.y, width, height, 2, true, Color.RED);
    }
}
