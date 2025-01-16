package com.example.shreeleathers.Controllers.BO.Master;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TermsMasterController implements Initializable
{
    public TableView terms_condition_tbl;
    public TableColumn sl_no_column;
    public TableColumn terms_column;
    public TableColumn status_column;
    public TextField terms_txt;
    public Button add_new_term_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
