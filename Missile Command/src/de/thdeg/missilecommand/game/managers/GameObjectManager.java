package de.thdeg.missilecommand.game.managers;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.movingobjects.Cross;
import de.thdeg.missilecommand.graphics.movingobjects.MissileShot;
import de.thdeg.missilecommand.graphics.movingobjects.Plane;
import de.thdeg.missilecommand.graphics.staticobjects.Defender;
import de.thdeg.missilecommand.graphics.staticobjects.Ground;
import de.thdeg.missilecommand.graphics.staticobjects.ScorePanel;


class GameObjectManager {

    private GameView gameView;
    private final Plane plane;
    private final Defender defender;
    private final Ground ground;
    private final MissileShot missileShot;
    private final Cross cross;
    private final ScorePanel scorePanel;


    GameObjectManager(GameView gameView) {
        this.gameView = new GameView();
        this.plane = new Plane(this.gameView);
        this.defender = new Defender(this.gameView);
        this.ground = new Ground(this.gameView);
        this.missileShot = new MissileShot(this.gameView);
        this.cross = new Cross(this.gameView);
        this.scorePanel = new ScorePanel(this.gameView);
    }

    void updateGameObjects() {
        plane.updatePosition();
        plane.addToCanvas();
        ground.updatePosition();
        ground.addToCanvas();
        missileShot.addToCanvas();
        defender.addToCanvas();
        cross.addToCanvas();
        gameView.printCanvas();
    }

    Cross getCross() {
        return cross;
    }
}
