package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.Accounts;
import com.example.shreeleathers.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    public ChoiceBox acc_type_selector;
    public TextField ph_no_txt;
    public TextField add_line1_txt;
    public TextField add_line2_txt;
    public TextField state_code_txt;
    public TextField city_txt;
    public TextField gst_no_txt;
    public TextField pincode_txt;
    public Button create_account_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        account_master_tbl.setEditable(true);
        addDataToTable();
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
}
