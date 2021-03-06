package pl.squier.player.controller.buttons;

import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.controller.AudioPlayerListeners;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.view.components.inner.Labels;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class NextAndPrevButtonController {

    public NextAndPrevButtonController(Button next, Button prev, Labels labels,
                                       AudioPlayer audioPlayer) {

        prev.setOnMouseClicked(e -> play("prev", labels, audioPlayer));
        next.setOnMouseClicked(e -> play("next", labels, audioPlayer));

    }

    private void play(String way, Labels labels, AudioPlayer audioPlayer) throws IllegalArgumentException {


        if (!audioPlayer.getPlaylist().isEmpty()) {

            MediaPlayer player;
            MediaPlayer.Status status;

            if (audioPlayer.getCurrentPlayer() != null) {

                player = audioPlayer.getCurrentPlayer();
                status = audioPlayer.getMediaPlayerStatus();

                player.stop();
            } else {
                status = MediaPlayer.Status.STOPPED;
            }

            player = prepareNewPlayer(way, labels, audioPlayer);

            final MediaPlayer finalPlayer = player;
            player.setOnReady(() -> {

                if (status.equals(MediaPlayer.Status.PLAYING)) {

                    labels.getCurrentPlayingMedia().setText(audioPlayer.getCurrentMediaName());
                    MediaDuration.duration = finalPlayer.getMedia().getDuration();
                    finalPlayer.play();

                } else {
                    labels.getCurrentPlayingMedia().setText(audioPlayer.getCurrentMediaName());
                    MediaDuration.duration = finalPlayer.getMedia().getDuration();

                    setTime(labels);
                }

            });

        }


    }


    private MediaPlayer prepareNewPlayer(String whichWay, Labels labels, AudioPlayer audioPlayer)
            throws IllegalArgumentException {

        MediaPlayer player;

        switch (whichWay) {
            case "prev":
                audioPlayer.preparePrevious();
                break;
            case "next":
                audioPlayer.prepareNext();
                break;
            default:
                throw new IllegalArgumentException("Argument: " + whichWay + "; Allowed args: PREV or NEXT");
        }

        new AudioPlayerListeners(audioPlayer, labels);

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
