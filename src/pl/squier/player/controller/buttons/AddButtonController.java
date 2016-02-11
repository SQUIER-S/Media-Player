package pl.squier.player.controller.buttons;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.squier.player.miscellaneous.FileChooser;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;

import java.io.File;
import java.util.List;

/**
 * Created by SQUIER
 * on 2015-10-21.
 */
public class AddButtonController {

    public AddButtonController(Button add, AudioPlayer audioPlayer, Stage stage) {
        add.setOnMouseClicked(e -> addFiles(audioPlayer, stage));
    }

    private void addFiles(AudioPlayer audioPlayer, Stage stage) {

        List<File> importedFiles = FileChooser.getChooser().showOpenMultipleDialog(stage);

        if (importedFiles != null && !importedFiles.isEmpty()) {
            audioPlayer.addToPlaylist(importedFiles);

        }
    }
}
