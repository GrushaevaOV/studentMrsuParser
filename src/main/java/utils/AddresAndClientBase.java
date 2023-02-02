package utils;

import object.Addres;
import object.Client;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AddresAndClientBase {

    public static List<Addres> listAdress = new ArrayList<>();

    public static List<Client> listClient = new ArrayList<>();

    public static void printListAddresBook() {
        for (Addres book : listAdress) {
            System.out.println(book.toStringAddress());
        }
    }

     public static  void printListClientBook() {
        for (Client client : listClient) {
            System.out.println(client.toString());
        }
    }

    public static void listPeopleOnFlatnumber() {
        for (int i = 0; i < listClient.size(); i++) {
            for (int j = i + 1; j < listClient.size(); j++) {
                Client person = listClient.get(i);
                Client human = listClient.get(j);
                if (person.address == human.address) {
                    System.out.println();
                    System.out.println(person.toStringAddres());
                    System.out.println(person.toStringName());
                    System.out.println(human.toStringName());
                }
            }
        }
    }

    public static void numberPeopleOnFloor() {
        HashMap<Integer, Integer> number = new HashMap<>();
        for (Client human : listClient) {
            if (!number.containsKey(human.address.getFloor())) {
                number.put(human.address.getFloor(), 1);
            } else {
                number.put(human.address.getFloor(), number.get(human.address.getFloor()) + 1);
            }
        }
        System.out.println(number);
    }

}

