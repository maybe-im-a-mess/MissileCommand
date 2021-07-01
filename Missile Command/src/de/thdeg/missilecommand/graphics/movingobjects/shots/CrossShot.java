package de.thdeg.missilecommand.graphics.movingobjects.shots;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.movingobjects.Cross;

import java.awt.*;
import java.util.ArrayList;

/**
 * Represents shots of the main player.
 */
public class CrossShot extends Shot implements MovingGameObject {

    private final Position targetPosition;

    /**
     * Creates a new shot.
     *
     * @param gameView             Window to show the GameObject on.
     * @param objectsToCollideWith Game objects this game object can collide with.
     * @param followMe             Game object this game object can follow.
     */
    public CrossShot(GameView gameView, ArrayList<CollidableGameObject> objectsToCollideWith, Cross followMe) {
        super(gameView, objectsToCollideWith);
        this.position = new Position(GameView.WIDTH / 2d, GameView.HEIGHT);
        this.size = 1;
        this.width = (int) (5 * size);
        this.height = (int) (5 * size);
        this.rotation = 0;
        this.speedInPixel = 5;
        this.hitBox.width = width * 5;
        this.hitBox.height = height * 5;
        this.targetPosition = followMe.getPosition().clone();
    }

    @Override
    public void updatePosition() {
        double distance = position.distance(targetPosition);
        position.right((targetPosition.x - position.x) / distance * speedInPixel);
        position.down((targetPosition.y - position.y) / distance * speedInPixel);
    }

    @Override
    protected void updateStatus() {
        destroyShotIfItHasLeftTheScreen();
        destroyShotIfItHasReachedDestination();
    }

    private void destroyShotIfItHasLeftTheScreen() {
        if (position.y < 0) {
            gamePlayManager.destroy(this);
        }
    }

    private void destroyShotIfItHasReachedDestination() {
        if (position.y < targetPosition.y) {
            gamePlayManager.destroy(this);
        }
    }

    @Override
    protected void updateHitBoxPosition() {
        hitBox.x = (int) (position.x - size);
        hitBox.y = (int) (position.y - (3 * size));
    }

    @Override
    public void reactToCollision(CollidableGameObject otherObject) {
        gamePlayManager.destroy(this);
    }

    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.x, position.y, width, height, 0, true, Color.WHITE);
    }
}
