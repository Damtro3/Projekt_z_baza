package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {
    static Pane stpane=new Pane();
    static  Pane root, zarz,dodaj,usun, zapisz_edyt,wybierz,lekarz;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stpane.setId("0");
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        zarz = FXMLLoader.load(getClass().getResource("zarz_pacjentami.fxml"));
        dodaj = FXMLLoader.load(getClass().getResource("dodaj_pacjenta.fxml"));
        usun = FXMLLoader.load(getClass().getResource("usun_pacjenta.fxml"));
        zapisz_edyt = FXMLLoader.load(getClass().getResource("zapisz_edycje_pacjenta.fxml"));
        wybierz = FXMLLoader.load(getClass().getResource("wybierz_pac.fxml"));
        lekarz = FXMLLoader.load(getClass().getResource("wybor_lekarza.fxml"));
        stpane.getChildren().add(root);
        primaryStage.setTitle("Przychodnia");

        stpane.getStylesheets().add(getClass().getResource("csesy.css").toExternalForm());
        primaryStage.setScene(new Scene(stpane, 600, 475));
        primaryStage.show();


    }
    static void wybierz_wybor_lekarza()
    {
        stpane.getChildren().remove(wybierz);
        stpane.getChildren().add(lekarz);
    }
    static void Nextpage()
    {
        stpane.getChildren().remove(root);
        stpane.getChildren().add(zarz);
    }
    static void dodaj_zarz_pac()
    {
        stpane.getChildren().remove(zarz);
        stpane.getChildren().add(dodaj);
    }
    static void usun_zarz_pac()
    {
        stpane.getChildren().remove(zarz);
        stpane.getChildren().add(usun);
    }
    static void anul_dod_pac()
    {
        stpane.getChildren().remove(dodaj);
        stpane.getChildren().add(zarz);
    }
    static void anul_usu_pac()
    {
        stpane.getChildren().remove(usun);
        stpane.getChildren().add(zarz);
    }
    static void edyt_zarz_pac()
    {
        stpane.getChildren().remove(zarz);
        stpane.getChildren().add(zapisz_edyt);
    }
    static void anul_zapisz_edyt_pac()
    {
        stpane.getChildren().remove(zapisz_edyt);
        stpane.getChildren().add(zarz);
    }
    static void umow_zarz_pac()
    {
        stpane.getChildren().remove(zarz);
        stpane.getChildren().add(wybierz);
    }
    //comita
    public static void main(String[] args) {
        launch(args);
        }
}
