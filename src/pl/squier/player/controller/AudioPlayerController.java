package pl.squier.player.controller;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import pl.squier.player.controller.refreshers.ElapsingTimeRefresher;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;
import pl.squier.player.view.Labels;

import java.util.stream.Collectors;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayerController {

    public AudioPlayerController(AudioPlayer audioPlayer, Playlist playlist, Labels labels) {


        audioPlayer.getMediaPlayers().stream()
                .map(mediaPlayer -> setListeners(mediaPlayer, audioPlayer, playlist, labels))
                .collect(Collectors.toList());

    }

    private MediaPlayer setListeners(MediaPlayer mediaPlayer, AudioPlayer audioPlayer, Playlist playlist, Labels labels) {

//        InvalidationListener timer = observable -> ElapsingTimeRefresher
//                .refreshLabel(labels.getElapsingTime(), audioPlayer, playlist);

        mediaPlayer.setOnEndOfMedia(() -> {

            audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).stop();
            //audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).currentTimeProperty().removeListener(timer);

            playlist.setNext();
            MediaDuration.duration = audioPlayer.getMediaPlayerByInteger(playlist.getcurrent())
                    .getMedia().getDuration();

            labels.getCurrentPlayingMedia().setText(playlist.getFileByInteger(playlist.getcurrent()).getName());
            audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).play();

        });

        mediaPlayer.setOnPlaying(() -> mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            ElapsingTimeRefresher
                    .refreshLabel(labels.getElapsingTime(), mediaPlayer);
            System.out.println(mediaPlayer.getCurrentTime().toSeconds());
        }));

        return mediaPlayer;
    }


}
