package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by SQUIER on 2015-12-21.
 */
public class RandomButtonViewController {

    public static void setOnRandom(Button random) {
        random.setOnMouseEntered(null);
        random.setOnMouseExited(null);
    }

    public static void setOnNormal(Button random) {
        random.setOnMouseEntered(RandomButtonViewController::setOnMouseEntered);
        random.setOnMouseExited(RandomButtonViewController::setOnMouseExited);
        random.setOnMousePressed(RandomButtonViewController::setOnMousePressed);
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
