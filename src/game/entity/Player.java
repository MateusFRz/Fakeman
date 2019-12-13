package game.entity;

import game.map.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player extends Entity {

    private static final int SPEED = 3;

    private final IntegerProperty scoreProperty = new SimpleIntegerProperty();
    public int getScoreProperty() { return scoreProperty.get(); }
    public void setScoreProperty(int score) { scoreProperty.set(score); }
    public IntegerProperty scoreProperty() { return scoreProperty;}

    private final IntegerProperty lifeProperty = new SimpleIntegerProperty();
    public int getLifeProperty() { return lifeProperty.get(); }
    private void setLifeProperty(int life) { lifeProperty.set(life);}
    public IntegerProperty lifeProperty() { return lifeProperty; }

    private static final int DEFAULT_LIFE_NUMBER = 3;

    public Player(int x, int y, int life) {
        super(x,y);
        this.setLifeProperty(life);
        this.setSpeed(SPEED);
    }

    public Player(int x, int y) {
        this(x,y,DEFAULT_LIFE_NUMBER);
    }

    public void die() {

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
