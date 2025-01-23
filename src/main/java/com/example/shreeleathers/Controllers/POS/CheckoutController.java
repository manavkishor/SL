package com.example.shreeleathers.Controllers.POS;


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
    public ObservableList<CartItems> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        items_listView.setCellFactory(e -> new CartItemCellFactory());
        Platform.runLater(this::getListItems);
        getBillDetails();
    }

    private void getListItems()
    {
        try
        {
            for(int i =0; i<SaleController.getInstance().data.size(); i++)
            {
                String ciCode = SaleController.getInstance().data.get(i).getItemCode();
                CartItems fItems = getCartItems(i, ciCode);
                data.add(fItems);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        items_listView.setItems(data);
    }

    private static CartItems getCartItems(int i, String ciCode) {
        String ciName = SaleController.getInstance().data.get(i).getItemName();
        String ciSize = SaleController.getInstance().data.get(i).getSize();
        String ciQty = SaleController.getInstance().data.get(i).getQuantity();
        String ciSm = SaleController.getInstance().data.get(i).getSalesman();
        double ciRate = SaleController.getInstance().data.get(i).getRate();
        CartItems fItems = new CartItems(ciCode, ciName, ciSize, ciQty, ciRate, ciSm);
        return fItems;
    }

    private void getBillDetails()
    {}
}

