package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.Panels;

import java.awt.*;

/**
 * Represents score and highscore
 *
 * @author Olha Solodovnyk
 */
public class ScorePanel extends Panels {
    private String score;
    private String highscore;

    /**
     * Creates a new score
     */
    public ScorePanel(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2, 1);
        this.size = 5;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.rotation = 0;
        this.disappear = false;
    }

    private void countScore() {
    }
    private void highscore(){

    }

    /**
     * Draws the score to the canvas
     */
    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas(score, position.x, position.y, size, Color.white, rotation);
    }

}
