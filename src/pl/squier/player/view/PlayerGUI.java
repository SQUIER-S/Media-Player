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

    private ActionButtons actionButtons;

    private ControlButtons controlButtons;

    private InnerPlaylist innerPlaylist;

    /*
     * Main window components
     */
    private TilePane controlButs, largeButtons, smallButtons;
    private TextArea playlist;
    private HBox labels;
    private Labels lbls;

    public PlayerGUI(Stage primaryStage) {

        initStage(primaryStage);

        initComponents();

        setMargins();

        addComponents();

        initScene();

        initMovable();

        PRIMARY_STAGE.setScene(scene);
    }

    /**
     * allows to move player on the screen by dragging it with mouse
     */
    private void initMovable() {
        new MovableWindowController(PRIMARY_STAGE, scene);
    }

    /**
     * adds components groups to the app's body
     */
    private void addComponents() {
        vbox.getChildren().addAll(controlButs, labels, playlist, smallButtons, largeButtons);
    }

    /**
     * sets margins around each components group
     */
    private void setMargins() {
        VBox.setMargin(controlButs, new Insets(2, 2, 0, 0));
        VBox.setMargin(labels, new Insets(0, 11, 0, 0));
        VBox.setMargin(playlist, new Insets(10, 10, 1, 10));
        VBox.setMargin(largeButtons, new Insets(0, 10, 10, 10));
    }

    /**
     * initialize components such as buttons, labels, playlist
     * and action buttons (play/pause, add media etc..)
     */
    private void initComponents() {
        controlButtons = new ControlButtons();
        controlButs = controlButtons.getControlButtons();

        lbls = new Labels();
        labels = lbls.getLabelTile();
        innerPlaylist = new InnerPlaylist();
        playlist = innerPlaylist.getInnerPlaylist();

        actionButtons = new ActionButtons();
        largeButtons = actionButtons.getLargeButtons();
        smallButtons = actionButtons.getSmallButtons();
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
     * @return labels
     */
    public Labels getLbls() {
        return lbls;
    }

    /**
     *
     * @return action buttons objects
     */
    public ActionButtons getActionButtons() {
        return actionButtons;
    }

    /**
     *
     * @return control buttons objects
     */
    public ControlButtons getControlButtons() {
        return controlButtons;
    }

    /**
     *
     * @return inner playlist object
     */
    public InnerPlaylist getInnerPlaylist() {
        return innerPlaylist;
    }

}