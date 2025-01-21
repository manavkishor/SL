package com.example.shreeleathers.Controllers.POS;

import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Model;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ExchangeController implements Initializable
{
    public Text branch_name_lbl;
    public Label add_line1_lbl;
    public Label add_line2_lbl;
    public TextField customer_name_txt;
    public TextField customer_contact_txt;
    public Text ex_invoice_lbl;
    public Label date_lbl;
    public TextField gst_number_txt;
    public TextField re_item_code_txt;
    public TextField re_item_name_txt;
    public TextField re_colour_txt;
    public ChoiceBox re_size_selector;
    public TextField re_quantity_txt;
    public TextField re_rate_txt;
    public TextField re_gst_txt;
    public TextField re_salesman_txt;
    public Button return_item_btn;
    public ListView return_item_listview;
    public Button exchange_btn;
    public Button hold_btn;
    public Button save_btn;
    public TextField issued_item_code_txt1;
    public TextField issued_item_name_txt1;
    public TextField issued_colour_txt1;
    public ChoiceBox issued_size_selector1;
    public TextField issued_quantity_txt1;
    public TextField issued_rate_txt1;
    public TextField issued_gst_txt1;
    public TextField issued_salesman_txt1;
    public Button issued_item_btn1;
    public ListView issued_item_listview1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<Firm> fm = Model.getInstance().getDatabaseDriver().getFirm();
        String bn = fm.getFirst().getFirmName();
        String a1 = fm.getFirst().getAdd1();
        String a2 = fm.getFirst().getAdd2();
        branch_name_lbl.setText(bn);
        add_line1_lbl.setText(a1);
        add_line2_lbl.setText(a2);
    }
}
