package pl.squier.player.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER
 * on 2015-10-21.
 */
public class Playlist {

    private static ObservableList<File> observablePlaylist = FXCollections.observableArrayList();

    public static void addToPlaylist(List<File> importedFiles) {

        observablePlaylist.addAll(importedFiles.stream().collect(Collectors.toList()));

    }

    public static ObservableList<File> getPlaylist() {
        return observablePlaylist;
    }

    public static File getFileByInteger(int index) {
        return observablePlaylist.get(index);
    }
}
