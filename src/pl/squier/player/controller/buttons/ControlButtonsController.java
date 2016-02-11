package pl.squier.player.controller.buttons;

import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by SQUIER
 * on 2015-10-17.
 */
public class ControlButtonsController {

    public ControlButtonsController(Button exit, Button minimize, Stage PRIMARY_STAGE, boolean main) {
        if(main){
            exit.setOnMouseClicked(e -> System.exit(0));
        } else {
            exit.setOnMouseClicked(e -> PRIMARY_STAGE.hide());
        }
        minimize.setOnMouseClicked(e -> PRIMARY_STAGE.setIconified(true));
    }
}
