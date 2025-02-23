package com.example.shreeleathers.Controllers.POS;

import com.example.shreeleathers.Models.Sale.CartItems;
import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Master.Salesman;
import com.example.shreeleathers.Models.Model;
import com.example.shreeleathers.Views.CartItemCellFactory;
import com.example.shreeleathers.Views.POSMenuOptions;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public ObservableList<CartItems> data = FXCollections.observableArrayList();
    public CartItems items;
    public Button checkout_btn;
    public Button hold_btn;
    public Button reset_btn;
    public ChoiceBox<Salesman> salesman_selector;
    public Button remove_item_btn;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public ObservableList<Firm> fm = FXCollections.observableArrayList();
    public String custGSTNumber;
    public String firmGSTNumber;
    public TextField total_amt_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Platform.runLater(() -> customer_name_txt.requestFocus());
        invoice_lbl.setText(Model.getInstance().getUser().getSystemAssigned() + "/" + Model.getInstance().getDatabaseDriver().getSaleDBServices().getInvoice(POSMenuOptions.SALE));
        customer_name_txt.setText(Model.getInstance().getDatabaseDriver().getAccounts().getFirst().getAccName());
        fm = Model.getInstance().getDatabaseDriver().getFirm();
        String bn = fm.getFirst().getFirmName();
        String a1 = fm.getFirst().getAdd1();
        String a2 = fm.getFirst().getAdd2();
        firmGSTNumber = fm.getFirst().getGSTNumber();
        branch_name_lbl.setText(bn);
        add_line1_lbl.setText(a1);
        add_line2_lbl.setText(a2);
        custGSTNumber = gst_number_txt.getText();
        salesman_selector.setItems(Model.getInstance().getDatabaseDriver().getSalesman());
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
        total_amt_txt.focusedProperty().addListener((observable, oldVal, newVal) ->
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
        total_amt_txt.setEditable(false);
        item_code_txt.textProperty().addListener(observable -> setItemName());
        item_code_txt.textProperty().addListener(observable -> setColour());
        item_name_txt.textProperty().addListener(observable -> setSz());
        item_code_txt.textProperty().addListener(observable -> setRate());
        item_code_txt.textProperty().addListener(observable -> setGST());
        item_code_txt.textProperty().addListener(observable -> setQuantity());
        quantity_txt.textProperty().addListener(observable -> setTotalAmount());
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalDateTime currentTime = LocalDateTime.now();
            date_lbl.setText(currentTime.format(formatter));
        }), new KeyFrame(Duration.seconds(1)) // Update every second
        );
        clock.setCycleCount(Timeline.INDEFINITE);
        clock.play();
        checkout_btn.setOnAction(event -> onCheckOut());
        add_item_btn.setOnAction(event -> onAddItem());
        reset_btn.setOnAction(event -> onReset());
    }

    private void onCheckOut()

    {
        if(data.isEmpty())
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/MessageBox.fxml"));
            Model.getInstance().getViewFactory().showMessageBox(loader, "WARNING!!!!");
            Model.getInstance().getMessageBoxController(loader).giveError("Entry Missing!");
        }
        else
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/POS/Checkout.fxml"));
            Model.getInstance().getViewFactory().showCheckoutWindow(loader, "Checkout");
            CheckoutController controller = loader.getController();
            double payableAmt = 0.00;
            for (CartItems datum : data) {
                double itemAmt = (datum.getRate() * datum.getQuantity());
                payableAmt = payableAmt + itemAmt;
            }
            controller.setBillDetails(payableAmt);
            controller.setRoundOff(payableAmt);
            controller.setData(data, invoice_lbl.getText(), customer_name_txt.getText(), customer_contact_txt.getText(), custGSTNumber, firmGSTNumber, branch_name_lbl.getText(), add_line1_lbl.getText(), add_line2_lbl.getText());
        }
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

    private void setQuantity()
    {
        if(item_code_txt.getText() != null)
        {
            quantity_txt.setText("1");
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

    private void setSz()
    {
        if(item_name_txt.getText() != null)
        {
            String itemName = item_name_txt.getText();
            try
            {
                ResultSet rs = Model.getInstance().getDatabaseDriver().getSaleDBServices().getSizeByItemCode(itemName);
                rs.next();
                int id = rs.getInt("Size_Id");
                switch(id)
                {
                    case 1 : size_selector.setItems(FXCollections.observableArrayList(rs.getString("S1")));
                    break;
                    case 2 : size_selector.setItems(FXCollections.observableArrayList(rs.getString("S1"), rs.getString("S2"), rs.getString("S3"),
                            rs.getString("S4"), rs.getString("S5"), rs.getString("S6"),
                            rs.getString("S7"), rs.getString("S8"), rs.getString("S9"), rs.getString("S10"),
                            rs.getString("S11"), rs.getString("S12"), rs.getString("S13")));
                    break;
                    case 3 : size_selector.setItems(FXCollections.observableArrayList(rs.getString("S1"), rs.getString("S2"), rs.getString("S3"),
                            rs.getString("S4"), rs.getString("S5"), rs.getString("S6"),
                            rs.getString("S7"), rs.getString("S8"), rs.getString("S9"), rs.getString("S10")));
                    break;
                    case 4 : size_selector.setItems(FXCollections.observableArrayList(rs.getString("S1"), rs.getString("S2"), rs.getString("S3"),
                            rs.getString("S4"), rs.getString("S5"), rs.getString("S6"),
                            rs.getString("S7"), rs.getString("S8"), rs.getString("S9")));
                    break;
                    case 5, 6: size_selector.setItems(FXCollections.observableArrayList(rs.getString("S1"), rs.getString("S2"), rs.getString("S3"),
                            rs.getString("S4"), rs.getString("S5"), rs.getString("S6"),
                            rs.getString("S7")));
                    break;
                }
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

    private void setTotalAmount()
    {
        double total = 0.00;
        double rate = Double.parseDouble(rate_txt.getText());
        int qty = Integer.parseInt(quantity_txt.getText());
        total = rate*qty;
        total_amt_txt.setText(String.format("%.2f", total));
    }

    private void onAddItem()
    {
        if(item_code_txt.getText()!=null && item_name_txt.getText()!=null && size_selector.getValue()!=null && salesman_selector.getValue().getSmCode()!=null &&
                quantity_txt.getText()!=null && rate_txt.getText()!=null)
        {
            String iCode = item_code_txt.getText();
            String iName = item_name_txt.getText();
            String iSize = size_selector.getValue();
            int iQty = Integer.parseInt(quantity_txt.getText());
            double iDisc = 0.00;
            String iSm = salesman_selector.getValue().getSmCode();
            double iRate = Double.parseDouble(rate_txt.getText());
            items = new CartItems(iCode, iName, iSize, iQty, iDisc, iRate, iSm);
            data.add(items);
        }
        else
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/MessageBox.fxml"));
            Model.getInstance().getViewFactory().showMessageBox(loader, "WARNING!!!!");
            Model.getInstance().getMessageBoxController(loader).giveError("Missing Entry!");
        }
        cart_listview.setItems(data);
        clearValues();
        item_code_txt.requestFocus();
    }

    private void onRemove()
    {
        int si = cart_listview.getSelectionModel().getSelectedIndex();
        cart_listview.getItems().remove(si);
        cart_listview.getSelectionModel().clearSelection();
        item_code_txt.requestFocus();
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
        total_amt_txt.clear();
        rate_txt.clear();
        gst_txt.clear();
        salesman_selector.setValue(null);
        cart_listview.setItems(null);
        data.clear();
        customer_name_txt.requestFocus();
    }

    private void clearValues()
    {
        item_code_txt.setText("");
        item_name_txt.setText("");
        colour_txt.setText("");
        quantity_txt.setText("");
        total_amt_txt.setText("");
        rate_txt.setText("");
        gst_txt.setText("");
        size_selector.setValue(null);
        salesman_selector.setValue(null);
    }
}
