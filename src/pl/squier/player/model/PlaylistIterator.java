package pl.squier.player.model;

/**
 * Created by SQUIER
 * on 2015-10-22.
 */
public class PlaylistIterator {

    private static int number = 0;

    public static void setNext() {

        if(number < AudioPlayer.getMediaPlayers().size() - 1 ) {
            number++;
        } else if(number == AudioPlayer.getMediaPlayers().size() - 1) {
            number = 0;
        }

    }

    public static void setPrevious() {

        if(number == 0) {
            number = AudioPlayer.getMediaPlayers().size() - 1;
        } else if(number > 0) {
            number--;
        }

    }

    public static int getNumber() {
        return number;
    }


}
