package pl.squier.player.miscellaneous;

/**
 * Created by SQUIER
 * on 2015-10-21.
 */
public class FileChooser {

    private static javafx.stage.FileChooser chooser;

    static {
        chooser = new javafx.stage.FileChooser();

        javafx.stage.FileChooser.ExtensionFilter fileFilter;
        fileFilter = new javafx.stage.FileChooser.ExtensionFilter("MP3 files", "*.mp3");

        chooser.setTitle("Select Media Files");
        chooser.getExtensionFilters().add(fileFilter);
    }


    public static javafx.stage.FileChooser getChooser() {
        return chooser;
    }

}
