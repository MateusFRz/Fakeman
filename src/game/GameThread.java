package game;

import game.entity.Player;

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
        System.out.println(player);
        switch (player.getDirection()) {
            case UP:
                player.setYProperty(player.getYProperty() + 1);
                break;
            case DOWN:
                player.setYProperty(player.getYProperty() - 1);
                break;
            case RIGHT:
                player.setXProperty(player.getXProperty() + 1);
                break;
            case LEFT:
                player.setXProperty(player.getXProperty() - 1);
                break;
            default:
                break;
        }
    }
}