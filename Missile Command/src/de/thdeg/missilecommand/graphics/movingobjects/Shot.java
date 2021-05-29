package de.thdeg.missilecommand.graphics.movingobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.CollidingGameObject;

import java.util.ArrayList;

/**
 * Represents a new shot
 *
 * @author Olha Solodovnyk
 */
public abstract class Shot extends CollidingGameObject {
    protected Shot(GameView gameView, ArrayList<CollidableGameObject> objectsToCollideWith) {
        super(gameView, objectsToCollideWith);
    }
}
