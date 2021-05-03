package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.Panels;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;

/**
 * Represents the Panel when starting a level
 */
public class StartLevelPanel extends Panels {

    private final static String FIRST_LINE = "PLAYER 1";
    private final static String SECOND_LINE = "1 x POINTS";
    private final static String THIRD_LINE = "DEFEND                  CITIES";
    private final static int WIDTH_FIRST_LINE = 8 / 2 * 20;
    private final static int WIDTH_SECOND_LINE = 10 / 2 * 20;
    private final static int WIDTH_THIRD_LINE = 30 / 2 * 20;
    private final static Position POSITION_FIRST = new Position((GameView.WIDTH / 2) - WIDTH_FIRST_LINE, 150);
    private final static Position POSITION_SECOND = new Position((GameView.WIDTH / 2) - WIDTH_SECOND_LINE, 200);
    private final static Position POSITION_THIRD = new Position(GameView.WIDTH / 2 - WIDTH_THIRD_LINE, 400);


    /**
     * Creates a new Panel when starting a level
     *
     * @param gameView GameView to show the Panel on.
     */
    public StartLevelPanel(GameView gameView) {
        super(gameView);
        this.size = 20;
        this.rotation = 0;
        this.disappear = true;

    }


    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas(FIRST_LINE, POSITION_FIRST.x, POSITION_FIRST.y, size, Color.BLUE, rotation);
        gameView.addTextToCanvas(SECOND_LINE, POSITION_SECOND.x, POSITION_SECOND.y, size, Color.BLUE, rotation);
        gameView.addTextToCanvas(THIRD_LINE, POSITION_THIRD.x, POSITION_THIRD.y, size, Color.BLUE, rotation);
    }
}
