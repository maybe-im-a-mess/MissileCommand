package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.game.utilities.Countdown;
import de.thdeg.missilecommand.game.utilities.Player;
import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.Position;
import de.thdeg.missilecommand.graphics.movingobjects.Cross;
import de.thdeg.missilecommand.graphics.movingobjects.Missile;
import de.thdeg.missilecommand.graphics.movingobjects.Plane;
import de.thdeg.missilecommand.graphics.movingobjects.shots.CrossShot;
import de.thdeg.missilecommand.graphics.movingobjects.shots.MissileShot;
import de.thdeg.missilecommand.graphics.movingobjects.shots.PlaneShot;
import de.thdeg.missilecommand.graphics.movingobjects.shots.Shot;
import de.thdeg.missilecommand.graphics.staticobjects.City;
import de.thdeg.missilecommand.graphics.staticobjects.Defender;
import de.thdeg.missilecommand.screens.EndScreen;
import de.thdeg.missilecommand.screens.StartScreen;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Manages the game.
 */
public class GamePlayManager {
    private final static int COUNTDOWN_LENGTH = 30;
    private final GameView gameView;
    private final GameObjectManager gameObjectManager;
    private final Player player;
    private LevelManager levelManager;
    private Countdown countdown;
    private boolean levelOver;
    private boolean gameOver;
    private int planeCounter;
    private int missileCounter;
    private int planeWasRemoved;
    private boolean nextLevel;
    private boolean nextGame;


    GamePlayManager(GameView gameView, GameObjectManager gameObjectManager) {
        this.gameView = gameView;
        this.gameObjectManager = gameObjectManager;
        this.gameObjectManager.getCross().setGamePlayManager(this);
        this.player = new Player();
        planeCounter = 0;
        missileCounter = 0;
        planeWasRemoved = 0;
        initializeGame();
    }

    private void initializeGame() {
        StartScreen startScreen = new StartScreen(gameView);
        startScreen.showStartScreen();
        levelManager = new LevelManager(startScreen.isDifficultySetToEasy());
        this.player.citiesLeft = Player.MAXIMUM_NUMBER_OF_CITIES;
        this.player.defendersLeft = Player.MAXIMUM_NUMBER_OF_DEFENDERS;
        this.player.score = 0;
        gameView.playSound("alert.wav", false);
        gameObjectManager.getCities().clear();
        initializeLevel();
    }

    private void initializeLevel() {
        countdown = new Countdown(gameView);
        countdown.startCountdown(COUNTDOWN_LENGTH);
        player.level = levelManager.getNextLevel();
        missileCounter = 0;
        planeCounter = 0;
        planeWasRemoved = 0;
        player.defendersLeft = Player.MAXIMUM_NUMBER_OF_DEFENDERS;
        gameObjectManager.getMissileShots().clear();
        gameObjectManager.getPlaneShots().clear();
        gameObjectManager.getCrossShots().clear(); //Ne grusti, pozhalusto. ne bud'((
        gameObjectManager.getPlanes().clear();
        gameObjectManager.getMissiles().clear();
        gameObjectManager.getScorePanel().setScore(0);
        gameObjectManager.getCross().resetCross(true);
        gameObjectManager.getOverlay().showMessage("DEFEND CITIES");
    }

    private void nextGame() {
        if (!gameOver) {
            gameView.setTimer("game", "GamePlayManager", 3000);
            gameOver = true;
            gameObjectManager.getOverlay().showMessage("Game Over!");
            countdown.stop();
            nextGame = true;
        }
        if (gameView.timerExpired("game", "GamePlayManager")) {
            gameOver = false;
            nextGame = false;
            gameView.stopAllSounds();
            EndScreen endScreen = new EndScreen(gameView);
            endScreen.showEndScreen(player.score);
            initializeGame();
        }
    }

    private void nextLevel() {
        if (!levelOver) {
            gameView.setTimer("level", "GamePlayManager", 3000);
            levelOver = true;
            gameObjectManager.getOverlay().showMessage("Well done!");
            countdown.stop();
            nextLevel = true;
        }
        if (gameView.timerExpired("level", "GamePlayManager")) {
            levelOver = false;
            initializeLevel();
            nextLevel = false;
        }
    }

    /**
     * Manages the game play.
     */
    void updateGamePlay() {
        if (player.citiesLeft < 0 || player.defendersLeft <= 0) {
            nextGame();
            spawnDefenders();
        } else if (planeWasRemoved == player.level.numberOfPlanes && gameObjectManager.getMissileShots().isEmpty()) {
            if (levelManager.hasNextLevel()) {
                nextLevel();
                spawnDefenders();
            } else {
                nextGame();
                spawnDefenders();
            }
        } else {
            createCities();
            spawnPlanes();
            spawnMissiles();
            spawnDefenders();
        }
    }

    void spawnPlanes() {
        if (gameObjectManager.getPlanes().size() < player.level.numberOfPlanes && planeCounter < player.level.numberOfPlanes) {
            if (gameView.timerExpired("spawnPlane", "GamePlayManager")) {
                gameView.setTimer("spawnPlane", "GamePlayManager", 8000);
                Plane plane = new Plane(gameView);
                plane.setSpeed(player.level.speedOfShots);
                plane.setGamePlayManager(this);
                gameObjectManager.getPlanes().add(plane);
                planeCounter++;
            }
        }
    }

