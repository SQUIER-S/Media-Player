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

    private List<File> importedFiles;

    public AddButtonController(Button add, Stage stage) {
        add.setOnMouseClicked(e -> addFiles(stage));
    }

    private void addFiles(Stage stage) {

        importedFiles = FileChooser.getChooser().showOpenMultipleDialog(stage);
        Playlist.addToPlaylist(importedFiles);
    }
}
