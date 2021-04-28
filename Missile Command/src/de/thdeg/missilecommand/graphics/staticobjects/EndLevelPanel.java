package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.Panels;

import java.awt.*;

/**
 * Represents the Panel at the end of a level
 */
public class EndLevelPanel extends Panels {

    private final static String FIRST_LINE = "BONUS POINTS";
    private Integer defenderPoints;
    private Integer citiesPoints;
    private Integer bonusPoints;
    private final static String DEFENDER = " B \n"
            + " B \n"
            + " B \n"
            + "B B\n"
            + "B B";
    private final static String CITY =
            "             B\n"
                    + "             B\n"
                    + "   B        BB\n"
                    + "   BB       BB\n"
                    + "   BB     B BB\n"
                    + "   BB B  BBBBBB BB\n"
                    + "   BB B  bbBBBB BB\n"
                    + "   BBBBB bbBBBB BB\n"
                    + "   bBBBB bbbBBb Bv\n"
                    + " BBbbBBBbbBbBBb BbB\n"
                    + " BBbbbBBbbBbbBbbBbbB\n"
                    + "BBBbbbBBbBBbbbbbbbbB\n"
                    + " bbbbbbbBBBBBbbbbbbBB\n"
                    + " bbbbbbBBBBBBBbbbbbB";
    private final static Position POSITION_FIRST_LINE = new Position(GameView.WIDTH / 2, 150);
    private final static Position POSITION_DEFENDER_POINTS = new Position(GameView.WIDTH / 2, 200);
    private final static Position POSITION_DEFENDERS = new Position(GameView.WIDTH / 2, 200);
    private final static Position POSITION_CITIES_POINTS = new Position(GameView.WIDTH / 2, 300);
    private final static Position POSITION_CITIES = new Position(GameView.WIDTH / 2 + 22, 300);


    /**
     * Creates a new Panel at the end of the level
     *
     * @param gameView GameView to show the Panel on.
     */
    public EndLevelPanel(GameView gameView) {
        super(gameView);
        size = 20;
        this.rotation = 0;
        this.disappear = true;

    }


    int countDefenderPoints() {
        return defenderPoints;
    }


    int countCitiesPoints() {
        return citiesPoints;
    }

    int countBonusPoints() {
        return bonusPoints;
    }

    @Override
    public void updatePosition() {
    }

    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas(FIRST_LINE, POSITION_FIRST_LINE.x, POSITION_FIRST_LINE.y, size, Color.BLUE, rotation);
        gameView.addTextToCanvas(defenderPoints.toString(), POSITION_DEFENDER_POINTS.x, POSITION_DEFENDER_POINTS.y, size, Color.BLUE, rotation);
        gameView.addBlockImageToCanvas(DEFENDER, POSITION_DEFENDERS.x, POSITION_DEFENDERS.y, size, rotation);
        gameView.addTextToCanvas(citiesPoints.toString(), POSITION_CITIES_POINTS.x, POSITION_CITIES_POINTS.y, size, Color.BLUE, rotation);
        gameView.addBlockImageToCanvas(CITY, POSITION_CITIES.x, POSITION_CITIES.y, size, rotation);
    }
}
