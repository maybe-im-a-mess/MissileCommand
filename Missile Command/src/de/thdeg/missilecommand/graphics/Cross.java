package de.thdeg.missilecommand.graphics;

import de.thdeg.missilecommand.gameview.GameView;

import java.awt.*;

/**
 * Represents a new main player
 *
 * @author Olha Solodovnyk
 */
public class Cross extends GameObject {

    private final static String MAINPLAYER =
            "  B\n"
                    + "  B\n"
                    + "BBBBB\n"
                    + "  B\n"
                    + "  B\n";
    private final double damage;
    private final int missilesLeft;
    private boolean shooting;
    private final boolean playerGraphics;

    /**
     * A new object "Main Player" is created
     */
    public Cross(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2, GameView.HEIGHT / 2);
        this.size = 20;
        this.width = (int) (3 * size);
        this.height = (int) (5 * size);
        this.damage = 20;
        this.missilesLeft = 30;
        this.rotation = 0;
        this.speedInPixel = 3;
        this.playerGraphics = true;
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
    public void updatePosition() {
    }

    @Override
    public void addToCanvas() {
        if (playerGraphics) {
            gameView.addTextToCanvas(shooting ? "O" : "X" , position.x, position.y, size, Color.gray, rotation);
            shooting = false;
        } else {
            gameView.addBlockImageToCanvas(MAINPLAYER, position.x, position.y, size, rotation);
        }
    }
}
