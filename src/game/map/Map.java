package game.map;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * This is a model class to hold map information
 * */
public class Map {


    private static final int DEFAULT_X = 0;
    private static final int DEFAULT_Y = 0;

    private final int x, y;
    private final IntegerProperty heightProperty = new SimpleIntegerProperty();
    private final IntegerProperty widthProperty = new SimpleIntegerProperty();


    /**
     * Map constructor initialize x and y coords
     *
     * @param x Coordinate on the x axis
     * @param y Coordinate on the y axis
     * */
    public Map(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Map constructor initialize default coords
     * */
    public Map() {
        this(DEFAULT_X, DEFAULT_Y);
    }

    public IntegerProperty heightProperty() {
        return heightProperty;
    }

    public IntegerProperty widthProperty() {
        return widthProperty;
    }

    /**
     * Return the center of the map on Y
     *
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Return the center of the map on X
     *
     * @return int
     */
    public int getX() {
        return x;
    }

    public int getMinHeight() {
        return getY();
    }

    public int getMaxHeight() {
        return getY() + getHeightProperty();
    }

    public int getMinWidth() {
        return getX();
    }

    public int getMaxWidth() {
        return getX() + getWidthProperty();
    }

    public int getWidthProperty() {
        return widthProperty.get();
    }

    public int getHeightProperty() {
        return heightProperty.get();
    }

    @Override
    public String toString() {
        return "Map{" +
                "height=" + getHeightProperty() +
                ", width=" + getWidthProperty() +
                ", x=" + x +
                ", y=" + y +
                ", minHeight=" + getMinHeight() +
                ", maxHeight=" + getMaxHeight() +
                ", minWidth=" + getMinWidth() +
                ", maxWidth=" + getMaxWidth() +
                '}';
    }
}
