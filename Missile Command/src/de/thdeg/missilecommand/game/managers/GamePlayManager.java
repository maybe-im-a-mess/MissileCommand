package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;

/**
 * This class manages the game
 */
public class GamePlayManager {
    GameView gameView;
    private final GameObjectManager gameObjectManager;

    /**
     * Creates the game play manager
     */
    public GamePlayManager(GameView gameView, GameObjectManager gameObjectManager) {
        this.gameView = gameView;
        this.gameObjectManager = new GameObjectManager(this.gameView);
    }

    void updateGamePlay() {
    }
}