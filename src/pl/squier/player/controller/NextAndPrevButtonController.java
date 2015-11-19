package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;
import pl.squier.player.view.Labels;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class NextAndPrevButtonController {

    public NextAndPrevButtonController(Button next, Button prev, Labels labels,
                                       AudioPlayer audioPlayer, Playlist playlist) {

        prev.setOnMouseClicked(e -> play("prev", labels, audioPlayer, playlist));
        next.setOnMouseClicked(e -> play("next", labels, audioPlayer, playlist));

    }

    private void play(String way, Labels labels, AudioPlayer audioPlayer, Playlist playlist) {

        if (!playlist.getPlaylist().isEmpty()) {


            if (!playlist.getPlaylist().isEmpty()) {

                MediaPlayer player;
                MediaPlayer.Status status;

                if (audioPlayer.getCurrentPlayer() != null) {

                    player = audioPlayer.getCurrentPlayer();
                    status = audioPlayer.getMediaPlayerStatus();

                    player.stop();
                } else {
                    status = MediaPlayer.Status.STOPPED;
                }

                player = prepareNewPlayer(way, labels, audioPlayer, playlist);

                final MediaPlayer finalPlayer = player;
                player.setOnReady(() -> {

                    if (status.equals(MediaPlayer.Status.PLAYING)) {


                        labels.getCurrentPlayingMedia().setText(playlist.getCurrentFile().getName());
                        MediaDuration.duration = finalPlayer.getMedia().getDuration();
                        finalPlayer.play();

                    } else {
                        labels.getCurrentPlayingMedia().setText(playlist.getCurrentFile().getName());
                        MediaDuration.duration = finalPlayer.getMedia().getDuration();

                        setTime(labels);
                    }

                });

            }

        }

    }


    private MediaPlayer prepareNewPlayer(String whichWay, Labels labels, AudioPlayer audioPlayer, Playlist playlist) {
        MediaPlayer player;

        if (whichWay.equals("prev")) playlist.setPrevious();
        else playlist.setNext();

        audioPlayer.createNewCurrent();
        new AudioPlayerListeners(audioPlayer, playlist, labels);

        player = audioPlayer.getCurrentPlayer();
        return player;
    }

    private void setTime(Labels labels) {
        int duration = (int) Math.floor(MediaDuration.duration.toSeconds());
        int minutes = duration / 60;
        int seconds = duration - (minutes * 60);

        labels.getElapsingTime().setText(String.format("%02d:%02d/%02d:%02d", 0, 0, minutes, seconds));
    }

}
