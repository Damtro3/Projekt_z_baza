package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Zarz_pacjentami {

    @FXML  TableColumn<Pacjent,String> c1;
    @FXML  TableColumn <Pacjent,String>c2;
    @FXML  TableColumn <Pacjent,String>c3;
    @FXML  TableColumn <Pacjent,String>c4;
    @FXML  TableColumn <Pacjent,Integer>c5;
    @FXML  TableColumn <Pacjent,String>c6;
    @FXML  TableView<Pacjent> tab;
  static   boolean flgstatus=false;
    public void przycisk_usuwanie_pacjenta_zarzadzaj_pacjentem()
    {
        Main.usun_zarz_pac();
    }
    public  void load_zarzadzaj_pacjentem(Event event)
    {
        tab.setItems(Selekty.select_tabela());
    }
    public void przycisk_dodaj_zarzadzaj_pacjentem()
    {
        Main.dodaj_zarz_pac();
    }

    public void przycisk_edytuj_zarzadzaj_pacjentem()
    {
        Main.edyt_zarz_pac();
    }

    public  void przycisk_umow_wizyte_zarzadzaj_pacjentem(){Main.umow_zarz_pac(); flgstatus=true; }
}
