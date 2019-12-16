package game.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.Transient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Player extends Entity implements Serializable {

    private static final int SPEED = 3;
    private static final long serialVersionUID = 654685343540L;


    private transient final IntegerProperty scoreProperty = new SimpleIntegerProperty();
    public int getScoreProperty() { return scoreProperty.get(); }
    public void setScoreProperty(int score) { scoreProperty.set(score); }
    public IntegerProperty scoreProperty() { return scoreProperty;}

    private transient final IntegerProperty lifeProperty = new SimpleIntegerProperty();
    public int getLifeProperty() { return lifeProperty.get(); }
    private void setLifeProperty(int life) { lifeProperty.set(life);}
    public IntegerProperty lifeProperty() { return lifeProperty; }

    private transient final StringProperty nameProperty = new SimpleStringProperty();
    public String getNameProperty() { return nameProperty.get(); }
    private void setNameProperty(String name) { nameProperty.set(name); }
    public StringProperty nameProperty() { return nameProperty; }

    private transient static final int DEFAULT_LIFE_NUMBER = 3;

    public Player(int x, int y, String name, int life) {
        super(x,y);
        setNameProperty(name);
        this.setLifeProperty(life);
        this.setSpeed(SPEED);
    }

    public Player(int x, int y, String name) {
        this(x, y, name, DEFAULT_LIFE_NUMBER);
    }

    public void die() {

    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    @Override
    public String toString() {
        return "Player{" +
                "scoreProperty=" + scoreProperty +
                ", lifeProperty=" + lifeProperty +
                ", direction=" + getDirection() +
                ", x=" + getXProperty() +
                ", y=" + getYProperty() +
                '}';
    }
}
