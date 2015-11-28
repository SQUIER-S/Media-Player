package pl.squier.player.controller;

import javafx.scene.control.Button;
import pl.squier.player.miscellaneous.PlayerMuteProperty;
import pl.squier.player.model.AudioPlayer;

/**
 * Created by SQUIER
 * on 2015-11-09.
 */
public class MuteButtonActionController {

    public MuteButtonActionController(Button mute, AudioPlayer audioPlayer) {

        addListener(mute, audioPlayer);

    }

    private void addListener(Button mute, AudioPlayer audioPlayer) {
        mute.setOnMouseClicked(e -> {
            if (audioPlayer.getCurrentPlayer() != null && audioPlayer.getCurrentPlayer().isMute()) {
                audioPlayer.getCurrentPlayer().setMute(false);
                MuteButtonViewController.setOnUnMute(mute);
            } else if (audioPlayer.getCurrentPlayer() != null && !audioPlayer.getCurrentPlayer().isMute()) {
                audioPlayer.getCurrentPlayer().setMute(true);
                MuteButtonViewController.setOnMute(mute);
            }
        });
    }

}
