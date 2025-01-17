package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item
{
    private final SimpleIntegerProperty itemId;
    private final SimpleStringProperty itemCode;
    private final SimpleIntegerProperty catId;
    private final SimpleStringProperty cat;
    private final SimpleStringProperty itemName;
    private final SimpleStringProperty hsnCode;
    private final SimpleStringProperty colour;
    private final SimpleStringProperty size;
    private final SimpleIntegerProperty sizeId;
    private final SimpleDoubleProperty purRate;
    private final SimpleDoubleProperty gstPur;
    private final SimpleDoubleProperty saleRate;
    private final SimpleDoubleProperty gstSale;
    private final SimpleDoubleProperty discPur;
    private final SimpleBooleanProperty status;
    private final SimpleIntegerProperty minStock;

    public Item(int itemId, String itemCode, int catId, String cat, String itemName, String hsnCode, String colour, String size,
                int sizeId, double purRate, double gstPur, double saleRate, double gstSale, double discPur, boolean status, int minStock)
    {
        this.itemId = new SimpleIntegerProperty(this, "Item Id", itemId);
        this.itemCode = new SimpleStringProperty(this, "Item Code", itemCode);
        this.catId = new SimpleIntegerProperty(this, "Category Id", catId);
        this.cat = new SimpleStringProperty(this, "Category", cat);
        this.itemName = new SimpleStringProperty(this, "Item Name", itemName);
        this.hsnCode = new SimpleStringProperty(this, "HSN Code", hsnCode);
        this.colour = new SimpleStringProperty(this, "Colour", colour);
        this.size = new SimpleStringProperty(this, "Size", size);
        this.sizeId = new SimpleIntegerProperty(this, "Size Id", sizeId);
        this.purRate = new SimpleDoubleProperty(this, "Purchase Rate", purRate);
        this.gstPur = new SimpleDoubleProperty(this, "GST Purchase", gstPur);
        this.saleRate = new SimpleDoubleProperty(this, "Sale Rate", saleRate);
        this.gstSale = new SimpleDoubleProperty(this, "GST Sale", gstSale);
        this.discPur = new SimpleDoubleProperty(this, "Discount Purchase", discPur);
        this.status = new SimpleBooleanProperty(this, "Status", status);
        this.minStock = new SimpleIntegerProperty(this, "Minimum Stock", minStock);
    }

    public SimpleIntegerProperty itemIdProperty() {return itemId;}
    public int getItemId() {return itemId.get();}
    public void setItemId(int itemId) {this.itemId.set(itemId);}

    public SimpleStringProperty itemCodeProperty() {return itemCode;}
    public String getItemCode() {return itemCode.get();}
    public void setItemCode(String itemCode) {this.itemCode.set(itemCode);}

    public SimpleIntegerProperty catIdProperty() {return catId;}
    public int getCatId() {return catId.get();}
    public void setCatId(int catId) {this.catId.set(catId);}

    public SimpleStringProperty categoryProperty() {return cat;}
    public String getCat() {return cat.get();}
    public void setCat(String cat) {this.cat.set(cat);}

    public SimpleStringProperty itemNameProperty() {return itemName;}
    public String getItemName() {return itemName.get();}
    public void setItemName(String itemName) {this.itemName.set(itemName);}

    public SimpleStringProperty hsnCodeProperty() {return hsnCode;}
    public String getHSNCode() {return hsnCode.get();}
    public void setHSNCode(String hsnCode) {this.hsnCode.set(hsnCode);}

    public SimpleStringProperty colourProperty() {return colour;}
    public String getColour() {return colour.get();}
    public void setColour(String colour) {this.colour.set(colour);}

    public SimpleStringProperty sizeProperty() {return size;}
    public String getSize() {return size.get();}
    public void setSize(String size) {this.size.set(size);}

    public SimpleIntegerProperty sizeIdProperty() {return sizeId;}
    public int getSizeId() {return sizeId.get();}
    public void setSizeId(int sizeId) {this.sizeId.set(sizeId);}

    public SimpleDoubleProperty purRateProperty() {return purRate;}
    public double getPurRate() {return purRate.get();}
    public void setPurRate(double purRate) {this.purRate.set(purRate);}

    public SimpleDoubleProperty gstPurProperty() {return gstPur;}
    public double getGSTPur() {return gstPur.get();}
    public void setGSTPur(double gstPur) {this.gstPur.set(gstPur);}

    public SimpleDoubleProperty saleRateProperty() {return saleRate;}
    public double getSaleRate() {return saleRate.get();}
    public void setSaleRate(double saleRate) {this.saleRate.set(saleRate);}

    public SimpleDoubleProperty gstSaleProperty() {return gstSale;}
    public double getGSTSale() {return gstSale.get();}
    public void setGSTSale(double gstSale) {this.gstSale.set(gstSale);}

    public SimpleDoubleProperty discPurProperty() {return discPur;}
    public double getDiscPur() {return discPur.get();}
    public void setDiscPur(double discPur) {this.discPur.set(discPur);}

    public SimpleBooleanProperty statusProperty() {return status;}
    public boolean getStatus() {return status.get();}
    public void setStatus(boolean status) {this.status.set(status);}

    public SimpleIntegerProperty minStockProperty() {return minStock;}
    public int getMinStock() {return minStock.get();}
    public void setMinStock(int minStock) {this.minStock.set(minStock);}
}
