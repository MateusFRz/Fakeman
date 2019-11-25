package game.input;

import game.Game;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyboardInput implements EventHandler<KeyEvent> {

    private Game game;

    public KeyboardInput(Game game) {
        this.game = game;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Z:
                game.getPlayer().setDirection(Direction.UP);
                break;
            case Q:
                game.getPlayer().setDirection(Direction.LEFT);
                break;
            case S:
                game.getPlayer().setDirection(Direction.DOWN);
                break;
            case D:
                game.getPlayer().setDirection(Direction.RIGHT);
                break;
            case ESCAPE:
                //PAUSE
                break;
        }
    }
}
