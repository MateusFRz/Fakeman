package game.entity;

import game.collision.EntityCollision;
import game.input.Direction;
import game.map.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Entity {

    private static final String COLOR = "#ede80d";

    private final IntegerProperty xProperty = new SimpleIntegerProperty();
    public int getXProperty() { return xProperty.get(); }
    public void setXProperty(int x) { xProperty.set(x);}
    public IntegerProperty xProperty() { return xProperty; }

    private final IntegerProperty yProperty = new SimpleIntegerProperty();
    public int getYProperty() { return yProperty.get(); }
    public void setYProperty(int y) { yProperty.set(y);}
    public IntegerProperty yProperty() { return yProperty; }

    private Circle entity;

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

    public Circle getEntity() {
        return entity;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(Map map, EntityCollision collision) {
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

    public void draw() {
        entity = new Circle();

        entity.translateXProperty().bind(xProperty);
        entity.translateYProperty().bind(yProperty);

        entity.setRadius(20);
        entity.setFill(Paint.valueOf(COLOR));
    }
}
