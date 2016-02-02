package pl.squier.player.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.miscellaneous.PlayerMuteProperty;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayer {

    private Playlist playlist;
    private MediaPlayer currentPlayer = null;
    private static boolean muteProperty = false;

    public AudioPlayer(Playlist playlist) {

        this.playlist = playlist;

    }

    public void createNewCurrent() {
        currentPlayer = new MediaPlayer(new Media(playlist.getCurrentFile().toURI().toString()));
        currentPlayer.setMute(muteProperty);

    }

    public MediaPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public MediaPlayer.Status getMediaPlayerStatus() {
        return currentPlayer.getStatus();
    }

    public static boolean isMuteProperty() {
        return muteProperty;
    }

    public static void setMuteProperty(boolean muteProperty) {
        AudioPlayer.muteProperty = muteProperty;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void prepareNext() {
        currentPlayer = new MediaPlayer(new Media(playlist.setNext().toURI().toString()));
        currentPlayer.setMute(muteProperty);
    }

    public void preparePrevious() {
        currentPlayer = new MediaPlayer(new Media(playlist.setPrevious().toURI().toString()));
        currentPlayer.setMute(muteProperty);
    }

    public String getCurrentMediaName() {
        return playlist.getCurrentFile().getName();
    }

    public Duration getCurrentMediaDuration() {
        return currentPlayer.getMedia().getDuration();
    }
}
