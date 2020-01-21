package game.entity;

import exception.DeadException;
import game.Game;
import game.collision.EntityCollision;
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

/**
 * This is a model class to hold player information
 * */
public class Player extends Entity implements Serializable {

    private static final long serialVersionUID = 654685343540L;
    private transient static final int DEFAULT_LIFE_NUMBER = 3;
    private transient static final int SPEED = 3;
    private transient final IntegerProperty scoreProperty = new SimpleIntegerProperty();
    private transient final IntegerProperty lifeProperty = new SimpleIntegerProperty();
    private transient final StringProperty nameProperty = new SimpleStringProperty();
    private transient Text tag = new Text();

    /**
     * Player constructor initialize instance variables
     *
     * @param x Coordinate on x axis
     * @param y Coordinate on y axis
     * @param life Number of player life
     * */
    public Player(int x, int y, int life) {
        super(x, y);
        this.setLifeProperty(life);
        this.setSpeed(SPEED);
    }

    /**
     * Player constructor initialize instance variables
     *
     * @param x Coordinate on x axis
     * @param y Coordinate on y axis
     */
    public Player(int x, int y) {
        this(x, y, DEFAULT_LIFE_NUMBER);
    }

    /**
     * Call when a player eat a <code>Point</code>
     *
     * @param point Point ate
     */
    public void eat(Point point) {
        setScoreProperty(getScoreProperty() + point.getValue());
    }

    /**
     * Call when a player die when touch a enemy
     *
     * @throws DeadException If the player already die the Exception is send
     */
    public void die() throws DeadException {
        if (getLifeProperty() == 0)
            throw new DeadException();
        setLifeProperty(getLifeProperty() - 1);
    }


    /**
     * Move the player on the map
     *
     * @param collision The game collision
     * @param game      The actual player game
     */
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

    /**
     * Write non-readable object like Property
     *
     * @param inputStream Input put stream
     * @throws ClassNotFoundException Class Not Found Exception
     * @throws IOException            Input Output Exception
     * @see ObjectInputStream
     */
    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        inputStream.defaultReadObject();
        setScoreProperty(inputStream.readInt());
        setNameProperty(inputStream.readUTF());
    }

    /**
     * Write non-writable object like Property
     *
     * @param outputStream Out put stream
     * @throws IOException Input Output Exception
     * @see ObjectInputStream
     */
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeInt(getScoreProperty());
        outputStream.writeUTF(getNameProperty());
    }

    /**
     * Draw the player in a Pane
     *
     * @param pane Actual application layout
     */
    @Override
    public void draw(Pane pane) {
        super.draw(pane);

        tag.textProperty().bind(nameProperty);

        tag.translateXProperty().bind(xProperty());
        tag.translateYProperty().bind(yProperty());

        pane.getChildren().add(tag);
    }

    public IntegerProperty scoreProperty() {
        return scoreProperty;
    }

    public IntegerProperty lifeProperty() {
        return lifeProperty;
    }

    public StringProperty nameProperty() {
        return nameProperty;
    }

    public int getScoreProperty() {
        return scoreProperty.get();

    }

    public void setScoreProperty(int score) {
        scoreProperty.set(score);
    }

    public int getLifeProperty() {
        return lifeProperty.get();
    }

    public void setLifeProperty(int life) {
        lifeProperty.set(life);
    }

    public String getNameProperty() {
        return nameProperty.get();
    }

    private void setNameProperty(String name) {
        nameProperty.set(name);
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
