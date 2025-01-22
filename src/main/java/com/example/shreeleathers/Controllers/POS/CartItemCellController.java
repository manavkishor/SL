package com.example.shreeleathers.Controllers.POS;

import com.example.shreeleathers.Models.Sale.CartItems;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CartItemCellController implements Initializable
{
    public Text item_Code_lbl;
    public Text item_Name_lbl;
    public Text size_lbl;
    public Text quantity_lbl;
    public Text rate_lbl;
    public Text salesman_lbl;

    private final CartItems cartItems;

    public CartItemCellController(CartItems cartItems)
    {
        this.cartItems = cartItems;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        item_Code_lbl.textProperty().bind(cartItems.itemCodeProperty());
        item_Name_lbl.textProperty().bind(cartItems.itemNameProperty());
        size_lbl.textProperty().bind(cartItems.sizeProperty());
        quantity_lbl.textProperty().bind(cartItems.quantityProperty());
        rate_lbl.textProperty().bind(cartItems.rateProperty().asString());
        salesman_lbl.textProperty().bind(cartItems.salesmanProperty());
    }
}
