package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a new plane
 */
public class Plane extends CollidableGameObject implements MovingGameObject {
    private enum Status {STANDARD, EXPLODING, EXPLODED}
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
    private final String objectID;


    /**
     * Creates a new plane.
     */
    public Plane(GameView gameView) {
        super(gameView);
        Status status = Status.STANDARD;
        Random random = new Random();
        this.position = new Position(1, random.nextInt(GameView.HEIGHT / 4));
        objectID = "plane" + position.x + position.y;
        this.size = 1.5;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.speedInPixel = 0.5;
        this.rotation = 0;
        this.hitBox.width = width;
        this.hitBox.height = height;
    }


    /**
     * Draws the plane to the canvas.
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(PLANE, position.x, position.y, size, rotation);
    }


    @Override
    public void updatePosition() {
        if (position.x + width <= GameView.WIDTH && rotation == 0) {
            position.right(speedInPixel);
        }
    }

    @Override
    public void updateStatus() {
        if (gameView.timerExpired("Shoot", objectID)) {
            gameView.setTimer("Shoot", objectID, 4000);
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
        gameView.playSound("explode.wav", false);
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


