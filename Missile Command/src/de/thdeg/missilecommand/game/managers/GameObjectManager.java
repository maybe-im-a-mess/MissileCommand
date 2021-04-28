package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.movingobjects.*;
import de.thdeg.missilecommand.graphics.staticobjects.*;
import de.thdeg.missilecommand.graphics.superclasses.GameObject;

import java.util.LinkedList;
import java.util.List;


class GameObjectManager {

    GameView gameView;
    private final Plane plane;
    private final Defender defender;
    private final Ground ground;
    private final MissileShot missileShot;
    private final Cross cross;
    private final ScorePanel scorePanel;
    private final StartLevelPanel startLevelPanel;
    private final EndLevelPanel endLevelPanel;
    private final City city;
    private LinkedList<GameObject> gameObjects;
    LinkedList<CrossShot> crossShots;
    LinkedList<MissileShot> missileShots;
    LinkedList<Plane> planes;
    LinkedList<PlaneShot> planeShots;
    LinkedList<City> cities;
    LinkedList<Defender> defenders;
    LinkedList<EndLevelPanel> endLevelPanels;
    LinkedList<ScorePanel> scorePanels;
    LinkedList<StartLevelPanel> startLevelPanels;
    LinkedList<Ground> grounds;


    GameObjectManager(GameView gameView) {
        this.gameView = gameView;
        this.plane = new Plane(gameView);
        this.defender = new Defender(gameView);
        this.ground = new Ground(gameView);
        this.missileShot = new MissileShot(gameView);
        this.scorePanel = new ScorePanel(gameView);
        this.cross = new Cross(gameView);
        this.startLevelPanel = new StartLevelPanel(gameView);
        this.endLevelPanel = new EndLevelPanel(gameView);
        this.city = new City(gameView);
        this.gameObjects = new LinkedList<>();
        this.crossShots = new LinkedList<>(List.of(new CrossShot(gameView)));
        this.missileShots = new LinkedList<>();
        missileShots.add(new MissileShot(gameView));
        this.planes = new LinkedList<>();
        planes.add(new Plane(gameView));
        this.planeShots = new LinkedList<>();
        planeShots.add(new PlaneShot(gameView));
        this.cities = new LinkedList<>();
        cities.add(new City(gameView));
        this.defenders = new LinkedList<>();
        defenders.add(new Defender(gameView));
        this.endLevelPanels = new LinkedList<>();
        endLevelPanels.add(new EndLevelPanel(gameView));
        this.scorePanels = new LinkedList<>();
        scorePanels.add(new ScorePanel(gameView));
        this.startLevelPanels = new LinkedList<>();
        startLevelPanels.add(new StartLevelPanel(gameView));
        this.grounds = new LinkedList<>();
        grounds.add(new Ground(gameView));
    }

    protected void updateGameObjects() {
        gameObjects.clear();
        gameObjects.add(new GameObject(gameView));
        gameObjects.addAll(grounds);
        //gameObjects.addAll(crossShots);
        //gameObjects.addAll(missileShots);
        gameObjects.addAll(planes);
        //gameObjects.addAll(planeShots);
        gameObjects.addAll(cities);
        gameObjects.addAll(defenders);
        //gameObjects.addAll(endLevelPanels);
        //gameObjects.addAll(scorePanels);
        //gameObjects.addAll(startLevelPanels);
        for (GameObject gameObject : gameObjects) {
            gameObject.updatePosition();
            gameObject.updateStatus();
            gameObject.addToCanvas();
        }
        cross.addToCanvas();
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

    LinkedList<City> getCity() {
        return cities;
    }

    LinkedList<Defender> getDefender() {
        return defenders;
    }

    LinkedList<EndLevelPanel> getEndLevelPanel() {
        return endLevelPanels;
    }

    LinkedList<ScorePanel> getScorePanel() {
        return scorePanels;
    }

    LinkedList<StartLevelPanel> getStartLevelPanel() {
        return startLevelPanels;
    }

    LinkedList<Ground> getGrounds() {
        return grounds;
    }
}
