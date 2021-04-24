package de.thdeg.missilecommand.graphics;


import de.thdeg.missilecommand.gameview.GameView;

/**
 * Represents a new defender missile
 *
 * @author Olha Solodovnyk
 */
public class Defender extends GameObject {

    private final static String DEFENDER =
            " B \n"
                    + " B \n"
                    + " B \n"
                    + "B B\n"
                    + "B B";
    private final double damage;
    private boolean alive;


    /**
     * A new object "Plane" is created
     */
    public Defender(GameView gameView) {
        super(gameView);
        this.position = new Position(30, 490);
        this.size = 3;
        this.width = (int) (3 * size);
        this.height = (int) (5 * size);
        this.damage = 20;
        this.alive = true;
        this.rotation = 0;
    }

    /**
     * Updates the position of an object
     */
    @Override
    public void updatePosition() {
        super.updatePosition();
    }

    /**
     * Draws the defender to the canvas
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(DEFENDER, position.x, position.y, size, rotation);
    }

    @Override
    public String toString() {
        return "Defender: " + position;
    }
}
