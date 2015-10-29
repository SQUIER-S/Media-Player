package pl.squier.player.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.squier.player.controller.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SQUIER
 * on 2015-10-16.
 */
public class ActionButtons {

    /*
     * Large buttons
     */
    private Button previous;
    private Button play;
    private Button next;
    private Button add;

    /*
     * Buttons group
     */
    private Button shuffle;
    private Button random;
    private Button equalizer;
    private Button clearList;

    /*
     * Small buttons
     */
    private Button mute;
    private Button list;

    private TilePane actionLButtons;

    private TilePane actionSButtons;

    public ActionButtons() {

        createActionButtons();

        createSmallButtons();

        new ActionButtonsViewController(previous, play,
                next, add, shuffle,
                list, equalizer,
                clearList, mute, random);

    }

    private void createSmallButtons() {
        initSmallButtons();
        actionSButtons = new TilePane();
        actionSButtons.setAlignment(Pos.CENTER_LEFT);
        actionSButtons.setHgap(10);
        actionSButtons.getChildren().addAll(mute, list);
    }

    private void initSmallButtons() {
        Image icon;
        String pathToImages = "../res/images/";

        mute = new Button();
        icon = new Image(getClass().getResourceAsStream(pathToImages + "mute.png"));
        mute.setGraphic(new ImageView(icon));
        mute.getStyleClass().add("smallButton");

        list = new Button();
        icon = new Image(getClass().getResourceAsStream(pathToImages + "list.png"));
        list.setGraphic(new ImageView(icon));
        list.getStyleClass().add("smallButton");
    }

    private void createActionButtons() {
        actionLButtons = new TilePane();
        actionLButtons.setAlignment(Pos.CENTER);
        actionLButtons.setHgap(15);
        actionLButtons.setVgap(10);
        actionLButtons.getChildren().addAll(createLargeButtons());
        actionLButtons.getChildren().addAll(createButtonsGroup(), add);
    }

    private List<Button> createLargeButtons() {
        Image icon;
        List<Button> buttons = new ArrayList<>();
        String pathToImages = "../res/images/";

        previous = new Button();
        icon = new Image(getClass().getResourceAsStream(pathToImages + "previousButton.png"));
        previous.setGraphic(new ImageView(icon));

        play = new Button();
        icon = new Image(getClass().getResourceAsStream(pathToImages + "playButton.png"));
        play.setGraphic(new ImageView(icon));

        next = new Button();
        icon = new Image(getClass().getResourceAsStream(pathToImages + "nextButton.png"));
        next.setGraphic(new ImageView(icon));

        add = new Button();
        icon = new Image(getClass().getResourceAsStream(pathToImages + "addButton.png"));
        add.setGraphic(new ImageView(icon));

        buttons.add(previous);
        buttons.add(play);
        buttons.add(next);

        return buttons;
    }


    /*
     * group of buttons
     */
    private VBox createButtonsGroup() {
        Image icon;
        String pathToImages = "../res/images/";

        VBox v = new VBox(2);
        v.setSpacing(0);
        HBox h1 = new HBox();
        h1.setSpacing(0);

        shuffle = new Button();
        shuffle.getStyleClass().add("top_left");
        icon = new Image(getClass().getResourceAsStream(pathToImages + "shuffleButton.png"));
        shuffle.setGraphic(new ImageView(icon));
        shuffle.setPadding(new Insets(7, 0, 0, 5));

        random = new Button("R");
        random.getStyleClass().add("top_right");
        random.setPadding(new Insets(5, 8, 0, 0));

        h1.getChildren().addAll(shuffle, random);

        equalizer = new Button("EQ");
        equalizer.getStyleClass().add("bottom_left");
        equalizer.setPadding(new Insets(0, 0, 5, 5));
        equalizer.setDisable(true);

        clearList = new Button("C");
        clearList.getStyleClass().add("bottom_right");
        clearList.setPadding(new Insets(0, 5, 5, 0));

        HBox h2 = new HBox();
        h2.setSpacing(0);

        h2.getChildren().addAll(equalizer, clearList);

        v.getChildren().addAll(h1, h2);

        return v;
    }

    public TilePane getLargeButtons() {
        return actionLButtons;
    }

    public TilePane getSmallButtons() {
        return actionSButtons;
    }

    public Button getPrevious() {
        return previous;
    }

    public Button getPlay() {
        return play;
    }

    public Button getNext() {
        return next;
    }

    public Button getAdd() {
        return add;
    }

    public Button getShuffle() {
        return shuffle;
    }

    public Button getRandom() {
        return random;
    }

    public Button getEqualizer() {
        return equalizer;
    }

    public Button getClearList() {
        return clearList;
    }

    public Button getMute() {
        return mute;
    }

    public Button getList() {
        return list;
    }

}
