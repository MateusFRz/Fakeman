package game;

import game.entity.Enemy;
import game.entity.Player;
import game.input.KeyboardInput;
import game.map.Map;
import javafx.scene.Scene;

import java.util.*;

public class Game {

    private Map map;
    private List<Enemy> enemies = new ArrayList<>();
    private Player player;

    public Game() {
        this.player = new Player(0,0);
        for (int i=0; i<4; i++)
            enemies.add(new Enemy(0,0));
    }

    public void launch(Scene scene) {
        TimerTask task = new GameThread(this);
        Timer timer = new Timer();

        timer.schedule(task, 0,1);

        scene.setOnKeyPressed(new KeyboardInput(this));
    }

    private List<Enemy> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }

    public Player getPlayer() {
        return player;
    }
}
