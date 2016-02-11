package pl.squier.player.controller.refresh;

import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import pl.squier.player.controller.AudioPlayerListeners;
import pl.squier.player.controller.components.MediaLabelActionController;
import pl.squier.player.controller.components.MediaLabelViewController;
import pl.squier.player.miscellaneous.MediaListFiller;
import pl.squier.player.miscellaneous.MediaFileLabel;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.view.components.inner.Labels;
import pl.squier.player.view.components.outer.OuterPlaylist;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-02-04.
 */
public class OuterPlaylistRefresh {

    public OuterPlaylistRefresh(AudioPlayer audioPlayer, OuterPlaylist outerPlaylist, Labels labels) {

        audioPlayer.getPlaylist().getPlaylist().addListener((ListChangeListener<File>) change -> {
            outerPlaylist.setMediaFiles(new ArrayList<>());
            for (int i = 0; i < audioPlayer.getPlaylist().getPlaylist().size(); i++) {
                MediaFileLabel label = new MediaFileLabel(new Label(audioPlayer.getPlaylist().getPlaylist().get(i).getName()), i);
                outerPlaylist.getMediaFiles().add(label);
                new MediaLabelViewController(label.getName());
                new MediaLabelActionController(label, audioPlayer, labels);
            }

            MediaListFiller.fillMediaFileList(outerPlaylist.getMediaFiles(), outerPlaylist.getLoadedMedia());
            outerPlaylist.getScrollPane().setContent(outerPlaylist.getLoadedMedia());

        });

    }

}
