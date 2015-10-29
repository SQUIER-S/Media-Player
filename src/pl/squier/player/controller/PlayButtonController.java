package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class PlayButtonController {

    public PlayButtonController(Button play, Label currentPlayingMedia,
                                AudioPlayer audioPlayer, Playlist playlist) {

        play.setOnMouseClicked( e -> play(play, currentPlayingMedia, audioPlayer, playlist));

    }

    private void play(Button play, Label currentPlayingMedia, AudioPlayer audioPlayer, Playlist playlist) {

        if(audioPlayer.getMediaPlayers().size() > 0) {
            MediaPlayer.Status playerStatus = audioPlayer.getMediaPlayerStatus(playlist.getcurrent());

            if (playerStatus.equals(MediaPlayer.Status.READY)
                    || playerStatus.equals(MediaPlayer.Status.PAUSED)
                    || playerStatus.equals(MediaPlayer.Status.STOPPED)) {

                MediaDuration.duration = audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).getMedia().getDuration();
                audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).play();
                setImage(play, "../res/images/pauseButton.png");

                if(currentPlayingMedia.getText().equals("")) {
                    currentPlayingMedia.setText(playlist.getFileByInteger(playlist.getcurrent()).getName());
                }

            } else if(playerStatus.equals(MediaPlayer.Status.PLAYING)) {

                audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).pause();
                setImage(play, "../res/images/playButton.png");
            }
        }
    }

    private void setImage(Button play, String pathToImage) {

        Image icon = new Image(getClass().getResourceAsStream(pathToImage));
        play.setGraphic(new ImageView(icon));

    }

}
