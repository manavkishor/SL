package com.example.shreeleathers.Controllers.POS;

import com.example.shreeleathers.Models.Sale.CartItems;
import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Master.Salesman;
import com.example.shreeleathers.Models.Model;
import com.example.shreeleathers.Views.CartItemCellFactory;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public ChoiceBox<String> size_selector;
    public TextField quantity_txt;
    public TextField rate_txt;
    public TextField gst_txt;
    public Button add_item_btn;
    public ListView<CartItems> cart_listview;
    public ObservableList<CartItems> data;
    public Button checkout_btn;
    public Button hold_btn;
    public Button reset_btn;
    public ChoiceBox<Salesman> salesman_selector;
    public Button remove_item_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)

    {
        Platform.runLater(() -> customer_name_txt.requestFocus());
        customer_name_txt.setText(Model.getInstance().getDatabaseDriver().getAccounts().getFirst().getAccName());
        ObservableList<Firm> fm = Model.getInstance().getDatabaseDriver().getFirm();
        String bn = fm.getFirst().getFirmName();
        String a1 = fm.getFirst().getAdd1();
        String a2 = fm.getFirst().getAdd2();
        branch_name_lbl.setText(bn);
        add_line1_lbl.setText(a1);
        add_line2_lbl.setText(a2);
        salesman_selector.setItems(Model.getInstance().getDatabaseDriver().getSalesman());
        data = FXCollections.observableArrayList();
        cart_listview.setItems(data);
        cart_listview.setCellFactory(e-> new CartItemCellFactory());
        cart_listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        remove_item_btn.setOnAction(event -> onRemove());
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
        salesman_selector.focusedProperty().addListener((observable, oldVal, newVal) ->
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
        item_name_txt.setEditable(false);
        colour_txt.setEditable(false);
        rate_txt.setEditable(false);
        gst_txt.setEditable(false);
        item_code_txt.textProperty().addListener(observable -> setItemName());
        item_code_txt.textProperty().addListener(observable -> setColour());
        item_name_txt.textProperty().addListener(observable -> setSize());
        item_code_txt.textProperty().addListener(observable -> setRate());
        item_code_txt.textProperty().addListener(observable -> setGST());
        checkout_btn.setOnAction(event -> onCheckOut());
        add_item_btn.setOnAction(event -> onAddItem());
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

    private void setItemName()
    {
        if(item_code_txt.getText() != null)
        {
            String itemCode = item_code_txt.getText();
            item_name_txt.setText(Model.getInstance().getDatabaseDriver().getSaleDBServices().getItemNameByCode(itemCode));
        }
    }

    private void setColour()
    {
        if(item_code_txt.getText() != null)
        {
            String itemCode = item_code_txt.getText();
            colour_txt.setText(Model.getInstance().getDatabaseDriver().getSaleDBServices().getColourByCode(itemCode));
        }
    }

    private void setSize()
    {
        if(item_name_txt.getText() != null)
        {
            String itemName = item_name_txt.getText();
            try
            {
                ResultSet rs = Model.getInstance().getDatabaseDriver().getSaleDBServices().getSizeByItemCode(itemName);
                rs.next();
                size_selector.setItems(FXCollections.observableArrayList(rs.getString("S1"), rs.getString("S2"), rs.getString("S3"),
                        rs.getString("S4"), rs.getString("S5"), rs.getString("S6"),
                        rs.getString("S7"), rs.getString("S8"), rs.getString("S9"), rs.getString("S10"),
                        rs.getString("S11"), rs.getString("S12"), rs.getString("S13")));
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void setRate()
    {
        if(item_code_txt.getText() != null)
        {
            String itemCode = item_code_txt.getText();
            rate_txt.setText(String.valueOf(Model.getInstance().getDatabaseDriver().getSaleDBServices().getRateByCode(itemCode)));
        }
    }

    private void setGST()
    {
        if(item_code_txt.getText() != null)
        {
            String itemCode = item_code_txt.getText();
            gst_txt.setText(String.valueOf(Model.getInstance().getDatabaseDriver().getSaleDBServices().getGSTByCode(itemCode)));
        }
    }

    private void onAddItem()
    {
        String itemCode = item_code_txt.getText();
        String itemName = item_name_txt.getText();
        String size = size_selector.getValue();
        String qty = quantity_txt.getText();
        double rate = Double.parseDouble(rate_txt.getText());
        String sm = salesman_selector.getValue().getSmCode();
        data.add(new CartItems(itemCode, itemName, size, qty + "pc", rate, sm));
        cart_listview.setItems(data);
        item_code_txt.setText("");
        item_name_txt.setText("");
        colour_txt.setText("");
        quantity_txt.setText("");
        rate_txt.setText("");
        gst_txt.setText("");
        size_selector.setValue(null);
        salesman_selector.setValue(null);
    }

    private void onRemove()
    {
        int si = cart_listview.getSelectionModel().getSelectedIndex();
        if(si>=0)
        {
            cart_listview.getItems().remove(si);
        }
        cart_listview.getSelectionModel().clearSelection();
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
        salesman_selector.setValue(null);
        cart_listview.setItems(null);
        customer_name_txt.requestFocus();
    }
}
