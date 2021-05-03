package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.base.Panels;

import java.awt.*;

/**
 * Displays the current score and highscore of the player.
 *
 * @author Olha Solodovnyk
 */
public class ScorePanel extends Panels {
    private int score;
    private int highscore;


    /**
     * Creates a new score
     */
    public ScorePanel(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2, 1);
        this.size = 20;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.rotation = 0;
        this.disappear = false;
        this.score = 0;
        this.highscore = 0;
    }


    /**
     * Sets the current score.
     *
     * @param score The current score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Sets the current highscore.
     *
     * @param highscore The highscore of the player.
     */
    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    /**
     * Draws the score to the canvas
     */
    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas(String.valueOf(score), position.x, position.y, size, Color.white, rotation);
    }

}
