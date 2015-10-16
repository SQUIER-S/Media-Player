package pl.squier.player.controller;

import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by SQUIER
 * on 2015-10-17.
 */
public class ControlButtonsController {

    public ControlButtonsController(Button exit, Button minimize, Stage PRIMARY_STAGE) {
        exit.setOnMouseClicked(e -> System.exit(0));
        minimize.setOnMouseClicked(e -> PRIMARY_STAGE.setIconified(true));
    }
}
