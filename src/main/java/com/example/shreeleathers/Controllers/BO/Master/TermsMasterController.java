package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.Terms;
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

public class TermsMasterController implements Initializable
{
    public TableView<Terms> terms_condition_tbl;
    public TableColumn<Terms, Integer> sl_no_column;
    public TableColumn<Terms, String> terms_column;
    public TableColumn<Terms, Boolean> status_column;
    public ObservableList<Terms> data;
    public TextField terms_txt;
    public Button add_new_term_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        terms_condition_tbl.setEditable(true);
        terms_column.setCellFactory(TextFieldTableCell.forTableColumn());
        status_column.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        addDataToTable();
        terms_column.setOnEditCommit(event ->
        {
            Terms dt = event.getRowValue();
            dt.setTerm(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableTermsAndCondition(dt);
        });
        status_column.setOnEditCommit(event ->
        {
            Terms dt = event.getRowValue();
            dt.setStatus(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableTermsAndCondition(dt);
        });
        add_new_term_btn.setOnAction(event -> onInsert());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        sl_no_column.setCellValueFactory(cellData -> cellData.getValue().slNoProperty().asObject());
        terms_column.setCellValueFactory(cellData -> cellData.getValue().termProperty());
        status_column.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getTerms();
            terms_condition_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void onInsert()
    {
        String terms = terms_txt.getText();
        int slNo = 0;
        boolean status = true;
        try
        {
            ResultSet resultSet = Model.getInstance().getDatabaseDriver().insertIntoTermsAndCondition(terms);
            slNo = resultSet.getInt("Sl_Number");
            status = resultSet.getBoolean("Status");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        Terms newData = new Terms(slNo, terms, status);
        data.add(newData);
        terms_txt.setText("");
    }
}
