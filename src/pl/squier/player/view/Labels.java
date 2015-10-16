package pl.squier.player.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by SQUIER
 * on 2015-10-16.
 *
 * App's labels
 */
public class Labels {

    private Label elapsingTime, currentPlayingMedia;

    private HBox labelTile;

    public Labels() {
        initLabels();

        addLabels();

    }

    private void addLabels() {
        labelTile = new HBox(20);
        labelTile.setAlignment(Pos.TOP_RIGHT);
        labelTile.getChildren().addAll(currentPlayingMedia, elapsingTime);
    }

    private void initLabels() {
        elapsingTime = new Label("00:00/00:00");
        currentPlayingMedia = new Label();
        currentPlayingMedia.setPrefSize(300, 20);
        currentPlayingMedia.getStyleClass().add("lbl");
    }

    public HBox getLabelTile() {
        return labelTile;
    }

}
