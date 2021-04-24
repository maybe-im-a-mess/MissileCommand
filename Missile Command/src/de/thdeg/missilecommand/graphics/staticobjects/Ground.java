package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.GameObject;

/**
 * Represents ground in the game
 *
 * @author Olha Solodovnyk
 */
public class Ground extends GameObject {

    private final static String GROUND =
            "    Y    Y                                 Y    Y                                   Y    Y\n"
                    + "    YYYYYY                                 YYYYYY                                   YYYYYY\n"
                    + "   YYYYYYYY                               YYYYYYYY                                 YYYYYYYY\n"
                    + "  YYYYYYYYYY                             YYYYYYYYYY                               YYYYYYYYYY\n"
                    + " YYYYYYYYYYYY                           YYYYYYYYYYYY                             YYYYYYYYYYYY\n"
                    + "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n"
                    + "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n"
                    + "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n"
                    + "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY";


    /**
     * A new object "Ground" is created
     */
    public Ground(GameView gameView) {
        super(gameView);
        position = new Position(1, 450);
        size = 10;
        width = (int) (3 * size);
        height = (int) (9 * size);
    }

    /**
     * Updates the position of an object
     */
    @Override
    public void updatePosition() {
        super.updatePosition();
    }

    /**
     * Draws the ground to the canvas
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(GROUND, position.x, position.y, size, rotation);
    }
}
