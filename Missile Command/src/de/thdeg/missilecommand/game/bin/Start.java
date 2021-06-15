package de.thdeg.missilecommand.game.bin;

import de.thdeg.missilecommand.game.managers.GameLoopManager;

/**
 * Starts the game
 */
public class Start {
    public static void main(String[] args) {
        /*System.out.println("Spiel");*/

        //Praktikum



        GameLoopManager gameLoopManager = new GameLoopManager();
        gameLoopManager.startGame();


        System.out.println();
    }

}
