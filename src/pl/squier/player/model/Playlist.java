package pl.squier.player.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by SQUIER
 * on 2015-10-21.
 */
public class Playlist {

    private ObservableList<File> observablePlaylist;
    private int current;
    private static boolean random = false;

    public Playlist() {

        observablePlaylist = FXCollections.observableArrayList();
        current = 0;

    }

    public ObservableList<File> getPlaylist() {
        return observablePlaylist;
    }

    public File getFileByInteger(int index) {
        return observablePlaylist.get(index);
    }

    public File setNext() {

        if(!random) {
            if (current < observablePlaylist.size() - 1) {
                current++;
            } else if (current == observablePlaylist.size() - 1) {
                current = 0;
            }
        } else {
            Random r = new Random();
            current = r.nextInt(observablePlaylist.size());
        }

        return observablePlaylist.get(current);
    }

    public File setPrevious() {

        if (current == 0) {
            current = observablePlaylist.size() - 1;
        } else if (current > 0) {
            current--;
        }

        return observablePlaylist.get(current);
    }

    public int getCurrent() {
        return current;
    }

    public File getCurrentFile() {
        return observablePlaylist.get(current);
    }

    public void clear() {
        observablePlaylist.clear();
    }

    public static boolean isRandom() {
        return random;
    }

    public static void setRandomProperty(boolean randomProperty) {
        Playlist.random = randomProperty;
    }

    public void addToPlaylist(List<File> importedFiles) {

        observablePlaylist.addAll(importedFiles.stream().collect(Collectors.toList()));

    }

    public boolean isEmpty() {
        return observablePlaylist.isEmpty();
    }
}
