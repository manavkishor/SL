package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Master.Category;
import com.example.shreeleathers.Models.Master.Colour;
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

public class ColourMasterController implements Initializable
{
    public TableView<Colour> colour_master_tbl;
    public TableColumn<Colour, Integer> sl_no_column;
    public TableColumn<Colour, String> colour_column;
    public ObservableList<Colour> data;
    public TextField colour_txt;
    public Button create_new_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        colour_master_tbl.setEditable(true);
        colour_column.setCellFactory(TextFieldTableCell.forTableColumn());
        addDataToTable();
        colour_column.setOnEditCommit(event ->
        {
            Colour dt = event.getRowValue();
            dt.setColour(event.getNewValue());
            Model.getInstance().getDatabaseDriver().updateTableColourMaster(dt);
        });
        create_new_btn.setOnAction(event -> onInsert());
    }

    private void addDataToTable()
    {
        data = FXCollections.observableArrayList();
        sl_no_column.setCellValueFactory(cellData -> cellData.getValue().slNoProperty().asObject());
        colour_column.setCellValueFactory(cellData -> cellData.getValue().colourProperty());
        try
        {
            data = Model.getInstance().getDatabaseDriver().getColour();
            colour_master_tbl.setItems(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void onInsert()
    {
        int slNo;
        String colour = colour_txt.getText();
        int id = Model.getInstance().getDatabaseDriver().insertIntoColourMaster(colour);
        Colour newData = new Colour(id, colour);
        data.add(newData);
        colour_txt.setText("");
    }
}
