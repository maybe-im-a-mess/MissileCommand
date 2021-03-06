package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;

/**
 * Represents a background of the game.
 */
public class Background extends GameObject {

    /**
     * Creates the background.
     *
     * @param gameView GameView to draw on.
     */
    public Background(GameView gameView) {
        super(gameView);
    }

    @Override
    public void addToCanvas() {
        addBackgroundToCanvas();
    }

    @Override
    protected void updateStatus() {
    }

    private void addBackgroundToCanvas() {
        gameView.addImageToCanvas("Background.png", 1, 1, 1.6, rotation);
    }
}
