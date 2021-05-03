package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.base.Shot;

import java.awt.*;
import java.util.Random;

/**
 * Represents a new missile
 *
 * @author Olha Solodovnyk
 */
public class MissileShot extends Shot {

    private final double damage;
    private boolean alive;
    private String objectID;
    private final Random random;

    /**
     * A new object "Missile" is created
     *
     * @param gameView Window to show the GameObject on.
     */
    public MissileShot(GameView gameView) {
        super(gameView);
        this.random = new Random();
        this.position = new Position(random.nextInt(GameView.WIDTH - 50), 1);
        this.size = 1;
        this.damage = 10;
        this.speedInPixel = 1;
        this.alive = true;
        this.rotation = 0;
        this.width = (int) (3 *size);
        this.height = (int) (3 * size);
        this.objectID = "Missile" + position.x + position.y;
    }


    /**
     * Updates the current or start position of the missile
     */
    @Override
    public void updatePosition() {
        position.down(speedInPixel);
    }

    @Override
    public void updateStatus() {
        if(position.y > GameView.HEIGHT - 30) {
            gamePlayManager.destroy(this);
        }
    }


    //Splitting of the missile into parts
    private void split() {
    }

    private void disappear() {
    }

    /**
     * Draws the defender to the canvas
     */
    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.x, position.y, width, height, 0, true, Color.WHITE);
    }

    @Override
    public String toString() {
        return "Missile: " + position;
    }


}
