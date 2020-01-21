package game;

import controller.MenuController;
import game.collision.EntityCollision;
import game.entity.Enemy;
import game.entity.Entity;
import game.entity.Player;
import game.entity.Point;
import game.input.Direction;
import game.map.Map;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a model class to hold game information
 * */
public class Game {

    private static final int ENEMIES_NUMBER = 4;
    private static final int X_MAP = 0;
    private static final int Y_MAP = 0;

    private static final String FXML_PATH_MENU = "menu.fxml";

    private Map map;
    private List<Entity> entities = new ArrayList<>();
    private EntityCollision collision;
    private Player player;
    private Thread thread;
    private GameThread gameThread;
    private final BooleanProperty pauseProperty = new SimpleBooleanProperty();
    private GameState state;
    private Stage stage;

    /**
     * Game constructor initialize instance stage
     *
     * @param stage this the main stage of the app
     * @see Map
     * @see Player
     * @see GameThread
     * */
    public Game(Stage stage) {
        map = new Map(X_MAP, Y_MAP);
        player = new Player(100, 100);
        this.stage = stage;

        gameThread = new GameThread(this);
    }

    /**
     * Setup a new game
     *
     * @see Point
     * @see Enemy
     * @see EntityCollision
     * */
    public void setup() {
        state = null;
        entities.removeAll(entities);

        player.setXProperty(100);
        player.setYProperty(100);
        player.setScoreProperty(0);
        player.setLifeProperty(3);
        player.setDirection(Direction.NONE);

        entities.add(player);
        entities.add(new Point(200, 200));
        entities.add(new Enemy(0,0));

        collision = new EntityCollision(entities);

        gameThread.start();
    }

    /**
     * Start the game by starting the game Thread
     *
     * @see Thread
     * */
    public void launch() {
        setup();

        thread = new Thread(gameThread);
        thread.setDaemon(true);

        thread.start();
        setPauseProperty(false);
    }

    /**
     * End the game
     *
     * @see MenuController
     * @see FXMLLoader
     * @see Scene
     * */
    public void end() {
        try {
            stop();

            MenuController menu = new MenuController(this);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_PATH_MENU));
            fxmlLoader.setController(menu);
            Scene scene = new Scene(fxmlLoader.load());

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Detect the end of the game by checking if the player
     * still have life or have point in the map
     *
     * @see Entity
     * @see GameState
     * */
    public void detectEnd() {

        for (Entity entity : entities) {
            if (entity instanceof Player && ((Player) entity).getLifeProperty() == 0) {
                state = GameState.LOSE;
                end();
                return;
            } else if (entity instanceof Point)
                return;
        }

        state = GameState.WIN;
        end();
    }

    /**
     * Stop the actual game
     * */
    public void stop() {
        setPauseProperty(true);
        gameThread.stop();
    }

    /**
     * Get unmodifiable entities list
     *
     * @return list <code>Collections</code>
     * */
    public List<Entity> getEntityList() {
        return Collections.unmodifiableList(entities);
    }

    /**
     * Remove entity for the vue and the entities list
     *
     * @param entity Entity to remove
     * */
    public void removeEntity(Entity entity) {
        entity.remove();
        entities.remove(entity);
    }

    /**
     * Get the game map
     *
     * @return map <code>Map</code>
     * */
    public Map getMap() {
        return map;
    }

    /**
     * Get player
     *
     * @return player <code>Player</code>
     * */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get collision
     *
     * @return collision <code>EntityCollision</code>
     * */
    public EntityCollision getCollision() {
        return collision;
    }

    /**
     * Get stage
     *
     * @return stage <code>Stage</code>
     * */
    public Stage getStage() {
        return stage;
    }

    /**
     * Set pause
     *
     * @param pause
     * */
    public void setPauseProperty(boolean pause) {
        pauseProperty.set(pause);
        if (pause) thread.suspend(); ///Resume thread
        else thread.resume();
    }

    public boolean getPauseProperty() {
        return pauseProperty.get();
    }

    public BooleanProperty pauseProperty() {
        return pauseProperty;
    }

    /**
     * Get game state
     *
     * @return state <code>GameState</code>
     * */
    public GameState getState() {
        return state;
    }
}
