package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.base.Shot;

import java.awt.*;

/**
 * Represents shots of the planes
 *
 * @author Olha Solodovnyk
 */
public class PlaneShot extends Shot implements MovingGameObject {


    /**
     * Creates a new shot
     */
    public PlaneShot(GameView gameView) {
        super(gameView);
        this.position = new Position(100, 80);
        this.size = 1;
        this.width = (int) (3 * size);
        this.height = (int) (3 * size);
        this.rotation = 0;
        this.speedInPixel = 1;

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
