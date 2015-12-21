package pl.squier.player.controller;

import javafx.scene.control.Button;
import pl.squier.player.model.Playlist;

/**
 * Created by SQUIER on 2015-12-21.
 */
public class RandomController {

    public RandomController(Button random) {
        random.setOnMouseClicked(e-> setRandom(random));
    }

    private void setRandom(Button random) {
        if(Playlist.isRandom()) {
            Playlist.setRandomProperty(false);
            RandomButtonViewController.setOnNormal(random);
        } else {
            Playlist.setRandomProperty(true);
            RandomButtonViewController.setOnRandom(random);
        }
    }

}
