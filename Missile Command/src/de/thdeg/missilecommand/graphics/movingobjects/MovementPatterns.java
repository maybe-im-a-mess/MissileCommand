package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.base.XAxisComparator;

import java.util.*;

class MovementPatterns {
    private final Random random;
    private final HashMap<String, ArrayList<Position>> movementPatterns;



    /**
     * Creates movement patterns.
     */
    public MovementPatterns() {
        this.random = new Random();
        this.movementPatterns = new HashMap<>(5);
        Comparator<Position> yAxisComparator = new Comparator<Position>() {
            @Override
            public int compare(Position obj1, Position obj2) {
                return (int) Math.signum(obj1.y - obj2.y);
            }
        };
        ArrayList<Position> square = new ArrayList<>(List.of(new Position(30, 30),
                new Position(930, 30),
                new Position(930, 510),
                new Position(30, 510)));
        ArrayList<Position> zigZag = new ArrayList<>(List.of(new Position(200, 340),
                new Position(300, 200),
                new Position(400, 340),
                new Position(500, 200),
                new Position(600, 340),
                new Position(700, 200),
                new Position(800, 340)));
        ArrayList<Position> zero = new ArrayList<> (List.of(new Position(30, 30),
                new Position(930, 30),
                new Position(930, 510),
                new Position(30, 510),
                new Position(200, 340),
                new Position(300, 200),
                new Position(400, 340),
                new Position(500, 200),
                new Position(600, 340),
                new Position(700, 200),
                new Position(800, 340)));
        Collections.sort(zero);
        ArrayList<Position> xFirst = new ArrayList<>(List.of(new Position(30, 30),
                new Position(930, 30),
                new Position(930, 510),
                new Position(30, 510),
                new Position(200, 340),
                new Position(300, 200),
                new Position(400, 340),
                new Position(500, 200),
                new Position(600, 340),
                new Position(700, 200),
                new Position(800, 340)));
        ArrayList<Position> yFirst = new ArrayList<>(List.of(new Position(30, 30),
                new Position(930, 30),
                new Position(930, 510),
                new Position(30, 510),
                new Position(200, 340),
                new Position(300, 200),
                new Position(400, 340),
                new Position(500, 200),
                new Position(600, 340),
                new Position(700, 200),
                new Position(800, 340)));
        ArrayList<Position> centered = new ArrayList<>(List.of(new Position(30, 30),
                new Position(930, 30),
                new Position(930, 510),
                new Position(30, 510),
                new Position(200, 340),
                new Position(300, 200),
                new Position(400, 340),
                new Position(500, 200),
                new Position(600, 340),
                new Position(700, 200),
                new Position(800, 340)));
        xFirst.sort(new XAxisComparator());
        yFirst.sort(yAxisComparator);
        Collections.sort(centered, (obj1, obj2) -> { return (int) Math.signum(distance(obj1) - distance(obj2));});
        System.out.println(centered);

        movementPatterns.put("square", square);
        movementPatterns.put("zigzag", zigZag);
        movementPatterns.put("zero", zero);
        movementPatterns.put("xFirst", xFirst);
        movementPatterns.put("yFirst", yFirst);
        movementPatterns.put("centered", centered);
    }

    /**
     * Get a string pattern.
     *
     * @param pattern String pattern.
     * @return The movement.
     */
    public ArrayList<Position> getPattern(String pattern) {
        return movementPatterns.get("Pattern");
    }

    /**
     * Get a random pattern.
     *
     * @return square or zigzag pattern.
     */
    public ArrayList<Position> getRandomPattern() {
       return movementPatterns.get("centered");
    }

    /**
     * Calculates the distance to center of the screen.
     *
     * @param obj Position to calculate the distance to.
     * @return The distance.
     */
    public double distance(Position obj) {
        return Math.sqrt(Math.pow((obj.x - GameView.WIDTH / 2), 2) + Math.pow((obj.y - GameView.HEIGHT / 2), 2));
    }
}
