package pl.squier.player.miscellaneous;

import javafx.scene.layout.VBox;
import pl.squier.player.model.MediaFileLabel;

import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-02-04.
 */
public class MediaListFiller {

    public static void fillMediaFileList(ArrayList<MediaFileLabel> source, VBox target) {

        target.getChildren().clear();
        source.stream().forEach(label -> target.getChildren().add(label.getName()));

    }

}
