package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class GST
{
    private final SimpleStringProperty invoiceNumber;
    private final SimpleStringProperty invoiceDate;
    private final SimpleDoubleProperty gst;
    private final SimpleDoubleProperty taxableAmount;
    private final SimpleDoubleProperty cgst;
    private final SimpleDoubleProperty cgstAmount;
    private final SimpleDoubleProperty sgst;
    private final SimpleDoubleProperty sgstAmount;
    private final SimpleDoubleProperty igst;
    private final SimpleDoubleProperty igstAmount;

    public GST(String invoiceNumber, String invoiceDate, double gst, double taxableAmount, double cgst, double cgstAmount, double sgst, double sgstAmount, double igst, double igstAmount)
    {
        this.invoiceNumber = new SimpleStringProperty(this, "Invoice Number", invoiceNumber);
        this.invoiceDate = new SimpleStringProperty(this, "Invoice Date", invoiceDate);
        this.gst = new SimpleDoubleProperty(this, "GST", gst);
        this.taxableAmount = new SimpleDoubleProperty(this, "Taxable Amount", taxableAmount);
        this.cgst = new SimpleDoubleProperty(this, "C_GST", cgst);
        this.cgstAmount = new SimpleDoubleProperty(this, "C_GST Amount", cgstAmount);
        this.sgst = new SimpleDoubleProperty(this, "S_GST", sgst);
        this.sgstAmount = new SimpleDoubleProperty(this, "S_GST Amount", sgstAmount);
        this.igst = new SimpleDoubleProperty(this, "IGST", igst);
        this.igstAmount = new SimpleDoubleProperty(this, "IGST Amount", igstAmount);
    }

    public SimpleStringProperty invoiceNumberProperty() {return invoiceNumber;}
    public String getInvoiceNumber() {return invoiceNumber.get();}
    public void setInvoiceNumber(String invoiceNumber) {this.invoiceNumber.set(invoiceNumber);}

    public SimpleStringProperty invoiceDateProperty() {return invoiceDate;}
    public String getInvoiceDate() {return invoiceDate.get();}
    public void setInvoiceDate(String invoiceDate) {this.invoiceDate.set(invoiceDate);}

    public SimpleDoubleProperty gstProperty() {return gst;}
    public double getGST() {return gst.get();}
    public void setGST(double gst) {this.gst.set(gst);}

    public SimpleDoubleProperty taxableAmountProperty() {return taxableAmount;}
    public double getTaxableAmount() {return taxableAmount.get();}
    public void setTaxableAmount(double taxableAmount) {this.taxableAmount.set(taxableAmount);}

    public SimpleDoubleProperty cgstProperty() {return cgst;}
    public double getCGST() {return cgst.get();}
    public void setCGST(double cgst) {this.cgst.set(cgst);}

    public SimpleDoubleProperty cgstAmountProperty() {return cgstAmount;}
    public double getCGSTAmount() {return cgstAmount.get();}
    public void setCGSTAmount(double cgstAmount) {this.cgstAmount.set(cgstAmount);}

    public SimpleDoubleProperty sgstProperty() {return sgst;}
    public double getSGST() {return sgst.get();}
    public void setSGST(double sgst) {this.sgst.set(sgst);}

    public SimpleDoubleProperty sgstAmountProperty() {return sgstAmount;}
    public double getSGSTAmount() {return sgstAmount.get();}
    public void setSGSTAmount(double sgstAmount) {this.sgstAmount.set(sgstAmount);}

    public SimpleDoubleProperty igstProperty() {return igst;}
    public double getIGST() {return igst.get();}
    public void setIGST(double igst) {this.igst.set(igst);}

    public SimpleDoubleProperty igstAmountProperty() {return igstAmount;}
    public double getIGSTAmount() {return igstAmount.get();}
    public void setIGSTAmount(double igstAmount) {this.igstAmount.set(igstAmount);}
}
