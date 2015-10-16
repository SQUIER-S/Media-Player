package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by SQUIER
 * on 2015-10-16.
 */
public class ActionButtonsViewController {

    public ActionButtonsViewController(Button... args) {

        addHandlers(args);

    }

    private void addHandlers(Button[] args) {
        for(int i = 0; i < args.length; i++) {
            args[i].setOnMouseEntered(this::setOnMouseEntered);
            args[i].setOnMouseExited(this::setOnMouseExited);
            args[i].setOnMousePressed(this::setOnMousePressed);

            if(i < args.length - 2){
                args[i].setOnMouseReleased(this::setOnMouseEntered);
            }
        }
    }

    private void setOnMousePressed(MouseEvent e) {
        ((Button)e.getSource()).setStyle("-fx-border-color: #5555ff; -fx-border-width: 3");
    }

    private void setOnMouseExited(MouseEvent e) {
        ((Button)e.getSource()).setStyle("-fx-border-color: #cccccc; -fx-border-width: 1");
    }

    private void setOnMouseEntered(MouseEvent e) {
        ((Button)e.getSource()).setStyle("-fx-border-color: #aaaaff; -fx-border-width: 2");
    }


}
