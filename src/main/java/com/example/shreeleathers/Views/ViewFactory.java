package com.example.shreeleathers.Views;

import com.example.shreeleathers.Controllers.POS.POSController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewFactory
{
private AccountType loginAccountType;

    //POS View
    private final ObjectProperty<POSMenuOptions> posSelectedMenuItem;
    private AnchorPane saleView;

    //BO View


    public ViewFactory()
    {
        this.loginAccountType = AccountType.POS;
        this.posSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType()
    {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType)
    {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty<POSMenuOptions> getPosSelectedMenuItem()
    {
        return posSelectedMenuItem;
    }

    /*
    * POS Views
    * */

    public AnchorPane getSaleView()
    {
        if(saleView == null)
        {
            try
            {
                saleView = new FXMLLoader(getClass().getResource("/Fxml/POS/Sale.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return saleView;
    }


    public void showPOSWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/POS/POS.fxml"));
        POSController posController = new POSController();
        loader.setController(posController);
        createStage(loader);
    }

    /*
    *  BO Views
    * */



    /*
    *  Other Views
    * */

    public void showLoginWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    public void showCheckoutWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/POS/Checkout.fxml"));
        createPopupStage(loader, "Checkout");
    }

    private void createPopupStage(FXMLLoader loader, String title)
    {
        Scene scene = null;
        try
        {
            scene = new Scene(loader.load());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/SL_logo.png"))));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.show();
    }

    private void createStage(FXMLLoader loader)
    {
        Scene scene = null;
        try
        {
            scene = new Scene(loader.load());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/SL_logo.png"))));
        stage.setResizable(false);
        stage.setTitle("Shreeleathers");
        stage.show();
    }

    public void closeStage(Stage stage)
    {
        stage.close();
    }
}
