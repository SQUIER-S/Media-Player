package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import pl.squier.player.model.AudioPlayer;

import static pl.squier.player.model.PlaylistIterator.getNumber;
import static pl.squier.player.model.PlaylistIterator.setNext;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class NextButtonController {

    public NextButtonController(Button next) {

        next.setOnMouseClicked( e -> playNext());

    }

    private void playNext() {

        if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.PLAYING)) {

            AudioPlayer.getMediaPlayerByInteger(getNumber()).stop();
            setNext();
            AudioPlayer.getMediaPlayerByInteger(getNumber()).play();

        } else if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.READY)) {

            setNext();

        } else if(AudioPlayer.getMediaPlayerStatus(getNumber()).equals(MediaPlayer.Status.PAUSED)) {

            AudioPlayer.getMediaPlayerByInteger(getNumber()).stop();
            setNext();
        }

    }

}
