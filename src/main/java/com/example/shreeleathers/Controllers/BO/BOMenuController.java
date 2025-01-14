package com.example.shreeleathers.Controllers.BO;

import com.example.shreeleathers.Models.Model;
import com.example.shreeleathers.Views.BOMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BOMenuController implements Initializable
{
    public Button master_btn;
    public Button entry_btn;
    public Button modify_btn;
    public Button options_btn;
    public Button exit_btn;
    public Button report_bug_btn;
    public Button fin_reports_btn;
    public Button inv_reports_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        addListeners();
    }

    private void addListeners()
    {
        master_btn.setOnAction(event -> onMaster());
        entry_btn.setOnAction(event -> onEntry());
        modify_btn.setOnAction(event -> onModification());
        options_btn.setOnAction(event -> onHouseKeeping());
        fin_reports_btn.setOnAction(event -> onFinancialReport());
        inv_reports_btn.setOnAction(event -> onInventoryReport());
        exit_btn.setOnAction(event -> onExit());
    }

    private void onMaster()
    {
        Model.getInstance().getViewFactory().getBoSelectedMenuItem().set(BOMenuOptions.MASTER);
    }

    private void onEntry()
    {
        Model.getInstance().getViewFactory().getBoSelectedMenuItem().set(BOMenuOptions.ENTRY);
    }

    private void onModification()
    {
        Model.getInstance().getViewFactory().getBoSelectedMenuItem().set(BOMenuOptions.MODIFICATION);
    }

    private void onFinancialReport()
    {
        Model.getInstance().getViewFactory().getBoSelectedMenuItem().set(BOMenuOptions.FINANCIALREPORT);
    }

    private void onInventoryReport()
    {
        Model.getInstance().getViewFactory().getBoSelectedMenuItem().set(BOMenuOptions.INVENTORYREPORT);
    }

    private void onHouseKeeping()
    {
        Model.getInstance().getViewFactory().getBoSelectedMenuItem().set(BOMenuOptions.HOUSEKEEPING);
    }

    private void onExit()
    {
        Stage stage = (Stage) report_bug_btn.getScene().getWindow();
        stage.close();
    }
}
