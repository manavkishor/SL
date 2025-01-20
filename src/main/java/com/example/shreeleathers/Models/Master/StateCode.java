package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StateCode
{
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty state;
    private final SimpleStringProperty sCode;

    public StateCode(int id, String sCode, String state)
    {
        this.id = new SimpleIntegerProperty(this, "Id", id);
        this.sCode = new SimpleStringProperty(this, "State Code", sCode);
        this.state = new SimpleStringProperty(this, "State Name", state);
    }

    public SimpleIntegerProperty idProperty() {return id;}
    public int getId() {return id.get();}
    public SimpleStringProperty stateProperty() {return state;}
    public String getState() {return state.get();}
    public void setState(String state) {this.state.set(state);}
    public SimpleStringProperty sCodeProperty() {return sCode;}
    public String getSCode() {return sCode.get();}
    public void setSCode(String sCode) {this.sCode.set(sCode);}

    @Override
    public String toString(){return getSCode() +" - "+ getState();}
}
