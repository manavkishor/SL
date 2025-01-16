package com.example.shreeleathers.Controllers.BO.Master;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SalesmanMasterController implements Initializable
{
    public TableView salesman_master_tbl;
    public TableColumn salesman_code_column;
    public TableColumn salesman_name_column;
    public TableColumn is_active_column;
    public TextField salesman_code_txt;
    public TextField salesman_name_txt;
    public Button create_new_salesman_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
