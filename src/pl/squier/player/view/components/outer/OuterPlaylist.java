package pl.squier.player.view.components.outer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.squier.player.controller.MovableWindowController;
import pl.squier.player.miscellaneous.MediaFileLabel;
import pl.squier.player.view.components.inner.ControlButtons;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-02-02.
 */
public class OuterPlaylist extends Application{

    private Stage PRIMARY_STAGE;
    private Scene SCENE;

    private VBox main;
    private VBox loadedMedia;

    private ScrollPane scrollPane;
    private ArrayList<MediaFileLabel> mediaFiles;

    private ControlButtons controlButtons;

    public OuterPlaylist() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PRIMARY_STAGE = primaryStage;
        PRIMARY_STAGE.setResizable(false);
        PRIMARY_STAGE.initStyle(StageStyle.TRANSPARENT);

        main = new VBox();

        controlButtons = new ControlButtons();
        loadedMedia = new VBox();
        initScrollPane();

        main.getChildren().addAll(controlButtons.getControlButtons(), scrollPane);
        VBox.setMargin(controlButtons.getControlButtons(), new Insets(2,2,0,0));
        VBox.setMargin(scrollPane, new Insets(5,0,5,5));

        initScene();

        initMovableWindow();
        PRIMARY_STAGE.setScene(SCENE);
    }

    private void initScrollPane() {
        scrollPane = new ScrollPane();
        scrollPane.setPrefSize(300, 582);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
    }

    private void initMovableWindow() {
        new MovableWindowController(PRIMARY_STAGE, SCENE);
    }

    private void initScene() {
        SCENE = new Scene(main, 300, 600);

        File cssFile = new File("resources/stylesheets/list.css");
        SCENE.getStylesheets().add("file:///" + cssFile.getAbsolutePath().replace("\\", "/"));
    }

    public Stage getPRIMARY_STAGE() {
        return PRIMARY_STAGE;
    }

    public Scene getSCENE() {
        return SCENE;
    }

    public VBox getMain() {
        return main;
    }

    public VBox getLoadedMedia() {
        return loadedMedia;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public ControlButtons getControlButtons() {
        return controlButtons;
    }

    public ArrayList<MediaFileLabel> getMediaFiles() {
        return mediaFiles;
    }

    public void show() {
        PRIMARY_STAGE.show();
    }

    public void setMediaFiles(ArrayList<MediaFileLabel> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }
}
