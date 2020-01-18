package game.entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class Enemy extends Entity {

    private static final String COLOR = "#aa0000";

    public Enemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        getEntity().setFill(Paint.valueOf(COLOR));
    }
}
