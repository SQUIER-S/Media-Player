package pl.squier.player.model;

/**
 * Created by SQUIER
 * on 2015-10-29.
 */
public class PlayerModel {

    private AudioPlayer audioPlayer;
    private Playlist playlist;

    public PlayerModel() {

        playlist = new Playlist();
        audioPlayer = new AudioPlayer(playlist);

    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public Playlist getPlaylist() {
        return playlist;
    }


}
