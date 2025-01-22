package com.example.shreeleathers.Models.Sale;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

public class CartItems
{
    private final StringProperty itemCode;
    private final StringProperty itemName;
    private final StringProperty size;
    private final StringProperty quantity;
    private final DoubleProperty rate;
    private final StringProperty salesman;

    public CartItems(String itemCode, String itemName, String size, String quantity, double rate, String salesman)
    {
        this.itemCode = new SimpleStringProperty(this, "Item Code", itemCode);
        this.itemName = new SimpleStringProperty(this, "Item Name", itemName);
        this.size = new SimpleStringProperty(this, "Size", size);
        this.quantity = new SimpleStringProperty(this, "Quantity", quantity);
        this.rate = new SimpleDoubleProperty(this, "Rate", rate);
        this.salesman = new SimpleStringProperty(this, "Salesman", salesman);
    }

    public StringProperty itemCodeProperty() {return itemCode;}

    public StringProperty itemNameProperty() {return itemName;}

    public StringProperty sizeProperty() {return size;}

    public ObservableValue<? extends String> quantityProperty() {return quantity;}
    public int getQuantity(){return Integer.parseInt(quantity.get());}

    public DoubleProperty rateProperty() {return rate;}
    public double getRate(){return rate.get();}

    public StringProperty salesmanProperty() {return salesman;}
}
