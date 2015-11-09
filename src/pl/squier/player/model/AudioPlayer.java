package pl.squier.player.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import pl.squier.player.miscellaneous.PlayerMuted;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayer {

    private Playlist playlist;
    private MediaPlayer currentPlayer = null;

    public AudioPlayer(Playlist playlist) {

        this.playlist = playlist;

    }

    public void createNewCurrent() {
        currentPlayer = new MediaPlayer(new Media(playlist.getCurrentFile().toURI().toString()));
        currentPlayer.setMute(PlayerMuted.isMuted);

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
}
