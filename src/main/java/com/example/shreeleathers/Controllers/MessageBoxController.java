package com.example.shreeleathers.Controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageBoxController implements Initializable
{
    public FontAwesomeIconView msg_typ_icon;
    public Text msg_typ_lbl;
    public Label message_lbl;
    public Button ok_btn;
    public Button close_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }

    public void giveWarning(String message)
    {
        message_lbl.setText(message);
        msg_typ_lbl.setText("WARNING!");
        msg_typ_icon.setGlyphName("WARNING");
        msg_typ_icon.setGlyphStyle("-fx-fill : yellow");
        close_btn.setVisible(false);
        Stage stage = (Stage) message_lbl.getScene().getWindow();
        ok_btn.setOnAction(e -> stage.close());
    }

    public void giveError(String message)
    {
        message_lbl.setText(message);
        msg_typ_lbl.setText("ERROR!");
        msg_typ_icon.setGlyphName("TIMES_CIRCLE_ALT");
        msg_typ_icon.setGlyphStyle("-fx-fill : red");
        ok_btn.setVisible(false);
        Stage stage = (Stage) message_lbl.getScene().getWindow();
        close_btn.setOnAction(e -> stage.close());
    }

    public void askQuestion(String message)
    {
        message_lbl.setText(message);
        msg_typ_lbl.setText("QUESTION?");
        msg_typ_icon.setGlyphName("QUESTION_CIRCLE");
        Stage stage = (Stage) message_lbl.getScene().getWindow();
        close_btn.setOnAction(e -> stage.close());
        ok_btn.setOnAction(event -> doAction());
    }

    private void doAction()
    {
        System.out.println("Data set to database");
        Stage stage = (Stage) message_lbl.getScene().getWindow();
        stage.close();
    }
}
