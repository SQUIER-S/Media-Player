package pl.squier.player.controller.refresh;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import pl.squier.player.miscellaneous.MediaListFiller;
import pl.squier.player.model.MediaFileLabel;
import pl.squier.player.view.OuterPlaylist;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-02-04.
 */
public class OuterPlaylistRefresh {

    public OuterPlaylistRefresh(ObservableList<File> playlist, OuterPlaylist outerPlaylist) {

        playlist.addListener((ListChangeListener<File>) change -> {
            outerPlaylist.setMediaFiles(new ArrayList<>());
            for (int i = 0; i < playlist.size(); i++) {
                outerPlaylist.getMediaFiles().add(new MediaFileLabel(new Label(playlist.get(i).getName()), i));
            }

            MediaListFiller.fillMediaFileList(outerPlaylist.getMediaFiles(), outerPlaylist.getLoadedMedia());
            outerPlaylist.getScrollPane().setContent(outerPlaylist.getLoadedMedia());

        });

    }

}
