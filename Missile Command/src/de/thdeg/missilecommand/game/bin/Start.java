package de.thdeg.missilecommand.game.bin;

import de.thdeg.missilecommand.game.managers.GameLoopManager;

/**
 * Starts the game
 */
public class Start {
    public static void main(String[] args) {

        GameLoopManager gameLoopManager = new GameLoopManager();
        gameLoopManager.startGame();

        System.out.println();
    }

}
