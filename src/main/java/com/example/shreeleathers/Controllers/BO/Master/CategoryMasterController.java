package com.example.shreeleathers.Controllers.BO.Master;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryMasterController implements Initializable
{
    public TableView category_master_tbl;
    public TableColumn category_name_column;
    public TableColumn gst_column;
    public TableColumn hsn_code_column;
    public TextField cat_name_txt;
    public TextField gst_txt;
    public TextField hsn_code_txt;
    public Button create_new_category_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
