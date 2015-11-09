package pl.squier.player.controller;

import javafx.scene.media.MediaPlayer;
import pl.squier.player.controller.refreshers.ElapsingTimeRefresher;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;
import pl.squier.player.view.Labels;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayerListeners {

    public AudioPlayerListeners(AudioPlayer audioPlayer, Playlist playlist, Labels labels) {


        setListeners(audioPlayer.getCurrentPlayer(), audioPlayer, playlist, labels);

    }

    private void setListeners(MediaPlayer mediaPlayer, AudioPlayer audioPlayer, Playlist playlist, Labels labels) {

        mediaPlayer.setOnReady(() -> {
            MediaDuration.duration = audioPlayer.getCurrentPlayer()
                    .getMedia().getDuration();
        });

        mediaPlayer.setOnEndOfMedia(() -> {

            audioPlayer.getCurrentPlayer().stop();

            playlist.setNext();

            audioPlayer.createNewCurrent();
            new AudioPlayerListeners(audioPlayer, playlist, labels);

            labels.getCurrentPlayingMedia().setText(playlist.getFileByInteger(playlist.getcurrent()).getName());
            audioPlayer.getCurrentPlayer().play();

        });

        mediaPlayer.setOnPlaying(() -> mediaPlayer.currentTimeProperty().addListener(observable -> {
            ElapsingTimeRefresher
                    .refreshLabel(labels.getElapsingTime(), mediaPlayer);
        }));

    }


}
