package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.Category;
import com.example.shreeleathers.Models.Master.ItemName;
import com.example.shreeleathers.Models.Master.Salesman;
import com.example.shreeleathers.Models.Master.Size;
import com.example.shreeleathers.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemNameMasterController implements Initializable
{
    public TableView<ItemName> item_name_master_tbl;
    public TableColumn<ItemName, Integer> category_id_column;
    public TableColumn<ItemName, String> item_name_column;
    public TableColumn<ItemName, Integer> size_id_column;
    public TableColumn<ItemName, String> size_from_column;
    public TableColumn<ItemName, String> size_upto_column;
    public ObservableList<ItemName> data;
    public TextField item_name_txt;
    public ChoiceBox<Category> category_selector;
    public ChoiceBox<Size> size_selector;
    public Button new_item_name_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        item_name_master_tbl.setEditable(true);
        category_id_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        item_name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        size_id_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        size_from_column.setCellFactory(TextFieldTableCell.forTableColumn());
        size_upto_column.setCellFactory(TextFieldTableCell.forTableColumn());
        category_selector.setItems(Model.getInstance().getDatabaseDriver().getCategory());
        size_selector.setItems(Model.getInstance().getDatabaseDriver().getSize());
        addDataToTable();
        category_id_column.setOnEditCommit(event ->
        {
            ItemName dt = event.getRowValue();
            dt.setCatId(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemNameMaster(dt);
        });
        item_name_column.setOnEditCommit(event ->
        {
            ItemName dt = event.getRowValue();
            dt.setItemName(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemNameMaster(dt);
        });
        size_id_column.setOnEditCommit(event ->
        {
            ItemName dt = event.getRowValue();
            dt.setSizeId(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemNameMaster(dt);
        });
        size_from_column.setOnEditCommit(event ->
        {
            ItemName dt = event.getRowValue();
            dt.setSzFrom(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemNameMaster(dt);
        });
        size_upto_column.setOnEditCommit(event ->
        {
            ItemName dt = event.getRowValue();
            dt.setSzUpto(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemNameMaster(dt);
        });
        new_item_name_btn.setOnAction(event -> onInsert());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        category_id_column.setCellValueFactory(cellData -> cellData.getValue().catIdProperty().asObject());
        item_name_column.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        size_id_column.setCellValueFactory(cellData -> cellData.getValue().sizeIdProperty().asObject());
        size_from_column.setCellValueFactory(cellData -> cellData.getValue().szFromProperty());
        size_upto_column.setCellValueFactory(cellData -> cellData.getValue().szUptoProperty());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getItemName();
            item_name_master_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void onInsert()
    {
        String itemName = item_name_txt.getText();
        Category cat = category_selector.getValue();
        Size size = size_selector.getValue();
        int slNo = Model.getInstance().getDatabaseDriver().insertIntoItemNameMaster(itemName, cat, size);
        ItemName newData = new ItemName(slNo, cat.getCatId(), itemName, size.getSizeId(), size.getSzFrom(), size.getSzUpto());
        data.add(newData);
        item_name_txt.setText("");
        category_selector.setValue(null);
        size_selector.setValue(null);

    }
}
