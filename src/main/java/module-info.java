module com.example.shreeleathers {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires de.jensd.fx.glyphs.fontawesome;
    requires mysql.connector.j;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql;
    requires java.desktop;


    opens com.example.shreeleathers to javafx.fxml;
    exports com.example.shreeleathers.Controllers;
    exports com.example.shreeleathers.Controllers.POS;
    exports com.example.shreeleathers.Controllers.BO;
    exports com.example.shreeleathers.Models;
    exports com.example.shreeleathers.Views;
    exports com.example.shreeleathers;
}