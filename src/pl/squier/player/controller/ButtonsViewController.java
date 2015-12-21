package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER
 * on 2015-10-16.
 */
public class ButtonsViewController {

    public ButtonsViewController(Button... buttons) {

        addHandlers(buttons);

    }

    private void addHandlers(Button[] args) {

        for (Button arg : args) {
            setListeners(arg);
        }
    }

    private void setListeners(Button button) {

        button.setOnMouseEntered(this::setOnMouseEntered);
        button.setOnMouseExited(this::setOnMouseExited);
        button.setOnMousePressed(this::setOnMousePressed);

    }

    private void setOnMousePressed(MouseEvent e) {
        ((Button) e.getSource()).setStyle("-fx-border-color: #5555ff; -fx-border-width: 3");
    }

    private void setOnMouseExited(MouseEvent e) {
        ((Button) e.getSource()).setStyle("-fx-border-color: #cccccc; -fx-border-width: 1");
    }

    private void setOnMouseEntered(MouseEvent e) {
        ((Button) e.getSource()).setStyle("-fx-border-color: #aaaaff; -fx-border-width: 2");
    }


}
