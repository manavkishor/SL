package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Category
{
    private final SimpleIntegerProperty catId;
    private final SimpleStringProperty catName;
    private final SimpleDoubleProperty gst;
    private final SimpleStringProperty hsnCode;

    public Category(int catId, String catName, double gst, String hsnCode)
    {
        this.catId = new SimpleIntegerProperty(this, "Category Id", catId);
        this.catName = new SimpleStringProperty(this, "Category Name", catName);
        this.gst = new SimpleDoubleProperty(this, "GST", gst);
        this.hsnCode = new SimpleStringProperty(this, "HSN Code", hsnCode);
    }

    public SimpleIntegerProperty catIdProperty() {return catId;}
    public int getCatId() {return catId.get();}
    public void setCatId(int catId) {this.catId.set(catId);}

    public SimpleStringProperty catNameProperty() {return catName;}
    public String getCatName() {return catName.get();}
    public void setCatName(String catName) {this.catName.set(catName);}

    public SimpleDoubleProperty gstProperty() {return gst;}
    public double getGST() {return gst.get();}
    public void setGST(double gst) {this.gst.set(gst);}

    public SimpleStringProperty hsnCodeProperty() {return hsnCode;}
    public String getHSNCode() {return hsnCode.get();}
    public void setHsnCode(String hsnCode) {this.hsnCode.set(hsnCode);}
}
