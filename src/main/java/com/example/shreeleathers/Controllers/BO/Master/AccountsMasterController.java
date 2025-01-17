package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.Accounts;
import com.example.shreeleathers.Models.Master.StateCode;
import com.example.shreeleathers.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountsMasterController implements Initializable
{
    public TableView<Accounts> account_master_tbl;
    public TableColumn<Accounts, String> acc_code_column;
    public TableColumn<Accounts, String> acc_type_column;
    public TableColumn<Accounts, String> acc_name_column;
    public TableColumn<Accounts, String> ph_no_column;
    public TableColumn<Accounts, String> add_line1_column;
    public TableColumn<Accounts, String> add_line2_column;
    public TableColumn<Accounts, String> state_code_column;
    public TableColumn<Accounts, String> city_column;
    public TableColumn<Accounts, String> pincode_column;
    public TableColumn<Accounts, String> gst_no_column;
    public ObservableList<Accounts> data;
    public TextField acc_code_txt;
    public TextField acc_name_txt;
    public TextField ph_no_txt;
    public TextField add_line1_txt;
    public TextField add_line2_txt;
    public TextField state_code_txt;
    public TextField city_txt;
    public TextField gst_no_txt;
    public TextField pincode_txt;
    public Button create_account_btn;
    public TextField acc_type_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        acc_code_column.setCellFactory(TextFieldTableCell.forTableColumn());
        acc_type_column.setCellFactory(TextFieldTableCell.forTableColumn());
        acc_name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        ph_no_column.setCellFactory(TextFieldTableCell.forTableColumn());
        add_line1_column.setCellFactory(TextFieldTableCell.forTableColumn());
        add_line2_column.setCellFactory(TextFieldTableCell.forTableColumn());
        state_code_column.setCellFactory(TextFieldTableCell.forTableColumn());
        city_column.setCellFactory(TextFieldTableCell.forTableColumn());
        pincode_column.setCellFactory(TextFieldTableCell.forTableColumn());
        gst_no_column.setCellFactory(TextFieldTableCell.forTableColumn());
        account_master_tbl.setEditable(true);
        addDataToTable();
        acc_code_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setAccCode(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        acc_type_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setAccType(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        acc_name_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setAccName(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        ph_no_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setPhoneNumber(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        add_line1_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setAdd1(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        add_line2_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setAdd2(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        state_code_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setSCode(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        city_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setCity(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        pincode_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setPinCode(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        gst_no_column.setOnEditCommit(event ->
        {
            Accounts dt = event.getRowValue();
            dt.setGSTNumber(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableAccountMaster(dt);
        });
        create_account_btn.setOnAction(event -> onInsert());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        acc_code_column.setCellValueFactory(cellData -> cellData.getValue().accCodeProperty());
        acc_type_column.setCellValueFactory(cellData -> cellData.getValue().accTypeProperty());
        acc_name_column.setCellValueFactory(cellData -> cellData.getValue().accNameProperty());
        ph_no_column.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        add_line1_column.setCellValueFactory(cellData -> cellData.getValue().add1Property());
        add_line2_column.setCellValueFactory(cellData -> cellData.getValue().add2Property());
        state_code_column.setCellValueFactory(cellData -> cellData.getValue().sCodeProperty());
        city_column.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        pincode_column.setCellValueFactory(cellData -> cellData.getValue().pinCodeProperty());
        gst_no_column.setCellValueFactory(cellData -> cellData.getValue().gstNumberProperty());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getAccounts();
            account_master_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void onInsert()
    {
        String accCode = acc_code_txt.getText();
        String accType = acc_type_txt.getText();
        String accName = acc_name_txt.getText();
        String phoneNumber = ph_no_txt.getText();
        String add1 = add_line1_txt.getText();
        String add2 = add_line2_txt.getText();
        String sCode = state_code_txt.getText();
        String city = city_txt.getText();
        String pinCode = pincode_txt.getText();
        String gstNumber = gst_no_txt.getText();
        int id = Model.getInstance().getDatabaseDriver().insertIntoAccountMaster(accCode, accType, accName, phoneNumber,
                add1, add2, sCode, city, pinCode, gstNumber);
        Accounts newData = new Accounts(id, accCode, accType, accName, phoneNumber, add1, add2, sCode, city, pinCode, gstNumber);
        data.add(newData);
        acc_code_txt.setText("");
        acc_type_txt.setText("");
        acc_name_txt.setText("");
        ph_no_txt.setText("");
        add_line1_txt.setText("");
        add_line2_txt.setText("");
        state_code_txt.setText("");
        city_txt.setText("");
        pincode_txt.setText("");
        gst_no_txt.setText("");
    }
}
