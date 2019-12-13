package game;

import game.collision.EntityCollision;
import game.entity.Enemy;
import game.entity.Entity;
import game.entity.Player;
import game.entity.Point;
import game.map.Map;

import java.util.*;

public class Game {

    private static final int ENEMIES_NUMBER = 4;
    private static final int X_MAP = 0;
    private static final int Y_MAP = 0;

    private Map map;
    private List<Entity> entities = new ArrayList<>();
    private EntityCollision collision;
    private Player player;
    private Thread thread;


    public Game() {
        map = new Map(X_MAP, Y_MAP);
        player = new Player(0, 0);

        for (int i=0; i<ENEMIES_NUMBER; i++)
            entities.add(new Enemy(0,0));

        collision = new EntityCollision(entities);
    }

    public void launch() {
        thread = new Thread(new GameThread(this));

        thread.setDaemon(true);
        thread.start();
    }

    private List<Entity> getEntityList() {
        return Collections.unmodifiableList(entities);
    }

    public Map getMap() { return map;}

    public Player getPlayer() {
        return player;
    }

    public EntityCollision getCollision() {
        return collision;
    }

    public void stop() {
        thread.interrupt();
    }
}
