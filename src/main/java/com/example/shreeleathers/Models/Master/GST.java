package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class GST
{
    private final SimpleStringProperty gstType;
    private final SimpleDoubleProperty gst;
    private final SimpleStringProperty taxableAmount;
    private final SimpleStringProperty gstAmount;

    public GST(String gstType, double gst, String taxableAmount, String gstAmount)
    {
        this.gstType = new SimpleStringProperty(this, "GST Type", gstType);
        this.gst = new SimpleDoubleProperty(this, "GST", gst);
        this.taxableAmount = new SimpleStringProperty(this, "Taxable Amount", taxableAmount);
        this.gstAmount = new SimpleStringProperty(this, "GST Amount", gstAmount);
    }

    public SimpleStringProperty gstTypeProperty() {return gstType;}
    public String getGSTType() {return gstType.get();}
    public void setGSTType(String gstType) {this.gstType.set(gstType);}

    public SimpleDoubleProperty gstProperty() {return gst;}
    public double getGST() {return gst.get();}
    public void setGST(double gst) {this.gst.set(gst);}

    public SimpleStringProperty taxableAmountProperty() {return taxableAmount;}
    public String getTaxableAmount() {return taxableAmount.get();}
    public void setTaxableAmount(String taxableAmount) {this.taxableAmount.set(taxableAmount);}

    public SimpleStringProperty gstAmountProperty() {return gstAmount;}
    public String getGSTAmount() {return gstAmount.get();}
    public void setGSTAmount(String gstAmount) {this.gstAmount.set(gstAmount);}
}
