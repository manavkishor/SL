package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Colour
{
    private final SimpleIntegerProperty slNo;
    private final SimpleStringProperty colour;

    public Colour(int slNo, String colour)
    {
        this.slNo = new SimpleIntegerProperty(this, "Sl Number", slNo);
        this.colour = new SimpleStringProperty(this, "Colour", colour);
    }

    public SimpleIntegerProperty slNoProperty() {return slNo;}
    public int getSlNo() {return slNo.get();}
    public void setSlNo(int slNo) {this.slNo.set(slNo);}

    public SimpleStringProperty colourProperty() {return colour;}
    public String getColour() {return colour.get();}
    public void setColour(String colour) {this.colour.set(colour);}
}
