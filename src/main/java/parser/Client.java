package parser;

import parser.Addres;

public class Client {
    public int id;              // идентификатор
    public String name;            // ФИО
    public String personnelNumber; // персональный номер
    public Addres address;         // адрес проживания

    public Client (int id, String name, String personnelNumber, Addres address ){
        this.id=id;
        this.name=name;
        this.personnelNumber=personnelNumber;
        this.address=address;
    }

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    void setPersonnelNumber(String personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    void setAddress(Addres address) {
        this.address = address;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getPersonnelNumber() {
        return personnelNumber;
    }

    Addres getAddress() {
        return address;
    }

    String toS () {
        return id + name + personnelNumber + address;
    }


}
