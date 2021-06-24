package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.game.utilities.Level;
import de.thdeg.missilecommand.game.utilities.Player;
import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.movingobjects.*;
import de.thdeg.missilecommand.graphics.staticobjects.Background;
import de.thdeg.missilecommand.graphics.staticobjects.City;
import de.thdeg.missilecommand.graphics.staticobjects.Defender;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Manages the game.
 */
public class GamePlayManager {
    private final GameView gameView;
    private final GameObjectManager gameObjectManager;
    private boolean listHasBeenDeleted;


    GamePlayManager(GameView gameView, GameObjectManager gameObjectManager) {
        this.gameView = gameView;
        this.gameObjectManager = gameObjectManager;
        gameObjectManager.getCross().setGamePlayManager(this);
        Player player = new Player();
        player.level = new Level("Level 1", new Background(gameView), 2, 5);
        gameObjectManager.getScorePanel().setScore(0);
    }

    /**
     * Manages the game play.
     */
    void updateGamePlay() {
        createCities();
        spawnAndDestroyPlanes();
        spawnAndDestroyMissiles();
        spawnAndDestroyDefenders();
    }

    void spawnAndDestroyPlanes() {
        LinkedList<Plane> planes = gameObjectManager.getPlanes();
        if (gameView.timerExpired("spawnPlane", "GamePlayManager")) {
            gameView.setTimer("spawnPlane", "GamePlayManager", 8000);
            Plane plane = new Plane(gameView);
            plane.setGamePlayManager(this);
            planes.add(plane);
        }
        if (!listHasBeenDeleted && gameView.getGameTimeInMilliseconds() > 100_000) {
            planes.clear();
            listHasBeenDeleted = true;
        }
    }

    void spawnAndDestroyMissiles() {
        LinkedList<Missile> missiles = gameObjectManager.getMissiles();
        if (gameView.timerExpired("spawnMissile", "GamePlayManager")) {
            gameView.setTimer("spawnMissile", "GamePlayManager", 8000);
            Missile missile = new Missile(gameView);
            missile.setGamePlayManager(this);
            missiles.add(missile);
        }
        if (!listHasBeenDeleted && gameView.getGameTimeInMilliseconds() > 10_000) {
            missiles.clear();
            listHasBeenDeleted = true;
        }
    }

    void createCities() {
        LinkedList<City> cities = gameObjectManager.getCities();
        if (cities.isEmpty()) {
            City city = new City(gameView, 155, 480);
            cities.add(city);
            city.setGamePlayManager(this);
            city = new City(gameView, 250, 469);
            cities.add(city);
            city.setGamePlayManager(this);
            city = new City(gameView, 350, 475);
            cities.add(city);
            city.setGamePlayManager(this);
            city = new City(gameView, 560, 475);
            cities.add(city);
            city.setGamePlayManager(this);
            city = new City(gameView, 660, 480);
            cities.add(city);
            city.setGamePlayManager(this);
            city = new City(gameView, 760, 469);
            cities.add(city);
            city.setGamePlayManager(this);
        }

    }

    void spawnAndDestroyDefenders() {
        LinkedList<Defender> defenders1 = gameObjectManager.getDefenders1();
        LinkedList<Defender> defenders2 = gameObjectManager.getDefenders2();
        LinkedList<Defender> defenders3 = gameObjectManager.getDefenders3();
        if (defenders1.isEmpty() && defenders2.isEmpty() && defenders3.isEmpty()) {
            for (int rows = 0; rows <= 4; rows++) {
                for (int rockets = 0; rockets < rows; rockets++) {
                    double x = rows * 16;
                    double y = 510 - rockets * 16;
                    Position position = new Position(x, y);
                    defenders1.add(new Defender(gameView, position.x, position.y));
                }
            }
            for (int rows = 0; rows <= 4; rows++) {
                for (int rockets = 0; rockets < rows; rockets++) {
                    double x = (rows * 16) + 420;
                    double y = 510 - rockets * 16;
                    Position position = new Position(x, y);
                    defenders2.add(new Defender(gameView, position.x, position.y));
                }
            }
            for (int rows = 0; rows <= 4; rows++) {
                for (int rockets = 0; rockets < rows; rockets++) {
                    double x = (rows * 16) + 820;
                    double y = 510 - rockets * 16;
                    Position position = new Position(x, y);
                    defenders3.add(new Defender(gameView, position.x, position.y));
                }
            }
        }
    }

