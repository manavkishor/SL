package com.example.shreeleathers.Controllers.BO.HouseKeeping;

import com.example.shreeleathers.Models.Master.Firm;
import com.example.shreeleathers.Models.Model;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HouseKeepingController implements Initializable {
    public Text branch_name_lbl;
    public Label add_line1_lbl;
    public Label add_line2_lbl;
    public Text change_switches_lbl;
    public Text indexing_lbl;
    public Text restore_lbl;
    public Text set_fn_key_lbl;
    public Text physical_pack_lbl;
    public Text financial_year_lbl;
    public Text opening_stock_lbl;
    public Text firm_info_lbl;
    public Text patch_menu_lbl;
    public Text opening_financial_lbl;
    public Text day_closing_lbl;
    public Text repair_database_lbl;
    public Text import_export_lbl;
    public Text password_lbl;
    public Text backup_lbl;

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
