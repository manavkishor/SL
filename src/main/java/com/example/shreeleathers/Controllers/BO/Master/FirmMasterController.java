package com.example.shreeleathers.Controllers.BO.Master;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FirmMasterController implements Initializable
{
    public TableView firm_master_tbl;
    public TableColumn firm_name_column;
    public TableColumn ph_no_column;
    public TableColumn add1_column;
    public TableColumn add2_column;
    public TableColumn state_code_column;
    public TableColumn city_column;
    public TableColumn pincode_column;
    public TableColumn gst_no_column;
    public TextField firm_name_txt;
    public TextField add1_txt;
    public TextField add2_txt;
    public TextField ph_no_txt;
    public TextField state_code_txt;
    public TextField city_txt;
    public TextField pincode_txt;
    public TextField gst_no_txt;
    public Button create_new_firm_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
