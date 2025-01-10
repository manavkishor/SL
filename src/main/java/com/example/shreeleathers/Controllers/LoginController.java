package com.example.shreeleathers.Controllers;

import com.example.shreeleathers.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.net.URL;

import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    public TextField user_txt;
    public PasswordField password_txt;
    public Button login_btn;
    public Label error_lbl;
    public ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        login_btn.setOnAction(event -> onLogin());
    }

    private void onLogin()
    {
        Model.getInstance().getDatabaseDriver().startConnection();
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().validateCred(user_txt.getText(), password_txt.getText());
        if(Model.getInstance().getPOSLoginSuccessFlag())
        {
            Model.getInstance().getViewFactory().showPOSWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        }
        else if (Model.getInstance().getBOLoginSuccessFlag())
        {
            //Model.getInstance().getViewFactory().showBOWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        }
        else
        {
            user_txt.setText("");
            password_txt.setText("");
            error_lbl.setText("Invalid Credentials!!!!");
        }
    }
}
