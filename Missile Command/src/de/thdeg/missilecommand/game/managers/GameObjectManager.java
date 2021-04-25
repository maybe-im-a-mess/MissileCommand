package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.movingobjects.Cross;
import de.thdeg.missilecommand.graphics.movingobjects.MissileShot;
import de.thdeg.missilecommand.graphics.movingobjects.Plane;
import de.thdeg.missilecommand.graphics.staticobjects.Defender;
import de.thdeg.missilecommand.graphics.staticobjects.Ground;
import de.thdeg.missilecommand.graphics.staticobjects.ScorePanel;


class GameObjectManager {

    GameView gameView;
    private final Plane plane;
    private final Defender defender;
    private final Ground ground;
    private final MissileShot missileShot;
    private final Cross cross;
    private final ScorePanel scorePanel;


    GameObjectManager(GameView gameView) {
        this.gameView = gameView;
        this.plane = new Plane(gameView);
        this.defender = new Defender(gameView);
        this.ground = new Ground(gameView);
        this.missileShot = new MissileShot(gameView);
        this.scorePanel = new ScorePanel(gameView);
        this.cross = new Cross(gameView);
    }

    void updateGameObjects() {
        plane.updatePosition();
        plane.addToCanvas();
        ground.updatePosition();
        ground.addToCanvas();
        missileShot.addToCanvas();
        defender.addToCanvas();
        cross.addToCanvas();
    }

    Cross getCross() {
        return cross;
    }
}
