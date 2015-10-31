package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;
import pl.squier.player.view.Labels;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class PlayButtonController {

    public PlayButtonController(Button play, Labels labels,
                                AudioPlayer audioPlayer, Playlist playlist) {

        play.setOnMouseClicked( e -> play(play, labels, audioPlayer, playlist));

    }

    private void play(Button play, Labels labels, AudioPlayer audioPlayer, Playlist playlist) {

        if(!playlist.getPlaylist().isEmpty()) {

            if(audioPlayer.getCurrentPlayer() == null) {
                audioPlayer.createNewCurrent();
                new AudioPlayerListeners(audioPlayer, playlist, labels);

                audioPlayer.getCurrentPlayer().setOnReady(() -> {

                    MediaDuration.duration = audioPlayer.getCurrentPlayer().getMedia().getDuration();
                    audioPlayer.getCurrentPlayer().play();
                    setImage(play, "../res/images/pauseButton.png");

                    labels.getCurrentPlayingMedia().setText(playlist.getCurrentFile().getName());

                });

            }


            if (audioPlayer.getMediaPlayerStatus().equals(MediaPlayer.Status.READY)
                    || audioPlayer.getMediaPlayerStatus().equals(MediaPlayer.Status.PAUSED)
                    || audioPlayer.getMediaPlayerStatus().equals(MediaPlayer.Status.STOPPED)) {

                MediaDuration.duration = audioPlayer.getCurrentPlayer().getMedia().getDuration();
                audioPlayer.getCurrentPlayer().play();
                setImage(play, "../res/images/pauseButton.png");

                labels.getCurrentPlayingMedia().setText(playlist.getCurrentFile().getName());

            } else if(audioPlayer.getMediaPlayerStatus().equals(MediaPlayer.Status.PLAYING)) {

                audioPlayer.getCurrentPlayer().pause();
                setImage(play, "../res/images/playButton.png");
            }



        }
    }

    private void setImage(Button play, String pathToImage) {

        Image icon = new Image(getClass().getResourceAsStream(pathToImage));
        play.setGraphic(new ImageView(icon));

    }

}
