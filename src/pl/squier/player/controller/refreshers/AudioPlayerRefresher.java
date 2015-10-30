package pl.squier.player.controller.refreshers;

import javafx.collections.ListChangeListener;
import pl.squier.player.controller.AudioPlayerController;
import pl.squier.player.controller.loaders.LoadPlaylistToAudioPlayer;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;
import pl.squier.player.view.Labels;

import java.io.File;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayerRefresher {

    public AudioPlayerRefresher(AudioPlayer audioPlayer, Playlist playlist, Labels labels) {

        playlist.getPlaylist().addListener((ListChangeListener<File>) c -> {
            LoadPlaylistToAudioPlayer.load(audioPlayer, playlist);

            /* Adds player "hidden" functionality such as auto switching to next media at the end of current
            * time counting, updating name of currently playing media
            */
            new AudioPlayerController(audioPlayer, playlist, labels);
        });

    }

}
