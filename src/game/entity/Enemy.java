package game.entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class Enemy extends Entity {

    /**
     * Red color
     * */
    private static final String COLOR = "#aa0000";


    /**
     * */
    public Enemy(int x, int y) {
        super(x, y);
    }

    /**
     * Draw the enemy in a Pane
     *
     * @param pane Actual application layout
     * */
    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        getEntity().setFill(Paint.valueOf(COLOR));
    }
}
