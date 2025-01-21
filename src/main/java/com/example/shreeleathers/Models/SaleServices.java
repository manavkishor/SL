package com.example.shreeleathers.Models;

import com.example.shreeleathers.Models.Master.Size;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleServices
{
    private final Connection connection;
    public SaleServices(Connection connection)
    {
        this.connection = connection;
    }

    public ResultSet getSizeByItemCode(String itemName)
    {
        ResultSet resultSet1;
        ResultSet resultSet2 = null;
        int id;
        String getSizeId = "SELECT Size_Id FROM Item_Name_Master WHERE Item_Name = ?";
        String getSizes = "SELECT * FROM Size_Master WHERE Size_Id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(getSizeId);
            {
                preparedStatement.setString(1,itemName);
            }
            resultSet1 = preparedStatement.executeQuery();
            resultSet1.next();
            id = resultSet1.getInt("Size_Id");

            PreparedStatement pstmt = this.connection.prepareStatement(getSizes);
            {
                pstmt.setInt(1,id);
            }
            resultSet2 = pstmt.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet2;
    }

    public String getItemNameByCode(String itemCode)
    {
        ResultSet rs;
        String itemName = null;
        String sql = "SELECT Item_Name FROM Item_Master WHERE Item_Code = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, itemCode);
            }
            rs = preparedStatement.executeQuery();
            rs.next();
            itemName = rs.getString("Item_Name");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return itemName;
    }

    public String getColourByCode(String itemCode)
    {
        ResultSet rs;
        String colour = null;
        String sql = "SELECT Colour FROM Item_Master WHERE Item_Code = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, itemCode);
            }
            rs = preparedStatement.executeQuery();
            rs.next();
            colour = rs.getString("Colour");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return colour;
    }

    public double getRateByCode(String itemCode)
    {
        ResultSet rs;
        double rate = 0;
        String sql = "SELECT Sale_Rate FROM Item_Master WHERE Item_Code = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, itemCode);
            }
            rs = preparedStatement.executeQuery();
            rs.next();
            rate = rs.getDouble("Sale_Rate");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return rate;
    }

    public double getGSTByCode(String itemCode)
    {
        ResultSet rs;
        double gst = 0;
        String sql = "SELECT GST_Sale FROM Item_Master WHERE Item_Code = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, itemCode);
            }
            rs = preparedStatement.executeQuery();
            rs.next();
            gst = rs.getDouble("GST_Sale");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return gst;
    }
}
