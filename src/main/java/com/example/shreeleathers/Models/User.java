package com.example.shreeleathers.Models;

import javafx.beans.property.SimpleStringProperty;

public class User
{
    private final SimpleStringProperty userName;
    private final SimpleStringProperty systemAssigned;
    private final SimpleStringProperty accType;

    public User( String userName, String systemAssigned, String accType)
    {
        this.userName = new SimpleStringProperty(this, "User Name", userName);
        this.systemAssigned = new SimpleStringProperty(this, "System Assigned", systemAssigned);
        this.accType = new SimpleStringProperty(this, "Account Type", accType);
    }

    public SimpleStringProperty userNameProperty() {return userName;}
    public String getUserName() {return userName.get();}
    public void setUserName(String userName) {this.userName.set(userName);}

    public SimpleStringProperty systemAssignedProperty() {return systemAssigned;}
    public String getSystemAssigned() {return systemAssigned.get();}
    public void setSystemAssigned(String systemAssigned) {this.systemAssigned.set(systemAssigned);}

    public SimpleStringProperty accTypeProperty() {return accType;}
    public String getAccType() {return accType.get();}
    public void setAccType(String accType) {this.accType.set(accType);}
}