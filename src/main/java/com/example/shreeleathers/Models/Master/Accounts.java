package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Accounts
{
    private final SimpleIntegerProperty accId;
    private final SimpleStringProperty accCode;
    private final SimpleStringProperty accType;
    private final SimpleStringProperty accName;
    private final SimpleStringProperty phoneNumber;
    private final SimpleStringProperty add1;
    private final SimpleStringProperty add2;
    private final SimpleStringProperty sCode;
    private final SimpleStringProperty city;
    private final SimpleStringProperty pinCode;
    private final SimpleStringProperty gstNumber;

    public Accounts(int accId, String accCode, String accType, String accName, String phoneNumber, String add1, String add2, String sCode, String city, String pinCode, String gstNumber)
    {
        this.accId = new SimpleIntegerProperty(this, "Account Id", accId);
        this.accCode = new SimpleStringProperty(this, "Account Code", accCode);
        this.accType = new SimpleStringProperty(this, "Account Type", accType);
        this.accName = new SimpleStringProperty(this, "Account Type", accName);
        this.phoneNumber = new SimpleStringProperty(this, "Account Type", phoneNumber);
        this.add1 = new SimpleStringProperty(this, "Account Type", add1);
        this.add2 = new SimpleStringProperty(this, "Account Type", add2);
        this.sCode = new SimpleStringProperty(this, "Account Type", sCode);
        this.city = new SimpleStringProperty(this, "Account Type", city);
        this.pinCode = new SimpleStringProperty(this, "Account Type", pinCode);
        this.gstNumber = new SimpleStringProperty(this, "Account Type", gstNumber);
    }

    public SimpleIntegerProperty accIdProperty() {return accId;}
    public int getAccId() {return accId.get();}
    public void setAccId(int accId) {this.accId.set(accId);}

    public SimpleStringProperty accCodeProperty() {return accCode;}
    public String getAccCode() {return accCode.get();}
    public void setAccCode(String accCode) {this.accCode.set(accCode);}

    public SimpleStringProperty accTypeProperty() {return accType;}
    public String getAccType() {return accType.get();}
    public void setAccType(String accType) {this.accType.set(accType);}

    public SimpleStringProperty accNameProperty() {return accName;}
    public String getAccName() {return accName.get();}
    public void setAccName(String accName) {this.accName.set(accName);}

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
