package pl.squier.player.controller;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by SQUIER
 * on 2015-10-21.
 */
public class MovableWindowController {

    private Point2D previousLocation;
    private Point2D anchor;

    public MovableWindowController(Stage stage, Scene scene) {

        stage.addEventHandler(WindowEvent.WINDOW_SHOWN, (WindowEvent e) -> {
            previousLocation = new Point2D(stage.getX(), stage.getY());
        });

        scene.setOnMousePressed(mouseEvent -> {
            anchor = new Point2D(mouseEvent.getScreenX(), mouseEvent.getScreenY());
        });

        scene.setOnMouseDragged(mouseEvent -> {
            if(anchor != null && previousLocation != null) {
                stage.setX(previousLocation.getX() + mouseEvent.getScreenX() - anchor.getX());
                stage.setY(previousLocation.getY() + mouseEvent.getScreenY() - anchor.getY());
            }
        });

        scene.setOnMouseReleased(mouseEvent -> {
            previousLocation = new Point2D(stage.getX(), stage.getY());
        });
    }

}
