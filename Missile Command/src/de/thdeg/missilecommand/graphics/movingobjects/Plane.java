package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a new plane
 *
 * @author Olha Solodovnyk
 */
public class Plane extends CollidableGameObject implements MovingGameObject {

    private final static String PLANE =
            "RR   RRR\n"
                    + "RWR  RWWR\n"
                    + "RWWR  RWWR\n"
                    + " RWWRRRRRRRRRR\n"
                    + "RWWWWWWWWWWWWWRR\n"
                    + "RRRWWWWWWWWWWWWWR\n"
                    + "   RRRWWWWWWWWWWR\n"
                    + "     RWWWRRRRRRR\n"
                    + "    RWWWR\n"
                    + "    RWWR\n"
                    + "   RWWR\n"
                    + "   RRR";
    private boolean flyFromLeftToRight;
    private Random random;
    private String objectID;


    /**
     * A new object "Plane" is created
     */
    public Plane(GameView gameView) {
        super(gameView);
        this.random = new Random();
        this.position = new Position(1, random.nextInt(GameView.HEIGHT / 4));
        objectID = "plane" + position.x + position.y;
        this.size = 2;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.speedInPixel = 1;
        this.rotation = 0;
        this.hitBox.width = width;
        this.hitBox.height = height;
    }


    /**
     * Draws the plane to the canvas
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(PLANE, position.x, position.y, size, rotation);
    }

    /**
     * Updates the position of an object
     */
    @Override
    public void updatePosition() {
        if (position.x + width <= GameView.WIDTH && rotation == 0) {
            flyFromLeftToRight = true;
        } else if (position.x + width <= width && rotation == 180) {
            rotation = 0;
        } else {
            rotation = 180;
            flyFromLeftToRight = false;
        }
        if (flyFromLeftToRight) {
            position.right(speedInPixel);
        } else {
            position.left(speedInPixel);
        }
    }


    /**
     * Updates status of the plane. Is used for shooting
     */
    @Override
    public void updateStatus() {
        if (gameView.timerExpired("Shoot", objectID)) {
            gameView.setTimer("Shoot", objectID, 5000);
            gamePlayManager.shootPlaneShot(position);
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
    }

    @Override
    public Plane clone() {
        return (Plane) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return flyFromLeftToRight == plane.flyFromLeftToRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flyFromLeftToRight);
    }
}


