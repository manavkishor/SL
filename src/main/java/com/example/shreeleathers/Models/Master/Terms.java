package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Terms
{
    private final SimpleIntegerProperty slNo;
    private final SimpleStringProperty term;
    private final SimpleBooleanProperty status;

    public Terms(int slNo, String term, boolean status)
    {
        this.slNo = new SimpleIntegerProperty(this, "Sl Number", slNo);
        this.term = new SimpleStringProperty(this, "Terms", term);
        this.status = new SimpleBooleanProperty(this, "Status", status);
    }

    public SimpleIntegerProperty slNoProperty(){return slNo;}
    public int getSlNo(){return slNo.get();}
    public void setSlNo(int slNo){this.slNo.set(slNo);}

    public SimpleStringProperty termProperty(){return term;}
    public String getTerm(){return term.get();}
    public void setTerm(String term){this.term.set(term);}

    public SimpleBooleanProperty statusProperty(){return status;}
    public boolean getStatus(){return status.get();}
    public void setStatus(boolean status){this.status.set(status);}
}
