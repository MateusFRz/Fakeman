package game.entity;

import javafx.scene.paint.Paint;

public class Enemy extends Entity {

    private static final String COLOR = "#aa0000";

    public Enemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        super.draw();
        getEntity().setFill(Paint.valueOf(COLOR));
    }
}
