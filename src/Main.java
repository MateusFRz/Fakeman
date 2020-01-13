import controller.MenuController;
import game.Game;
import game.input.KeyboardInput;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import save.BinarySave;
import save.Save;

import java.awt.event.ActionEvent;

public class Main extends Application {

    private Game game;

    private static final String GAME_TITLE = "Bambou";
    private static final String FXML_PATH = "menu.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        game = new Game();
        MenuController menu = new MenuController(game, stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_PATH));
        fxmlLoader.setController(menu);
        Scene scene = new Scene(fxmlLoader.load());


        stage.setTitle(GAME_TITLE);

        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(new KeyboardInput(game));
    }

    @Override
    public void stop() {
        Save save = new BinarySave();
        try {
            save.save("data.dat", game.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }
        game.stop();
    }

}
