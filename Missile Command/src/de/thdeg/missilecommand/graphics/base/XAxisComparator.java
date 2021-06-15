package de.thdeg.missilecommand.graphics.base;

import java.util.Comparator;

/**
 * Is used to compare the coordinates x of the objects.
 */
public class XAxisComparator implements Comparator<Position> {

    @Override
    public int compare(Position obj1, Position obj2) {
        return (int) Math.signum(obj1.x - obj2.x);
    }
}
