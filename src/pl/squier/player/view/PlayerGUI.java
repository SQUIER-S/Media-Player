package pl.squier.player.view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by SQUIER
 * on 2015-10-16.
 *
 * Graphic users interface
 */
public class PlayerGUI {

    /*
     * Main frame
     */
    private Stage PRIMARY_STAGE;

    /*
     * App's body
     */
    private Scene scene;

    /*
     * Container for app's buttons etc...
     */
    private VBox vbox = new VBox(4);

    public PlayerGUI(Stage primaryStage) {

        initStage(primaryStage);
        vbox.getChildren().addAll(new ControlButtons().getButtons(),
                new Labels().getLabelTile(),
                new InnerPlaylist().getInnerPlaylist());

        /*
        VBox.setMargin(controlButtons, new Insets(2, 2, 0, 0));
        VBox.setMargin(labelTile, new Insets(0, 11, 0, 0));
        VBox.setMargin(playListArea, new Insets(10, 10, 1, 10));

        */
        initScene();
        PRIMARY_STAGE.setScene(scene);
    }

    /**
     * Show the app
     */
    public void showStage() {
        PRIMARY_STAGE.show();
    }

    /**
     * Initialize frame
     * sets parameters like style, resizability,
     * scene style and size
     * @param primaryStage
     */
    private void initStage(Stage primaryStage) {
        PRIMARY_STAGE = primaryStage;
        //PRIMARY_STAGE.initStyle(StageStyle.TRANSPARENT);


        PRIMARY_STAGE.setResizable(false);
    }

    private void initScene() {
        scene = new Scene(vbox, 450, 260);
        scene.getStylesheets().add("pl/squier/player/res/stylesheets/style.css");
    }

    /**
     * @return scene    -- App's body
     */
    public Scene getScene() {
        return scene;
    }

}
