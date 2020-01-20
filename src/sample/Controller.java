package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

class Connector {
    private Connection connection;
    private static Connector instance;

    private Connector() throws SQLException {
        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverName);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root","");
    }


    public int update(String query) throws SQLException {
        Statement mystmt = connection.createStatement();

        return mystmt.executeUpdate(query);
    }

    public static Connector getInstance() throws SQLException {
        if (instance == null) {
            instance = new Connector();
        }

        return instance;
    }
}

public class Controller  {
    @FXML TextField login;
    @FXML Label niepoprawne;
    @FXML PasswordField haslo;
    @FXML Button zal;
    @FXML Button clear;





   public void _login()
   {
       String lek_login=Selekty.select_log();
       String lek_password=Selekty.select_pass();
       String _login=login.getText();
       String _password=haslo.getText();
       if(_login.equals(lek_login)&&_password.equals(lek_password))
       {
           System.out.println("Zalogowano");
            Main.Nextpage();

       }
       else
       {
           System.out.println("Nie zalogowano");
           System.out.println(_login+" "+lek_login);
           System.out.println(_password+" "+lek_password);
           niepoprawne.setVisible(true);
           niepoprawne.setStyle("-fx-Text-Fill:red");
       }

   }
   public void clear()
   {
       login.clear();
       haslo.clear();
       niepoprawne.setVisible(false);
   }





}
