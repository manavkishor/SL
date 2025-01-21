package com.example.shreeleathers.Controllers.BO.InventoryReport;

import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Model;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryReportController implements Initializable {
    public Text branch_name_lbl;
    public Label add_line1_lbl;
    public Label add_line2_lbl;
    public Text sale_menu_lbl;
    public Text purchase_menu_lbl;
    public Text order_to_company_lbl;
    public Text physical_stock_lbl;
    public Text company_complain_menu_lbl;
    public Text stock_transfer_lbl;
    public Text scheme_report_lbl;
    public Text sale_return_menu_lbl;
    public Text purchase_return_menu_lbl;
    public Text repair_menu_lbl;
    public Text comparative_statement_lbl;
    public Text stock_adjustment_lbl;
    public Text debit_note_lbl;
    public Text exchange_menu_lbl;
    public Text stock_menu_lbl;

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
