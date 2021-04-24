package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;

/**
 * This class manages the game
 */
public class GamePlayManager {
    private final GameView gameView;
    private final GameObjectManager gameObjectManager;

    /**
     * Creates the game play manager
     */
    public GamePlayManager(GameView gameView, GameObjectManager gameObjectManager) {
        this.gameView = new GameView();
        this.gameObjectManager = new GameObjectManager(this.gameView);
    }

    void updateGamePlay() {
    }
}
