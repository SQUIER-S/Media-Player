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

    private ObservableList<File> observablePlaylist;
    private int current;

    public void addToPlaylist(List<File> importedFiles) {

        observablePlaylist.addAll(importedFiles.stream().collect(Collectors.toList()));
        
    }

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

    public void setNext() {
        
        if(current < observablePlaylist.size() - 1 ) {
            current++;
        } else if(current == observablePlaylist.size() - 1) {
            current = 0;
        }

    }

    public void setPrevious() {

        if(current == 0) {
            current = observablePlaylist.size() - 1;
        } else if(current > 0) {
            current--;
        }

    }

    public int getcurrent() {
        return current;
    }

    public File getCurrentFile() {
        return observablePlaylist.get(current);
    }

}
