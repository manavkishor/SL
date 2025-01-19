package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Salesman
{
    private final SimpleIntegerProperty slNo;
    private final SimpleStringProperty smCode;
    private final SimpleStringProperty smName;
    private final SimpleBooleanProperty isActive;

    public Salesman(int slNo, String smCode, String smName, boolean isActive)
    {
        this.slNo = new SimpleIntegerProperty(this, "Sl Number", slNo);
        this.smCode = new SimpleStringProperty(this, "Salesman Code", smCode);
        this.smName = new SimpleStringProperty(this, "Salesman Name", smName);
        this.isActive = new SimpleBooleanProperty(this, "Is Active", isActive);
    }

    public SimpleIntegerProperty slNoProperty(){return slNo;}
    public int getSlNo(){return slNo.get();}
    public void setSlNo(int slNo){this.slNo.set(slNo);}

    public SimpleStringProperty smCodeProperty(){return smCode;}
    public String getSmCode(){return smCode.get();}
    public void setSmCode(String smCode){this.smCode.set(smCode);}

    public SimpleStringProperty smNameProperty(){return smName;}
    public String getSmName(){return smName.get();}
    public void setSmName(String smName){this.smName.set(smName);}

    public SimpleBooleanProperty isActiveProperty(){return isActive;}
    public boolean getIsActive(){return isActive.get();}
    public void setIsActive(boolean isActive){this.isActive.set(isActive);}
}
