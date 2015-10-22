package pl.squier.player.controller.loaders;

import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class LoadPlaylistToAudioPlayer {

    public static void load() {

        MediaCreator mc = new MediaCreator(Playlist.getPlaylist());
        AudioPlayer.addMediaToAudioPlayer(mc.getMedias());

    }

}
