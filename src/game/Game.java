package game;

import game.entity.Enemy;
import game.entity.Player;
import game.map.Map;

import java.io.IOException;
import java.util.*;

public class Game {

    private static final int ENEMIES_NUMBER = 4;
    public static final int HEIGHT = 512;
    public static final int WIDTH = 512;
    public static final int X_MAP = 750;
    public static final int Y_MAP = 256;

    private Map map;
    private List<Enemy> enemies = new ArrayList<>();
    private Player player;
    private Timer timer;

    public Game() {
        map = new Map(HEIGHT, WIDTH, X_MAP, Y_MAP);
        this.player = new Player(map.getX(), map.getY());
        for (int i=0; i<ENEMIES_NUMBER; i++)
            enemies.add(new Enemy(0,0));
    }

    public void launch() throws IOException {
        TimerTask task = new GameThread(this);

        timer = new Timer();
        timer.schedule(task, 0,20);
    }

    private List<Enemy> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }

    public Map getMap() { return map;}

    public Player getPlayer() {
        return player;
    }

    public void stop() {
        timer.cancel();
    }
}
