package pl.squier.player.controller.components;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Created by SQUIER on 2016-02-11.
 */
public class MediaLabelViewController {

    public MediaLabelViewController(Label label) {
        label.setOnMouseEntered(e -> onEntered(e));
        label.setOnMouseExited(e -> onExit(e));
    }

    private void onExit(MouseEvent e) {
        Label label = (Label)e.getSource();
        label.setStyle("-fx-text-fill: white");
    }

    private void onEntered(MouseEvent e) {
        Label label = (Label)e.getSource();
        label.setStyle("-fx-text-fill: #0077aa");
    }

}
