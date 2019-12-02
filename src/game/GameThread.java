package game;

import game.entity.Player;
import game.map.Map;

import java.util.TimerTask;

public class GameThread extends TimerTask {

    private Game game;
    private Player player;

    GameThread(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    @Override
    public void run() {
        Map map = game.getMap();
        switch (player.getDirection()) {
            case UP:
                player.setYProperty(player.getYProperty() -
                        (player.getYProperty() <= map.getMinHeight() ? 0 : player.getSpeed()));
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
    }
}