package game.map;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Map {


    private final IntegerProperty heightProperty = new SimpleIntegerProperty();
    public int getHeightProperty() { return heightProperty.get(); }
    public void setHeightProperty(int height) { heightProperty.set(x);}
    public IntegerProperty heightProperty() { return heightProperty; }

    private final IntegerProperty widthProperty = new SimpleIntegerProperty();
    public int getWidthProperty() { return widthProperty.get(); }
    public void setWidthProperty(int width) { widthProperty.set(x);}
    public IntegerProperty widthProperty() { return widthProperty; }

    private final int x, y;

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Map() {
        this(0,0);
    }

    /**
     * Return the center of the map on Y
     * @return int
     * */
    public int getY() {
        return y;
    }

    /**
     * Return the center of the map on X
     * @return int
     * */
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
