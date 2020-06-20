package sample;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.LocalDateStringConverter;

import java.sql.*;
import java.time.LocalDate;

public class Wybierz_pacjenta {
    @FXML TableView<Pacjent> tab2;
    @FXML TableColumn<Pacjent,String> name2;
    @FXML TableColumn <Pacjent,String>surname2;
    @FXML TableColumn <Pacjent,String>pesel3;
    @FXML TextField search;

    @FXML DatePicker date;
    @FXML TableView<Lekarz> tab3;
   public static String pesel_parametr="";
   public  static String nazwisko_lekarza="";
    public void przycisk_szukaj_wybierz_pac(){  tab2.setItems(select_tabela2());
        tab3.getSelectionModel().setCellSelectionEnabled(true);}

    public Object przycisk_wybierz_wybierz_pac(){
        tab2.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = tab2.getSelectionModel().getSelectedCells();
        TablePosition tablePosition = (TablePosition) selectedCells.get(0);
        Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
        pesel_parametr=val.toString();
        System.out.println("Selected Value " + val);
        Main.wybierz_wybor_lekarza();
        return  val;
    }

    public  ObservableList<Pacjent> select_tabela2(){
        String search2=search.getText();
        String name="";
        String surname="";
        String pesel="";
        int rok=0;
        String adres="";
        String miasto="";
        ObservableList<Pacjent> ob= FXCollections.observableArrayList();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT imie,nazwisko,adres,miasto,rok,pesel FROM pacjenci where pesel like '"+search2+"%'");
            while(rs.next()){
                name = rs.getString("imie");
                surname=rs.getString("nazwisko");
                pesel=rs.getString("pesel");
                ob.add(new Pacjent(name,surname,adres,miasto,rok,pesel));
            }
            rs.close();
            System.out.println("Statement executed values "+name+" "+surname+" "+pesel);
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }
        return ob;
    }

    public void selekt_tabela3 (){tab3.setItems(Selekty.select_tabela3());}

    public String wybierz_lekarza(){
        ObservableList selectedCells = tab3.getSelectionModel().getSelectedCells();
        TablePosition tablePosition = (TablePosition) selectedCells.get(0);
        Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
        nazwisko_lekarza=val.toString();
        System.out.println("Selected Value " + val);
        return nazwisko_lekarza;
    }

    public int selekt_lekarz(){
        System.out.println(nazwisko_lekarza);
        return Selekty.select_id_lek(wybierz_lekarza());
    }

    public void przycisk_ustal_date_wybierz_pacjenta(){
        LocalDate data = date.getValue();
        System.out.println(data);
        System.out.println(pesel_parametr);
        selekt_lekarz();
        Inserty.insert_date(data,Selekty.select_id(pesel_parametr),selekt_lekarz());
    }
}
