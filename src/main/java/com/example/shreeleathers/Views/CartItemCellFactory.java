package com.example.shreeleathers.Views;

import com.example.shreeleathers.Controllers.POS.CartItemCellController;
import com.example.shreeleathers.Models.Sale.CartItems;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class CartItemCellFactory extends ListCell<CartItems>
{
    @Override
    protected void updateItem(CartItems cartItems, boolean empty)
    {
        super.updateItem(cartItems, empty);
        if(empty)
        {
            setText(null);
            setGraphic(null);
            setStyle("");
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
            setStyle("");
        }

        if(isSelected())
        {
            setStyle("-fx-background-color : linear-gradient(to right, #007DCF, #00246C)");
        }
        else
        {
            setStyle("");
        }
    }
}
