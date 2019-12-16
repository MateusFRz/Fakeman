package game;

import game.entity.Player;
import game.map.Map;
import game.entity.Point;


public class GameThread implements Runnable {

    private Game game;
    private Player player;
    private Point point;

    GameThread(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    @Override
    public void run() {
        while (true) {

            Map map = game.getMap();
            player.move(map);

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}