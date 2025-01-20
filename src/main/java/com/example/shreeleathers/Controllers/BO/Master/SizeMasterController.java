package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.Size;
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
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class SizeMasterController implements Initializable
{
    public TableView<Size> size_master_tbl;
    public TableColumn<Size, String> size_from_column;
    public TableColumn<Size, String> size_upto_column;
    public TableColumn<Size, String> s1_column;
    public TableColumn<Size, String> s2_column;
    public TableColumn<Size, String> s3_column;
    public TableColumn<Size, String> s4_column;
    public TableColumn<Size, String> s5_column;
    public TableColumn<Size, String> s6_column;
    public TableColumn<Size, String> s7_column;
    public TableColumn<Size, String> s8_column;
    public TableColumn<Size, String> s9_column;
    public TableColumn<Size, String> s10_column;
    public TableColumn<Size, String> s11_column;
    public TableColumn<Size, String> s12_column;
    public TableColumn<Size, String> s13_column;
    public ObservableList<Size> data;
    public Button american_size_btn;
    public TableColumn<Size, Integer> size_id_column;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        size_id_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        size_from_column.setCellFactory(TextFieldTableCell.forTableColumn());
        size_upto_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s1_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s2_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s3_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s4_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s5_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s6_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s7_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s8_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s9_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s10_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s11_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s12_column.setCellFactory(TextFieldTableCell.forTableColumn());
        s13_column.setCellFactory(TextFieldTableCell.forTableColumn());
        addDataToTable();
        american_size_btn.setOnAction(event -> onAmericanSize());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        size_id_column.setCellValueFactory(cellData -> cellData.getValue().sizeIdProperty().asObject());
        size_from_column.setCellValueFactory(cellData -> cellData.getValue().szFromProperty());
        size_upto_column.setCellValueFactory(cellData -> cellData.getValue().szUptoProperty());
        s1_column.setCellValueFactory(cellData -> cellData.getValue().s1Property());
        s2_column.setCellValueFactory(cellData -> cellData.getValue().s2Property());
        s3_column.setCellValueFactory(cellData -> cellData.getValue().s3Property());
        s4_column.setCellValueFactory(cellData -> cellData.getValue().s4Property());
        s5_column.setCellValueFactory(cellData -> cellData.getValue().s5Property());
        s6_column.setCellValueFactory(cellData -> cellData.getValue().s6Property());
        s7_column.setCellValueFactory(cellData -> cellData.getValue().s7Property());
        s8_column.setCellValueFactory(cellData -> cellData.getValue().s8Property());
        s9_column.setCellValueFactory(cellData -> cellData.getValue().s9Property());
        s10_column.setCellValueFactory(cellData -> cellData.getValue().s10Property());
        s11_column.setCellValueFactory(cellData -> cellData.getValue().s11Property());
        s12_column.setCellValueFactory(cellData -> cellData.getValue().s12Property());
        s13_column.setCellValueFactory(cellData -> cellData.getValue().s13Property());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getSize();
            size_master_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void onAmericanSize()
    {
        Model.getInstance().getViewFactory().getAmericanSizeWindow();
    }
}
