package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;

/**
 * Represents ground in the game
 *
 * @author Olha Solodovnyk
 */
public class Ground extends GameObject {

    private final static String GROUND =
            "    Y    Y                                    Y    Y                                  Y    Y\n"
                    + "    YYYYYY                                    YYYYYY                                  YYYYYY\n"
                    + "   YOOOOOOY                                  YOOOOOOY                                YOOOOOOY\n"
                    + "  YOOOOOOOOY                                YOOOOOOOOY                              YOOOOOOOOY\n"
                    + " YOOOOOOOOOOY                              YOOOOOOOOOOY                            YOOOOOOOOOOY\n"
                    + "YOOOOOOOOOOOOYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYOOOOOOOOOOOOYYYYYYYYYYYYYYYYYYYYYYYYYYYYOOOOOOOOOOOOYYYYY\n"
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
        Color color1 = new Color(44, 29, 87);
        Color color2 = new Color(61, 47, 107);
        this.gameView.setColorForBlockImage('O', color1);
        this.gameView.setColorForBlockImage('Y', color2);
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
