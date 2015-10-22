package pl.squier.player;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.squier.player.controller.AudioPlayerController;
import pl.squier.player.controller.refreshers.AudioPlayerRefresher;
import pl.squier.player.model.Playlist;
import pl.squier.player.view.PlayerGUI;

/**
 * Created by SQUIER
 * on 2015-10-16.
 */
public class SQMediaPlayer extends Application implements EventHandler<MouseEvent> {

    private PlayerGUI playerGUI;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        playerGUI = new PlayerGUI(primaryStage);
        playerGUI.showStage();

        new AudioPlayerRefresher(Playlist.getPlaylist());
        new AudioPlayerController();

    }

    @Override
    public void handle(MouseEvent event) {

    }
}
