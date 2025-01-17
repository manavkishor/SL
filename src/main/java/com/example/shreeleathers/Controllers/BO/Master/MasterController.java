package com.example.shreeleathers.Controllers.BO.Master;

import com.example.shreeleathers.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MasterController implements Initializable
{
    public Text branch_name_lbl;
    public Label add_line1_lbl;
    public Label add_line2_lbl;
    public Text item_master_lbl;
    public Text accounts_master_lbl;
    public Text category_master_lbl;
    public Text salesman_master_lbl;
    public Text color_master_lbl;
    public Text size_master_lbl;
    public Text state_code_lbl;
    public Text set_comm_lbl;
    public Text order_level_lbl;
    public Text update_hsn_lbl;
    public Text sale_bill_terms_lbl;
    public Text sale_item_dead_item_lbl;
    public Text current_mrp_stock_lbl;
    public Text offer_master_lbl;
    public Text item_name_master_lbl;
    public Text firm_master_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        state_code_lbl.setOnMouseClicked(mouseEvent -> onStateCode());
        accounts_master_lbl.setOnMouseClicked(mouseEvent -> onAccountsMaster());
        category_master_lbl.setOnMouseClicked(mouseEvent -> onCategoryMaster());
        color_master_lbl.setOnMouseClicked(mouseEvent -> onColourMaster());
        firm_master_lbl.setOnMouseClicked(mouseEvent -> onFirmMaster());
        item_master_lbl.setOnMouseClicked(mouseEvent -> onItemMaster());
    }

    private void onStateCode()
    {
        Model.getInstance().getViewFactory().getStateCodeWindow();
    }

    private void onAccountsMaster()
    {
        Model.getInstance().getViewFactory().getAccountMasterWindow();
    }

    private void onCategoryMaster()
    {
        Model.getInstance().getViewFactory().getCategoryMasterWindow();
    }

    private void onColourMaster()
    {
        Model.getInstance().getViewFactory().getColourMasterWindow();
    }

    private void onFirmMaster()
    {
        Model.getInstance().getViewFactory().getFirmMasterWindow();
    }

    private void onItemMaster()
    {
        Model.getInstance().getViewFactory().getItemMasterWindow();
    }
}
