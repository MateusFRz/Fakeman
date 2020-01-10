package controller;

import game.Game;
import game.event.MusicEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MenuController {

    private Game game;

    @FXML private TextField playerName;
    @FXML private Button playBtn;
    @FXML private Button scoreBtn;
    @FXML private Button leaveBtn;
    @FXML private ComboBox<String> music;

    public MenuController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        playerName.textProperty().bindBidirectional(game.getPlayer().nameProperty());

        music.getItems().addAll("manu.mp3", "fausse.mp3", "pacman.mp3");
        music.setOnAction(new MusicEvent());
    }
}