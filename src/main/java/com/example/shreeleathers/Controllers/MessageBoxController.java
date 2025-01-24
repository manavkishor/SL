package com.example.shreeleathers.Controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

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
}
