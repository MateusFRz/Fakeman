package controller;

import game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Platform.exit;

public class ScoreController {


    private Game game;
    private Stage stage;


    private static final String FXML_PATH = "menu.fxml";

    @FXML private TextField playerName;
    @FXML private Button returnBtn;
    @FXML private Button leaveBtn;


    public ScoreController(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Button button;

        event.consume();
        if (event.getSource() instanceof Button) {
            button = (Button) event.getSource();
        } else
            return;

        switch (button.getText()) {
            case "Return":
                MenuController menu = new MenuController(game, stage);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_PATH));
                fxmlLoader.setController(menu);
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
                break;
            case "Leave":
                exit();
                break;
            default:
                break;
        }
    }
}
