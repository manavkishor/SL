package com.example.shreeleathers.Controllers.BO.Master;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountsMasterController implements Initializable
{
    public TableView account_master_tbl;
    public TableColumn acc_code_column;
    public TableColumn acc_type_column;
    public TableColumn acc_name_column;
    public TableColumn ph_no_column;
    public TableColumn add_line1_column;
    public TableColumn add_line2_column;
    public TableColumn state_code_column;
    public TableColumn city_column;
    public TableColumn pincode_column;
    public TableColumn gst_no_column;
    public TextField acc_code_txt;
    public TextField acc_name_txt;
    public ChoiceBox acc_type_selector;
    public TextField ph_no_txt;
    public TextField add_line1_txt;
    public TextField add_line2_txt;
    public TextField state_code_txt;
    public TextField city_txt;
    public TextField gst_no_txt;
    public TextField pincode_txt;
    public Button create_account_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
