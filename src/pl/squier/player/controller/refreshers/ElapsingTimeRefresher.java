package pl.squier.player.controller.refreshers;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import pl.squier.player.miscellaneous.MediaDuration;

/**
 * Created by SQUIER
 * on 2015-10-23.
 */
public class ElapsingTimeRefresher {

    public static void refreshLabel(Label elapsingTime, MediaPlayer mediaPlayer) {

        if (elapsingTime != null) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Duration currentTime = mediaPlayer.getCurrentTime();
                    elapsingTime.setText(formatTime(currentTime, MediaDuration.duration));
                }


                private String formatTime(Duration _elapsed, Duration _duration) {
                    /*
                     * calculating elapsed time
                     */
                    int elapsedTime = (int) Math.floor(_elapsed.toSeconds());
                    int elapsedMinutes = elapsedTime / 60;
                    int elapsedSeconds = elapsedTime - (elapsedMinutes * 60);

                    /*
                     * calculating duration of current media
                     */
                    if (_duration.greaterThan(Duration.ZERO)) {
                        int duration = (int) Math.floor(_duration.toSeconds());
                        int durationMinutes = duration / 60;
                        int durationSeconds = duration - (durationMinutes * 60);

                        return String.format("%02d:%02d/%02d:%02d",
                                elapsedMinutes, elapsedSeconds,
                                durationMinutes, durationSeconds);
                    } else {
                        return "something fucked";
                    }
                }
            });
        }

    }

}
