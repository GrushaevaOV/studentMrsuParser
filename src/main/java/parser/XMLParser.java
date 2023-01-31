package parser;

import FloorExeption.ParserException;

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
import java.util.stream.Collectors;

public class XMLParser implements Parser {

    public Map convertFromListInMap(List<Addres> list) {
        return list.stream()
                .collect(Collectors.toMap(Addres::getId, address -> address));
    }

    @Override
    public void parse(File... files) {

//    try/catch обработай ошибки
        try {
            if (files[0].getName().equals("address.xml")) {
                readAddress(files[0]);
                readClient(files[1]);
                throw new ParserException("", 1);
            }
        } catch (NullPointerException | ParserException e) {
            System.out.println("O NO, null");
        }
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
        AddresAndClientBase.listAdress = addressBook;
        return addressBook;
    }


    private void readClient(File file) {
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
        var idAndAddres = (HashMap<Integer, Addres>) convertFromListInMap(readAddress(new File("address.xml")));
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
                        human.setAddress(idAndAddres.get(Integer.parseInt(parser.getAttributeValue(3))));
                        clientBook.add(human);
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        AddresAndClientBase.listClient = clientBook;
    }
}

