package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public static String select_nazwisko(){
        String surname="";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nazwisko FROM lekarze");
            while(rs.next()){
                surname = rs.getString("nazwisko");
                System.out.println(", Last: " + surname);
            }
            rs.close();

            System.out.println("Statement executed");
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }
        return surname;
    }
    public static int select_id(){
        int id=0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM pacjenci where id="+id);
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
        int rok;
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
                System.out.println(", Last: " + name);
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
}
