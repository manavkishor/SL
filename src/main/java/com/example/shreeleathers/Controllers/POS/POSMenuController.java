package com.example.shreeleathers.Controllers.POS;


import com.example.shreeleathers.Models.Model;
import com.example.shreeleathers.Views.POSMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;

import java.util.ResourceBundle;

public class POSMenuController implements Initializable
{
    public Text user_lbl;
    public Button sale_btn;
    public Button exchange_btn;
    public Button saleReturn_btn;
    public Button cash_bank_btn;
    public Button dayClose_btn;
    public Button report_btn;
    public ImageView imageView;
    public Button sale_details_btn;
    public Button expenses_btn;
    public Button day_sheet_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Model.getInstance().setPosMenuController(this);
        addListeners();
    }

    private void addListeners()
    {
        sale_btn.setOnAction(event -> onSale());
        exchange_btn.setOnAction(event -> onExchange());
        saleReturn_btn.setOnAction(event -> onSaleReturn());
    }

    public void onSale()
    {
        Model.getInstance().getViewFactory().getPosSelectedMenuItem().set(POSMenuOptions.SALE);
    }

    private void onSaleReturn()
    {
        Model.getInstance().getViewFactory().getPosSelectedMenuItem().set(POSMenuOptions.SALERETURN);
    }

    private void onExchange()
    {
        Model.getInstance().getViewFactory().getPosSelectedMenuItem().set(POSMenuOptions.EXCHANGE);
    }
}
