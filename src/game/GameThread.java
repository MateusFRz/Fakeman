package game;

import game.entity.Player;
import game.map.Map;
import javafx.concurrent.Task;

import java.util.TimerTask;

public class GameThread implements Runnable {

    private Game game;
    private Player player;

    GameThread(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    @Override
    public void run() {
        while (true) {

            Map map = game.getMap();
            System.out.println(player);
            switch (player.getDirection()) {
                case UP:
                    player.setYProperty(player.getYProperty() - (player.getYProperty() <= map.getMinHeight() ? 0 : player.getSpeed()));
                    break;
                case DOWN:
                    player.setYProperty(player.getYProperty() + (player.getYProperty() >= map.getMaxHeight() ? 0 : player.getSpeed()));
                    break;
                case RIGHT:
                    player.setXProperty(player.getXProperty() + (player.getXProperty() >= map.getMaxWidth() ? 0 : player.getSpeed()));
                    break;
                case LEFT:
                    player.setXProperty(player.getXProperty() - (player.getXProperty() <= map.getMinWidth() ? 0 : player.getSpeed()));
                    break;
            }

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}