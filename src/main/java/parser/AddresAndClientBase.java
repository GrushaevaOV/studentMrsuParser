package parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddresAndClientBase {

    static HashMap<Integer, Integer> count = new HashMap<>();

    static List<Addres> listAdress = new ArrayList<>();

    static List<Client> listClient = new ArrayList<>();

    static public void printAddresBook() {
        for (Addres book : listAdress) {
            book.prin();
        }
    }

    static public void printClientBook() {
        for (Client book : listClient) {
            book.pprin();
        }
    }

}

