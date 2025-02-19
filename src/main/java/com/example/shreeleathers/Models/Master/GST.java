package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class GST
{
    private final SimpleStringProperty gstType;
    private final SimpleDoubleProperty gst;
    private final SimpleDoubleProperty gstAmount;

    public GST(String gstType, double gst, double gstAmount)
    {
        this.gstType = new SimpleStringProperty(this, "GST Type", gstType);
        this.gst = new SimpleDoubleProperty(this, "GST", gst);
        this.gstAmount = new SimpleDoubleProperty(this, "GST Amount", gstAmount);
    }

    public SimpleStringProperty gstTypeProperty() {return gstType;}
    public String getGSTType() {return gstType.get();}
    public void setGSTType(String gstType) {this.gstType.set(gstType);}

    public SimpleDoubleProperty gstProperty() {return gst;}
    public double getGST() {return gst.get();}
    public void setGST(double gst) {this.gst.set(gst);}

    public SimpleDoubleProperty gstAmountProperty() {return gstAmount;}
    public double getGSTAmount() {return gstAmount.get();}
    public void setGSTAmount(double gstAmount) {this.gstAmount.set(gstAmount);}
}
