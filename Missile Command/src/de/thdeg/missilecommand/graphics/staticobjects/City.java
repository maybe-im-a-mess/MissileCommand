package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.base.GameObject;

import java.awt.*;

/**
 * Represents a new city
 *
 * @author Olha Solodovnyk
 */
public class City extends GameObject {

    private final static String CITY =
            "             G\n"
                    + "             G\n"
                    + "   G        GG\n"
                    + "   GG       GG\n"
                    + "   GG     G GG\n"
                    + "   GG G  GGGGGG GG\n"
                    + "   GG G  ggGGGG GG\n"
                    + "   GGGGG ggGGGG GG\n"
                    + "   gGGGG gggGGg Gv\n"
                    + " GGggGGGggGgGGg GgG\n"
                    + " GGgggGGggGggGggGggG\n"
                    + "GGGgggGGgGGggggggggG\n"
                    + " gggggggGGGGGggggggGG\n"
                    + " ggggggGGGGGGGgggggG";
    private final double health;
    private boolean alive;
    private final Position[] city;

    /**
     * A new object "City" is created
     */
    public City(GameView gameView) {
        super(gameView);
        city = new Position[6];
        this.city[0] = new Position(155, 480);
        this.city[1] = new Position(250, 469);
        this.city[2] = new Position(350, 475);
        this.city[3] = new Position(560, 475);
        this.city[4] = new Position(660, 480);
        this.city[5] = new Position(760, 469);
        this.size = 3;
        this.width = (int) (22 * size);
        this.height = (int) (14 * size);
        this.health = 100;
        this.alive = true;
        Color color1 = new Color(109, 60, 128);
        Color color2 = new Color(133, 81, 130);
        this.gameView.setColorForBlockImage('g', color1);
        this.gameView.setColorForBlockImage('G', color2);
    }


    private boolean isDestroyed() {
        if (health == 0) {
            alive = false;
        }
        return alive;
    }

    private double getHealth() {
        return health;
    }

    private boolean isAlive() {
        return alive;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void updateStatus() {
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(CITY, city[0].x, city[0].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, city[1].x, city[1].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, city[2].x, city[2].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, city[3].x, city[3].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, city[4].x, city[4].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, city[5].x, city[5].y, size, rotation);
    }

}
