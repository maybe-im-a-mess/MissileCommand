package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.movingobjects.Cross;

import java.awt.event.KeyEvent;


class InputManager {
    GameView gameView;
    Cross cross;
    private final static boolean DIAGONAL_MOVEMENT_ALLOWED = true;

    InputManager(GameView gameView, Cross cross) {
        this.cross = cross;
        this.gameView = gameView;
    }


    private void processKeyCode(int keyCode) {
        if (keyCode == KeyEvent.VK_UP) {
            cross.up();
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            cross.down();
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            cross.right();
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            cross.left();
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            cross.shoot();
        }
    }

    void updateUserInputs() {
        Integer[] keyCodesOfCurrentlyPressedKeys = gameView.getKeyCodesOfCurrentlyPressedKeys();
        if (DIAGONAL_MOVEMENT_ALLOWED) {
            for (int keyCode : keyCodesOfCurrentlyPressedKeys) {
                processKeyCode(keyCode);
            }
        } else {
            if (keyCodesOfCurrentlyPressedKeys.length > 0) {
                processKeyCode(keyCodesOfCurrentlyPressedKeys[0]);
            }
        }
    }
}


