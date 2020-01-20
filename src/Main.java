import controller.MenuController;
import game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import save.BinarySave;
import save.Save;


public class Main extends Application {

    private Game game;

    private static final String GAME_TITLE = "Bambou";
    private static final String FXML_PATH = "menu.fxml";
    private static final String FILE_NAME = "data.dat";

    @Override
    public void start(Stage stage) throws Exception {
        game = new Game(stage);
        MenuController menu = new MenuController(game);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_PATH));
        fxmlLoader.setController(menu);
        Scene scene = new Scene(fxmlLoader.load());


        stage.setTitle(GAME_TITLE);

        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        Save save = new BinarySave();
        try {
            save.save(FILE_NAME, game.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }
        game.stop();
    }

    //ajout d'un monstre
    //ajout d'une page pour le résumer des scores enregistrés
    //regarder pour les ajouts des autres entités si on le fait par listes

}
