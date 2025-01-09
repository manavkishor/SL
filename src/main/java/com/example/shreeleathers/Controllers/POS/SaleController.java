package com.example.shreeleathers.Controllers.POS;

import com.example.shreeleathers.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SaleController implements Initializable
{
    public Text branch_name_lbl;
    public Label add_line1_lbl;
    public Label add_line2_lbl;
    public TextField customer_name_txt;
    public TextField customer_contact_txt;
    public Text invoice_lbl;
    public Label date_lbl;
    public TextField gst_number_txt;
    public TextField item_code_txt;
    public TextField item_name_txt;
    public TextField colour_txt;
    public ChoiceBox size_selector;
    public TextField quantity_txt;
    public TextField rate_txt;
    public TextField gst_txt;
    public TextField salesman_txt;
    public Button add_item_btn;
    public ListView cart_listview;
    public Button checkout_btn;
    public Button hold_btn;
    public Button save_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        checkout_btn.setOnAction(event -> onCheckOut());
    }

    private void onCheckOut()
    {
        Model.getInstance().getViewFactory().showCheckoutWindow();
    }
}
