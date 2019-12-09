import controller.MainController;
import game.Game;
import game.input.KeyboardInput;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Game game;

    private static final String GAME_TITLE = "FakeMan";
    private static final String FXML_PATH = "main.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        game = new Game();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_PATH));
        fxmlLoader.setController(new MainController(game));
        Scene scene = new Scene(fxmlLoader.load());


        stage.setTitle(GAME_TITLE);

        stage.setFullScreen(true);
        stage.setScene(scene);

        stage.show();

        scene.setOnKeyPressed(new KeyboardInput(game));

        game.launch();
    }

    @Override
    public void stop() throws Exception {
        game.stop();
    }
}
