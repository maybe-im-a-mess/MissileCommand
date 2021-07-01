package de.thdeg.missilecommand.screens;

import de.thdeg.missilecommand.gameview.GameView;

/**
 * Displays a start screen that enables the player chose between "Easy" and "Standard" difficulty. The player is also
 * able to end the game.
 */
public class StartScreen {
    private final GameView gameView;
    private boolean isDifficultySetToEasy;

    /**
     * Creates the screen.
     *
     * @param gameView GameView to show the screen on.
     */
    public StartScreen(GameView gameView) {
        this.gameView = gameView;
    }

    /**
     * Shows the screen.
     */
    public void showStartScreen() {
        //@formatter:off
        String title = "\n" +
                       "             ****     **** **  ********  ******** ** **       ********             \n" +
                       "            /**/**   **/**/** **//////  **////// /**/**      /**/////              \n"+
                       "            /**//** ** /**/**/**       /**       /**/**      /**                   \n"+
                       "            /** //***  /**/**/*********/*********/**/**      /*******              \n" +
                       "            /**  //*   /**/**////////**////////**/**/**      /**////               \n" +
                       "            /**   /    /**/**       /**       /**/**/**      /**                   \n" +
                       "            /**        /**/** ********  ******** /**/********/********             \n" +
                       "            //         // // ////////  ////////  // //////// ////////              \n\n" +
                       "   ******    *******   ****     **** ****     ****     **     ****     ** *******  \n" +
                       "  **////**  **/////** /**/**   **/**/**/**   **/**    ****   /**/**   /**/**////** \n" +
                       " **    //  **     //**/**//** ** /**/**//** ** /**   **//**  /**//**  /**/**    /**\n" +
                       "/**       /**      /**/** //***  /**/** //***  /**  **  //** /** //** /**/**    /**\n" +
                       "/**       /**      /**/**  //*   /**/**  //*   /** **********/**  //**/**/**    /**\n" +
                       "//**    **//**     ** /**   /    /**/**   /    /**/**//////**/**   //****/**    ** \n" +
                       " //******  //*******  /**        /**/**        /**/**     /**/**    //***/*******  \n" +
                       "  //////    ///////   //         // //         // //      // //      /// ///////   ";
        String description = "\n\n\n\n"
                + "                    Destroy enemies!\n\n" +
                  "                     Defend cities!\n\n" +
                  "  Use left, right, up and down to move and space to shoot! ";
        //@formatter:on
        isDifficultySetToEasy = gameView.showSimpleStartScreen(title, description);
    }

    /**
     * Returns the choice of the player.
     *
     * @return <code>true</code> if the player has chosen "Easy", <code>false</code> otherwise.
     */
    public boolean isDifficultySetToEasy() {
        return isDifficultySetToEasy;
    }
}
