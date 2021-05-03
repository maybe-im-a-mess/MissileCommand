package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;
import de.thdeg.missilecommand.graphics.movingobjects.*;
import de.thdeg.missilecommand.graphics.staticobjects.*;

import java.util.LinkedList;


class GameObjectManager {
    private final LinkedList<GameObject> gameObjects;
    private final LinkedList<CrossShot> crossShots;
    private final LinkedList<MissileShot> missileShots;
    private final LinkedList<Plane> planes;
    private final LinkedList<PlaneShot> planeShots;

    private final Ground ground;
    private final City city;
    private final Defender defender;
    private final ScorePanel scorePanel;
    private final Cross cross;
    private final StartLevelPanel startLevelPanel;
    private final EndLevelPanel endLevelPanel;


    GameObjectManager(GameView gameView) {
        this.gameObjects = new LinkedList<>();
        this.crossShots = new LinkedList<>();
        this.missileShots = new LinkedList<>();
        this.planes = new LinkedList<>();
        this.planeShots = new LinkedList<>();

        this.ground = new Ground(gameView);
        this.city = new City(gameView);
        this.defender = new Defender(gameView);
        this.scorePanel = new ScorePanel(gameView);
        this.cross = new Cross(gameView);
        this.startLevelPanel = new StartLevelPanel(gameView);
        this.endLevelPanel = new EndLevelPanel(gameView);
    }

    void updateGameObjects() {
        gameObjects.clear();

        gameObjects.add(ground);
        gameObjects.add(city);
        gameObjects.add(defender);
        gameObjects.add(scorePanel);
        gameObjects.add(cross);
        gameObjects.addAll(planes);
        gameObjects.addAll(crossShots);
        gameObjects.addAll(missileShots);
        gameObjects.addAll(planeShots);
        //gameObjects.add(endLevelPanel);
        //gameObjects.add(startLevelPanel);

        for (GameObject gameObject : gameObjects) {
            gameObject.update();
            gameObject.addToCanvas();
        }

    }

    Cross getCross() {
        return cross;
    }

    LinkedList<CrossShot> getCrossShot() {
        return crossShots;
    }

    LinkedList<MissileShot> getMissileShot() {
        return missileShots;
    }

    LinkedList<Plane> getPlane() {
        return planes;
    }

    LinkedList<PlaneShot> getPlaneShot() {
        return planeShots;
    }
}
