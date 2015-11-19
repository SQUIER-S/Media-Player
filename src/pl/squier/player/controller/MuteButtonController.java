package pl.squier.player.controller;

import javafx.scene.control.Button;
import pl.squier.player.miscellaneous.PlayerMuted;
import pl.squier.player.model.AudioPlayer;

/**
 * Created by SQUIER
 * on 2015-11-09.
 */
public class MuteButtonController {

    public MuteButtonController(Button mute, AudioPlayer audioPlayer) {

        addListener(mute, audioPlayer);

    }

    private void addListener(Button mute, AudioPlayer audioPlayer) {
        mute.setOnMouseClicked(e -> {
            if (audioPlayer.getCurrentPlayer() != null && audioPlayer.getCurrentPlayer().isMute()) {
                audioPlayer.getCurrentPlayer().setMute(false);
                PlayerMuted.isMuted = false;
            } else if (audioPlayer.getCurrentPlayer() != null && !audioPlayer.getCurrentPlayer().isMute()) {
                audioPlayer.getCurrentPlayer().setMute(true);
                PlayerMuted.isMuted = true;

                mute.setStyle("-fx-border-color: #5555ff; -fx-border-width: 3px;");
                mute.setOnMouseEntered(null);
                mute.setOnMouseExited(null);
            }
        });
    }

}
