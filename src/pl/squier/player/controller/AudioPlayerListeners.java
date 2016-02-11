package pl.squier.player.controller;

import javafx.scene.media.MediaPlayer;
import pl.squier.player.controller.refresh.ElapsingTimeRefresh;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.view.components.inner.Labels;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayerListeners {

    public AudioPlayerListeners(AudioPlayer audioPlayer, Labels labels) {


        setListeners(audioPlayer, labels);

    }

    private void setListeners(AudioPlayer audioPlayer, Labels labels) {

        MediaPlayer mediaPlayer = audioPlayer.getCurrentPlayer();

        mediaPlayer.setOnReady(() -> {
            MediaDuration.duration = mediaPlayer
                    .getMedia().getDuration();
        });

        mediaPlayer.setOnEndOfMedia(() -> {

            mediaPlayer.stop();

            audioPlayer.prepareNext();

            new AudioPlayerListeners(audioPlayer, labels);

            labels.getCurrentPlayingMedia().setText(audioPlayer.getCurrentMediaName());
            audioPlayer.getCurrentPlayer().setOnReady(audioPlayer.getCurrentPlayer()::play);

        });

        mediaPlayer.setOnPlaying(() -> mediaPlayer.currentTimeProperty().addListener(observable -> {
            ElapsingTimeRefresh.refreshLabel(labels.getElapsingTime(), mediaPlayer);
        }));

    }


}
