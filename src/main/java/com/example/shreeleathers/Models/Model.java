package com.example.shreeleathers.Models;

import com.example.shreeleathers.Controllers.POS.SaleController;
import com.example.shreeleathers.Models.Sale.CartItems;
import com.example.shreeleathers.Models.Sale.SaleServices;
import com.example.shreeleathers.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Model
{
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private final SaleServices saleServices;
    private final SaleController saleController;

    // POS Data Section
    private boolean posLoginSuccessFlag;
    private final ObservableList<CartItems> allItems;

    // BO Data Section
    private boolean boLoginSuccessFlag;


    private Model()
    {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.saleServices = new SaleServices();
        this.saleController = new SaleController();

        // POS Data Section
        this.posLoginSuccessFlag = false;
        this.allItems = FXCollections.observableArrayList();

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

    public SaleController getSaleController(){return saleController;}

    /*
    * POS Method Section
    * */

    public boolean getPOSLoginSuccessFlag(){return this.posLoginSuccessFlag;}

    private void prepareItem(ObservableList<CartItems> cartItems)
    {
        try
        {
            String itemCode = saleController.item_code_txt.getText();
            String itemName = saleController.item_name_txt.getText();
            String size = saleController.size_selector.getValue();
            String qty = saleController.quantity_txt.getText();
            double rate = Double.parseDouble(saleController.rate_txt.getText());
            String sm = saleController.salesman_selector.getValue().getSmCode();
            cartItems.add(new CartItems(itemCode, itemName, size, qty + "pc", rate, sm));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setAllItems(){prepareItem(this.allItems);}

    public ObservableList<CartItems> getAllItems(){return allItems;}

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
