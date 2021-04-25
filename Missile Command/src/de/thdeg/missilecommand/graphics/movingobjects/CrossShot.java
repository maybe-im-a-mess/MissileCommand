package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.Shot;

/**
 * Represents shots of the main player
 *
 * @author Olha Solodovnyk
 */
public class CrossShot extends Shot {

    /**
     * Creates a new shot
     */
    public CrossShot(GameView gameView) {
        super(gameView);
        this.position = new Position();
        this.size = 5;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.rotation = 0;
    }

}