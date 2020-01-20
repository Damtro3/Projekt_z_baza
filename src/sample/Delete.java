package sample;

import java.sql.SQLException;

public class Delete {
    public static void usun( String pesel){

        try {
            Connector conn = Connector.getInstance();
            conn.update("delete from pacjenci where pesel="+"'"+pesel+"'");
            System.out.println("Statement executed");
        } catch(SQLException exc) {
            System.out.println("Nieudane połączenie z " );
            System.out.println(exc);
            System.exit(1);
        }


    }
}
