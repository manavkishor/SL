package com.example.shreeleathers.Models.Sale;

import com.example.shreeleathers.Models.Master.GST;
import com.example.shreeleathers.Models.Model;
import com.example.shreeleathers.Views.POSMenuOptions;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class SaleDBServices
{
    private final Connection connection;
    public SaleDBServices(Connection connection)
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
            id = resultSet1.  getInt("Size_Id");

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

    public String getHSNCodeByCode(String itemCode)
    {
        ResultSet rs;
        String hsnCode = null;
        String sql = "SELECT HSN_Code FROM Item_Master WHERE Item_Code = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, itemCode);
            }
            rs = preparedStatement.executeQuery();
            rs.next();
            hsnCode = rs.getString("HSN_Code");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return hsnCode;
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

    public String getInvoice(POSMenuOptions posMenu)
    {
        String pfx = null;
        String inv = null;
        ResultSet resultset;
        switch(posMenu)
        {
            case SALE -> pfx = "SA";
            case SALERETURN -> pfx = "SR";
            case EXCHANGE -> pfx = "EX";
        }
        String sql = "SELECT * FROM Invoice_Number_Log WHERE Prefix = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            {
                preparedStatement.setString(1, pfx);
            }
            resultset = preparedStatement.executeQuery();
            resultset.next();
            inv = pfx + "/" + resultset.getString("Last_Invoice_Number");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return inv;
    }

    public void onSaleFunctions(ObservableList<CartItems> cartItems, ObservableList<GST> gstDetails, String invoice_Number,
                                String customerName, String customerContact, String payMode, double cashPaidAmt, double cardPaidAmt, double upiPaidAmt)
    {
        double totalGSTAmt = 0.00;
        for(GST details : gstDetails)
        {
            totalGSTAmt = totalGSTAmt + Double.parseDouble(String.format("%.2f", Double.parseDouble(details.getGSTAmount())));
        }
        double taxableAmt = 0.00;
        double invAmt = 0.00;
        for(CartItems items : cartItems)
        {
            double gst = Model.getInstance().getDatabaseDriver().getSaleDBServices().getGSTByCode(items.getItemCode());
            double amt = Double.parseDouble(String.format("%.2f", ((items.getRate() * 100) / (100 + gst)) * items.getQuantity()));
            taxableAmt = taxableAmt + amt;
            invAmt = invAmt + Double.parseDouble(String.format("%.2f",(items.getRate() * items.getQuantity())));
        }
        String sqlSaleMain = "INSERT INTO Sale_Main(Inv_Number, Inv_Date, Acc_Name, Acc_Mobile_Number, Total_GST, Taxable_Amt, Disc_Per," +
                " Disc_Amt, Disc_Ref, Invoice_Amt, User_Name) VALUES(?,CURRENT_TIMESTAMP,?,?,?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sqlSaleMain);
            {
                preparedStatement.setString(1, invoice_Number);
                preparedStatement.setString(2, customerName);
                preparedStatement.setString(3, customerContact);
                preparedStatement.setDouble(4, totalGSTAmt);
                preparedStatement.setDouble(5, taxableAmt);
                preparedStatement.setDouble(6, 0.00);
                preparedStatement.setDouble(7, 0.00);
                preparedStatement.setString(8, null);
                preparedStatement.setDouble(9, invAmt);
                preparedStatement.setString(10, Model.getInstance().getUser().getName());

            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        String sqlSaleBody = "INSERT INTO Sale_Body(Inv_Number, Item_Code, Quantity, Rate, Total, Salesman_Code)" +
                "VALUES(?,?,?,?,?,?)";
        for(CartItems items : cartItems)
        {
            try
            {
                PreparedStatement preparedStatement = this.connection.prepareStatement(sqlSaleBody);
                {
                    preparedStatement.setString(1, invoice_Number);
                    preparedStatement.setString(2, items.getItemCode());
                    preparedStatement.setInt(3, items.getQuantity());
                    preparedStatement.setDouble(4, Double.parseDouble(String.format("%.2f", items.getRate())));
                    preparedStatement.setDouble(5, Double.parseDouble(String.format("%.2f", (items.getRate()*items.getQuantity()))));
                    preparedStatement.setString(6, items.getSalesman());
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        String sqlSaleGST = "INSERT INTO Sale_GST_Details(Inv_Number, Inv_Date, GST, GST_Amt, C_GST, C_GST_Amt, S_GST, S_GST_Amt, IGST, IGST_Amt) " +
                "VALUES(?,CURRENT_TIMESTAMP,?,?,?,?,?,?,?,?)";
        for (GST gstDetail : gstDetails) {
            double gstAmt = 0.00;
            double gstPer = 0.00;
            double igstPer = 0.00;
            double igstAmt = 0.00;
            double csgstPer = 0.00;
            double csgstAmt = 0.00;
            if (gstDetail.getGSTType().equals("IGST")) {
                gstAmt = Double.parseDouble(gstDetail.getGSTAmount());
                gstPer = gstDetail.getGST();
                igstAmt = Double.parseDouble(gstDetail.getGSTAmount());
                igstPer = gstDetail.getGST();
                try {
                    PreparedStatement preparedStatement = this.connection.prepareStatement(sqlSaleGST);
                    {
                        preparedStatement.setString(1, invoice_Number);
                        preparedStatement.setDouble(2, gstPer);
                        preparedStatement.setDouble(3, gstAmt);
                        preparedStatement.setDouble(4, csgstPer);
                        preparedStatement.setDouble(5, csgstAmt);
                        preparedStatement.setDouble(6, csgstPer);
                        preparedStatement.setDouble(7, csgstAmt);
                        preparedStatement.setDouble(8, igstPer);
                        preparedStatement.setDouble(9, igstAmt);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (gstDetail.getGSTType().equals("C_GST")) {
                gstAmt = Double.parseDouble(String.format("%.2f", (Double.parseDouble(gstDetail.getGSTAmount()) * 2)));
                gstPer = (gstDetail.getGST()) * 2;
                csgstPer = gstDetail.getGST();
                csgstAmt = Double.parseDouble(gstDetail.getGSTAmount());
                try {
                    PreparedStatement preparedStatement = this.connection.prepareStatement(sqlSaleGST);
                    {
                        preparedStatement.setString(1, invoice_Number);
                        preparedStatement.setDouble(2, gstPer);
                        preparedStatement.setDouble(3, gstAmt);
                        preparedStatement.setDouble(4, csgstPer);
                        preparedStatement.setDouble(5, csgstAmt);
                        preparedStatement.setDouble(6, csgstPer);
                        preparedStatement.setDouble(7, csgstAmt);
                        preparedStatement.setDouble(8, igstPer);
                        preparedStatement.setDouble(9, igstAmt);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        String sqlPaymentModeDetails = "INSERT INTO Payment_Mode_Details(Inv_Number, Inv_Date, Pay_Mode, Amount)" +
                "VALUES(?,CURRENT_TIMESTAMP,?,?)";
        String[] array = payMode.split("-");
        String[] finalArray = Arrays.stream(array).filter(entry -> !entry.isEmpty()).toArray(String[]::new);
        for (String s : finalArray) {
            if (Objects.equals(s, "CASH")) {
                try {
                    PreparedStatement preparedStatement = this.connection.prepareStatement(sqlPaymentModeDetails);
                    {
                        preparedStatement.setString(1, invoice_Number);
                        preparedStatement.setString(2, s);
                        preparedStatement.setDouble(3, cashPaidAmt);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.equals(s, "CARD")) {
                try {
                    PreparedStatement preparedStatement = this.connection.prepareStatement(sqlPaymentModeDetails);
                    {
                        preparedStatement.setString(1, invoice_Number);
                        preparedStatement.setString(2, s);
                        preparedStatement.setDouble(3, cardPaidAmt);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.equals(s, "UPI")) {
                try {
                    PreparedStatement preparedStatement = this.connection.prepareStatement(sqlPaymentModeDetails);
                    {
                        preparedStatement.setString(1, invoice_Number);
                        preparedStatement.setString(2, s);
                        preparedStatement.setDouble(3, upiPaidAmt);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        String sqlInventoryUpdate = "INSERT INTO Item_Inventory_Master(Trn_Date, Particulars, Item_Id, Stock_In, Stock_Out, Row_Version) VALUES(CURRENT_TIMESTAMP,?,?,?,?,?)";
        for(CartItems items : cartItems)
        {
            String particulars = null;
            int stockOut = 0;
            int stockIn = 0;
            String[] parts = invoice_Number.split("/");
            if(parts[1].equals("SA"))
            {
                stockOut = items.getQuantity();
            }
            try
            {
                particulars = items.getItemCode()+", "+items.getItemName()+", "+getHSNCodeByCode(items.getItemCode())+", "+items.getQuantity();
                PreparedStatement preparedStatement = this.connection.prepareStatement(sqlInventoryUpdate);
                {
                    preparedStatement.setString(1, particulars);
                    preparedStatement.setString(2, items.getItemCode());
                    preparedStatement.setInt(3, stockIn);
                    preparedStatement.setInt(4, stockOut);
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        String sqlUpdateInvoice = "UPDATE Invoice_Number_Log Date = CURRENT_TIMESTAMP Last_Invoice_Number = ? WHERE Prefix = ?";
        String[] invParts = invoice_Number.split("/");
        int newInvNumber = Integer.parseInt(invParts[2]);
        newInvNumber = newInvNumber+1;
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sqlUpdateInvoice);
            {
                preparedStatement.setString(1, String.format("%06d", newInvNumber));
                preparedStatement.setString(2, invParts[2]);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
