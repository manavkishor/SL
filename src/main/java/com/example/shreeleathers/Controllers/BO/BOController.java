package com.example.shreeleathers.Controllers.BO;

import com.example.shreeleathers.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BOController implements Initializable
{
    public BorderPane BOParent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Model.getInstance().getViewFactory().getBoSelectedMenuItem().addListener(((observable, oldVal, newVal) ->
        {
            switch(newVal)
            {
                case ENTRY -> BOParent.setCenter(Model.getInstance().getViewFactory().getEntryView());
                case MODIFICATION -> BOParent.setCenter(Model.getInstance().getViewFactory().getModificationView());
                case FINANCIALREPORT -> BOParent.setCenter(Model.getInstance().getViewFactory().getFinancialReportView());
                case INVENTORYREPORT -> BOParent.setCenter(Model.getInstance().getViewFactory().getInventoryReportView());
                case HOUSEKEEPING -> BOParent.setCenter(Model.getInstance().getViewFactory().getHouseKeepingView());
                default -> BOParent.setCenter(Model.getInstance().getViewFactory().getMasterView());
            }
        }));
    }
}
