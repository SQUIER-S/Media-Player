package pl.squier.player;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.squier.player.controller.PlayerController;
import pl.squier.player.model.PlayerModel;
import pl.squier.player.model.Playlist;
import pl.squier.player.view.PlayerGUI;

/**
 * Created by SQUIER
 * on 2015-10-16.
 */
public class SQMediaPlayer extends Application implements EventHandler<MouseEvent> {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        PlayerGUI playerGUI = new PlayerGUI(primaryStage);

        PlayerModel playerModel = new PlayerModel();

        new PlayerController(playerGUI.getActionButtons(), playerGUI.getControlButtons(),
                playerGUI.getInnerPlaylist(), playerGUI.getLbls(), primaryStage,
                playerModel.getPlaylist(), playerModel.getAudioPlayer());

        playerGUI.showStage();

    }

    @Override
    public void handle(MouseEvent event) {

    }
}
