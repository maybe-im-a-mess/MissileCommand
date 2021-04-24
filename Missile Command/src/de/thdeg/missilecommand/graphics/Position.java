package de.thdeg.missilecommand.graphics;

/**
 * This class is used to set and change the position of all the objects in a game
 *
 * @author Olha Solodovnyk
 */
public class Position {
    /**
     * x coordinate of the object
     */
    public double x;
    /**
     * y coordinate of the object
     */
    public double y;

    /**
     * This constructor is used for creating a new position with coordinates
     *
     * @param x for the x coordinate of the object
     *          and
     * @param y for the y coordinate of the object
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Another constructor without parameters for the position (0, 0)
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

    @Override
    public String toString() {
        return "Position (" + (int) Math.round(x) + ", " + (int) Math.round(y) + ")";
    }


}
