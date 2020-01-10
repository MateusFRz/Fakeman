package controller;

import game.Game;
import game.event.MusicEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import java.io.IOException;


public class MenuController {

    private Game game;

    @FXML private TextField playerName;
    @FXML private Button playBtn;
    @FXML private Button scoreBtn;
    @FXML private Button leaveBtn;
    @FXML private Button closeButton;
    @FXML private ComboBox<String> music;


    public MenuController(Game game) {
        this.game = game;
    }

    @FXML
    private void initialize() {
        playerName.textProperty().bindBidirectional(game.getPlayer().nameProperty());

        music.getItems().addAll("manu.mp3", "fausse.mp3", "pacman.mp3");
        music.setOnAction(new MusicEvent());
    }

    @FXML
    private void scoreButtonAction(){
        Stage stage = (Stage) scoreBtn.getScene().getWindow();
      //  stage.setScene();
    }

    @FXML
    private void startButtonAction(ActionEvent e) throws IOException {
        /*
        Parent home_page_parent =FXMLLoader.load(getClass().getResource("game.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.hide(); //optional
        stage.setScene(home_page_scene);
        stage.show();
         */
    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


}