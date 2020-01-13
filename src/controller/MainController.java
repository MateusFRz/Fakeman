package controller;

import game.Game;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class MainController {

    @FXML private BorderPane borderPane;
    @FXML private Circle playerIcon;
    @FXML private Text score;
    @FXML private Text life;
    @FXML private Circle point1;

    private final Game game;

    private static final String PLAYER_COLOR = "#ede80d";

    public MainController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        playerIcon.setRadius(20);
        playerIcon.setFill(Paint.valueOf(PLAYER_COLOR));

        playerIcon.translateXProperty().bind(game.getPlayer().xProperty());
        playerIcon.translateYProperty().bind(game.getPlayer().yProperty());

        point1.setRadius(5);
        point1.setFill(Paint.valueOf("#ede80d"));

        point1.setCenterX(200);
        point1.setCenterY(200);



        game.getMap().heightProperty().bind(borderPane.heightProperty());
        game.getMap().widthProperty().bind(borderPane.widthProperty());

        score.textProperty().bind(Bindings.format("Score: %s", game.getPlayer().scoreProperty()));

        life.textProperty().bind(SimpleStringProperty.stringExpression(game.getPlayer().lifeProperty()));
    }
}
