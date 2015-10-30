package pl.squier.player.controller.loaders;

import javafx.scene.media.Media;
import pl.squier.player.model.Playlist;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class MediaCreator {

    private static List<Media> medias = new ArrayList<>();

    public static List<Media> createMedias(Playlist playlist) {

        return playlist.getPlaylist().stream()
                .map(file -> new Media(file.toURI().toString())).collect(Collectors.toList());
    }
}
