package de.thdeg.missilecommand.graphics.staticobjects;

import de.thdeg.missilecommand.gameview.GameView;
import de.thdeg.missilecommand.graphics.base.CollidableGameObject;
import de.thdeg.missilecommand.graphics.base.Position;

import java.awt.*;

/**
 * Represents a new city
 *
 * @author Olha Solodovnyk
 */
public class City extends CollidableGameObject {

    private final static String CITY =
            "             G\n"
                    + "             G\n"
                    + "   G        GG\n"
                    + "   GG       GG\n"
                    + "   GG     G GG\n"
                    + "   GG G  GGGGGG GG\n"
                    + "   GG G  ggGGGG GG\n"
                    + "   GGGGG ggGGGG GG\n"
                    + "   gGGGG gggGGg Gv\n"
                    + " GGggGGGggGgGGg GgG\n"
                    + " GGgggGGggGggGggGggG\n"
                    + "GGGgggGGgGGggggggggG\n"
                    + " gggggggGGGGGggggggGG\n"
                    + " ggggggGGGGGGGgggggG";

    /**
     * A new object "City" is created
     *
     * @param gameView Window to show the GameObject on.
     * @param x Coordinate x of the City
     * @param y Coordinate y of the City
     */
    public City(GameView gameView, int x, int y) {
        super(gameView);
        this.position = new Position(x, y);
        this.size = 3;
        this.width = (int) (22 * size);
        this.height = (int) (14 * size);
        Color color1 = new Color(109, 60, 128);
        Color color2 = new Color(133, 81, 130);
        this.gameView.setColorForBlockImage('g', color1);
        this.gameView.setColorForBlockImage('G', color2);
        this.hitBox.width = width;
        this.hitBox.height = height;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void updateStatus() {
    }

    @Override
    protected void updateHitBoxPosition() {
        hitBox.x = (int) position.x;
        hitBox.y = (int) position.y;
    }

    @Override
    public void reactToCollision(CollidableGameObject otherObject) {
        gamePlayManager.destroy(this);
        int number = gameView.playSound("explode.wav", false);
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(CITY, position.x, position.y, size, rotation);
    }

}
