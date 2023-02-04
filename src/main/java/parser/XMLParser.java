package parser;

import exeption.ParserException;
import object.Addres;
import object.Client;
import org.jetbrains.annotations.NotNull;
import utils.AddresAndClientBase;

import javax.swing.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class XMLParser implements Parser {

    public Map convertFromListInMap(@NotNull List<Addres> list) {
        return list.stream()
                .collect(Collectors.toMap(Addres::getId, address -> address));
    }

    @Override
    public void parse(File... files) {

        try {

            if (!files[0].getName().equals("address.xml")) {
                throw new ParserException("NO ADDRESS");
            } else {
                readAddress(files[0]);
                if (!files[1].getName().equals("client.xml")) {
                    throw new ParserException("NO CLIENT");
                } else {
                    readClient(files[1]);
                }
            }
        } catch (ParserException e) {
            System.out.println("Check name of files");
        }
    }

    private XMLStreamReader xmlRead(File file) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        return parser;
    }

    private void readAddress(File file) {
        XMLStreamReader parser = xmlRead(file);
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
    }

    private List <Client> noDubleLine (List <Client> list) {
        for (int i=0;i<list.size();i++){
           for (int j=i+1;j<list.size();j++) {
               Client person = list.get(i);
               Client human = list.get(j);
               if (person.personnelNumber.equals(human.personnelNumber)) {
                   list.remove(human);
               }
           }
       }
        return list;
    }

    private void readClient(File file) {
        XMLStreamReader parser = xmlRead(file);
        List<Client> clientBook = new ArrayList<>();
        Map<Integer, Addres> addressMap = convertFromListInMap(AddresAndClientBase.listAdress);
        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("client")) {
                        System.out.println();
                        Client human = Client.newBuilder()
                                .setId(Integer.parseInt(parser.getAttributeValue(0)))
                                .setName(parser.getAttributeValue(1))
                                .setPersonnelNumber(parser.getAttributeValue(2))
                                .setAddress(addressMap.get(Integer.parseInt(parser.getAttributeValue(3)))).build();
                        clientBook.add(human);
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        List <Client> clients = noDubleLine(clientBook);
        AddresAndClientBase.listClient=clients;
    }

}


