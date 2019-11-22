package game;

import game.entity.Enemy;
import game.entity.Player;
import game.map.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private Map map;
    private List<Enemy> enemies = new ArrayList<>();
    private Player player;

    public Game() {
        player = new Player(0,0);
        for (int i=0; i<4; i++)
            enemies.add(new Enemy(0,0));
    }

    public void launch() {
    }

    private List<Enemy> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }
}
