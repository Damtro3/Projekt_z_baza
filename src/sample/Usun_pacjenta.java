package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;

public class Usun_pacjenta {
    @FXML
    TextField delete_field;
    String a;
    public String zwroc_pesel ()
    {
        String ret_pesel="00000000000";
        String where=delete_field.getText();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pesel FROM pacjenci where pesel= "+"'"+where+"'");
            while(rs.next())
            {
                ret_pesel= rs.getString("pesel");
            }
            rs.close();
            System.out.println(", pesel"+": " + ret_pesel);
            System.out.println("Statement executed");
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }
        a=ret_pesel;
        return ret_pesel;
    }
    public  void przycisk_usun_usun_pacjenta()
    {
        if(delete_field.getText().equals(zwroc_pesel())==true) {
            Delete.usun(delete_field.getText());
        }
        else
        {
            System.out.println("Brak peselu w bazie");
        }
    }
    public void przycisk_anuluj_usun_pacjenta()
    {
        Main.anul_usu_pac();
    }
}
