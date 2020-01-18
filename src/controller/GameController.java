package controller;

import game.Game;
import game.entity.Entity;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

    private static final String SCORE_FORMAT = "Score: %s";
    private static final String LIFE_FORMAT = "Life: %s";
    private static final String FXML_PATH_MENU = "menu.fxml";

    private final Game game;
    private final Stage stage;

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


    public GameController(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;
    }


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

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        game.stop();

        MenuController menu = new MenuController(game, stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_PATH_MENU));
        fxmlLoader.setController(menu);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
