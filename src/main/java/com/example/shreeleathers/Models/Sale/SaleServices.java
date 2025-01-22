package com.example.shreeleathers.Models.Sale;

import javafx.collections.ObservableList;

public class SaleServices
{
    public SaleServices(){}

    public double calculateTotalAmount(ObservableList<CartItems> cart)
    {
        double amt = 0;
        if(cart != null)
        {
            for(int i=0; i<= cart.size(); i++)
            {
                double rate = cart.get(i).rateProperty().get();
                amt = amt + rate;
            }
        }
        return amt;
    }

    public String getAmount(ObservableList<CartItems> cart)
    {
        return String.valueOf(calculateTotalAmount(cart));
    }
}