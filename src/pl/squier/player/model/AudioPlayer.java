package pl.squier.player.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayer {

    private static ObservableList<MediaPlayer> mediaPlayers = FXCollections.observableArrayList();

    public static void addMediaToAudioPlayer(List<Media> medias) {

        mediaPlayers.addAll(medias.stream().map(MediaPlayer::new).collect(Collectors.toList()));

    }

    public static MediaPlayer getMediaPlayerByInteger(int index) {

        return mediaPlayers.get(index);

    }
}
