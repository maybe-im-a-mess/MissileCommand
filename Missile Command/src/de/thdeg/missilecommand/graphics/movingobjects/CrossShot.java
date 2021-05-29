package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;
import java.util.ArrayList;

/**
 * Represents shots of the main player
 *
 * @author Olha Solodovnyk
 */
public class CrossShot extends Shot implements MovingGameObject {

    /**
     * Creates a new shot
     *
     * @param gameView Window to show the GameObject on.
     * @param objectsToCollideWith Game objects this game object can collide with.
     */
    public CrossShot(GameView gameView, ArrayList<CollidableGameObject> objectsToCollideWith) {
        super(gameView, objectsToCollideWith);
        this.position = new Position(GameView.WIDTH / 2d, GameView.HEIGHT);
        this.size = 1;
        this.width = (int) (3 * size);
        this.height = (int) (3 * size);
        this.rotation = 0;
        this.speedInPixel = 3;
        this.hitBox.width = width;
        this.hitBox.height = height;
    }

    @Override
    public void updatePosition() {
        position.up(speedInPixel);
    }

    @Override
    protected void updateStatus() {
        destroyShotIfItHasLeftTheScreen();
    }

    private void destroyShotIfItHasLeftTheScreen() {
        if (position.y < 0) {
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
