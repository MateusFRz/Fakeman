package game.entity;

import exception.DeadException;
import game.Game;
import game.collision.EntityCollision;
import game.map.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Player extends Entity implements Serializable {

    private static final long serialVersionUID = 654685343540L;
    private transient static final int DEFAULT_LIFE_NUMBER = 3;
    private transient static final int SPEED = 3;
    private transient static final String DEFAULT_NAME = "Player Name";

    private transient Text tag = new Text();

    private transient final IntegerProperty scoreProperty = new SimpleIntegerProperty();
    private transient final IntegerProperty lifeProperty = new SimpleIntegerProperty();
    private transient final StringProperty nameProperty = new SimpleStringProperty();

    public Player(int x, int y, String name, int life) {
        super(x, y);
        setNameProperty(name);
        this.setLifeProperty(life);
        this.setSpeed(SPEED);
    }

    public Player(int x, int y, String name) {
        this(x, y, name, DEFAULT_LIFE_NUMBER);
    }

    public Player(int x, int y) {
        this(x, y, DEFAULT_NAME);
    }

    public int getScoreProperty() {
        return scoreProperty.get();
    }

    public void setScoreProperty(int score) {
        scoreProperty.set(score);
    }

    public IntegerProperty scoreProperty() {
        return scoreProperty;
    }

    public int getLifeProperty() {
        return lifeProperty.get();
    }

    public void setLifeProperty(int life) {
        lifeProperty.set(life);
    }

    public IntegerProperty lifeProperty() {
        return lifeProperty;
    }

    public String getNameProperty() {
        return nameProperty.get();
    }

    private void setNameProperty(String name) {
        nameProperty.set(name);
    }

    public StringProperty nameProperty() {
        return nameProperty;
    }

    public void eat(Point point) {
        setScoreProperty(getScoreProperty() + point.getValue());
    }

    public void die() throws DeadException {
        if (getLifeProperty() == 0)
            throw new DeadException();
        setLifeProperty(getLifeProperty() - 1);
    }

    @Override
    public void move(Game game, EntityCollision collision) {
        super.move(game, collision);
        try {
            if (collision.isHitting(this)) {
                if (collision.getEntityHit() instanceof Point) {
                    eat((Point) collision.getEntityHit());
                    game.removeEntity(collision.getEntityHit());
                } else die();
            }
        } catch (DeadException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        inputStream.defaultReadObject();
        setScoreProperty(inputStream.readInt());
        setNameProperty(inputStream.readUTF());
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeInt(getScoreProperty());
        outputStream.writeUTF(getNameProperty());
    }

    @Override
    public void draw(Pane pane) {
        super.draw(pane);

        tag.textProperty().bind(nameProperty);

        tag.translateXProperty().bind(xProperty());
        tag.translateYProperty().bind(yProperty());

        pane.getChildren().add(tag);
    }

    @Override
    public String toString() {
        return "Player {" +
                "scoreProperty=" + scoreProperty +
                ", lifeProperty=" + lifeProperty +
                ", direction=" + getDirection() +
                ", x=" + getXProperty() +
                ", y=" + getYProperty() +
                '}';
    }
}
