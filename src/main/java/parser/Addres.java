package parser;

public class Addres {
    int id;           // идентификатор
    String city;         // город
    String street;       // улица
    int house;        // дом
    int floor;        // этаж
    int flatNumber;   // квартира

    public Addres() {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
        this.flatNumber = flatNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public int getFloor() {
        return floor;
    }

    public int gF(int floor) throws FloorException {
        if (floor < 1) throw new FloorException("The number is less than 1", floor);

        return floor;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    String toAddress() {
        return id + " " + city + " " + street + " " + house + " " + floor + " " + flatNumber;
    }

    void prin() {
        System.out.println(toAddress());
    }


}

class FloorException extends Exception {
    int floor;

    public int getFloor() {
        return floor;
    }

    public FloorException(String message, int flo) {

        super(message);
        floor = flo;
    }
}


