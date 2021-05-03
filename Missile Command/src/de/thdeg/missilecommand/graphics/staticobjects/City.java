package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.base.GameObject;

/**
 * Represents a new city
 *
 * @author Olha Solodovnyk
 */
public class City extends GameObject {

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
    private final double health;
    private boolean alive;
    private final Position[] city;

    /**
     * A new object "City" is created
     */
    public City(GameView gameView) {
        super(gameView);
        city = new Position[6];
        this.city[0] = new Position(155, 460);
        this.city[1] = new Position(250, 460);
        this.city[2] = new Position(350, 460);
        this.city[3] = new Position(560, 460);
        this.city[4] = new Position(660, 460);
        this.city[5] = new Position(760, 460);
        this.size = 3;
        this.width = (int) (22 * size);
        this.height = (int) (14 * size);
        this.health = 100;
        this.alive = true;

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
