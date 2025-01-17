package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.Category;
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
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryMasterController implements Initializable
{
    public TableView<Category> category_master_tbl;
    public TableColumn<Category, String> category_name_column;
    public TableColumn<Category, Double> gst_column;
    public TableColumn<Category, String> hsn_code_column;
    public ObservableList<Category> data;
    public TextField cat_name_txt;
    public TextField gst_txt;
    public TextField hsn_code_txt;
    public Button create_new_category_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        category_master_tbl.setEditable(true);
        category_name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        gst_column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        hsn_code_column.setCellFactory(TextFieldTableCell.forTableColumn());
        addDataToTable();
        category_name_column.setOnEditCommit(event ->
        {
            Category dt = event.getRowValue();
            dt.setCatName(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableCategoryMaster(dt);
        });
        gst_column.setOnEditCommit(event ->
        {
            Category dt = event.getRowValue();
            dt.setGST(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableCategoryMaster(dt);
        });
        hsn_code_column.setOnEditCommit(event ->
        {
            Category dt = event.getRowValue();
            dt.setHsnCode(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableCategoryMaster(dt);
        });
        create_new_category_btn.setOnAction(event -> onInsert());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        category_name_column.setCellValueFactory(cellData -> cellData.getValue().catNameProperty());
        gst_column.setCellValueFactory(cellData -> cellData.getValue().gstProperty().asObject());
        hsn_code_column.setCellValueFactory(cellData -> cellData.getValue().hsnCodeProperty());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getCategory();
            category_master_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void onInsert()
    {
        String catName = cat_name_txt.getText();
        double gst = Double.parseDouble(gst_txt.getText());
        String hsnCode = hsn_code_txt.getText();
        int id = Model.getInstance().getDatabaseDriver().insertIntoCategoryMaster(catName, gst, hsnCode);
        Category newData = new Category(id, catName, gst, hsnCode);
        data.add(newData);
        cat_name_txt.setText("");
        gst_txt.setText("");
        hsn_code_txt.setText("");
    }
}
