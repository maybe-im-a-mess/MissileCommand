package de.thdeg.missilecommand.game;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.Cross;

import java.awt.event.KeyEvent;

public class InputManager {
    protected final GameView gameView;
    protected final Cross cross;
    private final static boolean DIAGONAL_MOVEMENT_ALLOWED = true;

    public InputManager(GameView gameView){
        this.gameView = gameView;
        this.cross = new Cross(gameView);
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


