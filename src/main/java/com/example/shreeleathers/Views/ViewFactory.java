package com.example.shreeleathers.Views;

import com.example.shreeleathers.Controllers.BO.BOController;
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
    private AnchorPane saleReturnView;
    private AnchorPane exchangeView;

    //BO View

    private final ObjectProperty<BOMenuOptions> boSelectedMenuItem;
    private AnchorPane masterView;
    private AnchorPane entryView;
    private AnchorPane modificationView;
    private AnchorPane financialReportView;
    private AnchorPane inventoryReportView;
    private AnchorPane houseKeepingView;


    public ViewFactory()
    {
        this.loginAccountType = AccountType.POS;
        this.posSelectedMenuItem = new SimpleObjectProperty<>();
        this.boSelectedMenuItem = new SimpleObjectProperty<>();
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
    public ObjectProperty<BOMenuOptions> getBoSelectedMenuItem() {return boSelectedMenuItem;}

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

    public void showCheckoutWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/POS/Checkout.fxml"));
        createPopupStage(loader, "Checkout");
    }

    public AnchorPane getSaleReturnView()
    {
        if(saleReturnView == null)
        {
            try
            {
                saleReturnView = new FXMLLoader(getClass().getResource("/Fxml/POS/SaleReturn.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return saleReturnView;
    }

    public AnchorPane getExchangeView()
    {
        if(exchangeView == null)
        {
            try
            {
                exchangeView = new FXMLLoader(getClass().getResource("/Fxml/POS/Exchange.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return exchangeView;
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

    public AnchorPane getMasterView()
    {
        if(masterView == null)
        {
            try
            {
                masterView = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/Master.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return masterView;
    }

    public AnchorPane getEntryView()
    {
        if(entryView == null)
        {
            try
            {
                entryView = new FXMLLoader(getClass().getResource("/Fxml/BO/Entry/Entry.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return entryView;
    }

    public AnchorPane getModificationView()
    {
        if(modificationView == null)
        {
            try
            {
                modificationView = new FXMLLoader(getClass().getResource("/Fxml/BO/Modification/Modification.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return modificationView;
    }


    public AnchorPane getFinancialReportView()
    {
        if(financialReportView == null)
        {
            try
            {
                financialReportView = new FXMLLoader(getClass().getResource("/Fxml/BO/Financial Report/FinancialReport.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return financialReportView;
    }


    public AnchorPane getInventoryReportView()
    {
        if(inventoryReportView == null)
        {
            try
            {
                inventoryReportView = new FXMLLoader(getClass().getResource("/Fxml/BO/Inventory Report/InventoryReport.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return inventoryReportView;
    }

    public AnchorPane getHouseKeepingView()
    {
        if(houseKeepingView == null)
        {
            try
            {
                houseKeepingView = new FXMLLoader(getClass().getResource("/Fxml/BO/HouseKeeping/HouseKeeping.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return houseKeepingView;
    }

    public void getStateCodeWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/StateCodeMaster.fxml"));
        createPopupStage(loader, "State Code Master");
    }

    public void getAccountMasterWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/AccountsMaster.fxml"));
        createPopupStage(loader, "Accounts Master");
    }

    public void getCategoryMasterWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/CategoryMaster.fxml"));
        createPopupStage(loader, "Category Master");
    }

    public void getColourMasterWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/ColourMaster.fxml"));
        createPopupStage(loader, "Colour Master");
    }

    public void getFirmMasterWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/FirmMaster.fxml"));
        createPopupStage(loader, "Firm Master");
    }

    public void getItemMasterWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/ItemMaster.fxml"));
        createPopupStage(loader, "Item Master");
    }

    public void getSalesmanMasterWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/SalesmanMaster.fxml"));
        createPopupStage(loader, "Salesman Master");
    }

    public void getSizeMasterWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/SizeMaster.fxml"));
        createPopupStage(loader, "Size Master");
    }

    public void getAmericanSizeWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/AmericanSize.fxml"));
        createPopupStage(loader, "American Size");
    }

    public void getTermsWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/Master/TermsMaster.fxml"));
        createPopupStage(loader, "Terms & Condition");
    }

    public void showBOWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/BO/BO.fxml"));
        BOController boController = new BOController();
        loader.setController(boController);
        createStage(loader);
    }

    /*
    *  Other Views
    * */

    public void showLoginWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
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
}
