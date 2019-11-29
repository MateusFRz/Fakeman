package game;

import controller.MainController;
import game.entity.Enemy;
import game.entity.Player;
import game.input.KeyboardInput;
import game.map.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class Game {

    private static final int ENEMIES_NUMBER = 4;

    private Map map;
    private List<Enemy> enemies = new ArrayList<>();
    private Player player;
    private Timer timer;

    public Game() {
        this.player = new Player(0,0);
        for (int i=0; i<ENEMIES_NUMBER; i++)
            enemies.add(new Enemy(0,0));
    }

    public void launch() throws IOException {
        TimerTask task = new GameThread(this);

        timer = new Timer();
        timer.schedule(task, 0,1);
    }

    private List<Enemy> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }

    public Player getPlayer() {
        return player;
    }

    public void stop() {
        timer.cancel();
    }
}
