package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.StateCode;
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

public class StateCodeMasterController implements Initializable
{
    public TableView<StateCode> state_code_tbl;
    public TableColumn<StateCode, String> state_code_column;
    public TableColumn<StateCode, String> state_column;
    public ObservableList<StateCode> data;
    public Button add_btn;
    public TextField state_name_txt;
    public TextField state_code_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        state_code_tbl.setEditable(true);
        state_code_column.setCellFactory(TextFieldTableCell.forTableColumn());
        state_column.setCellFactory(TextFieldTableCell.forTableColumn());
        addDataToTable();
        state_code_column.setOnEditCommit(event ->
        {
            StateCode dt = event.getRowValue();
            dt.setSCode(event.getNewValue());
            updateTable(dt);
        });
        state_column.setOnEditCommit(event ->
        {
            StateCode dt = event.getRowValue();
            dt.setState(event.getNewValue());
            updateTable(dt);
        });
        add_btn.setOnAction(event -> onInsert());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        state_code_column.setCellValueFactory(cellData -> cellData.getValue().sCodeProperty());
        state_column.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getStateCode();
            state_code_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void updateTable(StateCode dt)
    {
        Model.getInstance().getDatabaseDriver().updateTable(dt);
    }

    private void onInsert()
    {
        String sCode = state_code_txt.getText();
        String state = state_name_txt.getText();
        int id = Model.getInstance().getDatabaseDriver().insertIntoStateCode(sCode, state);
        StateCode newData = new StateCode(id, sCode, state);
        data.add(newData);
        state_code_txt.setText("");
        state_name_txt.setText("");
    }
}
