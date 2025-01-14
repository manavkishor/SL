package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.StateCode;
import com.example.shreeleathers.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class StateCodeMasterController implements Initializable
{
    public TableView<StateCode> state_code_tbl;
    public TableColumn<StateCode, String> state_code_column;
    public TableColumn<StateCode, String> state_column;
    public Button save_btn;
    public ObservableList<StateCode> data;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        addDataToTable();
    }

    public void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        try
        {
            ResultSet resultSet = Model.getInstance().getDatabaseDriver().getStateCode();
            while(resultSet.next())
            {
                data.add(new StateCode(resultSet.getString("State_Code"), resultSet.getString("State_Name")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        state_code_column.setCellValueFactory(new PropertyValueFactory<>("State_Code"));
        state_column.setCellValueFactory(new PropertyValueFactory<>("State_Name"));

        state_code_tbl.setItems(data);
    }
}
