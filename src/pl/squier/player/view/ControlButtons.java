package pl.squier.player.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

/**
 * Created by SQUIER
 * on 2015-10-16.
 *
 * Exit and minimize buttons
 */
public class ControlButtons {

    /**
     * control buttons
     */
    private Button exit, minimize;

    private TilePane controlButtons;

    public ControlButtons() {
        initControlButtons();


        addControlButtons();
    }

    private void initControlButtons() {
        /*
         * exit button
         */
        exit = new Button("X");
        exit.getStyleClass().add("controlButtons");
        exit.setPadding(new Insets(0));
        exit.setOnMouseEntered(mouseEvent -> exit.setStyle("-fx-background-color: rgba(230, 0, 0, 130)"));
        exit.setOnMouseExited(mouseEvent -> exit.setStyle("-fx-background-color: rgba(0, 0, 0, 0)"));

        /*
		 * minimize button
		 */
        minimize = new Button("---");
        minimize.getStyleClass().add("controlButtons");
        minimize.setPadding(new Insets(0));
        minimize.setOnMouseEntered(mouseEvent -> minimize.setStyle("-fx-background-color: rgba(0, 150, 220, 130)"));
        minimize.setOnMouseExited(mouseEvent -> minimize.setStyle("-fx-background-color: rgba(0, 0, 0, 0)"));
    }

    private void addControlButtons() {
        controlButtons = new TilePane();
        controlButtons.setAlignment(Pos.TOP_RIGHT);
        controlButtons.getChildren().addAll(minimize, exit);
    }

    public TilePane getButtons() {
        return controlButtons;
    }

}
