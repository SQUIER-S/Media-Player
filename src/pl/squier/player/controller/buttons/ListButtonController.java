package pl.squier.player.controller.buttons;

import javafx.scene.control.Button;
import pl.squier.player.view.components.outer.OuterPlaylist;

/**
 * Created by SQUIER on 2016-02-04.
 */
public class ListButtonController {

    public ListButtonController(Button list, OuterPlaylist outerPlaylist) {

        list.setOnMouseClicked(e -> outerPlaylist.show());

    }

}
