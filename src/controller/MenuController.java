package controller;

import game.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuController {

    private Game game;

    @FXML TextField playerName;
    @FXML Button playBtn;
    @FXML Button scoreBtn;
    @FXML Button leaveBtn;

    public MenuController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        playerName.textProperty().bindBidirectional(game.getPlayer().nameProperty());
    }
}