package pl.squier.player.controller.refresh;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.io.File;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class InnerPlaylistRefresh {

    public InnerPlaylistRefresh(ObservableList<File> playlist, TextArea innerPlaylist) {

        playlist.addListener((ListChangeListener<File>) change -> {
            innerPlaylist.setText("");

            for (int i = 0; i < playlist.size(); i++) {
                innerPlaylist.appendText(i + 1 + ". " + playlist.get(i).getName() + "\n");
            }

            innerPlaylist.setEditable(true);
            innerPlaylist.deletePreviousChar();
            innerPlaylist.setEditable(false);

        });

    }

}
