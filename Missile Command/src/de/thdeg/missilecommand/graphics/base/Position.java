package de.thdeg.missilecommand.graphics.base;

import java.util.Objects;

/**
 * This class is used to set and change the position of all the objects in a game
 *
 * @author Olha Solodovnyk
 */
public class Position implements Cloneable, Comparable<Position> {
    /**
     * x coordinate of the object
     */
    public double x;
    /**
     * y coordinate of the object
     */
    public double y;

    /**
     * Creates a position on (x, y)
     *
     * @param x for the x coordinate of the object
     * @param y for the y coordinate of the object
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a position on (0, 0)
     */
    public Position() {
        this(0, 0);
    }

    /**
     * The position of the object changes one Pixel to the left
     *
     * @return the new position
     */
    public double left() {
        return x -= 1;
    }

    /**
     * The position of the object changes to the left
     *
     * @param pixel number of pixels for moving
     * @return the new position
     */
    public double left(double pixel) {
        return x -= pixel;
    }

    /**
     * The position of the object changes one Pixel to the right
     *
     * @return the new position
     */
    public double right() {
        return x += 1;
    }

    /**
     * The position of the object changes to the right
     *
     * @param pixel number of pixels for moving
     * @return the new position
     */
    public double right(double pixel) {
        return x += pixel;
    }

    /**
     * The position of the object changes one Pixel up
     *
     * @return the new position
     */
    public double up() {
        return y -= 1;
    }

    /**
     * The position of the object changes up
     *
     * @param pixel number of pixels for moving
     * @return the new position
     */
    public double up(double pixel) {
        return y -= pixel;
    }

    /**
     * The position of the object changes one Pixel down
     *
     * @return the new position
     */
    public double down() {
        return y += 1;
    }

    /**
     * The position of the object changes down
     *
     * @param pixel number of pixels for moving
     * @return the new position
     */
    public double down(double pixel) {
        return y += pixel;
    }

    /**
     * Calculates the distance to any other position.
     *
     * @param other Position to calculate the distance to.
     * @return The distance.
     */
    public double distance(Position other) {
        return Math.sqrt(Math.pow((x - other.x), 2) + Math.pow((y - other.y), 2));
    }

    @Override
    public String toString() {
        return "Position (" + (int) Math.round(x) + ", " + (int) Math.round(y) + ")";
    }

    @Override
    public Position clone(){
        Position clone = null;
        try {
            clone = (Position) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return  true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {return Objects.hash(x, y);}


    @Override
    public int compareTo(Position obj) {
        Position position = new Position(0, 0);
        return (int) Math.signum(distance(position) - distance(obj));
    }
}
