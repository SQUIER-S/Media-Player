package pl.squier.player.controller.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.view.components.inner.Labels;

/**
 * Created by SQUIER on 2015-12-21.
 */
public class ClearListController {

    public ClearListController(Button clear, AudioPlayer audioPlayer, Labels labels, Button playButton) {
        clear.setOnMouseClicked(e -> setOnClick(audioPlayer, labels, playButton));
    }

    private void setOnClick(AudioPlayer audioPlayer, Labels labels, Button playButton) {
        if(audioPlayer.getCurrentPlayer() != null) {
            audioPlayer.getCurrentPlayer().stop();
            audioPlayer.getPlaylist().clear();
            labels.getCurrentPlayingMedia().setText("");
            labels.getElapsingTime().setText("00:00/00:00");
            setImage(playButton, "../res/images/playButton.png");
        }
    }

    private void setImage(Button play, String pathToImage) {

        Image icon = new Image(getClass().getResourceAsStream(pathToImage));
        play.setGraphic(new ImageView(icon));

    }

}
