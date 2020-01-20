package controller;

import game.Game;
import game.GameState;
import game.input.KeyboardInput;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Platform.exit;

public class MenuController {


    private Game game;
    private MediaPlayer mediaPlayer;


    private static final String FXML_PATH_GAME = "game.fxml";
    private static final String FXML_PATH_SCORE = "score.fxml";

    @FXML
    private TextField playerName;
    @FXML
    private Button playBtn;
    @FXML
    private Button scoreBtn;
    @FXML
    private Button leaveBtn;
    @FXML
    private ComboBox<String> music;
    @FXML
    private Label nameField;
    @FXML
    private Label state;

    public MenuController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        if (game.getState() != null) {
            if (game.getState() == GameState.LOSE) state.setText("You lose");
            if (game.getState() == GameState.WIN) state.setText("You win");
        }

        playerName.textProperty().bindBidirectional(game.getPlayer().nameProperty());
        nameField.textProperty().bind(Bindings.format("Pseudo: %s", game.getPlayer().nameProperty()));

        music.getItems().addAll("manu.mp3", "fausse.mp3", "pacman.mp3");
        music.setOnAction(actionEvent -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }

            this.mediaPlayer = new MediaPlayer(new Media(getClass().getClassLoader().getResource(music.getValue()).toString()));
            this.mediaPlayer.play();
        });
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
            case "Play":
                GameController gameCtrl = new GameController(game);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_PATH_GAME));
                fxmlLoader.setController(gameCtrl);
                Scene scene = new Scene(fxmlLoader.load());
                game.getStage().setScene(scene);
                game.getStage().show();
                scene.setOnKeyPressed(new KeyboardInput(game));
                break;
            case "Score":
                ScoreController scoreCtrl = new ScoreController(game);
                fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_PATH_SCORE));
                fxmlLoader.setController(scoreCtrl);
                scene = new Scene(fxmlLoader.load());
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