package parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLParser implements Parser {
    /*   public Map convertListHash(List list) {
           Map map = new HashMap<>();
           for (Addres addresBook : list) {
               map.put(adres.getId(), adres);
           }
           return map;
       }*/
    static HashMap<Integer, Addres> key = new HashMap<>();

    // HashMap<id, Addres> hashMap
//    hashMap.get(id);
    @Override
    public void parse(File file) {
        List<Addres> re = readAddress(file);
        readClient(file);

    }

    private List<Addres> readAddress(File file) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        List<Addres> addressBook = new ArrayList<>();
        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("address")) {
                        Addres add = new Addres();
                        add.setId(Integer.parseInt(parser.getAttributeValue(0)));
                        add.setCity(parser.getAttributeValue(1));
                        add.setStreet(parser.getAttributeValue(2));
                        add.setHouse(Integer.parseInt(parser.getAttributeValue(3)));
                        add.setFloor(Integer.parseInt(parser.getAttributeValue(4)));
                        add.setFlatNumber(Integer.parseInt(parser.getAttributeValue(5)));
                        addressBook.add(add);
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        for (Addres addres : addressBook) {
            addres.prin();
        }
        return addressBook;
    }

    private List<Client> readClient(File file) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        List<Client> clientBook = new ArrayList<>();
        var re = readAddress(new File("address.xml"));
        for (Addres ad : re) {
            key.put(ad.getId(), ad);
        }
        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("client")) {
                        System.out.println();
                        Client human = new Client();
                        human.setId(Integer.parseInt(parser.getAttributeValue(0)));
                        human.setName(parser.getAttributeValue(1));
                        human.setPersonnelNumber(parser.getAttributeValue(2));
                        human.setAddress(key.get(Integer.parseInt(parser.getAttributeValue(3))));
                        clientBook.add(human);
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        for (Client client : clientBook) {
            client.pprin();
        }
        int count = 0;
        for (Client client : clientBook) {
            if (client.address.getFloor() == 2) {
                count++;
            }
        }
        System.out.println(1 + " Floor: " + count + "human");
        return null;

    }
}
