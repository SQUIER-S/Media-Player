package pl.squier.player.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.List;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayer {

    private Playlist playlist;
    private MediaPlayer currentPlayer = null;
    private static boolean MUTE_PROPERTY = false;

    public AudioPlayer(Playlist playlist) {

        this.playlist = playlist;

    }

    public void createNewCurrent() {
        currentPlayer = new MediaPlayer(new Media(playlist.getCurrentFile().toURI().toString()));
        currentPlayer.setMute(MUTE_PROPERTY);

    }

    public void createById(int id) {
        currentPlayer = new MediaPlayer((new Media(playlist.getFileByInteger(id).toURI().toString())));
        currentPlayer.setMute(MUTE_PROPERTY);
        setNewCurrent(id);
    }

    public MediaPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public MediaPlayer.Status getMediaPlayerStatus() {
        return currentPlayer.getStatus();
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public String getCurrentMediaName() {
        return playlist.getCurrentFile().getName();
    }

    public Duration getCurrentMediaDuration() {
        return currentPlayer.getMedia().getDuration();
    }

    public static boolean isMute() {
        return MUTE_PROPERTY;
    }

    public static void setMuteProperty(boolean muteProperty) {
        AudioPlayer.MUTE_PROPERTY = muteProperty;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public void prepareNext() {
        currentPlayer = new MediaPlayer(new Media(playlist.setNext().toURI().toString()));
        currentPlayer.setMute(MUTE_PROPERTY);
    }

    public void preparePrevious() {
        currentPlayer = new MediaPlayer(new Media(playlist.setPrevious().toURI().toString()));
        currentPlayer.setMute(MUTE_PROPERTY);
    }

    public void setNewCurrent(int id) {playlist.setCurrent(id);}

    public void addToPlaylist(List<File> playlist) {
        this.playlist.addToPlaylist(playlist);
    }
}
