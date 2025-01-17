package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class FirmMasterController implements Initializable
{
    public TableView<Firm> firm_master_tbl;
    public TableColumn<Firm, String> firm_name_column;
    public TableColumn<Firm, String> ph_no_column;
    public TableColumn<Firm, String> add1_column;
    public TableColumn<Firm, String> add2_column;
    public TableColumn<Firm, String> state_code_column;
    public TableColumn<Firm, String> city_column;
    public TableColumn<Firm, String> pincode_column;
    public TableColumn<Firm, String> gst_no_column;
    public TableColumn<Firm, String> state_column;
    public TextField state_txt;
    ObservableList<Firm> data;
    public TextField firm_name_txt;
    public TextField add1_txt;
    public TextField add2_txt;
    public TextField ph_no_txt;
    public TextField state_code_txt;
    public TextField city_txt;
    public TextField pincode_txt;
    public TextField gst_no_txt;
    public Button create_new_firm_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        firm_name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        ph_no_column.setCellFactory(TextFieldTableCell.forTableColumn());
        add1_column.setCellFactory(TextFieldTableCell.forTableColumn());
        add2_column.setCellFactory(TextFieldTableCell.forTableColumn());
        state_code_column.setCellFactory(TextFieldTableCell.forTableColumn());
        state_column.setCellFactory(TextFieldTableCell.forTableColumn());
        city_column.setCellFactory(TextFieldTableCell.forTableColumn());
        pincode_column.setCellFactory(TextFieldTableCell.forTableColumn());
        gst_no_column.setCellFactory(TextFieldTableCell.forTableColumn());
        firm_master_tbl.setEditable(true);
        addDataToTable();
        firm_name_column.setOnEditCommit(event ->
        {
            Firm dt = event.getRowValue();
            dt.setFirmName(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableFirmMaster(dt);
        });
        ph_no_column.setOnEditCommit(event ->
        {
            Firm dt = event.getRowValue();
            dt.setPhoneNumber(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableFirmMaster(dt);
        });
        add1_column.setOnEditCommit(event ->
        {
            Firm dt = event.getRowValue();
            dt.setAdd1(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableFirmMaster(dt);
        });
        add2_column.setOnEditCommit(event ->
        {
            Firm dt = event.getRowValue();
            dt.setAdd2(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableFirmMaster(dt);
        });
        state_code_column.setOnEditCommit(event ->
        {
            Firm dt = event.getRowValue();
            dt.setSCode(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableFirmMaster(dt);
        });
        city_column.setOnEditCommit(event ->
        {
            Firm dt = event.getRowValue();
            dt.setCity(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableFirmMaster(dt);
        });
        state_column.setOnEditCommit(event ->
        {
            Firm dt = event.getRowValue();
            dt.setState(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableFirmMaster(dt);
        });
        pincode_column.setOnEditCommit(event ->
        {
            Firm dt = event.getRowValue();
            dt.setPinCode(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableFirmMaster(dt);
        });
        gst_no_column.setOnEditCommit(event ->
        {
            Firm dt = event.getRowValue();
            dt.setGSTNumber(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableFirmMaster(dt);
        });
        create_new_firm_btn.setOnAction(event -> onInsert());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        firm_name_column.setCellValueFactory(cellData -> cellData.getValue().firmNameProperty());
        ph_no_column.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        add1_column.setCellValueFactory(cellData -> cellData.getValue().add1Property());
        add2_column.setCellValueFactory(cellData -> cellData.getValue().add2Property());
        city_column.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        state_column.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        state_code_column.setCellValueFactory(cellData -> cellData.getValue().sCodeProperty());
        pincode_column.setCellValueFactory(cellData -> cellData.getValue().pinCodeProperty());
        gst_no_column.setCellValueFactory(cellData -> cellData.getValue().gstNumberProperty());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getFirm();
            firm_master_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void onInsert()
    {
        String firmName = firm_name_txt.getText();
        String phoneNumber = ph_no_txt.getText();
        String add1 = add1_txt.getText();
        String add2 = add2_txt.getText();
        String sCode = state_code_txt.getText();
        String city = city_txt.getText();
        String state = state_txt.getText();
        String pinCode = pincode_txt.getText();
        String gstNumber = gst_no_txt.getText();
        int id = Model.getInstance().getDatabaseDriver().insertIntoFirmMaster(firmName, phoneNumber,
                add1, add2, city, state, sCode, pinCode, gstNumber);
        Firm newData = new Firm(id, firmName, phoneNumber, add1, add2, city, state, sCode, pinCode, gstNumber);
        data.add(newData);
        firm_name_txt.setText("");
        ph_no_txt.setText("");
        add1_txt.setText("");
        add2_txt.setText("");
        state_code_txt.setText("");
        state_txt.setText("");
        city_txt.setText("");
        pincode_txt.setText("");
        gst_no_txt.setText("");
    }
}
