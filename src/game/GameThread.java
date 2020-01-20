package game;

import game.entity.Player;
import game.map.Map;


public class GameThread implements Runnable {

    private static final int SLEEP_TIME_MS = 16;

    private Game game;
    private Player player;
    private boolean exit = false;

    GameThread(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    @Override
    public void run() {
        while (!exit) {
            player.move(game, game.getCollision());

            game.detectEnd();

            try {
                Thread.sleep(SLEEP_TIME_MS);
            } catch (InterruptedException ignored) {}
        }
    }

    public void stop() {
        exit = true;
    }

    public void start() {
        exit = false;
    }
}