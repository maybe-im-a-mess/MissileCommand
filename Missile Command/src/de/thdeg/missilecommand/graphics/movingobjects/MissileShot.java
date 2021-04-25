package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.Shot;

import java.awt.*;

/**
 * Represents a new missile
 *
 * @author Olha Solodovnyk
 */
public class MissileShot extends Shot {

    private final double damage;
    private boolean alive;

    /**
     * A new object "Missile" is created
     *
     * @param gameView Window to show the GameObject on.
     */
    public MissileShot(GameView gameView) {
        super(gameView);
        this.position = new Position(45, 1);
        this.size = 1;
        this.damage = 10;
        this.speedInPixel = 1;
        this.alive = true;
        this.rotation = 0;
    }

    /**
     * Updates the current or start position of the missile
     */
    @Override
    public void updatePosition() {
        position.down(speedInPixel);
    }


    //Splitting of the missile into parts
    private void split() {
    }

    private void disappear(){}

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
