package game;

import game.collision.EntityCollision;
import game.entity.Entity;
import game.entity.Player;
import game.entity.Point;
import game.input.Direction;
import game.map.Map;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private static final int ENEMIES_NUMBER = 4;
    private static final int X_MAP = 0;
    private static final int Y_MAP = 0;

    private Map map;
    private List<Entity> entities = new ArrayList<>();
    private EntityCollision collision;
    private Player player;
    private Thread thread;
    private GameThread gameThread;
    private final BooleanProperty pauseProperty = new SimpleBooleanProperty();

    public Game() {
        map = new Map(X_MAP, Y_MAP);
        player = new Player(100, 100);

        gameThread = new GameThread(this);
    }

    public void setup() {
        entities.removeAll(entities);

        player.setXProperty(100);
        player.setYProperty(100);
        player.setScoreProperty(0);
        player.setLifeProperty(3);
        player.setDirection(Direction.NONE);

        entities.add(player);
        entities.add(new Point(200, 200));

        /*for (int i=0; i<ENEMIES_NUMBER; i++)
            entities.add(new Enemy(0,0));*/
        collision = new EntityCollision(entities);

        gameThread.start();
    }

    public void launch() {
        setup();

        thread = new Thread(gameThread);
        thread.setDaemon(true);

        thread.start();
        setPauseProperty(false);
    }

    public List<Entity> getEntityList() {
        return Collections.unmodifiableList(entities);
    }

    public void removeEntity(Entity entity) {
        entity.remove();
        entities.remove(entity);
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public EntityCollision getCollision() {
        return collision;
    }

    public void setPauseProperty(boolean pause) {
        pauseProperty.set(pause);
        if (pause) thread.suspend(); ///Resume thread
        else thread.resume();
    }

    public boolean getPauseProperty() {
        return pauseProperty.get();
    }

    public BooleanProperty pauseProperty() { return pauseProperty; }

    public void stop() {
        gameThread.stop();
    }
}
