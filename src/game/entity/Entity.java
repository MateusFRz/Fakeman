package game.entity;

import game.input.Direction;
import game.map.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Entity {

    private final IntegerProperty xProperty = new SimpleIntegerProperty();
    public final int getXProperty() { return xProperty.get(); }
    public final void setXProperty(int x) { xProperty.set(x);}
    public IntegerProperty xProperty() { return xProperty; }

    private final IntegerProperty yProperty = new SimpleIntegerProperty();
    public final int getYProperty() { return yProperty.get(); }
    public final void setYProperty(int y) { yProperty.set(y);}
    public IntegerProperty yProperty() { return yProperty; }

    private Direction direction = Direction.NONE;

    private int speed = 1;

    public Entity(int x, int y) {
        setYProperty(y);
        setXProperty(x);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(Map map) {
        switch (getDirection()) {
            case UP:
                setYProperty(getYProperty() - (getYProperty() <= map.getMinHeight() ? 0 : getSpeed()));
                break;
            case DOWN:
                setYProperty(getYProperty() + (getYProperty() >= map.getMaxHeight() ? 0 : getSpeed()));
                break;
            case RIGHT:
                setXProperty(getXProperty() + (getXProperty() >= map.getMaxWidth() ? 0 : getSpeed()));
                break;
            case LEFT:
                setXProperty(getXProperty() - (getXProperty() <= map.getMinWidth() ? 0 : getSpeed()));
                break;
        }
    }
}
