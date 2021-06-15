package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.GameObject;
import de.thdeg.missilecommand.graphics.movingobjects.*;
import de.thdeg.missilecommand.graphics.staticobjects.*;

import java.util.LinkedList;

/**
 * Manages the objects of the game
 */
public class GameObjectManager {
    private final LinkedList<GameObject> gameObjects;
    private final LinkedList<CrossShot> crossShots;
    private final LinkedList<Missile> missiles;
    private final LinkedList<Plane> planes;
    private final LinkedList<PlaneShot> planeShots;
    private final LinkedList<City> cities;

    private final Background background;
    private final Ground ground;
    private final Defender defender;
    private final ScorePanel scorePanel;
    private final Cross cross;

    private final RandomBall randomBall;

    GameObjectManager(GameView gameView) {
        this.gameObjects = new LinkedList<>();
        this.crossShots = new LinkedList<>();
        this.missiles = new LinkedList<>();
        this.planes = new LinkedList<>();
        this.planeShots = new LinkedList<>();
        this.cities = new LinkedList<>();

        this.background = new Background(gameView);
        this.ground = new Ground(gameView);
        this.defender = new Defender(gameView);
        this.scorePanel = new ScorePanel(gameView);
        this.cross = new Cross(gameView);

        this.randomBall = new RandomBall(gameView);
    }

    void updateGameObjects() {
        gameObjects.clear();

        gameObjects.add(background);
        gameObjects.add(ground);
        gameObjects.add(defender);
        gameObjects.add(scorePanel);
        gameObjects.add(cross);
        gameObjects.addAll(cities);
        gameObjects.addAll(planes);
        gameObjects.addAll(crossShots);
        gameObjects.addAll(missiles);
        gameObjects.addAll(planeShots);

        gameObjects.add(randomBall);

        for (GameObject gameObject : gameObjects) {
            gameObject.update();
            gameObject.addToCanvas();
        }

    }

    /**
     * Adapts the position of all game objects.
     *
     * @param adaptX Adaption to the right.
     * @param adaptY Adaption downwards.
     */
    public void moveWorld(double adaptX, double adaptY) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getClass() != Cross.class
                    && gameObject.getClass() != Ground.class
                    && gameObject.getClass() != ScorePanel.class
                    && gameObject.getClass() != Defender.class) {
                gameObject.adaptPosition(adaptX, adaptY);
            }
        }
    }

    Cross getCross() {
        return cross;
    }

    LinkedList<CrossShot> getCrossShot() {
        return crossShots;
    }

    LinkedList<Missile> getMissileShot() {
        return missiles;
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

    ScorePanel getScorePanel() {return scorePanel;}
}
