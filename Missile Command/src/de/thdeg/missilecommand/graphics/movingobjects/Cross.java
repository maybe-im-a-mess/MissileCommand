package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;

/**
 * Represents a new main player.
 */
public class Cross extends GameObject {

    private final static String CROSS =
            "  W\n"
                    + "  W\n"
                    + "WWWWW\n"
                    + "  W\n"
                    + "  W\n";
    private boolean shooting;

    /**
     * A new cross is created.
     *
     * @param gameView GameView to show the cross on.
     */
    public Cross(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2d, GameView.HEIGHT / 2d);
        this.size = 3;
        this.width = (int) (3 * size);
        this.height = (int) (5 * size);
        int missilesLeft = 30;
        this.rotation = 0;
        this.speedInPixel = 3;
        this.gameView.setColorForBlockImage('X', Color.gray.brighter());
    }

    /**
     * The position of the object changes to the left.
     */
    public void left() {
        position.left(speedInPixel);
    }

    /**
     * The position of the object changes to the right.
     */
    public void right() {
        position.right(speedInPixel);
    }

    /**
     * The position of the object changes up.
     */
    public void up() {
        position.up(speedInPixel);
    }

    /**
     * The position of the object changes down.
     */
    public void down() {
        position.down(speedInPixel);
    }

    /**
     * Is used for shooting.
     */
    public void shoot() {
        if (gameView.timerExpired("Shot", "Cross")) {
            gameView.setTimer("Shot", "Cross", 300);
            gamePlayManager.shootCrossShot(position);
        }

    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(CROSS, position.x, position.y, size, rotation);
    }

    @Override
    public void updateStatus() {
    }

}

