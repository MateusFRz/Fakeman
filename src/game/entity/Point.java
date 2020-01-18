package game.entity;

public class Point extends Entity {

    private static final int DEFAULT_VALUE = 1;

    private int value;

    public Point(int x, int y) {
        super(x, y);
        this.value = DEFAULT_VALUE;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Point {" +
                "x=" + getXProperty() +
                ", y=" + getYProperty() +
                '}';
    }
}
