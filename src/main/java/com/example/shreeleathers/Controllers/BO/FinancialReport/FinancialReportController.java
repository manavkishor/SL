package com.example.shreeleathers.Controllers.BO.FinancialReport;

import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Model;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class FinancialReportController implements Initializable {
    public Text branch_name_lbl;
    public Label add_line1_lbl;
    public Label add_line2_lbl;
    public Text cash_book_lbl;
    public Text journal_lbl;
    public Text trial_lbl;
    public Text balance_sheet_lbl;
    public Text gst_sale_register_lbl;
    public Text salesman_performance_lbl;
    public Text date_wise_physical_cash_lbl;
    public Text quot_proforma_bill_lbl;
    public Text sale_mst_rate_lbl;
    public Text age_wise_outstanding_lbl;
    public Text voucher_printing_lbl;
    public Text gstr_hsn_wise_sale_lbl;
    public Text gstr_purchase_detail_lbl;
    public Text exit_lbl;
    public Text profit_loss_lbl;
    public Text ledger_lbl;

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
