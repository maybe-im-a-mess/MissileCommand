package de.thdeg.missilecommand.graphics;

import de.thdeg.missilecommand.gameview.GameView;

/**
 * Represents a new missile
 *
 * @author Olha Solodovnyk
 */
public class MissileShot extends Shot {

    private final static String MISSILE =
            "GG\n"
                    + "GG";
    private final double damage;
    private boolean alive;

    /**
     * A new object "Missile" is created
     */
    public MissileShot(GameView gameView) {
        super(gameView);
        position = new Position(45, 1);
        size = 1;
        this.damage = 10;
        speedInPixel = 1;
        this.alive = true;
        rotation = 0;
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

    //Exploding
    private void explode() {
    }

    /**
     * Draws the defender to the canvas
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(MISSILE, position.x, position.y, size, rotation);
    }

    @Override
    public String toString() {
        return "Missile: " + position;
    }


}
