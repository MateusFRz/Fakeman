package game;

import game.entity.Player;

/**
 * This is the game Thread
 *
 * @see Runnable
 * */
public class GameThread implements Runnable {

    /**
     * Loop time
     * */
    private static final int SLEEP_TIME_MS = 16;

    private Game game;
    private Player player;
    private boolean exit = false;


    /**
     * GameThread constructor
     *
     * @param game The actual game
     * */
    GameThread(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    /**
     * Actions made every <code>SLEEP_TIME_MS</code> millisecond
     * */
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

    /**
     * Stop thread
     * */
    public void stop() {
        exit = true;
    }

    /**
     * Start thread
     * */
    public void start() {
        exit = false;
    }
}