package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.*;
import com.example.shreeleathers.Models.Model;
import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemMasterController implements Initializable
{
    public TableView<Item> item_master_tbl;
    public TableColumn<Item, String> item_code_column;
    public TableColumn<Item, Integer> cat_id_column;
    public TableColumn<Item, String> category_column;
    public TableColumn<Item, String> item_name_column;
    public TableColumn<Item, String> hsn_code_column;
    public TableColumn<Item, String> colour_column;
    public TableColumn<Item, String> size_column;
    public TableColumn<Item, Integer> size_id_column;
    public TableColumn<Item, Double> pur_rate_column;
    public TableColumn<Item, Double> gst_pur_column;
    public TableColumn<Item, Double> sale_rate_column;
    public TableColumn<Item, Double> gst_sale_column;
    public TableColumn<Item, Double> disc_per_column;
    public TableColumn<Item, Boolean> status_column;
    public TableColumn<Item, Integer> min_stock_column;
    public ObservableList<Item> data;
    public TextField item_code_txt;
    public TextField item_name_txt;
    public TextField hsn_code_txt;
    public TextField pur_rate_txt;
    public TextField pur_gst_txt;
    public TextField sale_rate_txt;
    public TextField sale_gst_txt;
    public TextField disc_per_txt;
    public TextField min_stock_txt;
    public Button create_item_btn;
    public ChoiceBox<Category> category_selector;
    public ChoiceBox<Colour> colour_selector;
    public ChoiceBox<Size> size_selector;
    public ChoiceBox<String> sz_selector;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        item_code_column.setCellFactory(TextFieldTableCell.forTableColumn());
        cat_id_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        category_column.setCellFactory(TextFieldTableCell.forTableColumn());
        item_name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        hsn_code_column.setCellFactory(TextFieldTableCell.forTableColumn());
        colour_column.setCellFactory(TextFieldTableCell.forTableColumn());
        size_column.setCellFactory(TextFieldTableCell.forTableColumn());
        size_id_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        pur_rate_column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        gst_pur_column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        sale_rate_column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        gst_sale_column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        disc_per_column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        status_column.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        min_stock_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        category_selector.setItems(Model.getInstance().getDatabaseDriver().getCategory());
        category_selector.valueProperty().addListener(observable -> setCatName());
        size_selector.setItems(Model.getInstance().getDatabaseDriver().getSize());
        size_selector.valueProperty().addListener(observable -> setSizes());
        colour_selector.setItems(Model.getInstance().getDatabaseDriver().getColour());
        item_master_tbl.setEditable(true);
        addDataToTable();
        item_code_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setItemCode(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        cat_id_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setCatId(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        category_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setCat(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        item_name_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setItemName(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        hsn_code_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setHSNCode(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        colour_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setColour(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        size_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setSize(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        size_id_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setSizeId(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        pur_rate_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setPurRate(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        gst_pur_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setGSTPur(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        sale_rate_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setSaleRate(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        gst_sale_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setGSTSale(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        disc_per_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setDiscPur(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        status_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setStatus(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        min_stock_column.setOnEditCommit(event ->
        {
            Item dt = event.getRowValue();
            dt.setMinStock(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableItemMaster(dt);
        });
        create_item_btn.setOnAction(event -> onInsert());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        item_code_column.setCellValueFactory(cellData -> cellData.getValue().itemCodeProperty());
        cat_id_column.setCellValueFactory(cellData -> cellData.getValue().catIdProperty().asObject());
        item_name_column.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        hsn_code_column.setCellValueFactory(cellData -> cellData.getValue().hsnCodeProperty());
        colour_column.setCellValueFactory(cellData -> cellData.getValue().colourProperty());
        size_column.setCellValueFactory(cellData -> cellData.getValue().sizeProperty());
        size_id_column.setCellValueFactory(cellData -> cellData.getValue().sizeIdProperty().asObject());
        pur_rate_column.setCellValueFactory(cellData -> cellData.getValue().purRateProperty().asObject());
        gst_pur_column.setCellValueFactory(cellData -> cellData.getValue().gstPurProperty().asObject());
        sale_rate_column.setCellValueFactory(cellData -> cellData.getValue().saleRateProperty().asObject());
        gst_sale_column.setCellValueFactory(cellData -> cellData.getValue().gstSaleProperty().asObject());
        disc_per_column.setCellValueFactory(cellData -> cellData.getValue().discPurProperty().asObject());
        status_column.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        min_stock_column.setCellValueFactory(cellData -> cellData.getValue().minStockProperty().asObject());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getItem();
            item_master_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void onInsert()
    {
        String itemCode = item_code_txt.getText();
        Category category = category_selector.getValue();
        String itemName = item_name_txt.getText();
        String hsnCode = hsn_code_txt.getText();
        Colour colour = colour_selector.getValue();
        String sizenm = sz_selector.getValue();
        Size size = size_selector.getValue();
        double purRate = Double.parseDouble(pur_rate_txt.getText());
        double gstPur = Double.parseDouble(pur_gst_txt.getText());
        double saleRate = Double.parseDouble(sale_rate_txt.getText());
        double gstSale = Double.parseDouble(sale_gst_txt.getText());
        double discPur = Double.parseDouble(disc_per_txt.getText());
        int minStock = Integer.parseInt(min_stock_txt.getText());
        int id = 0;
        boolean status = true;
        try
        {
            ResultSet resultSet = Model.getInstance().getDatabaseDriver().insertIntoItemMaster(itemCode, category.getCatId(), category.getCatName(), itemName, hsnCode, colour.getColour(), sizenm, size.getSizeId(), purRate, gstPur, saleRate, gstSale, discPur,minStock);
            id = resultSet.getInt("Item_Id");
            status = resultSet.getBoolean("Status");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        Item newData = new Item(id, itemCode, category.getCatId(), category.getCatName(), itemName, hsnCode, colour.getColour(), sizenm, size.getSizeId(), purRate, gstPur, saleRate, gstSale, discPur, status, minStock);
        data.add(newData);
        item_code_txt.setText("");
        category_selector.setValue(null);
        item_name_txt.setText("");
        hsn_code_txt.setText("");
        colour_selector.setValue(null);
        sz_selector.setValue(null);
        size_selector.setValue(null);
        pur_rate_txt.setText("");
        pur_gst_txt.setText("");
        sale_rate_txt.setText("");
        sale_gst_txt.setText("");
        disc_per_txt.setText("");
        min_stock_txt.setText("");
    }

    private void setCatName()
    {
        if(category_selector.getValue() != null)
        {
            String hsn = category_selector.getValue().getHSNCode();
            hsn_code_txt.setText(hsn);
        }
    }

    private void setSizes()
    {
        if(size_selector.getValue() != null)
        {
            int id = size_selector.getValue().getSizeId();
            switch(id)
            {
                case 1 : sz_selector.setItems(FXCollections.observableArrayList(size_selector.getValue().getS1()));
                break;
                case 2 : sz_selector.setItems(FXCollections.observableArrayList(size_selector.getValue().getS1(), size_selector.getValue().getS2(), size_selector.getValue().getS3(), size_selector.getValue().getS4(),
                        size_selector.getValue().getS5(), size_selector.getValue().getS6(), size_selector.getValue().getS7(), size_selector.getValue().getS8(),
                        size_selector.getValue().getS9(), size_selector.getValue().getS10(), size_selector.getValue().getS11(), size_selector.getValue().getS12(),
                        size_selector.getValue().getS13()));
                break;
                case 3 : sz_selector.setItems(FXCollections.observableArrayList(size_selector.getValue().getS1(), size_selector.getValue().getS2(), size_selector.getValue().getS3(), size_selector.getValue().getS4(),
                        size_selector.getValue().getS5(), size_selector.getValue().getS6(), size_selector.getValue().getS7(), size_selector.getValue().getS8(),
                        size_selector.getValue().getS9(), size_selector.getValue().getS10()));
                break;
                case 4 : sz_selector.setItems(FXCollections.observableArrayList(size_selector.getValue().getS1(), size_selector.getValue().getS2(), size_selector.getValue().getS3(), size_selector.getValue().getS4(),
                        size_selector.getValue().getS5(), size_selector.getValue().getS6(), size_selector.getValue().getS7(), size_selector.getValue().getS8(),
                        size_selector.getValue().getS9()));
                break;
                case 5, 6: sz_selector.setItems(FXCollections.observableArrayList(size_selector.getValue().getS1(), size_selector.getValue().getS2(), size_selector.getValue().getS3(), size_selector.getValue().getS4(),
                        size_selector.getValue().getS5(), size_selector.getValue().getS6(), size_selector.getValue().getS7()));
                break;
            }
        }
    }
}
