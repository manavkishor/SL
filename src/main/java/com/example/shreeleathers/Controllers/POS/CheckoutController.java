package com.example.shreeleathers.Controllers.POS;


import com.example.shreeleathers.Models.Model;
import com.example.shreeleathers.Models.Sale.CartItems;
import com.example.shreeleathers.Views.CartItemCellFactory;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
    public ListView<CartItems> items_listView;
    public double cashAmt;
    public double cardAmt;
    public double upiAmt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Platform.runLater(() -> cash_paid_txt.requestFocus());
        items_listView.setCellFactory(e -> new CartItemCellFactory());
        card_paid_txt.textProperty().addListener(observable -> setPaidDetails());
        cash_paid_txt.textProperty().addListener(observable -> setPaidDetails());
        upi_paid_txt.textProperty().addListener(observable -> setPaidDetails());
        round_off_lbl.textProperty().addListener(observable -> getChange());
    }

    public void setData(ObservableList<CartItems> items)
    {
        items_listView.setItems(items);
    }

    public void setBillDetails(double payableAmount)
    {
        payable_amount_lbl.setText(String.valueOf(payableAmount));
    }

    private void setPaidDetails()
    {
        cardAmt = Double.parseDouble(card_paid_txt.getText());
        cashAmt = Double.parseDouble(cash_paid_txt.getText());
        upiAmt = Double.parseDouble(upi_paid_txt.getText());
        paid_amount_lbl.setText(String.valueOf(cardAmt + cashAmt + upiAmt));
    }

    private void getChange()
    {
        round_off_lbl.setText(String.valueOf(Double.parseDouble(payable_amount_lbl.getText()) - Double.parseDouble(paid_amount_lbl.getText())));
    }
}

