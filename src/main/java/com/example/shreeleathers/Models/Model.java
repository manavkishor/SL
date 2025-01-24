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
//    private final SaleController saleController;

    // POS Data Section
    private boolean posLoginSuccessFlag;
//    private final ObservableList<CartItems> cart;

    // BO Data Section
    private boolean boLoginSuccessFlag;


    private Model()
    {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.saleServices = new SaleServices();
//        this.saleController = new SaleController();

        // POS Data Section
        this.posLoginSuccessFlag = false;
//        this.cart = FXCollections.observableArrayList();

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


    /*
    * POS Method Section
    * */

    public boolean getPOSLoginSuccessFlag(){return this.posLoginSuccessFlag;}

//    public void createNewList(ObservableList<CartItems> cartItems)
//    {
//        if(saleController.transferList != null)
//        {
//            System.out.println(saleController.transferList.getLast().getQuantity());
//            for (int i = 0; i < saleController.transferList.size(); i++)
//            {
//                String chICode = saleController.transferList.get(i).getItemCode();
//                String chIName = saleController.transferList.get(i).getItemName();
//                String chISize = saleController.transferList.get(i).getSize();
//                String chIQty = saleController.transferList.get(i).getQuantity();
//                String chISm = saleController.transferList.get(i).getSalesman();
//                double chIRate = saleController.transferList.get(i).getRate();
//                cartItems.add(new CartItems(chICode, chIName, chISize, chIQty+"pc", chIRate, chISm));
//            }
//        }
//        else
//        {
//            System.out.println("No Data");
//        }
//    }
//
//    public void setList()
//    {
//        createNewList(this.cart);
//    }
//
//    public ObservableList<CartItems> getList()
//    {
//        return cart;
//    }


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
