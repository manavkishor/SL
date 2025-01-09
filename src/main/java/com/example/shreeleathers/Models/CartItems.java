package com.example.shreeleathers.Models;

import javafx.beans.property.*;

public class CartItems
{
    private final StringProperty itemCode;
    private final StringProperty itemName;
    private final StringProperty size;
    private final IntegerProperty quantity;
    private final DoubleProperty rate;
    private final StringProperty salesman;

    public CartItems(String itemCode, String itemName, String size, int quantity, double rate, String salesman)
    {
        this.itemCode = new SimpleStringProperty(this, "Item Code", itemCode);
        this.itemName = new SimpleStringProperty(this, "Item Name", itemName);
        this.size = new SimpleStringProperty(this, "Size", size);
        this.quantity = new SimpleIntegerProperty(this, "Quantity", quantity);
        this.rate = new SimpleDoubleProperty(this, "Rate", rate);
        this.salesman = new SimpleStringProperty(this, "Salesman", salesman);
    }

    public StringProperty itemCodeProperty() {return itemCode;}

    public StringProperty itemNameProperty() {return itemName;}

    public StringProperty sizeProperty() {return size;}

    public IntegerProperty quantityProperty() {return quantity;}

    public DoubleProperty rateProperty() {return rate;}

    public StringProperty salesmanProperty() {return salesman;}
}
