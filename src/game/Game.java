package game;

import game.entity.Enemy;
import game.entity.Player;
import game.entity.Point;
import game.map.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

import java.util.*;

public class Game {

    private static final int ENEMIES_NUMBER = 4;
    private static final int X_MAP = 0;
    private static final int Y_MAP = 0;

    private Map map;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Point> points = new ArrayList<>();
    private Player player;
    private Thread thread;
    private ObservableValue<? extends String> FPS;


    public Game() {
        map = new Map(X_MAP, Y_MAP);
        player = new Player(0, 0);

        for (int i=0; i<ENEMIES_NUMBER; i++)
            enemies.add(new Enemy(0,0));
    }

    public void launch() {
        thread = new Thread(new GameThread(this));

        thread.setDaemon(true);
        thread.start();
    }

    private List<Enemy> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }

    public Map getMap() { return map;}

    public Player getPlayer() {
        return player;
    }

    public void stop() {
        thread.interrupt();
    }
}
