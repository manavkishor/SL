package com.example.shreeleathers.Controllers.POS;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class POSMenuController implements Initializable
{
    public Text user_lbl;
    public Button sale_btn;
    public Button exchange_btn;
    public Button saleReturn_btn;
    public Button cash_bank_btn;
    public Button dayClose_btn;
    public Button report_btn;
    public ImageView imageView;
    public Button sale_details_btn;
    public Button expenses_btn;
    public Button day_sheet_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/SL_Logo.png")));
        imageView.setImage(image);
    }
}
