package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;

/**
 * Represents a new main player
 *
 * @author Olha Solodovnyk
 */
public class Cross extends GameObject {

    private enum Status {STANDARD, DAMAGED1, DAMAGED2, GONE}

    private enum JumpState {STANDARD, HALF_UP, FULL_UP, HALF_DOWN}

    private final static boolean SHOW_X = true;
    private final static String CROSS =
            "  W\n"
                    + "  W\n"
                    + "WWWWW\n"
                    + "  W\n"
                    + "  W\n";
    //private final int missilesLeft;
    private boolean shooting;
    private JumpState jumpState;
    private Status status;
    private boolean movingToRight;
    private boolean movingToLeft;

    /**
     * A new Cross is created
     *
     * @param gameView GameView to show the shot on.
     */
    public Cross(GameView gameView) {
        super(gameView);
        this.position = new Position(GameView.WIDTH / 2d, GameView.HEIGHT / 2d);
        this.size = 50;
        //this.width = (int) (3 * size);
        //this.height = (int) (5 * size);
        //this.missilesLeft = 30;
        this.rotation = 0;
        this.speedInPixel = 3;
        this.gameView.setColorForBlockImage('X', Color.gray.brighter());

        this.status = Status.STANDARD;
        this.jumpState = JumpState.STANDARD;
    }

    /**
     * The position of the object changes to the left
     */
    public void left() {
        movingToLeft = true;
        position.left(speedInPixel);
    }

    /**
     * The position of the object changes to the right
     */
    public void right() {
        movingToRight = true;
        position.right(speedInPixel);
    }

    /**
     * The position of the object changes up
     */
    public void up() {
        position.up(speedInPixel);
        if (status == Status.STANDARD) {
            status = Status.DAMAGED1;
        }
    }

    /**
     * The position of the object changes down
     */
    public void down() {
        position.down(speedInPixel);
    }

    /**
     * Is used for shooting
     */
    public void shoot() {
        if (SHOW_X) {
            this.shooting = true;
        } else {
            if (gameView.timerExpired("Shot", "Cross")) {
                gameView.setTimer("Shot", "Cross", 300);
                gamePlayManager.shootCrossShot(position);
            }
        }

    }

    @Override
    public void addToCanvas() {
        if (status == Status.STANDARD) {
            switch (jumpState) {
                case STANDARD:
                    gameView.addTextToCanvas("X", position.x, position.y, size, Color.WHITE, rotation);
                    break;
                case HALF_UP:
                case HALF_DOWN:
                    gameView.addTextToCanvas("X", position.x, position.y - 20, size, Color.WHITE, rotation);
                    break;
                case FULL_UP:
                    gameView.addTextToCanvas("X", position.x, position.y - 40, size, Color.WHITE, rotation);
                    break;
            }
        } else if (status == Status.DAMAGED1) {
            gameView.addTextToCanvas("X", position.x - 20, position.y - 20, 90, Color.WHITE, rotation);
        } else if (status == Status.DAMAGED2) {
            gameView.addTextToCanvas("X", position.x - 40, position.y - 40, 130, Color.WHITE, rotation);
        }
    }

    @Override
    public void updateStatus() {
        switch (status) {
            case STANDARD:
                jumpingAnimation();
                rollingAnimation();
                break;
            case DAMAGED1:
                damaged1Animation();
                break;
            case DAMAGED2:
                damaged2Animation();
                break;
            case GONE:
                break;
        }
    }

    public void switchJumpState(){
        switch(jumpState) {
            case STANDARD:
                jumpState = JumpState.HALF_UP;
                break;
            case HALF_UP:
                jumpState = JumpState.FULL_UP;
                break;
            case FULL_UP:
                jumpState = JumpState.HALF_DOWN;
                break;
            case HALF_DOWN:
                jumpState = JumpState.STANDARD;
                break;
        }
    }

    private void jumpingAnimation() {
        if (gameView.timerExpired("jumpAnimation", "Cross")) {
            gameView.setTimer("jumpAnimation", "Cross", 80);
            if (movingToRight) {
                switchJumpState();
                movingToRight = false;
            } else {
                jumpState = JumpState.STANDARD;
            }
        }
    }

    private void rollingAnimation() {
        if (movingToLeft) {
            rotation -= 5;
            movingToLeft = false;
        } else {
            rotation = 0;
        }
    }

    private void damaged1Animation() {
        if (gameView.timerExpired("damaged", "Cross")) {
            gameView.setTimer("damaged", "Cross", 300);
            status = Status.DAMAGED2;
        }
    }

    private void damaged2Animation() {
        if (gameView.timerExpired("damaged", "Cross")) {
            gameView.setTimer("damaged", "Cross", 300);
            status = Status.GONE;
        }
    }
}

