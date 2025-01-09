package com.example.shreeleathers.Controllers.POS;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckoutController implements Initializable
{
    public Text payable_amount_lbl;
    public Text paid_amount_lbl;
    public Text round_off_lbl;
    public TextField cash_paid_txt;
    public TextField card_paid_txt;
    public TextField upi_paid_txt;
    public Button print_btn;
    public Button hold_btn;
    public Button save_btn;
    public Button modify_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
