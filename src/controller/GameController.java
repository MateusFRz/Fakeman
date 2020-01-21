package controller;

import game.Game;
import game.entity.Entity;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * Class associated to <code>game.fxml</code> that represent all action do in the graphic application
 * */
public class GameController {

    private static final String SCORE_FORMAT = "Score: %s";
    private static final String LIFE_FORMAT = "Life: %s";

    private final Game game;

    @FXML
    private BorderPane borderPane;
    @FXML
    private Text score;
    @FXML
    private Text life;
    @FXML
    private Text pause;
    @FXML
    private Button leave;


    public GameController(Game game) {
        this.game = game;
    }

    /**
     * Call when fxml is interpreted to build graphic layout
     * */
    @FXML
    private void initialize() {
        game.launch();

        for (Entity entities : game.getEntityList())
            entities.draw(borderPane);

        game.getMap().heightProperty().bind(borderPane.heightProperty());
        game.getMap().widthProperty().bind(borderPane.widthProperty());

        score.textProperty().bind(Bindings.format(SCORE_FORMAT, game.getPlayer().scoreProperty()));
        life.textProperty().bind(Bindings.format(LIFE_FORMAT, game.getPlayer().lifeProperty()));

        pause.visibleProperty().bind(game.pauseProperty());
        leave.visibleProperty().bind(game.pauseProperty());
    }

    /**
     *
     * @param event Type of event called
     * */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        game.end();
    }
}
