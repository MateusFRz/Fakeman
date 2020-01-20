package game.entity;

import javafx.scene.layout.Pane;

public class Point extends Entity {

    private static final int VALUE = 1;
    private static final int RADIUS = 9;

    private int value;

    public Point(int x, int y) {
        super(x, y);
        this.value = VALUE;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        getEntity().setRadius(RADIUS);
    }

    @Override
    public String toString() {
        return "Point {" +
                "x=" + getXProperty() +
                ", y=" + getYProperty() +
                '}';
    }
}
