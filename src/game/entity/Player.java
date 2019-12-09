package game.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player extends Entity {

    public static final int SPEED = 3;

    private final IntegerProperty scoreProperty = new SimpleIntegerProperty();
    public final int getScoreProperty() { return scoreProperty.get(); }
    public final void setScoreProperty(int score) { scoreProperty.set(score); }
    public final IntegerProperty scoreProperty() { return scoreProperty;}

    private final IntegerProperty lifeProperty = new SimpleIntegerProperty();
    public final int getLifeProperty() { return lifeProperty.get(); }
    public final void setLifeProperty(int life) { lifeProperty.set(life);}
    public final IntegerProperty lifeProperty() { return lifeProperty; }

    private static final int DEFAULT_LIFE_NUMBER = 3;

    public Player(int x, int y, int life) {
        super(x,y);
        this.setLifeProperty(life);
        this.setSpeed(SPEED);
    }

    public Player(int x, int y) {
        this(x,y,DEFAULT_LIFE_NUMBER);
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
