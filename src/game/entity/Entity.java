package game.entity;

import game.Game;
import game.collision.EntityCollision;
import game.input.Direction;
import game.map.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Entity {

    private static final String COLOR = "#ede80d";
    private static final double RADIUS = 15;

    private final IntegerProperty xProperty = new SimpleIntegerProperty();
    private final IntegerProperty yProperty = new SimpleIntegerProperty();
    private Circle entity = new Circle();
    private Direction direction = Direction.NONE;
    private int speed = 1;

    public Entity(int x, int y) {
        setYProperty(y);
        setXProperty(x);
    }

    public int getXProperty() {
        return xProperty.get();
    }

    public void setXProperty(int x) {
        xProperty.set(x);
    }

    public IntegerProperty xProperty() {
        return xProperty;
    }

    public int getYProperty() {
        return yProperty.get();
    }

    public void setYProperty(int y) {
        yProperty.set(y);
    }

    public IntegerProperty yProperty() {
        return yProperty;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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

    public void move(Game game, EntityCollision collision) {
        switch (getDirection()) {
            case UP:
                setYProperty(getYProperty() - (getYProperty() <= game.getMap().getMinHeight() ? 0 : getSpeed()));
                break;
            case DOWN:
                setYProperty(getYProperty() + (getYProperty() >= game.getMap().getMaxHeight() ? 0 : getSpeed()));
                break;
            case RIGHT:
                setXProperty(getXProperty() + (getXProperty() >= game.getMap().getMaxWidth() ? 0 : getSpeed()));
                break;
            case LEFT:
                setXProperty(getXProperty() - (getXProperty() <= game.getMap().getMinWidth() ? 0 : getSpeed()));
                break;
        }
    }

    public void remove() {
        getEntity().visibleProperty().setValue(false);
        getEntity().setDisable(true);
    }

    public void draw(Pane pane) {

        entity.translateXProperty().bind(xProperty);
        entity.translateYProperty().bind(yProperty);

        entity.setRadius(RADIUS);
        entity.setFill(Paint.valueOf(COLOR));

        pane.getChildren().add(entity);
    }
}
