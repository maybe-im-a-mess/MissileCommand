package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.movingobjects.Cross;
import de.thdeg.missilecommand.graphics.movingobjects.MissileShot;
import de.thdeg.missilecommand.graphics.movingobjects.Plane;
import de.thdeg.missilecommand.graphics.staticobjects.*;


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
    }

    void updateGameObjects() {
        plane.updatePosition();
        plane.addToCanvas();
        ground.updatePosition();
        ground.addToCanvas();
        missileShot.addToCanvas();
        defender.addToCanvas();
        cross.addToCanvas();
        //startLevelPanel.addToCanvas();
        //endLevelPanel.addToCanvas();
        city.addToCanvas();
    }

    Cross getCross() {
        return cross;
    }
}
