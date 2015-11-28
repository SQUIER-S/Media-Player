package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by SQUIER on 2015-11-28.
 */
public class MuteButtonViewController {

    public static void setOnUnMute(Button mute) {
        mute.setOnMouseEntered(MuteButtonViewController::setOnMouseEntered);
        mute.setOnMouseExited(MuteButtonViewController::setOnMouseExited);
        mute.setOnMousePressed(MuteButtonViewController::setOnMousePressed);
    }

    public static void setOnMute(Button mute) {
        mute.setOnMouseEntered(null);
        mute.setOnMouseExited(null);
    }

    private static void setOnMousePressed(MouseEvent e) {
        ((Button) e.getSource()).setStyle("-fx-border-color: #5555ff; -fx-border-width: 3");
    }

    private static void setOnMouseExited(MouseEvent e) {
        ((Button) e.getSource()).setStyle("-fx-border-color: #cccccc; -fx-border-width: 1");
    }

    private static void setOnMouseEntered(MouseEvent e) {
        ((Button) e.getSource()).setStyle("-fx-border-color: #aaaaff; -fx-border-width: 2");
    }

}
