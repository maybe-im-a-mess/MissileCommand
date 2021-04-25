package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.GameObject;

import java.awt.*;

/**
 * Represents a new main player
 *
 * @author Olha Solodovnyk
 */
public class Cross extends GameObject {

    private final boolean SHOW_X = false;
    private final static String CROSS =
            "  B\n"
                    + "  B\n"
                    + "BBBBB\n"
                    + "  B\n"
                    + "  B\n";
    private final int missilesLeft;
    private boolean shooting;


    /**
     * A new object "Main Player" is created
     *
     * @param gameView GameView to show the shot on.
     */
    public Cross(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2, GameView.HEIGHT / 2);
        this.size = 3;
        this.width = (int) (3 * size);
        this.height = (int) (5 * size);
        this.missilesLeft = 30;
        this.rotation = 0;
        this.speedInPixel = 3;
        this.gameView.setColorForBlockImage('X', Color.gray.brighter());
    }

    /**
     * The position of the object changes to the left
     */
    public void left() {
        position.x -= speedInPixel;
    }

    /**
     * The position of the object changes to the right
     */
    public double right() {
        return position.x += speedInPixel;
    }

    /**
     * The position of the object changes up
     */
    public double up() {
        return position.y -= speedInPixel;
    }

    /**
     * The position of the object changes down
     */
    public double down() {
        return position.y += speedInPixel;
    }

    /**
     * Is used for shooting
     */
    public void shoot() {
        shooting = true;
    }

    @Override
    public void addToCanvas() {
        if (SHOW_X) {
            gameView.addTextToCanvas(shooting ? "O" : "X", position.x, position.y, size, Color.WHITE, rotation);
            shooting = false;
        } else {
            gameView.addBlockImageToCanvas(CROSS, position.x, position.y, size, rotation);
        }
    }
}
