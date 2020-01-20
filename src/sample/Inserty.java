package sample;

import java.sql.SQLException;

public class Inserty {

    public static void insert( String value1 , String value2,String value3,String value4,int value5,String value6){

        try {
            Connector conn = Connector.getInstance();
            conn.update("insert into pacjenci"+"(pesel,imie,nazwisko,rok,adres,miasto)"+"values ("+"'"+value6+"','"+value1+"','"+value2+"','"+value5+"','"+value3+"','"+value4+"')");
            System.out.println("Statement executed");
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }


    }
}
