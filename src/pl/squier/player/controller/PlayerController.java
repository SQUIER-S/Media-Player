package pl.squier.player.controller;

import javafx.stage.Stage;
import pl.squier.player.controller.refresh.InnerPlaylistRefresh;
import pl.squier.player.controller.refresh.OuterPlaylistRefresh;
import pl.squier.player.model.AudioPlayer;
import pl.squier.player.model.PlayerModel;
import pl.squier.player.model.Playlist;
import pl.squier.player.view.*;

/**
 * Created by SQUIER
 * on 2015-10-29.
 */
public class PlayerController {


    public PlayerController(PlayerGUI playerGUI, PlayerModel playerModel) {

        ActionButtons ac = playerGUI.getActionButtons();
        ControlButtons cb = playerGUI.getControlButtons();
        InnerPlaylist inp  = playerGUI.getInnerPlaylist();
        Labels labels = playerGUI.getLbls();
        Stage stage = playerGUI.getPRIMARY_STAGE();
        AudioPlayer audioPlayer = playerModel.getAudioPlayer();
        ControlButtons cbOuterPlaylist = playerGUI.getOuterPlaylist().getControlButtons();
        Stage outerStage = playerGUI.getOuterPlaylist().getPRIMARY_STAGE();

        /*Adds view-changing on mouse actions */
        new ButtonsViewController(ac.getPrevious(), ac.getPlay(), ac.getNext(),
                ac.getAdd(), ac.getClearList(), ac.getEqualizer(), ac.getShuffle(),
                ac.getList());

        /*
         *For main program window
         *EXIT - exiting program on click
         *MINIMIZE - minimizing program on click
         */
        new ControlButtonsController(cb.getExit(), cb.getMinimize(), stage, true);
        /*
         *For outer playlist window
         *EXIT - hides playlist
         */
        new ControlButtonsController(cbOuterPlaylist.getExit(), cbOuterPlaylist.getMinimize(), outerStage ,false);

        /*Possibility of adding files using drag and drop gesture*/
        new InnerPlaylistController(inp.getInnerPlaylist(), audioPlayer);
        /* Refreshing playlist content after adding files to playlist */
        new InnerPlaylistRefresh(audioPlayer.getPlaylist().getPlaylist(), inp.getInnerPlaylist());

        /* Adds functionality to buttons
         * ADD  - adding files using file chooser
         * PLAY - play/pause current media
         * NEXT/PREV - switching to next song/switching to previous position on playlist
         * MUTE - turning volume off/on
         * CLEAR - clears playlist
         * RANDOM - sets random play
         */
        new AddButtonController(ac.getAdd(), audioPlayer, stage);
        new PlayButtonController(ac.getPlay(), labels, audioPlayer);
        new NextAndPrevButtonController(ac.getNext(), ac.getPrevious(), labels, audioPlayer);
        new MuteButtonActionController(ac.getMute(), audioPlayer);
        new ClearListController(ac.getClearList(), audioPlayer, labels, ac.getPlay());
        new RandomController(ac.getRandom());
        new ListButtonController(ac.getList(), playerGUI.getOuterPlaylist());
        new OuterPlaylistRefresh(audioPlayer.getPlaylist().getPlaylist(), playerGUI.getOuterPlaylist());
    }

}