    /**
     * Adds a cross shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootCrossShot(Position startPosition) {
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.addAll(gameObjectManager.getMissileShots());
        collidableGameObjects.addAll(gameObjectManager.getPlaneShots());
        collidableGameObjects.addAll(gameObjectManager.getPlanes());
        Cross cross = gameObjectManager.getCross();
        CrossShot crossShot = new CrossShot(gameView, collidableGameObjects, cross);

        double posX = cross.getPosition().x;
        double posY = cross.getPosition().y;

        double dist1 = Math.sqrt(Math.pow(posX, 2) + Math.pow((posY - GameView.HEIGHT), 2));
        double dist2 = Math.sqrt(Math.pow((posX - GameView.WIDTH / 2d), 2) + Math.pow((posY - GameView.HEIGHT), 2));
        double dist3 = Math.sqrt(Math.pow((posX - (GameView.WIDTH - 1)), 2) + Math.pow((posY - GameView.HEIGHT), 2));
        double result = Math.min(dist1, Math.min(dist2, dist3));

        LinkedList<Defender> defenders1 = gameObjectManager.getDefenders1();
        LinkedList<Defender> defenders2 = gameObjectManager.getDefenders2();
        LinkedList<Defender> defenders3 = gameObjectManager.getDefenders3();
        if (!defenders1.isEmpty() && result == dist1) {
            crossShot.getPosition().x = 70;
            defenders1.remove(0);

        } else if (!defenders2.isEmpty() && result == dist2) {
            crossShot.getPosition().x = GameView.WIDTH / 2d;
            defenders2.remove(0);
        } else if (!defenders3.isEmpty() && result == dist3) {
            crossShot.getPosition().x = GameView.WIDTH - 70;
            defenders3.remove(0);
        }
        crossShot.getPosition().y = GameView.HEIGHT - 20;
        crossShot.setGamePlayManager(this);
        gameObjectManager.getCrossShots().add(crossShot);
    }

    /**
     * Adds a plane shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootPlaneShot(Position startPosition) {
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.addAll(gameObjectManager.getCities());
        PlaneShot planeShot = new PlaneShot(gameView, collidableGameObjects);
        planeShot.getPosition().x = startPosition.x;
        planeShot.getPosition().y = startPosition.y;
        planeShot.setGamePlayManager(this);
        gameObjectManager.getPlaneShots().add(planeShot);
    }

    /**
     * Adds a missile shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootMissileShot(Position startPosition) {
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.addAll(gameObjectManager.getCities());
        MissileShot missileShot = new MissileShot(gameView, collidableGameObjects);
        missileShot.getPosition().x = startPosition.x;
        missileShot.getPosition().y = startPosition.y;
        missileShot.setGamePlayManager(this);
        gameObjectManager.getMissileShots().add(missileShot);
    }

    /**
     * Removes a Shot from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param shot Object to be removed from the window.
     */
    public void destroy(Shot shot) {
        if (shot.getClass() == CrossShot.class) {
            gameObjectManager.getCrossShots().remove(shot);
        } else if (shot.getClass() == PlaneShot.class) {
            gameObjectManager.getPlaneShots().remove(shot);
        } else if (shot.getClass() == MissileShot.class) {
            gameObjectManager.getMissileShots().remove(shot);
        }
    }

    /**
     * Removes an Plane from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param plane Object to be removed from the window.
     */
    public void destroy(Plane plane) {
        gameObjectManager.getPlanes().remove(plane);
    }

    /**
     * Removes an Missile from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param missile Object to be removed from the window.
     */
    public void destroy(Missile missile) {
        gameObjectManager.getMissiles().remove(missile);
    }

    /**
     * Removes a City from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param city Object to be removed from the window.
     */
    public void destroy(City city) {
        gameObjectManager.getCities().remove(city);
    }
}


