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
public class PrevButtonController {

    public PrevButtonController(Button prev, Label currentPlayingMedia,
                                AudioPlayer audioPlayer, Playlist playlist) {

        prev.setOnMouseClicked( e -> playPrev(currentPlayingMedia, audioPlayer, playlist));

    }

    private void playPrev(Label currentPlayingMedia, AudioPlayer audioPlayer, Playlist playlist) {

        if(audioPlayer.getMediaPlayerStatus(playlist.getcurrent()).equals(MediaPlayer.Status.PLAYING)) {

            audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).stop();
            playlist.setPrevious();
            MediaDuration.duration = audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).getMedia().getDuration();
            audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).play();

            currentPlayingMedia.setText(playlist.getFileByInteger(playlist.getcurrent()).getName());

        } else if(audioPlayer.getMediaPlayerStatus(playlist.getcurrent()).equals(MediaPlayer.Status.READY)) {

            playlist.setPrevious();
            MediaDuration.duration = audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).getMedia().getDuration();
            currentPlayingMedia.setText(playlist.getFileByInteger(playlist.getcurrent()).getName());

        } else if(audioPlayer.getMediaPlayerStatus(playlist.getcurrent()).equals(MediaPlayer.Status.PAUSED)) {

            audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).stop();
            playlist.setPrevious();
            MediaDuration.duration = audioPlayer.getMediaPlayerByInteger(playlist.getcurrent()).getMedia().getDuration();
            currentPlayingMedia.setText(playlist.getFileByInteger(playlist.getcurrent()).getName());
        }

    }

}
