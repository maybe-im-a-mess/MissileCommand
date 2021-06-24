package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;
import java.util.ArrayList;

/**
 * Represents shots of the missiles.
 */
public class MissileShot extends Shot implements MovingGameObject {

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
        this.speedInPixel = 0.1;
        this.hitBox.width = width * 5;
        this.hitBox.height = height * 5;
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
        if (position.y > GameView.HEIGHT) {
            gamePlayManager.destroy(this);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.x, position.y, width, height, 0, true, Color.WHITE);
    }

    @Override
    public void updatePosition() {
        position.down(speedInPixel);
    }
}
