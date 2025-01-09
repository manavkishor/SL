package com.example.shreeleathers.Models;

import java.sql.*;

public class DatabaseDriver
{
    private Connection connection;

    private static final String url = "jdbc:sqlserver://DESKTOP-KA9I181\\SQLEXPRESS:1433;databaseName=SLDB;user=mk;password=2444;encrypt=true;trustServerCertificate=true";

    public DatabaseDriver()
    {
    }

    public void startConnection()
    {
        try
        {
            this.connection = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void closeConnection()
    {
        try
        {
            this.connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ResultSet getUserCred(String user, String password)
    {
        ResultSet resultset = null;
        String sql = "SELECT * FROM Login_Details WHERE User_Name = ? AND Password = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, password);
            }
            resultset = preparedStatement.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultset;
    }
}
