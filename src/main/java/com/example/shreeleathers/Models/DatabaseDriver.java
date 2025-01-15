package com.example.shreeleathers.Models;

import com.example.shreeleathers.Models.Master.StateCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public ObservableList<StateCode> getStateCode()
    {
        ObservableList<StateCode> dataList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM State_Code_Master";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                dataList.add(new StateCode(resultSet.getInt("Id"), resultSet.getString("State_Code"), resultSet.getString("State_Name")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return dataList;
    }

    public void updateTableStateCode(StateCode dt)
    {
        String sql = "UPDATE State_Code_Master SET State_Code = ?, State_Name = ? WHERE id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, dt.getSCode());
                preparedStatement.setString(2, dt.getState());
                preparedStatement.setInt(3, dt.getId());
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public int insertIntoStateCode(String sCode, String state)
    {
        int id = 0;
        String sql = "INSERT INTO State_Code_Master (State_Code, State_Name) VALUES (?,?)";
        String selSql = "SELECT Id FROM State_Code_Master WHERE State_Code = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, sCode);
                preparedStatement.setString(2, state);
            }
            preparedStatement.executeUpdate();

            PreparedStatement pStmt = this.connection.prepareStatement(selSql);
            {
                pStmt.setString(1, sCode);
            }
            ResultSet resultSet = pStmt.executeQuery();
            resultSet.next();
            id = resultSet.getInt("Id");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return id;
    }
}
