package controller;

import game.Game;
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
    @FXML private ComboBox music;

    public MenuController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        playerName.textProperty().bindBidirectional(game.getPlayer().nameProperty());

        music.getItems().addAll("notre projet");
    }
}