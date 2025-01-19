package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.Salesman;
import com.example.shreeleathers.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BooleanStringConverter;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SalesmanMasterController implements Initializable
{
    public TableView<Salesman> salesman_master_tbl;
    public TableColumn<Salesman, String> salesman_code_column;
    public TableColumn<Salesman, String> salesman_name_column;
    public TableColumn<Salesman, Boolean> is_active_column;
    public ObservableList<Salesman> data;
    public TextField salesman_code_txt;
    public TextField salesman_name_txt;
    public Button create_new_salesman_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        salesman_master_tbl.setEditable(true);
        salesman_code_column.setCellFactory(TextFieldTableCell.forTableColumn());
        salesman_name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        is_active_column.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        addDataToTable();
        salesman_code_column.setOnEditCommit(event ->
        {
            Salesman dt = event.getRowValue();
            dt.setSmCode(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableSalesmanMaster(dt);
        });
        salesman_name_column.setOnEditCommit(event ->
        {
            Salesman dt = event.getRowValue();
            dt.setSmName(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableSalesmanMaster(dt);
        });
        is_active_column.setOnEditCommit(event ->
        {
            Salesman dt = event.getRowValue();
            dt.setIsActive(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableSalesmanMaster(dt);
        });
        create_new_salesman_btn.setOnAction(event -> onInsert());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        salesman_code_column.setCellValueFactory(cellData -> cellData.getValue().smCodeProperty());
        salesman_name_column.setCellValueFactory(cellData -> cellData.getValue().smNameProperty());
        is_active_column.setCellValueFactory(cellData -> cellData.getValue().isActiveProperty());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getSalesman();
            salesman_master_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void onInsert()
    {
        String smCode = salesman_code_txt.getText();
        String smName = salesman_name_txt.getText();
        int slNo = 0;
        boolean isActive = true;
        try
        {
            ResultSet resultSet = Model.getInstance().getDatabaseDriver().insertIntoSalesmanMaster(smCode, smName);
            slNo = resultSet.getInt("Sl_Number");
            isActive = resultSet.getBoolean("IsActive");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        Salesman newData = new Salesman(slNo, smCode, smName, isActive);
        data.add(newData);
        salesman_code_txt.setText("");
        salesman_name_txt.setText("");
    }
}
