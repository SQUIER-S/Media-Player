package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.squier.player.miscellaneous.FileChooser;
import pl.squier.player.model.Playlist;

import java.io.File;
import java.util.List;

/**
 * Created by SQUIER
 * on 2015-10-21.
 */
public class AddButtonController {

    public AddButtonController(Button add, Playlist playlist, Stage stage) {
        add.setOnMouseClicked(e -> addFiles(playlist, stage));
    }

    private void addFiles(Playlist playlist, Stage stage) {

        List<File> importedFiles = FileChooser.getChooser().showOpenMultipleDialog(stage);

        if (importedFiles != null && !importedFiles.isEmpty()) {
            playlist.addToPlaylist(importedFiles);
        }
    }
}
