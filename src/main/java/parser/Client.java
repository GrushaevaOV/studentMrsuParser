package parser;

import parser.Addres;

public class Client {
    public int id;              // идентификатор
    public String name;            // ФИО
    public String personnelNumber; // персональный номер
    public Addres address;         // адрес проживания

    public Client (){
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
        String string = id +" "+ name +" "+ personnelNumber +" "+ address.getCity()+" "+ address.getStreet()+" "+ address.getHouse()+" "+ address.getFloor()+" "+ address.getFlatNumber();

       return string;
    }

    void pprin () {

        System.out.println(toS());
    }
    String toName () {
        String string = id +" "+ name +" "+ personnelNumber;
        return string;
    }
    void prinName () {

        System.out.println(toName());
    }

    String toAddres () {
        return address.getCity()+" "+ address.getStreet()+" "+ address.getHouse()+" "+ address.getFloor()+" "+ address.getFlatNumber();
    }
    void prinAddres () {

        System.out.println(toAddres());
    }

}
