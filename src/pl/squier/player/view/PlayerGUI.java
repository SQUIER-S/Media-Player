package pl.squier.player.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.squier.player.controller.MovableWindowController;

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

    /*
     * Main window components
     */
    private TilePane controlButtons, actionLButtons, actionSButtons;
    private HBox labels;
    private TextArea innerPlaylist;

    private Labels l;

    public PlayerGUI(Stage primaryStage) {

        initStage(primaryStage);

        initComponents();

        setMargins();

        addComponents();

        initScene();

        initMovablePlayer();

        PRIMARY_STAGE.setScene(scene);
    }

    /**
     * allows to move player on the screen by dragging it with mouse
     */
    private void initMovablePlayer() {
        new MovableWindowController(PRIMARY_STAGE, scene);
    }

    /**
     * adds components groups to the app's body
     */
    private void addComponents() {
        vbox.getChildren().addAll(controlButtons, labels, innerPlaylist, actionSButtons, actionLButtons);
    }

    /**
     * sets margins around each components group
     */
    private void setMargins() {
        VBox.setMargin(controlButtons, new Insets(2, 2, 0, 0));
        VBox.setMargin(labels, new Insets(0, 11, 0, 0));
        VBox.setMargin(innerPlaylist, new Insets(10, 10, 1, 10));
        VBox.setMargin(actionLButtons, new Insets(0, 10, 10, 10));
    }

    /**
     * initialize components such as buttons, labels, playlist
     * and action buttons (play/pause, add media etc..)
     */
    private void initComponents() {
        controlButtons = new ControlButtons(PRIMARY_STAGE).getButtons();

        l = new Labels();
        labels = l.getLabelTile();
        innerPlaylist = new InnerPlaylist().getInnerPlaylist();

        ActionButtons ab = new ActionButtons(PRIMARY_STAGE, l.getCurrentPlayingMedia(), l.getElapsingTime());
        actionLButtons = ab.getActionLButtons();
        actionSButtons = ab.getActionSButtons();
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
     * @param primaryStage  -- App's frame
     */
    private void initStage(Stage primaryStage) {
        PRIMARY_STAGE = primaryStage;
        PRIMARY_STAGE.initStyle(StageStyle.TRANSPARENT);

        PRIMARY_STAGE.setResizable(false);
    }

    /**
     * Initialize app's body
     */
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

    /**
     * @return
     */
    public Labels getL() {
        return l;
    }

}