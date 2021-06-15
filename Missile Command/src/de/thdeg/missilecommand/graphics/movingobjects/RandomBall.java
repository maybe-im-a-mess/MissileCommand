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
    private int currentPosition;
    private final MovementPatterns movementPatterns;
    private ArrayList<Position> movementPattern;

    /**
     * Creates the GameObject with the GameView to be displayed on.
     * @param gameView gameView to show the ball on
     */
    public RandomBall(GameView gameView) {
        super(gameView);
        this.movementPatterns = new MovementPatterns();
        this.movementPattern = movementPatterns.getRandomPattern();
        this.targetPosition = movementPattern.get(0);
        this.random = new Random();
        this.size = 50;
        this.speedInPixel = 4;
        this.currentPosition = 0;
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
        if (currentPosition < movementPattern.size() - 1) {
            currentPosition++;
        } else {
            currentPosition = 0;
            movementPattern = movementPatterns.getRandomPattern();
        }
        targetPosition = movementPattern.get(currentPosition);
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
