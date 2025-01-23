package com.example.shreeleathers.Models.Sale;

import javafx.beans.property.*;

public class CartItems
{
    private final SimpleStringProperty itemCode;
    private final SimpleStringProperty itemName;
    private final SimpleStringProperty size;
    private final SimpleStringProperty quantity;
    private final SimpleDoubleProperty rate;
    private final SimpleStringProperty salesman;

    public CartItems(String itemCode, String itemName, String size, String quantity, double rate, String salesman)
    {
        this.itemCode = new SimpleStringProperty(this, "Item Code", itemCode);
        this.itemName = new SimpleStringProperty(this, "Item Name", itemName);
        this.size = new SimpleStringProperty(this, "Size", size);
        this.quantity = new SimpleStringProperty(this, "Quantity", quantity);
        this.rate = new SimpleDoubleProperty(this, "Rate", rate);
        this.salesman = new SimpleStringProperty(this, "Salesman", salesman);
    }

    public SimpleStringProperty itemCodeProperty() {return itemCode;}
    public String getItemCode(){return itemCode.get();}
    public void setItemCode(String itemCode) {this.itemCode.set(itemCode);}

    public SimpleStringProperty itemNameProperty() {return itemName;}
    public void setItemName(String itemName) {this.itemName.set(itemName);}
    public String getItemName(){return itemName.get();}

    public SimpleStringProperty sizeProperty() {return size;}
    public void setSize(String size) {this.size.set(size);}
    public String getSize(){return size.get();}

    public SimpleStringProperty quantityProperty() {return quantity;}
    public String getQuantity(){return quantity.get();}
    public void setQuantity(String quantity) {this.quantity.set(quantity);}

    public SimpleDoubleProperty rateProperty() {return rate;}
    public double getRate(){return rate.get();}
    public void setRate(double rate) {this.rate.set(rate);}

    public SimpleStringProperty salesmanProperty() {return salesman;}
    public void setSalesman(String salesman) {this.salesman.set(salesman);}
    public String getSalesman(){return salesman.get();}
}
