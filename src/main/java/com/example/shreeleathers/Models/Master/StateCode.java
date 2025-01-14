package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleStringProperty;

public class StateCode
{
    private final SimpleStringProperty state;
    private final SimpleStringProperty sCode;

    public StateCode(String state, String sCode)
    {
        this.state = new SimpleStringProperty(state);
        this.sCode = new SimpleStringProperty(sCode);
    }

    public String getState()
    {
        return state.get();
    }

    public void setState(String state)
    {
        this.state.set(state);
    }

    public String getSCode()
    {
        return sCode.get();
    }

    public void setSCode(String sCode)
    {
        this.sCode.set(sCode);
    }
}
