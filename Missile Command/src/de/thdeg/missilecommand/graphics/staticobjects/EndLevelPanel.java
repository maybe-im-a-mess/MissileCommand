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
                    +"             B\n"
                    +"   B        BB\n"
                    +"   BB       BB\n"
                    +"   BB     B BB\n"
                    +"   BB B  BBBBBB BB\n"
                    +"   BB B  bbBBBB BB\n"
                    +"   BBBBB bbBBBB BB\n"
                    +"   bBBBB bbbBBb Bv\n"
                    +" BBbbBBBbbBbBBb BbB\n"
                    +" BBbbbBBbbBbbBbbBbbB\n"
                    +"BBBbbbBBbBBbbbbbbbbB\n"
                    +" bbbbbbbBBBBBbbbbbbBB\n"
                    +" bbbbbbBBBBBBBbbbbbB";
    private final static Position positionFirstLine = new Position(GameView.WIDTH / 2, 150);
    private final static Position positionDefenderPoints = new Position(GameView.WIDTH / 2, 200);
    private final static Position positionDefenders = new Position(GameView.WIDTH / 2, 200);
    private final static Position positionCitiesPoints = new Position(GameView.WIDTH / 2, 300);
    private final static Position positionCities = new Position(GameView.WIDTH / 2 + 22, 300);

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

    int countDefenderPoints(){
        return defenderPoints;
    }


    int countCitiesPoints(){
        return citiesPoints;
    }

    int countBonusPoints(){
        return bonusPoints;
    }

    @Override
    public void updatePosition(){}

    @Override
    public void addToCanvas(){
        gameView.addTextToCanvas(FIRST_LINE, positionFirstLine.x, positionFirstLine.y, size, Color.BLUE, rotation);
        gameView.addTextToCanvas(defenderPoints.toString(), positionDefenderPoints.x, positionDefenderPoints.y, size, Color.BLUE, rotation);
        gameView.addBlockImageToCanvas(DEFENDER, positionDefenders.x, positionDefenders.y, size, rotation);
        gameView.addTextToCanvas(citiesPoints.toString(), positionCitiesPoints.x, positionCitiesPoints.y, size, Color.BLUE, rotation);
        gameView.addBlockImageToCanvas(CITY, positionCities.x, positionCities.y, size, rotation);
    }
}
