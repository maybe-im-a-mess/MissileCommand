package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.game.utilities.Level;
import de.thdeg.missilecommand.graphics.staticobjects.Background;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the levels of the game.
 */
public class LevelManager {
    private ArrayList<Level> levels;
    private int nextLevel;

    LevelManager(boolean difficultyIsSetToEasy) {
        Background background = GameObjectManager.getBackground();
        int numberOfPlanes = difficultyIsSetToEasy ? 2 : 4;
        int numberOfMissiles = difficultyIsSetToEasy ? 2 : 4;
        double speedOfShots = difficultyIsSetToEasy ? 0.1 : 0.2;
        Level firstLevel = new Level("First level", background, numberOfPlanes, numberOfMissiles, speedOfShots);
        Level secondLevel = new Level("Second level", background, numberOfPlanes + 3,
                numberOfMissiles + 3, speedOfShots + 0.1);
        Level thirdLevel = new Level("Third level", background, numberOfPlanes + 5,
                numberOfMissiles + 5, speedOfShots + 0.2);
        levels = new ArrayList<>(List.of(firstLevel, secondLevel, thirdLevel));
        this.nextLevel = 0;
    }

    /**
     * determines if a next level exists.
     *
     * @return <code>true</code> if there is a next level.
     */
    public boolean hasNextLevel() {
        return nextLevel < levels.size();
    }

    /**
     * Returns the next level.
     *
     * @return Next level.
     * @throws NoMoreLevelsAvailableException if no next level is available.
     */
    public Level getNextLevel() {
        Level level = levels.get(nextLevel);
        if (level == null) {
            throw new NoMoreLevelsAvailableException();
        }
        nextLevel++;
        return level;
    }
}
