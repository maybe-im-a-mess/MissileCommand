package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.Panels;

/**
 * Represents a new sign "Defend Cities"
 *
 * @author Olha Solodovnyk
 */
class DefendCitiesPanel extends Panels {

    private String defendCities;

    /**
     * Creates a new string "Defend cities"
     */
    public DefendCitiesPanel(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2, 400);
        this.size = 5;
        this.width = (int) (17 * size);
        this.height = (int) (12 * size);
        this.rotation = 0;
        this.disappear = true;
    }
}
