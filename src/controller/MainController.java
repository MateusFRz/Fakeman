package controller;

import game.Game;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class MainController {

    @FXML private BorderPane borderPane;
    @FXML private Circle playerIcon;

    private final Game game;

    public MainController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        game.getMap().setHeight((int) borderPane.getHeight());
        game.getMap().setWidth((int) borderPane.getWidth());

        playerIcon.setRadius(20);
        playerIcon.setFill(Paint.valueOf("#ede80d"));

        playerIcon.translateXProperty().bind(game.getPlayer().xProperty());
        playerIcon.translateYProperty().bind(game.getPlayer().yProperty());

    }
}
