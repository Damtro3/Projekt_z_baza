package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Dodaj_pacjenta {

    @FXML TextField name;
    @FXML TextField surname;
    @FXML TextField adress;
    @FXML TextField city;
    @FXML TextField year;
    @FXML TextField pesel;
    @FXML Label za_dlugi;
    @FXML Label bledny_rok;
    public void przycisk_zapisz_dodaj_pacjenta()
    {

        String v1,v2,v3,v4,v6;
        int v5=0;
       long zakres1,zakres2;
        v1=name.getText();
        v2=surname.getText();
        v3=adress.getText();
        v4=city.getText();
        v6=pesel.getText();
        zakres1=Long.parseLong(v6);
        if(year.getText().equals(""))
        {
            year.setText("0000");
        }
        else
        {
            v5=Integer.parseInt(year.getText());
            if( v5>=1900 && v5<=2020)
            {
                System.out.println(wstaw_rok());
                if(v6.length()==11 && zakres1>100000000 && v6.charAt(0)==wstaw_rok().charAt(0)&&v6.charAt(2)==wstaw_rok().charAt(3)) {
                    Inserty.insert(v1, v2, v3, v4, v5, v6);
                }
                else{
                    za_długi_za_krotki();
                }
            }else{zly_rok(); }
        }

    }
    public void przycisk_wyczysc_dodaj_pacjenta()
    {
        name.clear();
        surname.clear();
        adress.clear();
        city.clear();
        year.clear();
        pesel.clear();
        za_dlugi.setVisible(false);
        bledny_rok.setVisible(false);
    }
    public void przycisk_anuluj_dodaj_pacjenta()
    {
        Main.anul_dod_pac();
    }
    public void za_długi_za_krotki()
    {
        za_dlugi.setVisible(true);
    }
    public void zly_rok()
    {
        bledny_rok.setVisible(true);
    }
    public String wstaw_rok()
    {
        String tmp2=year.getText();
    return tmp2;
    }
}
