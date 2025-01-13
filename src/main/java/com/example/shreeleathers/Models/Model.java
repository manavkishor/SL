package com.example.shreeleathers.Models;

import com.example.shreeleathers.Views.AccountType;
import com.example.shreeleathers.Views.ViewFactory;

import java.sql.ResultSet;
import java.util.Objects;

public class Model
{
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;

    // POS Data Section
    private boolean posLoginSuccessFlag;

    // BO Data Section
    private boolean boLoginSuccessFlag;


    private Model()
    {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();

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

    /*
    * POS Method Section
    * */

    public boolean getPOSLoginSuccessFlag(){return this.posLoginSuccessFlag;}

    public void setPosLoginSuccessFlag(boolean Flag)
    {
        this.posLoginSuccessFlag = Flag;
    }


    /*
    * BO Method Section
    * */

    public boolean getBOLoginSuccessFlag(){return this.boLoginSuccessFlag;}

    public void setBoLoginSuccessFlag(boolean Flag)
    {
        this.boLoginSuccessFlag = Flag;
    }

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
