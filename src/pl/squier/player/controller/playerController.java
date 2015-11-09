package pl.squier.player.controller;

import javafx.stage.Stage;
import pl.squier.player.controller.refreshers.InnerPlaylistRefresher;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.Playlist;
import pl.squier.player.view.ActionButtons;
import pl.squier.player.view.ControlButtons;
import pl.squier.player.view.InnerPlaylist;
import pl.squier.player.view.Labels;

/**
 * Created by SQUIER
 * on 2015-10-29.
 */
public class PlayerController {


    public PlayerController(ActionButtons ac, ControlButtons cb, InnerPlaylist inp, Labels labels, Stage stage,
                            Playlist playlist, AudioPlayer audioPlayer) {

        /*Adds default view-changing on mouse actions */
        new ActionButtonsViewController(ac.getPrevious(), ac.getPlay(), ac.getNext(),
                ac.getAdd(), ac.getClearList(), ac.getEqualizer(), ac.getShuffle(),
                ac.getList(), ac.getRandom(), ac.getMute());

        /*EXIT - exiting program on click
         *MINIMIZE - minimizing program on click
         */
        new ControlButtonsController(cb.getExit(), cb.getMinimize(), stage);

        /*Possibility of adding files using drag and drop gesture*/
        new InnerPlaylistController(inp.getInnerPlaylist(), playlist);
        /* Refreshing playlist content after adding files to playlist */
        new InnerPlaylistRefresher(playlist.getPlaylist(), inp.getInnerPlaylist());

        /* Adds functionality to buttons
         * ADD  - adding files using file chooser
         * PLAY - play/pause current media
         * NEXT/PREV - switching to next song/switching to previous position on playlist
         * MUTE - turning volume off/on
         */
        new AddButtonController(ac.getAdd(), playlist, stage);
        new PlayButtonController(ac.getPlay(), labels, audioPlayer, playlist);
        new NextAndPrevButtonController(ac.getNext(), ac.getPrevious(), labels, audioPlayer, playlist);
        new MuteButtonController(ac.getMute(), audioPlayer);

    }

}
