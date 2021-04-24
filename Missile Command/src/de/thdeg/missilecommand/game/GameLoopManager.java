package de.thdeg.missilecommand.game;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.*;

import java.awt.event.KeyEvent;

/**
 * This class manages the main game loop of the game
 */
public class GameLoopManager {
    private final GameView gameView;
    private final InputManager inputManager;
    private final GameObjectManager gameObjectManager;
    private final GamePlayManager gamePlayManager;

    /**
     * Creates the main loop
     */
    public GameLoopManager() {
        this.gameView = new GameView();
        this.gameView.setWindowTitle("Missile Command");
        this.gameView.setStatusText("Olha Solodovnyk - Java Programmierung SS 2021");
        this.gameView.setWindowIcon("Missile Command.png");
        this.gameObjectManager = new GameObjectManager(gameView);
        this.inputManager = new InputManager(gameView, gameObjectManager.getClass());
        this.gamePlayManager = new GamePlayManager(gameView, gameObjectManager);
    }

    /**
     * Starts the main loop of the game
     */
    public void startGame() {
        while (true) {
            gamePlayManager.updateGamePlay();
            inputManager.updateUserInputs();
            gameObjectManager.updateGameObjects();
            gameView.printCanvas();
        }
    }
}