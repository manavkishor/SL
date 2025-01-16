package com.example.shreeleathers.Controllers.BO.Master;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemNameMasterController implements Initializable
{
    public TableView item_name_master_tbl;
    public TableColumn category_id_column;
    public TableColumn item_name_column;
    public TableColumn size_id_column;
    public TableColumn size_from_column;
    public TableColumn size_upto_column;
    public TextField item_name_txt;
    public ChoiceBox category_selector;
    public ChoiceBox size_selector;
    public Button new_item_name_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
