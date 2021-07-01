package de.thdeg.missilecommand.graphics.movingobjects.shots;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents shots of the missiles.
 */
public class MissileShot extends Shot implements MovingGameObject {
    private final Position targetPosition;

    /**
     * Creates a new shot.
     *
     * @param gameView             Window to show the GameObject on.
     * @param objectsToCollideWith Game objects this game object can collide with.
     */
    public MissileShot(GameView gameView, ArrayList<CollidableGameObject> objectsToCollideWith) {
        super(gameView, objectsToCollideWith);
        this.position = new Position();
        this.size = 1;
        this.width = (int) (5 * size);
        this.height = (int) (5 * size);
        this.rotation = 0;
        this.speedInPixel = 0.4;
        this.hitBox.width = width;
        this.hitBox.height = height;
        Random random = new Random();
        this.targetPosition = new Position(random.nextInt(GameView.WIDTH), GameView.HEIGHT);
    }

    @Override
    protected void updateHitBoxPosition() {
        hitBox.x = (int) position.x;
        hitBox.y = (int) position.y;
    }

    @Override
    public void reactToCollision(CollidableGameObject otherObject) {
        gameView.playSound("explode.wav", false);
        gamePlayManager.destroy(this);
    }

    @Override
    protected void updateStatus() {
        destroyShotIfItHasLeftTheScreen();
    }

    private void destroyShotIfItHasLeftTheScreen() {
        if (position.y > GameView.HEIGHT) {
            gamePlayManager.destroy(this);
        }
        if (position.x > GameView.WIDTH) {
            gamePlayManager.destroy(this);
        }
    }

    /**
     * Set speed of the missile shot.
     *
     * @param speed Speed to set.
     */
    public void setSpeed(double speed) {
        speedInPixel = speed;
    }

    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.x, position.y, width, height, 0, true, Color.WHITE);
        gameView.addRectangleToCanvas(hitBox.x, hitBox.y, hitBox.width, hitBox.height, 1, false, Color.red);
    }

    @Override
    public void updatePosition() {
        double distance = position.distance(targetPosition);
        position.right((targetPosition.x - position.x) / distance * speedInPixel);
        position.down((targetPosition.y - position.y) / distance * speedInPixel);
    }
}
