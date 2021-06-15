package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;
import java.util.Random;

/**
 * Represents a new missile
 *
 * @author Olha Solodovnyk
 */
public class Missile extends CollidableGameObject implements MovingGameObject{
    private String objectID;
    private final Random random;

    /**
     * Creates a missile.
     *
     * @param gameView             Window to show the GameObject on.
     *
     */
    public Missile(GameView gameView) {
        super(gameView);
        this.random = new Random();
        this.position = new Position(100, 50);
        this.size = 1;
        this.speedInPixel = 1;
        this.rotation = 0;
        this.width = (int) (3 * size);
        this.height = (int) (3 * size);
        this.objectID = "Missile" + position.x + position.y;
        this.hitBox.width = width;
        this.hitBox.height = height;
    }

    @Override
    protected void updateStatus() {

    }


    /**
     * Updates the current or start position of the missile
     */
    @Override
    public void updatePosition() {
        position.down(speedInPixel);
    }

    /*@Override
    public void updateStatus() {
        if (gameView.timerExpired("Shoot", objectID)) {
            gameView.setTimer("Shoot", objectID, 1000);
            gamePlayManager.shootMissileShot(position);
        }
        /*if (position.y > GameView.HEIGHT) {
            gamePlayManager.destroy(this);
        }
    }*/

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
     * Draws the shoot to the canvas
     */
    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.x, position.y, width, height, 2, true, Color.WHITE);
    }
}
