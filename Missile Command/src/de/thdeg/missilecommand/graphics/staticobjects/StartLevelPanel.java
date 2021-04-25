package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.Panels;

import java.awt.*;

/**
 * Represents the Panel when starting a level
 */
public class StartLevelPanel extends Panels {

    private final static String FIRST_LINE = "PLAYER 1";
    private final static String SECOND_LINE = "1 x POINTS";
    private final static String THIRD_LINE = "DEFEND                  CITIES";
    private final static int widthFirstLine = 8/2 * 20;
    private final static int widthSecondLine = 10/2 * 20;
    private final static int widthThirdLine = 30/2 * 20;
    private final static Position positionFirst = new Position((GameView.WIDTH / 2) - widthFirstLine, 150);
    private final static Position positionSecond = new Position((GameView.WIDTH / 2) - widthSecondLine, 200);
    private final static Position positionThird = new Position(GameView.WIDTH / 2 - widthThirdLine, 400);



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
    public void updatePosition(){}

    @Override
    public void addToCanvas(){
        gameView.addTextToCanvas(FIRST_LINE, positionFirst.x, positionFirst.y, size, Color.BLUE, rotation);
        gameView.addTextToCanvas(SECOND_LINE, positionSecond.x, positionSecond.y, size, Color.BLUE, rotation);
        gameView.addTextToCanvas(THIRD_LINE, positionThird.x, positionThird.y, size, Color.BLUE, rotation);
    }
}
