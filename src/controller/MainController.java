package controller;

import game.Game;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MainController {

    @FXML private BorderPane borderPane;
    @FXML private Circle playerIcon;

    private final Game game;

    public MainController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        playerIcon.setRadius(20);
        playerIcon.setFill(Paint.valueOf("#ede80d"));

        playerIcon.translateXProperty().bind(game.getPlayer().xProperty());
        playerIcon.translateYProperty().bind(game.getPlayer().yProperty());

        game.getMap().heightProperty().bind(borderPane.heightProperty());
        game.getMap().widthProperty().bind(borderPane.widthProperty());
    }
}
