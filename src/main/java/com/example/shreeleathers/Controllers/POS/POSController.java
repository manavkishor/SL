package com.example.shreeleathers.Controllers.POS;

import com.example.shreeleathers.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class POSController implements Initializable
{
    public BorderPane POSParent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Model.getInstance().getViewFactory().getPosSelectedMenuItem().addListener((((observableValue, oldVal, newVal) ->
        {
            switch(newVal)
            {
                case EXCHANGE -> POSParent.setCenter(Model.getInstance().getViewFactory().getExchangeView());
                case SALERETURN -> POSParent.setCenter(Model.getInstance().getViewFactory().getSaleReturnView());
                default -> POSParent.setCenter(Model.getInstance().getViewFactory().getSaleView());
            }
        })));
    }
}
