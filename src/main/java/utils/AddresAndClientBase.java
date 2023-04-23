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

    public static HashMap<Integer, Integer> number = new HashMap<>();
    public static List<Client> listPeopleOnFlatnumber = new ArrayList<>();


    public static void printListAddresBook() {
        for (Addres book : listAdress) {
            System.out.println(book.toStringAddress());
        }
    }

    public static void printListClientBook() {
        for (Client client : listClient) {
            System.out.println(client.toString());
        }
    }


}

