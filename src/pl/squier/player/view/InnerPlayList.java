package pl.squier.player.view;

import javafx.scene.control.TextArea;

/**
 * Created by SQUIER
 * on 2015-10-16.
 *
 * Inner uneditable playlist
 */
public class InnerPlaylist {

    private TextArea innerPlaylist;

    public InnerPlaylist() {

        createInnerPlaylist();

    }

    private void createInnerPlaylist() {
        innerPlaylist = new TextArea("Songs list");
        innerPlaylist.setEditable(false);
        innerPlaylist.setPrefHeight(90);
        innerPlaylist.setPrefWidth(400);
        innerPlaylist.setWrapText(true);
        innerPlaylist.getStyleClass().add("txArea");
    }

    public TextArea getInnerPlaylist() {
        return innerPlaylist;
    }

}
