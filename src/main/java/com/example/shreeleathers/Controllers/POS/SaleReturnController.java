package com.example.shreeleathers.Controllers.POS;

import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Model;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SaleReturnController implements Initializable
{
    public Text branch_name_lbl;
    public Label add_line1_lbl;
    public Label add_line2_lbl;
    public TextField old_invoice_txt;
    public Text sr_invoice_lbl;
    public Label date_lbl;
    public DatePicker bill_date_datepicker;
    public Text customer_name_lbl;
    public Text customer_contact_lbl;
    public Text upi_lbl;
    public Text card_lbl;
    public Text cash_lbl;
    public Text amount_paid_lbl;
    public ListView return_item_listview;
    public Button return_btn;
    public Button hold_btn;
    public Button save_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<Firm> fm = Model.getInstance().getDatabaseDriver().getFirm();
        String bn = fm.getFirst().getCity();
        String a1 = fm.getFirst().getAdd1();
        String a2 = fm.getFirst().getAdd2();
        branch_name_lbl.setText(bn);
        add_line1_lbl.setText(a1);
        add_line2_lbl.setText(a2);
    }
}
