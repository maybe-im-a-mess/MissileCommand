package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.base.GameObject;

/**
 * Represents ground in the game
 *
 * @author Olha Solodovnyk
 */
public class Ground extends GameObject {

    private final static String GROUND =
            "    O    O                                    O    O                                  O    O\n"
                    + "    OOOOOO                                    OOOOOO                                  OOOOOO\n"
                    + "   OOOOOOOO                                  OOOOOOOO                                OOOOOOOO\n"
                    + "  OOOOOOOOOO                                OOOOOOOOOO                              OOOOOOOOOO\n"
                    + " OOOOOOOOOOOO                              OOOOOOOOOOOO                            OOOOOOOOOOOO\n"
                    + "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO\n"
                    + "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO\n"
                    + "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO\n"
                    + "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO";


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

    @Override
    public void updateStatus(){}

    /**
     * Draws the ground to the canvas
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(GROUND, position.x, position.y, size, rotation);
    }
}
