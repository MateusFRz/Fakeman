package controller;

import game.Game;
import game.input.KeyboardInput;
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
    private Stage stage;
    private MediaPlayer mediaPlayer;


    private static final String FXML_PATH = "game.fxml";
    private static final String FXML_PATH_SCORE = "score.fxml";

    @FXML private TextField playerName;
    @FXML private Button playBtn;
    @FXML private Button scoreBtn;
    @FXML private Button leaveBtn;
    @FXML private ComboBox<String> music;
    @FXML private Label nameField;

    public MenuController(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        playerName.textProperty().bindBidirectional(game.getPlayer().nameProperty());
        nameField.textProperty().bind(game.getPlayer().nameProperty());

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
        System.out.println("Scene changing...");


        switch (button.getText()) {
            case "Play":
                MainController gameCtrl = new MainController(game);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_PATH));
                fxmlLoader.setController(gameCtrl);
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
                scene.setOnKeyPressed(new KeyboardInput(game));
                game.launch();
                break;
            case "Score":
                ScoreController scoreCtrl = new ScoreController(game,stage);
                fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_PATH_SCORE));
                fxmlLoader.setController(scoreCtrl);
                scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
                break;
            case "Leave":
                exit();
                break;
            default:
                return;
        }
    }
}