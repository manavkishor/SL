package com.example.shreeleathers.Models;

import java.sql.*;

public class DatabaseDriver
{
    private Connection connection;
    private static final String URL = "jdbc:sqlserver://DESKTOP-KA9I181\\SQLEXPRESS:1433;databaseName=SLDB;encrypt=true;trustServerCertificate=true";
    private static final String USER = "mk";
    private static final String PASSWORD = "2444";

    public DatabaseDriver()
    {
    }

    public void startConnection()
    {
        try
        {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
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

    public ResultSet getStateCode()
    {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM State_Code_Master";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }
}
