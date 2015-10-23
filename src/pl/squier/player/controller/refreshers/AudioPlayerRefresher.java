package pl.squier.player.controller.refreshers;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import pl.squier.player.controller.AudioPlayerController;
import pl.squier.player.controller.loaders.LoadPlaylistToAudioPlayer;

import java.io.File;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayerRefresher {

    public AudioPlayerRefresher(ObservableList<File> playlist) {

        playlist.addListener((ListChangeListener<File>) c -> {
            LoadPlaylistToAudioPlayer.load();
            new AudioPlayerController();
        });

    }

}
