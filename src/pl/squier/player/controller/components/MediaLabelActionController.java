package pl.squier.player.controller.components;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import pl.squier.player.controller.AudioPlayerListeners;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.miscellaneous.MediaFileLabel;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.view.components.inner.Labels;

/**
 * Created by SQUIER on 2016-02-11.
 */
public class MediaLabelActionController {

    public MediaLabelActionController(MediaFileLabel label, AudioPlayer audioPlayer, Labels labels) {
        label.getName().setOnMouseClicked(e -> onClick(e, label, audioPlayer, labels));
    }

    private void onClick(MouseEvent e, MediaFileLabel label, AudioPlayer audioPlayer, Labels labels) {

        if(e.getClickCount() == 2 && e.getButton().equals(MouseButton.PRIMARY)) {
            onDoubleClick(label, audioPlayer, labels);
        } else if(e.getClickCount() == 1 && e.getButton().equals(MouseButton.SECONDARY)) {
            //TO DO!
        }

    }

    private void onDoubleClick(MediaFileLabel label, AudioPlayer audioPlayer, Labels labels) {
        audioPlayer.getCurrentPlayer().stop();
        audioPlayer.createById(label.getId());
        audioPlayer.getCurrentPlayer().setOnReady(() -> {
            MediaDuration.duration = audioPlayer.getCurrentPlayer().getMedia().getDuration();
            new AudioPlayerListeners(audioPlayer, labels);
            labels.getCurrentPlayingMedia().setText(audioPlayer.getCurrentMediaName());
            setTime(labels);
            audioPlayer.getCurrentPlayer().play();
        });
    }

    private void setTime(Labels labels) {
        int duration = (int) Math.floor(MediaDuration.duration.toSeconds());
        int minutes = duration / 60;
        int seconds = duration - (minutes * 60);

        labels.getElapsingTime().setText(String.format("%02d:%02d/%02d:%02d", 0, 0, minutes, seconds));
    }
}
