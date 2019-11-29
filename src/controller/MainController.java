package controller;

import game.Game;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class MainController {

    @FXML private Rectangle map;
    @FXML private GridPane gridPane;
    @FXML private Circle playerIcon;

    private final Game game;

    public MainController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        gridPane.setMinSize(1536,768);

        playerIcon.setRadius(20);
        playerIcon.setFill(Paint.valueOf("#ede80d"));

        playerIcon.centerXProperty().bind(game.getPlayer().xProperty());
        playerIcon.centerYProperty().bind(game.getPlayer().yProperty());

//        map.setFill(Color.TRANSPARENT);
//        map.setStroke(Color.BLACK);
    }
}
