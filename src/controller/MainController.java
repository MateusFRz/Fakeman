package controller;

import javafx.fxml.FXML;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MainController {

    @FXML
    private Circle playerIcon;

    @FXML
    private void initialize() {
        playerIcon.setCenterX(0);
        playerIcon.setCenterY(0);
        playerIcon.setRadius(20);

        playerIcon.setFill(Paint.valueOf("#ede80d"));
    }
}
