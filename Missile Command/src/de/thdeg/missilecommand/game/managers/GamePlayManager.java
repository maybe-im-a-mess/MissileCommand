package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.base.Shot;
import de.thdeg.missilecommand.graphics.movingobjects.*;

import java.util.LinkedList;

/**
 * This class manages the game
 */
public class GamePlayManager {
    private final GameView gameView;
    private final GameObjectManager gameObjectManager;
    private boolean listHasBeenDeleted;


    GamePlayManager(GameView gameView, GameObjectManager gameObjectManager) {
        this.gameView = gameView;
        this.gameObjectManager = gameObjectManager;
        gameObjectManager.getCross().setGamePlayManager(this);
    }

    /**
     * This method manages the game play.
     */
    void updateGamePlay() {
        spawnAndDestroyPlanes();
    }

    void spawnAndDestroyPlanes() {
        LinkedList<Plane> planes = gameObjectManager.getPlane();
        if (gameView.timerExpired("spawnPlane", "GamePlayManager")) {
            gameView.setTimer("spawnPlane", "GamePlayManager", 5000);
            Plane plane = new Plane(gameView);
            plane.setGamePlayManager(this);
            planes.add(plane);
        }
        if (gameView.timerExpired("destroyPlane", "GamePlayManager")) {
            gameView.setTimer("destroyPlane", "GamePlayManager", 10_000);
            if (!planes.isEmpty()) {
                planes.remove(0);
            }
        }
        if (!listHasBeenDeleted && gameView.getGameTimeInMilliseconds() > 10_000) {
            planes.clear();
            listHasBeenDeleted = true;
        }
    }

    /**
     * Adds a shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootCrossShot(Position startPosition) {
        CrossShot crossShot = new CrossShot(gameView);
        Cross cross = gameObjectManager.getCross();

        double posX = 0;
        double posY = 0;
        posX = cross.getPosition().x;
        posY = cross.getPosition().y;

        double dist1 = Math.sqrt(Math.pow(posX, 2) + Math.pow((posY - GameView.HEIGHT), 2));
        double dist2 = Math.sqrt(Math.pow((posX - GameView.WIDTH / 2d), 2) + Math.pow((posY - GameView.HEIGHT), 2));
        double dist3 = Math.sqrt(Math.pow((posX - (GameView.WIDTH - 1)), 2) + Math.pow((posY - GameView.HEIGHT), 2));
        double result = Math.min(dist1, Math.min(dist2, dist3));

        if (result == dist1) {
            crossShot.getPosition().x = 70;
        } else if (result == dist2) {
            crossShot.getPosition().x = GameView.WIDTH / 2d;
        } else if (result == dist3) {
            crossShot.getPosition().x = GameView.WIDTH - 70;
        }

        crossShot.getPosition().y = GameView.HEIGHT - 20;


        crossShot.setGamePlayManager(this);
        gameObjectManager.getCrossShot().add(crossShot);
    }

    /**
     * Adds a shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootPlaneShot(Position startPosition) {
        PlaneShot planeShot = new PlaneShot(gameView);
        planeShot.getPosition().x = startPosition.x;
        planeShot.getPosition().y = startPosition.y;
        planeShot.setGamePlayManager(this);
        gameObjectManager.getPlaneShot().add(planeShot);
    }

    /**
     * Adds a shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootMissileShot(Position startPosition) {
        MissileShot missileShot = new MissileShot(gameView);
        missileShot.getPosition().x = startPosition.x;
        missileShot.getPosition().y = startPosition.y;
        missileShot.setGamePlayManager(this);
        gameObjectManager.getMissileShot().add(missileShot);
    }

    /**
     * Removes a Shot from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param shot Object to be removed from the window.
     */
    public void destroy(Shot shot) {
        if (shot.getClass() == CrossShot.class) {
            gameObjectManager.getCrossShot().remove(shot);
        } else if (shot.getClass() == PlaneShot.class) {
            gameObjectManager.getPlaneShot().remove(shot);
        } else if (shot.getClass() == MissileShot.class) {
            gameObjectManager.getMissileShot().remove(shot);
        }
    }

    /**
     * Moves the World to the left.
     *
     * @param speedInPixel Speed to move the World.
     */
    public void crossMovingRight(double speedInPixel) {
        gameObjectManager.moveWorld(-speedInPixel, 0);
    }

    /**
     * Moves the World to the right.
     *
     * @param speedInPixel Speed to move the World.
     */
    public void crossMovingLeft(double speedInPixel) {
        gameObjectManager.moveWorld(speedInPixel, 0);
    }

}


