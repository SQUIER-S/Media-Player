package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class NextButtonController {

    public NextButtonController(Button next, Label currentPlayingMedia,
                                AudioPlayer audioPlayer, Playlist playlist) {

        next.setOnMouseClicked( e -> playNext(currentPlayingMedia, audioPlayer, playlist));

    }

    private void playNext(Label currentPlayingMedia, AudioPlayer audioPlayer, Playlist playlist) {


        if(audioPlayer.getMediaPlayerStatus(playlist.getcurrent()).equals(MediaPlayer.Status.PLAYING)) {

            audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).stop();
            playlist.setNext();

            currentPlayingMedia.setText(playlist.getFileByInteger(playlist.getcurrent()).getName());

            MediaDuration.duration = audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).getMedia().getDuration();
            audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).play();

        } else if(audioPlayer.getMediaPlayerStatus(playlist.getcurrent()).equals(MediaPlayer.Status.READY)) {

            playlist.setNext();

            currentPlayingMedia.setText(playlist.getFileByInteger(playlist.getcurrent()).getName());

            MediaDuration.duration = audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).getMedia().getDuration();
            audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).play();

        } else if(audioPlayer.getMediaPlayerStatus(playlist.getcurrent()).equals(MediaPlayer.Status.PAUSED) ||
                audioPlayer.getMediaPlayerStatus(playlist.getcurrent()).equals(MediaPlayer.Status.STOPPED)) {

            audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).stop();
            playlist.setNext();

            currentPlayingMedia.setText(playlist.getFileByInteger(playlist.getcurrent()).getName());

            MediaDuration.duration = audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).getMedia().getDuration();

        } else {
            System.out.println("Unhandled player's status!" +
                    audioPlayer.getMediaPlayerStatus(playlist.getcurrent()).toString());
        }

    }

}
