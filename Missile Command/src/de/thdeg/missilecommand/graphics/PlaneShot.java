package de.thdeg.missilecommand.graphics;

import de.thdeg.missilecommand.gameview.GameView;

/**
 * Represents shots of the planes
 *
 * @author Olha Solodovnyk
 */
public class PlaneShot extends Shot{

    /**
     * Creates a new shot
     */
    public PlaneShot(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2, 1);
        this.size = 5;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.rotation = 0;
    }
}
