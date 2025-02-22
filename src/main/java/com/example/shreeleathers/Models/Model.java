package com.example.shreeleathers.Models;

import com.example.shreeleathers.Controllers.MessageBoxController;
import com.example.shreeleathers.Controllers.POS.POSMenuController;
import com.example.shreeleathers.Controllers.POS.SaleController;
import com.example.shreeleathers.Views.ViewFactory;
import javafx.fxml.FXMLLoader;

import java.sql.ResultSet;

public class Model
{
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    public MessageBoxController messageBoxController;
    public SaleController saleController;
    private User user;
    public POSMenuController posMenuController;

    // POS Data Section
    private boolean posLoginSuccessFlag;

    // BO Data Section
    private boolean boLoginSuccessFlag;


    private Model()
    {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.messageBoxController = new MessageBoxController();
        this.saleController = new SaleController();
        this.posMenuController = new POSMenuController();

        // POS Data Section
        this.posLoginSuccessFlag = false;

        // BO Data Section
        this.boLoginSuccessFlag = false;
    }

    public static synchronized Model getInstance()
    {
        if(model == null)
        {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory()
    {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() {return databaseDriver;}

    public MessageBoxController getMessageBoxController(FXMLLoader loader)
    {
        return messageBoxController = loader.getController();
    }

    public SaleController getSaleController(FXMLLoader loader)
    {
        return saleController = loader.getController();
    }

    public User getUser() {return  user;}

    public void setUser(User user)
    {
        this.user = user;
    }

    public POSMenuController getPosMenuController()
    {
        return posMenuController;
    }

    public void setPosMenuController(POSMenuController posMenuController)
    {
        this.posMenuController = posMenuController;
    }


    /*
    * POS Method Section
    * */

    public boolean getPOSLoginSuccessFlag(){return this.posLoginSuccessFlag;}


    /*
    * BO Method Section
    * */

    public boolean getBOLoginSuccessFlag(){return this.boLoginSuccessFlag;}

    /*
    * Utility Method Section
    * */

    public void validateCred(String user, String password)
    {
        ResultSet resultSet = databaseDriver.getUserCred(user, password);
        try
        {
            if (resultSet.isBeforeFirst())
            {
                resultSet.next();
                setUser(new User(resultSet.getString("User_Name"), resultSet.getString("Name"),
                        resultSet.getString("System_Assigned"), resultSet.getString("Acc_Type")));
            }
            if (this.user.getAccType().equals("POS"))
            {
                this.posLoginSuccessFlag = true;
            }
            else if (this.user.getAccType().equals("BO"))
            {
                this.boLoginSuccessFlag = true;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
