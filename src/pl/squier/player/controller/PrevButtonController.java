package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;

import static pl.squier.player.model.AudioPlayer.getMediaPlayerByInteger;
import static pl.squier.player.model.PlaylistIterator.getNumber;
import static pl.squier.player.model.PlaylistIterator.setPrevious;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class PrevButtonController {

    public PrevButtonController(Button prev, Label currentPlayingMedia) {

        prev.setOnMouseClicked( e -> playPrev(currentPlayingMedia));

    }

    private void playPrev(Label currentPlayingMedia) {

        if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.PLAYING)) {

            AudioPlayer.getMediaPlayerByInteger(getNumber()).stop();
            setPrevious();
            MediaDuration.duration = getMediaPlayerByInteger(getNumber()).getMedia().getDuration();
            AudioPlayer.getMediaPlayerByInteger(getNumber()).play();

            currentPlayingMedia.setText(Playlist.getFileByInteger(getNumber()).getName());

        } else if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.READY)) {

            setPrevious();
            MediaDuration.duration = getMediaPlayerByInteger(getNumber()).getMedia().getDuration();
            currentPlayingMedia.setText(Playlist.getFileByInteger(getNumber()).getName());

        } else if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.PAUSED)) {

            AudioPlayer.getMediaPlayerByInteger(getNumber()).stop();
            setPrevious();
            MediaDuration.duration = getMediaPlayerByInteger(getNumber()).getMedia().getDuration();
            currentPlayingMedia.setText(Playlist.getFileByInteger(getNumber()).getName());
        }

    }

}
