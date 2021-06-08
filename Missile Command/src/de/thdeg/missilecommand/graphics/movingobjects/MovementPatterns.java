package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.graphics.base.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class MovementPatterns {
    private ArrayList<Position> square;
    private ArrayList<Position> zigZag;
    private final HashMap<String, ArrayList<Position>> movementPatterns;
    private final Random random;

    /**
     * Creates movement patterns.
     */
    public MovementPatterns(){
        this.random = new Random();
        this.movementPatterns = new HashMap<>();
        this.square = new ArrayList<>();
        this.zigZag = new ArrayList<>();
        square.add(new Position(30, 30));
        square.add(new Position(930, 30));
        square.add(new Position(930, 510));
        square.add(new Position(30, 510));
        zigZag.add(new Position(300, 200));
        zigZag.add(new Position(400, 340));
        zigZag.add(new Position(500, 200));
        zigZag.add(new Position(600, 340));
        zigZag.add(new Position(700, 200));
        zigZag.add(new Position(800, 340));
        movementPatterns.put("square", square);
        movementPatterns.put("zigzag", zigZag);
    }

    /**
     * Get a string pattern.
     * @param pattern String pattern.
     * @return The movement.
     */
    public ArrayList<Position> getPattern (String pattern) {
        return movementPatterns.get(pattern);
    }

    /**
     * Get a random pattern.
     * @return square or zigzag pattern.
     */
    public ArrayList<Position> getRandomPattern() {
        if(random.nextInt(10) % 2 == 0) {
            return movementPatterns.get("zigzag");
        } else {
            return movementPatterns.get("square");
        }
    }
}
