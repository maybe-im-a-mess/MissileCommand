package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;
import de.thdeg.missilecommand.graphics.base.MovingGameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * This is a random ball
 */
public class RandomBall extends GameObject implements MovingGameObject {
    private Position targetPosition;
    private final Random random;
    private int movesCounter;
    private final MovementPatterns movementPatterns;
    private ArrayList<Position> square;
    private ArrayList<Position> zigZag;

    /**
     * Creates a new random ball
     * @param gameView gameView to show the ball on
     */
    public RandomBall(GameView gameView) {
        super(gameView);
        this.targetPosition = new Position();
        this.random = new Random();
        this.size = 50;
        this.speedInPixel = 4;
        this.movesCounter = 0;
        this.movementPatterns = new MovementPatterns();
        this.square = movementPatterns.getPattern("square");
        this.zigZag = movementPatterns.getPattern("zigzag");
    }

    @Override
    public void updatePosition() {
        double distance = position.distance(targetPosition);
        if (distance >= speedInPixel) {
            position.right((targetPosition.x - position.x) / distance * speedInPixel);
            position.down((targetPosition.y - position.y) / distance * speedInPixel);
        } else {
            setTargetPosition();
        }
    }

    /**
     * Set position to aim at
     */
    public void setTargetPosition() {
        int maxMovements = zigZag.size();
        if (movesCounter >= maxMovements) {
            movesCounter = 0;
            setMovementToARandomPattern();
        }
        this.targetPosition.x = zigZag.get(movesCounter).x;
        this.targetPosition.y = zigZag.get(movesCounter).y;
        movesCounter++;
    }

    /**
     * Setting a pattern to a random one.
     */
    public void setMovementToARandomPattern() {
        this.zigZag = movementPatterns.getRandomPattern();
    }

    @Override
    protected void updateStatus() {

    }

    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.x, position.y, size, size, 2, true, Color.YELLOW);
        gameView.addOvalToCanvas(targetPosition.x, targetPosition.y, size, size, 2, false, Color.WHITE);
    }


}
