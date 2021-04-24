package de.thdeg.missilecommand.graphics;

import de.thdeg.missilecommand.gameview.GameView;

/**
 * Represents a new plane
 *
 * @author Olha Solodovnyk
 */
public class Plane extends GameObject {

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
    private final double damage;
    private boolean alive;
    private boolean flyFromLeftToRight;

    /**
     * A new object "Plane" is created
     */
    public Plane(GameView gameView) {
        super(gameView);
        this.position = new Position(1, 80);
        this.size = 2;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.damage = 20;
        this.speedInPixel = 1;
        this.alive = true;
        this.rotation = 0;
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
        } else if (position.x + width <= 0 + width && rotation == 180) {
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


    private void shoot() {
    }

    private void explode() {
    }

    @Override
    public String toString() {
        return "Plane: " + position;
    }
}


