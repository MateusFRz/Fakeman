package game;

import game.collision.EntityCollision;
import game.entity.Enemy;
import game.entity.Entity;
import game.entity.Player;
import game.entity.Point;
import game.map.Map;

import java.util.*;

public class Game {

    private static final int POINT_NUMBER = 4;
    private static final int ENEMIES_NUMBER = 4;
    private static final int X_MAP = 0;
    private static final int Y_MAP = 0;

    private Map map;
    private List<Entity> entities = new ArrayList<>();
    private EntityCollision collision;
    private EntityCollision col;
    private Player player;
    private Thread thread;
    private Point point1;
    private Point point2;
    private List<Entity> ent;


    public Game() {
        map = new Map(X_MAP, Y_MAP);
        player = new Player(10, 10);

        point1 = new Point(200,200);
        point2 = new Point(400,400);
        ent.add(point1);
        ent.add(point2);
        col = new EntityCollision(ent);
        col.isHitting(player);

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

    public List<Entity> getEntityListPoint() {
        return Collections.unmodifiableList(ent);
    }
    public EntityCollision getCollision() {
        return collision;
    }

    public void stop() {
        thread.interrupt();
    }
}
