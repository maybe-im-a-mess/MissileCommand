package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;
import de.thdeg.missilecommand.graphics.base.Position;

/**
 * Displays the current score of the player.
 */
public class ScorePanel extends GameObject {
    private String scoreString;


    /**
     * Creates a new panel to show the current score of the player.
     *
     * @param gameView GameView to show the score on.
     */
    public ScorePanel(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2, 1);
        this.size = 20;
        this.scoreString = " ";
    }

    @Override
    public void updateStatus() {
    }

    @Override
    public void addToCanvas() {

    }

    /**
     * Sets the score to be displayed.
     *
     * @param score Score to be displayed.
     */
    public void setScore(int score) {
        scoreString = String.valueOf(score);
        scoreString = " ".repeat(6 - scoreString.length()) + score;
    }

}
