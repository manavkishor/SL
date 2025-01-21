package com.example.shreeleathers.Controllers.BO.Modification;

import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Model;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ModificationController implements Initializable {
    public Text branch_name_lbl;
    public Label add_line1_lbl;
    public Label add_line2_lbl;
    public Text sale_invoice_lbl;
    public Text purchase_invoice_lbl;
    public Text physical_stock_lbl;
    public Text sale_return_lbl;
    public Text physical_cash_coin_lbl;
    public Text stock_transfer_lbl;
    public Text purchase_return_lbl;
    public Text quot_perfo_lbl;
    public Text debit_note_lbl;
    public Text cash_voucher_lbl;
    public Text journal_voucher_lbl;
    public Text exchange_item_lbl;
    public Text order_lbl;

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
