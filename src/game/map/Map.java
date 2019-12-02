package game.map;

public class Map {

    private final int height, width, x, y;

    public Map(int height, int width, int x, int y) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
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

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getMinHeight() {
        return getY() - (getHeight()/2);
    }


    public int getMaxHeight() {
        return getY() + (getHeight()/2);
    }


    public int getMinWidth() {
        return getX() - (getWidth()/2);
    }


    public int getMaxWidth() {
        return getX() + (getWidth()/2);
    }

    /*@Override
    public String toString() {
        return "Map{" +
                "height=" + height +
                ", width=" + width +
                ", x=" + x +
                ", y=" + y +
                ", minHeight=" + getMinHeight() +
                ", maxHeight=" + getMaxHeight() +
                ", minWidth=" + getMinWidth() +
                ", maxWidth=" + getMaxWidth() +
                '}';
    }*/
}
