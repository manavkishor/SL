package com.example.shreeleathers.Views;

import com.example.shreeleathers.Controllers.POS.CartItemCellController;
import com.example.shreeleathers.Models.CartItems;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;

public class CartItemCellFactory extends ListCell<CartItems>
{
    protected void updateItem(CartItems cartItems, boolean empty)
    {
        super.updateItem(cartItems, empty);
        if(empty)
        {
            setText(null);
            setGraphic(null);
        }
        else
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/POS/CartItemCell.fxml"));
            CartItemCellController cartItemCellController = new CartItemCellController(cartItems);
            loader.setController(cartItemCellController);
            setText(null);
            try
            {
                setGraphic(loader.load());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
