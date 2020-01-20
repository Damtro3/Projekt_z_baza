
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


import java.sql.*;
public class Zapisz_edycje_pacjenta {
        @FXML
        javafx.scene.control.Button zatwierdz;
        @FXML
        javafx.scene.control.Button anuluj3;
        @FXML
        javafx.scene.control.TextField id_do_edycji;
        @FXML
        javafx.scene.control.Label peselnotfound;
        @FXML
        javafx.scene.control.TextField name;
        @FXML
        javafx.scene.control.TextField surname;
        @FXML
        javafx.scene.control.TextField adress;
        @FXML
        javafx.scene.control.TextField city;
        @FXML
        javafx.scene.control.TextField year;
        @FXML
        javafx.scene.control.TextField pesel;
        @FXML
        Button save;

        String a;
        public String zwroc_pesel ()
        {
            String ret_pesel="00000000000";
            String where=id_do_edycji.getText();

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
        public  void przycisk_anuluj_zapisz_edycje_pacjenta()
        {
            Main.anul_zapisz_edyt_pac();
        }
        public void przycisk_zatwierdz_zapisz_edycje_pacjenta()
        {
            String pes=zwroc_pesel();
            if(id_do_edycji.getText().equals(pes)==true)
            {
                name.setVisible(true);
                surname.setVisible(true);
                adress.setVisible(true);
                year.setVisible(true);
                city.setVisible(true);
                pesel.setVisible(true);
                save.setVisible(true);
                peselnotfound.setVisible(false);

            }
            else
            {
                pesel_nie_istnieje();
            }
        }
        public void pesel_nie_istnieje()
        {
            peselnotfound.setVisible(true);
            name.setVisible(false);
            surname.setVisible(false);
            adress.setVisible(false);
            year.setVisible(false);
            city.setVisible(false);
            pesel.setVisible(false);
            save.setVisible(false);
        }

        public void przycisk_zapisz_zapisz_edycje_pacjenta()
        {
            a=id_do_edycji.getText();
            try {
                Connector conn = Connector.getInstance();
                if(a.equals("")==false)
                {
                    if (name.getText().equals("") == false)
                    {
                        conn.update("update pacjenci set imie=" + "'" + name.getText() + "'" + " " + " where pesel=" + "'" + a + "'");
                        System.out.println("Statement executed");
                    }
                    if (surname.getText().equals("") == false)
                    {
                        conn.update("update pacjenci set nazwisko=" + "'" + surname.getText() + "'" + " " + " where pesel=" + "'" + a + "'");
                        System.out.println("Statement executed");
                    }
                    if (adress.getText().equals("") == false)
                    {
                        conn.update("update pacjenci set adres=" + "'" + adress.getText() + "'" + " " + " where pesel=" + "'" + a + "'");
                        System.out.println("Statement executed");
                    }
                    if (city.getText().equals("") == false)
                    {
                        conn.update("update pacjenci set miasto=" + "'" + city.getText() + "'" + " " + " where pesel=" + "'" + a + "'");
                        System.out.println("Statement executed");
                    }
                    if (year.getText().equals("") == false)
                    {
                        conn.update("update pacjenci set rok=" + "'" + year.getText() + "'" + " " + " where pesel=" + "'" + a + "'");
                        System.out.println("Statement executed");
                    }
                    if (pesel.getText().equals("") == false)
                    {
                        conn.update("update pacjenci set pesel=" + "'" + pesel.getText() + "'" + " " + " where pesel=" + "'" + a + "'");
                        System.out.println("Statement executed");
                    }

                    else {
                        System.out.println("Błąd");
                    }
                }
            } catch(SQLException exc) {
                System.out.println("Nieudane połączenie z " );
                System.out.println(exc);
                System.exit(1);
            }

        }





}
