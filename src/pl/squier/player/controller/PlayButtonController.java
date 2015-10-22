package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;

import static pl.squier.player.model.PlaylistIterator.getNumber;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class PlayButtonController {

    public PlayButtonController(Button play, Label currentPlayingMedia) {

        play.setOnMouseClicked( e -> play(play, currentPlayingMedia));

    }

    private void play(Button play, Label currentPlayingMedia) {

        if(AudioPlayer.getMediaPlayers().size() > 0) {
            MediaPlayer.Status playerStatus = AudioPlayer.getMediaPlayerStatus(getNumber());

            if (playerStatus.equals(MediaPlayer.Status.READY)
                    || playerStatus.equals(MediaPlayer.Status.PAUSED)
                    || playerStatus.equals(MediaPlayer.Status.STOPPED)) {

                AudioPlayer.getMediaPlayerByInteger(getNumber()).play();
                setImage(play, "../res/images/pauseButton.png");

                if(currentPlayingMedia.getText().equals("")) {
                    currentPlayingMedia.setText(Playlist.getFileByInteger(getNumber()).getName());
                }

            } else if(playerStatus.equals(MediaPlayer.Status.PLAYING)) {

                AudioPlayer.getMediaPlayerByInteger(getNumber()).pause();
                setImage(play, "../res/images/playButton.png");
            }
        }
    }

    private void setImage(Button play, String pathToImage) {

        Image icon = new Image(getClass().getResourceAsStream(pathToImage));
        play.setGraphic(new ImageView(icon));

    }

}
