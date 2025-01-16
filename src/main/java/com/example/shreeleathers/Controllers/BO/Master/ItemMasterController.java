package com.example.shreeleathers.Controllers.BO.Master;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemMasterController implements Initializable
{
    public TableView item_master_tbl;
    public TableColumn item_code_column;
    public TableColumn cat_id_column;
    public TableColumn category_column;
    public TableColumn item_name_column;
    public TableColumn hsn_code_column;
    public TableColumn colour_column;
    public TableColumn size_column;
    public TableColumn size_id_column;
    public TableColumn pur_rate_column;
    public TableColumn gst_pur_column;
    public TableColumn sale_rate_column;
    public TableColumn gst_rate_column;
    public TableColumn disc_per_column;
    public TableColumn status_column;
    public TableColumn min_stock_column;
    public TextField item_code_txt;
    public TextField cat_id_txt;
    public TextField cat_name_txt;
    public TextField item_name_txt;
    public TextField hsn_code_txt;
    public TextField colour_txt;
    public TextField size_id_txt;
    public TextField size_txt;
    public TextField pur_rate_txt;
    public TextField pur_gst_txt;
    public TextField sale_rate_txt;
    public TextField sale_gst_txt;
    public TextField disc_per_txt;
    public TextField min_stock_txt;
    public Button create_item_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
