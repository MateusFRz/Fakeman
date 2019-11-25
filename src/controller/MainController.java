package controller;

import game.entity.Player;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class MainController {

    @FXML private Rectangle map;
    @FXML private GridPane gridPane;
    @FXML private Circle playerIcon;

    @FXML
    private void initialize() {
        gridPane.setMinSize(1536,768);

        playerIcon.setRadius(20);

        playerIcon.centerXProperty().bind();

        playerIcon.setFill(Paint.valueOf("#ede80d"));

        map.setFill(Color.TRANSPARENT);
        map.setStroke(Color.BLACK);
    }
}
