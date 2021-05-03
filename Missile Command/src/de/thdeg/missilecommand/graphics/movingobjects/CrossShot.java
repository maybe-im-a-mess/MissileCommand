package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.base.Shot;

import java.awt.*;

/**
 * Represents shots of the main player
 *
 * @author Olha Solodovnyk
 */
public class CrossShot extends Shot {

    /**
     * Creates a new shot
     *
     * @param gameView Window to show the GameObject on.
     */
    public CrossShot(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2d, GameView.HEIGHT);
        this.size = 1;
        this.width = (int) (3 * size);
        this.height = (int) (3 * size);
        this.rotation = 0;
        this.speedInPixel = 2.5;
    }


    @Override
    public void updatePosition() {
        position.up();
    }

    //Exploding
    private void explode() {
    }

    private void disappear() {
    }

    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.x, position.y, width, height, 0, true, Color.BLUE);
    }

}
