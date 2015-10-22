package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;

import static pl.squier.player.model.PlaylistIterator.getNumber;
import static pl.squier.player.model.PlaylistIterator.setNext;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class NextButtonController {

    public NextButtonController(Button next, Label currentPlayingMedia) {

        next.setOnMouseClicked( e -> playNext(currentPlayingMedia));

    }

    private void playNext(Label currentPlayingMedia) {

        if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.PLAYING)) {

            AudioPlayer.getMediaPlayerByInteger(getNumber()).stop();
            setNext();
            AudioPlayer.getMediaPlayerByInteger(getNumber()).play();

            currentPlayingMedia.setText(Playlist.getFileByInteger(getNumber()).getName());

        } else if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.READY)) {

            setNext();
            currentPlayingMedia.setText(Playlist.getFileByInteger(getNumber()).getName());

        } else if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.PAUSED)) {

            AudioPlayer.getMediaPlayerByInteger(getNumber()).stop();
            setNext();
            currentPlayingMedia.setText(Playlist.getFileByInteger(getNumber()).getName());
        }

    }

}
