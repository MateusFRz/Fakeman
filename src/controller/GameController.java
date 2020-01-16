package controller;

import game.Game;
import game.entity.Entity;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {

    @FXML private BorderPane borderPane;
    @FXML private Text score;
    @FXML private Text life;

    private final Game game;



    public GameController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        for (Entity entities : game.getEntityList()) {
            entities.draw();
            borderPane.getChildren().add(entities.getEntity());
        }

        game.getMap().heightProperty().bind(borderPane.heightProperty());
        game.getMap().widthProperty().bind(borderPane.widthProperty());

        score.textProperty().bind(Bindings.format("Score: %s", game.getPlayer().scoreProperty()));
        life.textProperty().bind(Bindings.format("Life: %s", game.getPlayer().lifeProperty()));
    }
}
