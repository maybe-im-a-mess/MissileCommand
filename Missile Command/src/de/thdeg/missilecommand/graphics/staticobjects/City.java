package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Position;
import de.thdeg.missilecommand.graphics.superclasses.GameObject;

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
    private Position cities[] = new Position[6];

    /**
     * A new object "City" is created
     */
    public City(GameView gameView) {
        super(gameView);
        this.cities[0] = new Position(155, 460);
        this.cities[1] = new Position(250, 460);
        this.cities[2] = new Position(350, 460);
        this.cities[3] = new Position(560, 460);
        this.cities[4] = new Position(660, 460);
        this.cities[5] = new Position(760, 460);
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
    public void addToCanvas(){
        gameView.addBlockImageToCanvas(CITY, cities[0].x, cities[0].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, cities[1].x, cities[1].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, cities[2].x, cities[2].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, cities[3].x, cities[3].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, cities[4].x, cities[4].y, size, rotation);
        gameView.addBlockImageToCanvas(CITY, cities[5].x, cities[5].y, size, rotation);
    }

}
