package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;
import de.thdeg.missilecommand.graphics.movingobjects.*;
import de.thdeg.missilecommand.graphics.movingobjects.shots.CrossShot;
import de.thdeg.missilecommand.graphics.movingobjects.shots.MissileShot;
import de.thdeg.missilecommand.graphics.movingobjects.shots.PlaneShot;
import de.thdeg.missilecommand.graphics.staticobjects.*;

import java.util.LinkedList;

/**
 * Manages the objects of the game.
 */
public class GameObjectManager {
    private final LinkedList<GameObject> gameObjects;
    private final LinkedList<CrossShot> crossShots;
    private final LinkedList<Missile> missiles;
    private final LinkedList<MissileShot> missileShots;
    private final LinkedList<Plane> planes;
    private final LinkedList<PlaneShot> planeShots;
    private final LinkedList<City> cities;
    private final LinkedList<Defender> defenders1;
    private final LinkedList<Defender> defenders2;
    private final LinkedList<Defender> defenders3;

    private static Background background;
    private final Ground ground;
    private final ScorePanel scorePanel;
    private final Cross cross;
    private final Overlay overlay;


    GameObjectManager(GameView gameView) {
        this.gameObjects = new LinkedList<>();
        this.crossShots = new LinkedList<>();
        this.missiles = new LinkedList<>();
        this.missileShots = new LinkedList<>();
        this.planes = new LinkedList<>();
        this.planeShots = new LinkedList<>();
        this.cities = new LinkedList<>();
        this.defenders1 = new LinkedList<>();
        this.defenders2 = new LinkedList<>();
        this.defenders3 = new LinkedList<>();

        background = new Background(gameView);
        this.ground = new Ground(gameView);
        this.scorePanel = new ScorePanel(gameView);
        this.cross = new Cross(gameView);
        this.overlay = new Overlay(gameView);
    }

    void updateGameObjects() {
        gameObjects.clear();

        gameObjects.add(background);
        gameObjects.add(ground);
        gameObjects.add(scorePanel);
        gameObjects.add(cross);
        gameObjects.addAll(defenders1);
        gameObjects.addAll(defenders2);
        gameObjects.addAll(defenders3);
        gameObjects.addAll(cities);
        gameObjects.addAll(planes);
        gameObjects.addAll(planeShots);
        gameObjects.addAll(crossShots);
        gameObjects.addAll(missiles);
        gameObjects.addAll(missileShots);
        gameObjects.add(overlay);

        for (GameObject gameObject : gameObjects) {
            gameObject.update();
            gameObject.addToCanvas();
        }
    }

    Cross getCross() {
        return cross;
    }

    static Background getBackground() {
        return background;
    }

    ScorePanel getScorePanel() {
        return scorePanel;
    }

    Overlay getOverlay() {
        return overlay;
    }

    LinkedList<CrossShot> getCrossShots() {
        return crossShots;
    }

    LinkedList<Missile> getMissiles() {
        return missiles;
    }

    LinkedList<MissileShot> getMissileShots() {
        return missileShots;
    }

    LinkedList<Plane> getPlanes() {
        return planes;
    }

    LinkedList<PlaneShot> getPlaneShots() {
        return planeShots;
    }

    LinkedList<City> getCities() {
        return cities;
    }

    LinkedList<Defender> getDefenders1() {
        return defenders1;
    }

    LinkedList<Defender> getDefenders2() {
        return defenders2;
    }

    LinkedList<Defender> getDefenders3() {
        return defenders3;
    }
}
