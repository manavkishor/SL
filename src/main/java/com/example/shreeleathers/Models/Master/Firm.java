package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Firm
{
    private final SimpleIntegerProperty firmId;
    private final SimpleStringProperty firmName;
    private final SimpleStringProperty phoneNumber;
    private final SimpleStringProperty add1;
    private final SimpleStringProperty add2;
    private final SimpleStringProperty state;
    private final SimpleStringProperty sCode;
    private final SimpleStringProperty city;
    private final SimpleStringProperty pinCode;
    private final SimpleStringProperty gstNumber;

    public Firm(int firmId, String firmName, String phoneNumber, String add1, String add2,
                String city,String state, String sCode, String pinCode, String gstNumber)
    {
        this.firmId = new SimpleIntegerProperty(this, "Firm Id", firmId);
        this.state = new SimpleStringProperty(this, "State", state);
        this.firmName = new SimpleStringProperty(this, "Firm Name", firmName);
        this.phoneNumber = new SimpleStringProperty(this, "Phone Number", phoneNumber);
        this.add1 = new SimpleStringProperty(this, "Address Line1", add1);
        this.add2 = new SimpleStringProperty(this, "Address Line2", add2);
        this.sCode = new SimpleStringProperty(this, "State Code", sCode);
        this.city = new SimpleStringProperty(this, "City", city);
        this.pinCode = new SimpleStringProperty(this, "Pin Code", pinCode);
        this.gstNumber = new SimpleStringProperty(this, "GST Number", gstNumber);
    }

    public SimpleIntegerProperty firmIdProperty() {return firmId;}
    public int getFirmId() {return firmId.get();}
    public void setFirmId(int firmId) {this.firmId.set(firmId);}

    public SimpleStringProperty stateProperty() {return state;}
    public String getState() {return state.get();}
    public void setState(String state) {this.state.set(state);}

    public SimpleStringProperty firmNameProperty() {return firmName;}
    public String getFirmName() {return firmName.get();}
    public void setFirmName(String firmName) {this.firmName.set(firmName);}

    public SimpleStringProperty phoneNumberProperty() {return phoneNumber;}
    public String getPhoneNumber() {return phoneNumber.get();}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber.set(phoneNumber);}

    public SimpleStringProperty add1Property() {return add1;}
    public String getAdd1() {return add1.get();}
    public void setAdd1(String add1) {this.add1.set(add1);}

    public SimpleStringProperty add2Property() {return add2;}
    public String getAdd2() {return add2.get();}
    public void setAdd2(String add2) {this.add2.set(add2);}

    public SimpleStringProperty sCodeProperty() {return sCode;}
    public String getSCode() {return sCode.get();}
    public void setSCode(String sCode) {this.sCode.set(sCode);}

    public SimpleStringProperty cityProperty() {return city;}
    public String getCity() {return city.get();}
    public void setCity(String city) {this.city.set(city);}

    public SimpleStringProperty pinCodeProperty() {return pinCode;}
    public String getPinCode() {return pinCode.get();}
    public void setPinCode(String pinCode) {this.pinCode.set(pinCode);}

    public SimpleStringProperty gstNumberProperty() {return gstNumber;}
    public String getGSTNumber() {return gstNumber.get();}
    public void setGSTNumber(String gstNumber) {this.gstNumber.set(gstNumber);}
}
