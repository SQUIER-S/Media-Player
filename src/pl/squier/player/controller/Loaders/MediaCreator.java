package pl.squier.player.controller.loaders;

import javafx.scene.media.Media;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class MediaCreator {

    private List<Media> medias;

    public MediaCreator(List<File> files) {

        medias = new ArrayList<>();

        createMediaList(files);

    }

    private void createMediaList(List<File> files) {
        medias.addAll(files.stream().map(file -> new Media(file.toURI().toString())).collect(Collectors.toList()));
    }

    public List<Media> getMedias() {
        return medias;
    }
}
