package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.Shot;

import java.awt.*;

/**
 * Represents shots of the planes
 *
 * @author Olha Solodovnyk
 */
public class PlaneShot extends Shot {


    /**
     * Creates a new shot
     */
    public PlaneShot(GameView gameView) {
        super(gameView);
        this.position = new Position(100, 80);
        this.size = 5;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.rotation = 0;

    }


    @Override
    public void updatePosition() {
        position.down(speedInPixel);
    }

    private void disappear() {
    }

    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.x, position.y, width, height, 0, true, Color.WHITE);
    }
}
