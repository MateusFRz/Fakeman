package controller;

import game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

import static javafx.application.Platform.exit;

/**
 * Class associated to <code>score.fxml</code> that represent all action do in the graphic application
 * */
public class ScoreController {


    private static final String FXML_PATH = "menu.fxml";
    private Game game;
    @FXML
    private TextField playerName;
    @FXML
    private Button returnBtn;
    @FXML
    private Button leaveBtn;
    @FXML
    private ListView scores;


    public ScoreController(Game game) {
        this.game = game;
    }

    /**
     * Call when the user click on a button in the scoreboard
     *
     * @param event Type of event called
     * @throws IOException Input Output Exception
     * */
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
                MenuController menu = new MenuController(game);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_PATH));
                fxmlLoader.setController(menu);
                Scene scene = new Scene(fxmlLoader.load());
                game.getStage().setScene(scene);
                game.getStage().show();
                break;
            case "Leave":
                exit();
                break;
            default:
                break;
        }
    }
}
