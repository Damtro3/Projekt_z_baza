package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.*;

public  class Selekty {

    public static String select_log(){
        String lek_login="";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT lek_login FROM lekarze");
            while(rs.next()){
                lek_login = rs.getString("lek_login");
                System.out.print(", First: " + lek_login);

            }
            rs.close();

            System.out.println("Statement executed");
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }
        return lek_login;
    }

    public static String select_pass(){
        String lek_password="";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT lek_password FROM lekarze");
            while(rs.next()){
                lek_password = rs.getString("lek_password");
                System.out.println(", Last: " + lek_password);
            }
            rs.close();

            System.out.println("Statement executed");
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }
        return lek_password;
    }

    public static int select_id_lek(String value1){
        int id=0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM lekarze where nazwisko ="+"'"+value1+"'");
            while(rs.next()){
                id = rs.getInt("id");
                System.out.println(", Last: " + id);
            }
            rs.close();

            System.out.println("Statement executed value id: "+id);
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }
        return id;
    }
    public static int select_id(String pesel){
        int id=0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM pacjenci where pesel="+pesel);
            while(rs.next()){
                id = rs.getInt("id");
                System.out.println(", Id"+": " + id);
            }
            rs.close();

            System.out.println("Statement executed");
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }
        return id;
    }

    public static  ObservableList<Pacjent> select_tabela(){
        String name="";
        String surname="";
        String pesel;
        int rok=0;
        String adres="";
        String miasto="";
        ObservableList<Pacjent> ob= FXCollections.observableArrayList();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT imie,nazwisko,adres,miasto,rok,pesel FROM pacjenci");
            while(rs.next()){
                name = rs.getString("imie");
                surname=rs.getString("nazwisko");
                pesel=rs.getString("pesel");
                rok=rs.getInt("rok");
                adres=rs.getString("adres");
                miasto=rs.getString("miasto");

                ob.add(new Pacjent(name,surname,adres,miasto,rok,pesel));
            }
            rs.close();

            System.out.println("Statement executed");
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }
        return ob;
    }

    public static  ObservableList<Lekarz> select_tabela3(){

        String name="";
        String surname="";
        String specjalizacja;
        ObservableList<Lekarz> lek= FXCollections.observableArrayList();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT imie, nazwisko, specjalizacja from lekarze as l inner join specjalizacje as s on l.id=s.lekid");
            while(rs.next()){
                name = rs.getString("imie");
                surname=rs.getString("nazwisko");
                specjalizacja=rs.getString("specjalizacja");
                lek.add(new Lekarz(name,surname,specjalizacja));
            }
            rs.close();
            System.out.println("Statement executed");
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }
        return lek;
    }

}
