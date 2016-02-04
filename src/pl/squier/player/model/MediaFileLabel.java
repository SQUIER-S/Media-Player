package pl.squier.player.model;

import javafx.scene.control.Label;

/**
 * Created by SQUIER on 2016-02-04.
 */
public class MediaFileLabel {

    private Label name;
    private int id;

    public MediaFileLabel(Label name, int id) {
        this.name = name;
        this.id = id;
    }

    public Label getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
