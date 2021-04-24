package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.Panels;

/**
 * Represents a new sign "Bonus Points"
 *
 * @author Olha Solodovnyk
 */
class BonusPointsPanel extends Panels {

    private String bonusPoints;

    /**
     * Creates a new string "Bonus Points"
     */
    public BonusPointsPanel(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2, GameView.HEIGHT/2);
        this.size = 5;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.rotation = 0;
        this.disappear = true;
    }
}
