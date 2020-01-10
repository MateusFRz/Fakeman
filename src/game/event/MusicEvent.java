package game.event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicEvent implements EventHandler<ActionEvent> {

    private MediaPlayer player;

    @Override
    public void handle(ActionEvent event) {
        ComboBox comboBox = (ComboBox) event.getSource();

        if (player != null) player.stop();
        player = new MediaPlayer(new Media(getClass().getClassLoader().getResource(comboBox.getValue().toString()).toString()));
        player.play();
    }
}
