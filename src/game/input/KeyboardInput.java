package game.input;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardInput implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Z:
                //UP
                break;
            case Q:
                //LEFT
                break;
            case S:
                //DOWN
                break;
            case D:
                //RIGHT
                break;
            case ESCAPE:
                //PAUSE
                break;
        }
    }
}
