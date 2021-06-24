package de.thdeg.missilecommand.graphics.staticobjects;


import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;
import de.thdeg.missilecommand.graphics.base.Position;

/**
 * Represents a new defender missile.
 */
public class Defender extends GameObject {

    private final static String DEFENDER =
            " B \n"
                    + " B \n"
                    + " B \n"
                    + "B B\n"
                    + "B B";


    /**
     * Creates a new defender missile.
     *  @param gameView Window to show the GameObject on.
     * @param x        Coordinate x of the defender.
     * @param y        Coordinate y of the defender.
     */
    public Defender(GameView gameView, double x, double y) {
        super(gameView);
        this.position = new Position(x, y);
        this.size = 3;
        this.width = (int) (3 * size);
        this.height = (int) (5 * size);
        this.rotation = 0;
    }

    @Override
    public void updateStatus() {
    }

    /**
     * Draws the defender to the canvas.
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(DEFENDER, position.x, position.y, size, rotation);
    }
}
