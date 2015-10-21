package pl.squier.player.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER
 * on 2015-10-21.
 */
public class Playlist implements Observable {

    private static List<File> playlist = new ArrayList<>();

    public static void addToPlaylist(List<File> importedFiles) {

        playlist.addAll(importedFiles.stream().collect(Collectors.toList()));

    }

    public static List<File> getPlaylist() {
        return playlist;
    }

    public static File getFileByInteger(int index) {
        return playlist.get(index);
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
