package controller;

import game.Game;
import game.entity.Entity;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.List;

public class MainController {

    @FXML private BorderPane borderPane;
    @FXML private Circle playerIcon;
    @FXML private Circle point;
    @FXML private List<Entity> ent;

    private final Game game;

    public MainController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        playerIcon.setRadius(20);
        playerIcon.setFill(Paint.valueOf("#ede80d"));

        point.setRadius(5);
        point.setFill(Paint.valueOf("#ede80d"));
        ent=game.getEntityListPoint();

        for(int i=1; i>0 ; i++){
            point.setCenterX(ent.get(i).getXProperty());
            point.setCenterY(ent.get(i).getYProperty());
        }
        playerIcon.translateXProperty().bind(game.getPlayer().xProperty());
        playerIcon.translateYProperty().bind(game.getPlayer().yProperty());

        game.getMap().heightProperty().bind(borderPane.heightProperty());
        game.getMap().widthProperty().bind(borderPane.widthProperty());
    }
}
