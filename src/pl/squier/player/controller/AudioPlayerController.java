package pl.squier.player.controller;

import pl.squier.player.controller.refreshers.ElapsingTimeRefresher;
import pl.squier.player.miscellaneous.MediaDuration;
import pl.squier.player.model.PlaylistIterator;

import static pl.squier.player.model.AudioPlayer.getMediaPlayerByInteger;
import static pl.squier.player.model.AudioPlayer.getMediaPlayers;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class AudioPlayerController {

    public AudioPlayerController(){

        for (int i = 0; i < getMediaPlayers().size(); i++) {

            getMediaPlayers().get(i).setOnEndOfMedia(() -> {
                getMediaPlayerByInteger(PlaylistIterator.getNumber()).stop();
                PlaylistIterator.setNext();
                MediaDuration.duration = getMediaPlayerByInteger(PlaylistIterator.getNumber()).getMedia().getDuration();
                getMediaPlayerByInteger(PlaylistIterator.getNumber()).play();
            });

            getMediaPlayers().get(i).currentTimeProperty().addListener(observable -> {

                ElapsingTimeRefresher.refreshLabel();

            });


        }

    }


}