    void spawnMissiles() {
        if (gameObjectManager.getMissiles().size() < player.level.numberOfMissiles && missileCounter < player.level.numberOfMissiles) {
            if (gameView.timerExpired("spawnMissile", "GamePlayManager")) {
                gameView.setTimer("spawnMissile", "GamePlayManager", 8000);
                Missile missile = new Missile(gameView);
                missile.setGamePlayManager(this);
                gameObjectManager.getMissiles().add(missile);
                missileCounter++;
            }
        }
    }

    void createCities() {
        LinkedList<City> cities = gameObjectManager.getCities();
        if (cities.isEmpty() || nextGame) {
            nextGame = false;
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

    void spawnDefenders() {
        LinkedList<Defender> defenders1 = gameObjectManager.getDefenders1();
        LinkedList<Defender> defenders2 = gameObjectManager.getDefenders2();
        LinkedList<Defender> defenders3 = gameObjectManager.getDefenders3();
        if (defenders1.isEmpty() && defenders2.isEmpty() && defenders3.isEmpty() || nextLevel || nextGame) {
            defenders1.clear();
            defenders2.clear();
            defenders3.clear();
            nextLevel = false;
            nextGame = false;
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
        if (result == dist1) {
            if (!defenders1.isEmpty()) {
                crossShot.getPosition().x = 70;
                crossShot.getPosition().y = GameView.HEIGHT - 20;
                crossShot.setGamePlayManager(this);
                gameObjectManager.getCrossShots().add(crossShot);
                defenders1.remove(0);
                player.defendersLeft--;
            } else if (!defenders2.isEmpty()) {
                crossShot.getPosition().x = GameView.WIDTH / 2d;
                crossShot.getPosition().y = GameView.HEIGHT - 20;
                crossShot.setGamePlayManager(this);
                gameObjectManager.getCrossShots().add(crossShot);
                defenders2.remove(0);
                player.defendersLeft--;
            } else if (!defenders3.isEmpty()) {
                crossShot.getPosition().x = GameView.WIDTH - 70;
                crossShot.getPosition().y = GameView.HEIGHT - 20;
                crossShot.setGamePlayManager(this);
                gameObjectManager.getCrossShots().add(crossShot);
                defenders3.remove(0);
                player.defendersLeft--;
            }
        } else if (result == dist2) {
            if (!defenders2.isEmpty()) {
                crossShot.getPosition().x = GameView.WIDTH / 2d;
                crossShot.getPosition().y = GameView.HEIGHT - 20;
                crossShot.setGamePlayManager(this);
                gameObjectManager.getCrossShots().add(crossShot);
                defenders2.remove(0);
                player.defendersLeft--;
            } else if (!defenders1.isEmpty()) {
                crossShot.getPosition().x = 70;
                crossShot.getPosition().y = GameView.HEIGHT - 20;
                crossShot.setGamePlayManager(this);
                gameObjectManager.getCrossShots().add(crossShot);
                defenders1.remove(0);
                player.defendersLeft--;
            } else if (!defenders3.isEmpty()) {
                crossShot.getPosition().x = GameView.WIDTH - 70;
                crossShot.getPosition().y = GameView.HEIGHT - 20;
                crossShot.setGamePlayManager(this);
                gameObjectManager.getCrossShots().add(crossShot);
                defenders3.remove(0);
                player.defendersLeft--;
            }
        } else if (result == dist3) {
            if (!defenders3.isEmpty()) {
                crossShot.getPosition().x = GameView.WIDTH - 70;
                crossShot.getPosition().y = GameView.HEIGHT - 20;
                crossShot.setGamePlayManager(this);
                gameObjectManager.getCrossShots().add(crossShot);
                defenders3.remove(0);
                player.defendersLeft--;
            } else if (!defenders2.isEmpty()) {
                crossShot.getPosition().x = GameView.WIDTH / 2d;
                crossShot.getPosition().y = GameView.HEIGHT - 20;
                crossShot.setGamePlayManager(this);
                gameObjectManager.getCrossShots().add(crossShot);
                defenders2.remove(0);
                player.defendersLeft--;
            } else if (!defenders1.isEmpty()) {
                crossShot.getPosition().x = 70;
                crossShot.getPosition().y = GameView.HEIGHT - 20;
                crossShot.setGamePlayManager(this);
                gameObjectManager.getCrossShots().add(crossShot);
                defenders1.remove(0);
                player.defendersLeft--;
            }
        }
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
        planeShot.setSpeed(player.level.speedOfShots);
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
        missileShot.setSpeed(player.level.speedOfShots);
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
            player.score += 10;
            gameObjectManager.getPlaneShots().remove(shot);
        } else if (shot.getClass() == MissileShot.class) {
            player.score += 10;
            gameObjectManager.getMissileShots().remove(shot);
        }
    }

    /**
     * Removes an Plane from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param plane Object to be removed from the window.
     */
    public void destroy(Plane plane) {
        player.score += 10;
        gameObjectManager.getPlanes().remove(plane);
        planeWasRemoved++;
    }

    /**
     * Removes an Missile from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param missile Object to be removed from the window.
     */
    public void destroy(Missile missile) {
        player.score += 10;
        gameObjectManager.getMissiles().remove(missile);
    }

    /**
     * Removes a City from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param city Object to be removed from the window.
     */
    public void destroy(City city) {
        player.citiesLeft -= 1;
        gameObjectManager.getCities().remove(city);
    }
}


