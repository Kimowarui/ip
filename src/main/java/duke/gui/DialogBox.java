package duke.gui;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * An example of a custom control using FXML.
 * This control represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        displayPicture.setImage(img);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    public static DialogBox getUserDialog(String text, Image img) {
        DialogBox dialogBox = new DialogBox(text, img);
        dialogBox.dialog.setStyle("-fx-border-color:#FFADAD; -fx-border-style:solid; -fx-border-width:4;"
                + "-fx-border-radius:10px; -fx-background-color:#FFADAD; -fx-background-radius: 12px;"
                + "-fx-padding: 10;"
                + "-fx-spacing: 10;"
                + "-fx-alignment: center;"
                + "-fx-font-size: 18;");
        return dialogBox;
    }

    public static DialogBox getDukeDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        db.flip();
        db.dialog.setStyle("-fx-border-color:#CECCFD; -fx-border-style:solid; -fx-border-width:4;"
                + "-fx-border-radius:10px; -fx-background-color:#CECCFD;; -fx-background-radius: 12px;"
                + "-fx-padding: 10;"
                + "-fx-spacing: 10;"
                + "-fx-alignment: center;"
                + "-fx-font-size: 12;");
        return db;
    }
}
