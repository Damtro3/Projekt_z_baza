package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.print.DocFlavor;

public  class Pacjent {
      SimpleStringProperty firstName;
      SimpleStringProperty lastName;
      SimpleStringProperty pesel;
      SimpleIntegerProperty rok;
      SimpleStringProperty adres;
      SimpleStringProperty miasto;


    public Pacjent(String firstName, String lastName,String adres,String miasto,int rok,String pesel) {

        this.firstName = new SimpleStringProperty(firstName);
        this.lastName =new SimpleStringProperty(lastName);
        this.adres=new SimpleStringProperty(adres);
        this.miasto=new SimpleStringProperty(miasto);
        this.rok=new SimpleIntegerProperty(rok);
        this.pesel=new SimpleStringProperty(pesel);
    }

    public String getname() {
        return firstName.get();
    }
    public void setname(String firstName) {
        this.firstName.set(firstName);
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }


    public String getlastName() {
        return lastName.getValue();
    }
    public void setlastName(String lastName) {
        this.lastName.set(lastName);
    }
    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public SimpleStringProperty peselProperty() {
        return pesel;
    }

    public SimpleIntegerProperty rokProperty() {
        return rok;
    }

    public SimpleStringProperty adresProperty() {
        return adres;
    }

    public SimpleStringProperty miastoProperty() {
        return miasto;
    }


}
