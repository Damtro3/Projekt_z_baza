package sample;

import javafx.beans.property.SimpleStringProperty;

public class Lekarz {
    SimpleStringProperty firstNamel;
    SimpleStringProperty lastNamel;
    SimpleStringProperty specjalizacja;
    public Lekarz (String firsNamel, String lastNamel, String specjalizacja){

        this.firstNamel=new SimpleStringProperty(firsNamel);
        this.lastNamel= new SimpleStringProperty(lastNamel);
        this.specjalizacja= new SimpleStringProperty(specjalizacja);
    }

    public SimpleStringProperty firstNamelProperty() {
        return firstNamel;
    }

    public SimpleStringProperty lastNamelProperty() {
        return lastNamel;
    }

    public SimpleStringProperty specjalizacjaProperty() {
        return specjalizacja;
    }
}
