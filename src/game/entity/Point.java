package game.entity;

import javafx.scene.layout.Pane;

/**
 * This is a model class to hold point information
 *
 * @see Entity
 * */
public class Point extends Entity {

    private static final int VALUE = 1;
    private static final int RADIUS = 9;

    private int value;

    /**
     * Map constructor initialize x, y coords and point value
     *
     * @param x Coordinate on the x axis
     * @param y Coordinate on the y axis
     * */
    public Point(int x, int y) {
        super(x, y);
        this.value = VALUE;
    }

    public int getValue() {
        return value;
    }


    /**
     * Draw the point in a Pane
     *
     * @param pane Actual application layout
     * */
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
