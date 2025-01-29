package com.example.shreeleathers.Models;

import com.example.shreeleathers.Controllers.MessageBoxController;
import com.example.shreeleathers.Controllers.POS.SaleController;
import com.example.shreeleathers.Models.Sale.CartItems;
import com.example.shreeleathers.Models.Sale.SaleServices;
import com.example.shreeleathers.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.sql.ResultSet;

public class Model
{
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private final SaleServices saleServices;
    public MessageBoxController messageBoxController;
    public SaleController saleController;

    // POS Data Section
    private boolean posLoginSuccessFlag;

    // BO Data Section
    private boolean boLoginSuccessFlag;


    private Model()
    {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.saleServices = new SaleServices();
        this.messageBoxController = new MessageBoxController();
        this.saleController = new SaleController();

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

    public SaleServices getSaleServices() {return saleServices;}

    public MessageBoxController getMessageBoxController(FXMLLoader loader) {return messageBoxController = loader.getController();}

    public SaleController getSaleController(FXMLLoader loader) {return saleController = loader.getController();}


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
                if (resultSet.getString(3).equals("POS"))
                {
                    this.posLoginSuccessFlag = true;
                }
                else if (resultSet.getString(3).equals("BO"))
                {
                    this.boLoginSuccessFlag = true;
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
