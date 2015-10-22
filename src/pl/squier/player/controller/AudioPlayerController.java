package pl.squier.player.controller;

import pl.squier.player.model.PlaylistIterator;

import static pl.squier.player.model.AudioPlayer.getMediaPlayerByInteger;
import static pl.squier.player.model.AudioPlayer.getMediaPlayers;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayerController {

    public AudioPlayerController()

        for (int i = 0; i < getMediaPlayers().size(); i++) {
            getMediaPlayers().get(i).setOnEndOfMedia(() -> {
                getMediaPlayerByInteger(PlaylistIterator.getNumber()).stop();
                PlaylistIterator.setNext();
                getMediaPlayerByInteger(PlaylistIterator.getNumber()).play();
            });
        }

    }


}
