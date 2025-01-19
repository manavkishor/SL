package com.example.shreeleathers.Models;

import com.example.shreeleathers.Models.Master.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseDriver
{
    private Connection connection;
    private static final String URL = "jdbc:sqlserver://JARVIS\\SQLEXPRESS:1433;databaseName=SLDB;encrypt=true;trustServerCertificate=true";
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

    /*
    * SELECT statements
    * */

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
                dataList.add(new StateCode(resultSet.getInt("Id"),
                        resultSet.getString("State_Code"), resultSet.getString("State_Name")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return dataList;
    }

    public ObservableList<Accounts> getAccounts()
    {
        ObservableList<Accounts> dataList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Account_Master";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                dataList.add(new Accounts(resultSet.getInt("Acc_Id"),
                        resultSet.getString("Acc_Code"), resultSet.getString("Acc_Type"),
                        resultSet.getString("Acc_Name"), resultSet.getString("Acc_Mobile"),
                        resultSet.getString("Acc_Add_Line1"), resultSet.getString("Acc_Add_Line2"),
                        resultSet.getString("State_Code"), resultSet.getString("City"),
                        resultSet.getString("Pin_Code"), resultSet.getString("GST_Number")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return dataList;
    }

    public ObservableList<Firm> getFirm()
    {
        ObservableList<Firm> dataList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Firm_Master";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                dataList.add(new Firm(resultSet.getInt("Firm_Id"),
                        resultSet.getString("Firm_Name"), resultSet.getString("Phone_Number"),
                        resultSet.getString("Add_1"), resultSet.getString("Add_2"),
                        resultSet.getString("City"), resultSet.getString("State"),
                        resultSet.getString("State_Code"),
                        resultSet.getString("Pin_Code"), resultSet.getString("GST_Number")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return dataList;
    }

    public ObservableList<Category> getCategory()
    {
        ObservableList<Category> dataList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Category_Master";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                dataList.add(new Category(resultSet.getInt("Category_Id"),
                        resultSet.getString("Category_Name"), resultSet.getDouble("GST"),
                        resultSet.getString("HSN_Code")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return dataList;
    }

    public ObservableList<Colour> getColour()
    {
        ObservableList<Colour> dataList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Color_Master";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                dataList.add(new Colour(resultSet.getInt("SL_Number"), resultSet.getString("Colour_Desc")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return dataList;
    }

    public ObservableList<Item> getItem()
    {
        ObservableList<Item> dataList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Item_Master";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                dataList.add(new Item(resultSet.getInt("Item_Id"), resultSet.getString("Item_Code"),
                        resultSet.getInt("Category_Id"), resultSet.getString("Category"),
                        resultSet.getString("Item_Name"), resultSet.getString("HSN_Code"),
                        resultSet.getString("Colour"), resultSet.getString("Size"),
                        resultSet.getInt("Size_Id"), resultSet.getDouble("Purchase_Rate"),
                        resultSet.getDouble("GST_Purchase"), resultSet.getDouble("Sale_Rate"),
                        resultSet.getDouble("GST_Sale"), resultSet.getDouble("Disc_Per"),
                        resultSet.getBoolean("Status"), resultSet.getInt("Min_Stock")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return dataList;
    }

    public ObservableList<Salesman> getSalesman()
    {
        ObservableList<Salesman> dataList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Salesman_Master";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                dataList.add(new Salesman(resultSet.getInt("Sl_Number"),
                        resultSet.getString("Salesman_Code"),
                        resultSet.getString("Salesman_Name"), resultSet.getBoolean("IsActive")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return dataList;
    }


    /*
    * INSERT statements
    * */

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

    public int insertIntoCategoryMaster(String catName, double gst, String hsn_Code)
    {
        int id = 0;
        String sql = "INSERT INTO Category_Master (Category_Name, GST, HSN_Code) VALUES (?,?,?)";
        String selSql = "SELECT Category_Id FROM Category_Master WHERE Category_Name = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, catName);
                preparedStatement.setDouble(2, gst);
                preparedStatement.setString(3, hsn_Code);
            }
            preparedStatement.executeUpdate();

            PreparedStatement pStmt = this.connection.prepareStatement(selSql);
            {
                pStmt.setString(1, catName);
            }
            ResultSet resultSet = pStmt.executeQuery();
            resultSet.next();
            id = resultSet.getInt("Category_Id");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return id;
    }

    public int insertIntoAccountMaster(String accCode, String accType, String accName, String phNo, String add1,
                                       String add2, String sCode, String city, String pinCode, String gstNumber)
    {
        int id = 0;
        String sql = "INSERT INTO Account_Master (Acc_Code, Acc_Type, Acc_Name, Acc_Mobile, Acc_Add_Line1, " +
                "Acc_Add_Line2, State_Code, City, Pin_Code, GST_Number) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        String selSql = "SELECT Acc_Id FROM Account_Master WHERE Acc_Code = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, accCode);
                preparedStatement.setString(2, accType);
                preparedStatement.setString(3, accName);
                preparedStatement.setString(4, phNo);
                preparedStatement.setString(5, add1);
                preparedStatement.setString(6, add2);
                preparedStatement.setString(7, sCode);
                preparedStatement.setString(8, city);
                preparedStatement.setString(9, pinCode);
                preparedStatement.setString(10, gstNumber);
            }
            preparedStatement.executeUpdate();

            PreparedStatement pStmt = this.connection.prepareStatement(selSql);
            {
                pStmt.setString(1, accCode);
            }
            ResultSet resultSet = pStmt.executeQuery();
            resultSet.next();
            id = resultSet.getInt("Acc_Id");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return id;
    }

    public int insertIntoColourMaster(String colour)
    {
        int id = 0;
        String sql = "INSERT INTO Color_Master (Colour_Desc) VALUES (?)";
        String selSql = "SELECT Sl_Number FROM Color_Master WHERE Colour_Desc = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, colour);
            }
            preparedStatement.executeUpdate();

            PreparedStatement pStmt = this.connection.prepareStatement(selSql);
            {
                pStmt.setString(1, colour);
            }
            ResultSet resultSet = pStmt.executeQuery();
            resultSet.next();
            id = resultSet.getInt("Sl_Number");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return id;
    }

    public int insertIntoFirmMaster(String firmName, String phNo, String add1,
                                       String add2, String city, String state, String sCode, String pinCode, String gstNumber)
    {
        int id = 0;
        String sql = "INSERT INTO Firm_Master (Firm_Name, Phone_Number, Add_1, " +
                "Add_2, City, State, State_Code, Pin_Code, GST_Number) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        String selSql = "SELECT Firm_Id FROM Firm_Master WHERE Firm_Name = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, firmName);
                preparedStatement.setString(2, phNo);
                preparedStatement.setString(3, add1);
                preparedStatement.setString(4, add2);
                preparedStatement.setString(5, city);
                preparedStatement.setString(6, state);
                preparedStatement.setString(7, sCode);
                preparedStatement.setString(8, pinCode);
                preparedStatement.setString(9, gstNumber);
            }
            preparedStatement.executeUpdate();

            PreparedStatement pStmt = this.connection.prepareStatement(selSql);
            {
                pStmt.setString(1, firmName);
            }
            ResultSet resultSet = pStmt.executeQuery();
            resultSet.next();
            id = resultSet.getInt("Firm_Id");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return id;
    }

    public ResultSet insertIntoItemMaster(String itemCode, int catId, String cat, String itemName,
                                    String hsnCode, String colour, String size, int sizeId, double purRate, double gstPur,
                                    double saleRate, double gstSale, double discPur, int minStock)
    {
        ResultSet resultSet = null;
        String sql = "INSERT INTO Item_Master (Item_Code, Category_Id, Category, Item_Name, HSN_Code, Colour, Size, " +
                "Size_Id, Purchase_Rate, GST_Purchase, Sale_Rate, GST_Sale, Disc_Per, Min_Stock) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String selSql = "SELECT Item_Id FROM Item_Master WHERE Item_Code = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, itemCode);
                preparedStatement.setInt(2, catId);
                preparedStatement.setString(3, cat);
                preparedStatement.setString(4, itemName);
                preparedStatement.setString(5, hsnCode);
                preparedStatement.setString(6, colour);
                preparedStatement.setString(7, size);
                preparedStatement.setInt(8, sizeId);
                preparedStatement.setDouble(9, purRate);
                preparedStatement.setDouble(10, gstPur);
                preparedStatement.setDouble(11, saleRate);
                preparedStatement.setDouble(12, gstSale);
                preparedStatement.setDouble(13, discPur);
                preparedStatement.setInt(14, minStock);
            }
            preparedStatement.executeUpdate();

            PreparedStatement pStmt = this.connection.prepareStatement(selSql);
            {
                pStmt.setString(1, itemCode);
            }
            resultSet = pStmt.executeQuery();
            resultSet.next();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet insertIntoSalesmanMaster(String smCode, String smName)
    {
        ResultSet resultSet = null;
        String sql = "INSERT INTO Salesman_Master (Salesman_Code, Salesman_Name) VALUES (?,?)";
        String selSql = "SELECT Sl_Number FROM Salesman_Master WHERE Salesman_Code = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, smCode);
                preparedStatement.setString(2, smName);
            }
            preparedStatement.executeUpdate();

            PreparedStatement pStmt = this.connection.prepareStatement(selSql);
            {
                pStmt.setString(1, smCode);
            }
            resultSet = pStmt.executeQuery();
            resultSet.next();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }


    /*
    * UPDATE statements
    * */

    public void updateTableStateCode(StateCode dt)
    {
        String sql = "UPDATE State_Code_Master SET State_Code = ?, State_Name = ? WHERE Id = ?";
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

    public void updateTableAccountMaster(Accounts dt)
    {
        String sql = "UPDATE Account_Master SET Acc_Code = ?, Acc_Type = ?, Acc_Name = ?, Acc_Mobile = ?, " +
                "Acc_Add_Line1 = ?, Acc_Add_Line2 = ?, State_Code = ?, City = ?, Pin_Code = ?, GST_Number = ? WHERE Acc_Id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, dt.getAccCode());
                preparedStatement.setString(2, dt.getAccType());
                preparedStatement.setString(3, dt.getAccName());
                preparedStatement.setString(4, dt.getPhoneNumber());
                preparedStatement.setString(5, dt.getAdd1());
                preparedStatement.setString(6, dt.getAdd2());
                preparedStatement.setString(7, dt.getSCode());
                preparedStatement.setString(8, dt.getCity());
                preparedStatement.setString(9, dt.getPinCode());
                preparedStatement.setString(10, dt.getGSTNumber());
                preparedStatement.setInt(11, dt.getAccId());
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateTableFirmMaster(Firm dt)
    {
        String sql = "UPDATE Firm_Master SET Firm_Name = ?, Phone_Number = ?, " +
                "Add_1 = ?, Add_2 = ?, City = ?, State = ?, State_Code = ?, Pin_Code = ?, GST_Number = ? WHERE Firm_Id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, dt.getFirmName());
                preparedStatement.setString(2, dt.getPhoneNumber());
                preparedStatement.setString(3, dt.getAdd1());
                preparedStatement.setString(4, dt.getAdd2());
                preparedStatement.setString(5, dt.getCity());
                preparedStatement.setString(6, dt.getState());
                preparedStatement.setString(7, dt.getSCode());
                preparedStatement.setString(8, dt.getPinCode());
                preparedStatement.setString(9, dt.getGSTNumber());
                preparedStatement.setInt(10, dt.getFirmId());
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateTableCategoryMaster(Category dt)
    {
        String sql = "UPDATE Category_Master SET Category_Name = ?, GST = ?, HSN_Code = ? WHERE Category_Id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, dt.getCatName());
                preparedStatement.setDouble(2, dt.getGST());
                preparedStatement.setString(3, dt.getHSNCode());
                preparedStatement.setInt(4, dt.getCatId());
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateTableColourMaster(Colour dt)
    {
        String sql = "UPDATE Color_Master SET Colour_Desc = ? WHERE Sl_Number = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, dt.getColour());
                preparedStatement.setInt(2, dt.getSlNo());
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateTableItemMaster(Item dt)
    {
        String sql = "UPDATE Item_Master SET Item_Code = ?, Category_Id = ?, " +
                "Category = ?, Item_Name = ?, HSN_Code = ?, Colour = ?, Size = ?, Size_Id = ?, Purchase_Rate = ?, " +
                "GST_Purchase = ?, Sale_Rate = ?, GST_Sale = ?, Disc_Per = ?, Status = ?, Min_Stock = ? WHERE Item_Id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, dt.getItemCode());
                preparedStatement.setInt(2, dt.getCatId());
                preparedStatement.setString(3, dt.getCat());
                preparedStatement.setString(4, dt.getItemName());
                preparedStatement.setString(5, dt.getHSNCode());
                preparedStatement.setString(6, dt.getColour());
                preparedStatement.setString(7, dt.getSize());
                preparedStatement.setInt(8, dt.getSizeId());
                preparedStatement.setDouble(9, dt.getPurRate());
                preparedStatement.setDouble(10, dt.getGSTPur());
                preparedStatement.setDouble(11, dt.getSaleRate());
                preparedStatement.setDouble(12, dt.getGSTSale());
                preparedStatement.setDouble(13, dt.getDiscPur());
                preparedStatement.setBoolean(14, dt.getStatus());
                preparedStatement.setInt(15, dt.getMinStock());
                preparedStatement.setInt(16, dt.getItemId());
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateTableSalesmanMaster(Salesman dt)
    {
        String sql = "UPDATE Salesman_Master SET Salesman_Code = ?, Salesman_Name = ?, IsActive = ? WHERE Sl_Number = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, dt.getSmCode());
                preparedStatement.setString(2, dt.getSmName());
                preparedStatement.setBoolean(3, dt.getIsActive());
                preparedStatement.setInt(4, dt.getSlNo());
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
