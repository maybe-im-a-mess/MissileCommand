package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.graphics.Position;

/**
 * Represents a new city
 *
 * @author Olha Solodovnyk
 */
class City {

    private final Position position;
    private final double size;
    private final double width;
    private final double height;
    private final double health;
    private boolean alive;

    /**
     * A new object "City" is created
     */
    City() {
        this.position = new Position();
        this.size = 5;
        this.width = 5;
        this.height = 5;
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


    private Position getPosition() {
        return position;
    }


    private boolean isAlive() {
        return alive;
    }
}
