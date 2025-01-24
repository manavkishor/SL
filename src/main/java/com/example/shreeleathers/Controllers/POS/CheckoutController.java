package com.example.shreeleathers.Controllers.POS;


import com.example.shreeleathers.Models.Model;
import com.example.shreeleathers.Models.Sale.CartItems;
import com.example.shreeleathers.Views.CartItemCellFactory;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
//    public String chICode;
//    public String chIName;
//    public String chISize;
//    public String chIQty;
//    public String chISm;
//    public double chIRate;
//    public ObservableList<CartItems> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
//        for (int i = 0; i < SaleController.getInstance().data.size(); i++)
//        {
//            chICode = SaleController.getInstance().data.get(i).itemCodeProperty().get();
//            chIName = SaleController.getInstance().data.get(i).itemNameProperty().get();
//            chISize = SaleController.getInstance().data.get(i).sizeProperty().get();
//            chIQty = SaleController.getInstance().data.get(i).quantityProperty().get();
//            chISm = SaleController.getInstance().data.get(i).salesmanProperty().get();
//            chIRate = SaleController.getInstance().data.get(i).rateProperty().get();
//            CartItems fItems = new CartItems(chICode, chIName, chISize, chIQty, chIRate, chISm);
//            data.add(fItems);
//        }
        Platform.runLater(() -> cash_paid_txt.requestFocus());
//        initList();
        items_listView.setCellFactory(e -> new CartItemCellFactory());
        items_listView.setFocusTraversable(false);
//        items_listView.setItems(Model.getInstance().getList());
    }

//    private void initList()
//    {
//        if(Model.getInstance().getList().isEmpty())
//        {
//            Model.getInstance().setList();
//        }
//    }

    public void setData(ObservableList<CartItems> items)
    {
        items_listView.setItems(items);
    }
}

