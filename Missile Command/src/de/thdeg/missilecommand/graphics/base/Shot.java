package de.thdeg.missilecommand.graphics.base;

import de.thdeg.missilecommand.gameview.GameView;

/**
 * Represents a new shot
 *
 * @author Olha Solodovnyk
 */
public class Shot extends GameObject implements MovingGameObject {

    /**
     * Creates a new game objects
     *
     * @param gameView
     */
    public Shot(GameView gameView) {
        super(gameView);
    }

    @Override
    public void updatePosition() {
    }

    @Override
    public void addToCanvas() {

    }

    @Override
    public void updateStatus() {

    }
}
