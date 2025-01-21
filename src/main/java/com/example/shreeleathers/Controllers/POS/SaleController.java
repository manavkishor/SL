package com.example.shreeleathers.Controllers.POS;

import com.example.shreeleathers.Models.CartItems;
import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Master.Size;
import com.example.shreeleathers.Models.Model;
import javafx.collections.ObservableList;
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
    public ChoiceBox<Size> size_selector;
    public TextField quantity_txt;
    public TextField rate_txt;
    public TextField gst_txt;
    public TextField salesman_txt;
    public Button add_item_btn;
    public ListView<CartItems> cart_listview;
    public Button checkout_btn;
    public Button hold_btn;
    public Button reset_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)

    {
        ObservableList<Firm> fm = Model.getInstance().getDatabaseDriver().getFirm();
        String bn = fm.getFirst().getFirmName();
        String a1 = fm.getFirst().getAdd1();
        String a2 = fm.getFirst().getAdd2();
        branch_name_lbl.setText(bn);
        add_line1_lbl.setText(a1);
        add_line2_lbl.setText(a2);

        customer_name_txt.setText(Model.getInstance().getDatabaseDriver().getAccounts().getFirst().getAccName());
        item_code_txt.focusedProperty().addListener((observable, oldVal, newVal) ->
        {
            if(newVal)
            {
                lockCustomerDetails();
            }
        });
        item_name_txt.focusedProperty().addListener((observable, oldVal, newVal) ->
        {
            if(newVal)
            {
                lockCustomerDetails();
            }
        });
        colour_txt.focusedProperty().addListener((observable, oldVal, newVal) ->
        {
            if(newVal)
            {
                lockCustomerDetails();
            }
        });
        size_selector.focusedProperty().addListener((observable, oldVal, newVal) ->
        {
            if(newVal)
            {
                lockCustomerDetails();
            }
        });
        quantity_txt.focusedProperty().addListener((observable, oldVal, newVal) ->
        {
            if(newVal)
            {
                lockCustomerDetails();
            }
        });
        rate_txt.focusedProperty().addListener((observable, oldVal, newVal) ->
        {
            if(newVal)
            {
                lockCustomerDetails();
            }
        });
        gst_txt.focusedProperty().addListener((observable, oldVal, newVal) ->
        {
            if(newVal)
            {
                lockCustomerDetails();
            }
        });
        salesman_txt.focusedProperty().addListener((observable, oldVal, newVal) ->
        {
            if(newVal)
            {
                lockCustomerDetails();
            }
        });
        add_item_btn.focusedProperty().addListener((observable, oldVal, newVal) ->
        {
            if(newVal)
            {
                lockCustomerDetails();
            }
        });
        checkout_btn.setOnAction(event -> onCheckOut());
        reset_btn.setOnAction(event -> onReset());
    }

    private void onCheckOut()

    {
        Model.getInstance().getViewFactory().showCheckoutWindow();
    }

    private void lockCustomerDetails()
    {
        customer_name_txt.setEditable(false);
        customer_name_txt.setStyle("-fx-background-color : #EEEEEE");
        customer_contact_txt.setEditable(false);
        customer_contact_txt.setStyle("-fx-background-color : #EEEEEE");
        gst_number_txt.setEditable(false);
        gst_number_txt.setStyle("-fx-background-color : #EEEEEE");
    }

    private void onReset()
    {
        customer_name_txt.setText(Model.getInstance().getDatabaseDriver().getAccounts().getFirst().getAccName());
        customer_contact_txt.clear();
        gst_number_txt.clear();
        customer_name_txt.setEditable(true);
        customer_name_txt.setStyle("-fx-background-color : #FFFFFF");
        customer_contact_txt.setEditable(true);
        customer_contact_txt.setStyle("-fx-background-color : #FFFFFF");
        gst_number_txt.setEditable(true);
        gst_number_txt.setStyle("-fx-background-color : #FFFFFF");
        item_code_txt.clear();
        item_name_txt.clear();
        colour_txt.clear();
        size_selector.setValue(null);
        quantity_txt.clear();
        rate_txt.clear();
        gst_txt.clear();
        salesman_txt.clear();
        cart_listview.setItems(null);
    }
}
