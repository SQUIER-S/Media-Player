package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.model.AudioPlayer;

import static pl.squier.player.model.PlaylistIterator.getNumber;
import static pl.squier.player.model.PlaylistIterator.setNext;
import static pl.squier.player.model.PlaylistIterator.setPrevious;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class PrevButtonController {

    public PrevButtonController(Button prev) {

        prev.setOnMouseClicked( e -> playPrev());

    }

    private void playPrev() {

        if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.PLAYING)) {

            AudioPlayer.getMediaPlayerByInteger(getNumber()).stop();
            setPrevious();
            AudioPlayer.getMediaPlayerByInteger(getNumber()).play();

        } else if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.READY)) {

            setPrevious();

        } else if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.PAUSED)) {

            AudioPlayer.getMediaPlayerByInteger(getNumber()).stop();
            setPrevious();
        }

    }

}
