package parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser implements Parser {

    @Override
    public void parse(File file) {
        readAddress(file);

    }

    //     todo дополнить реализацию, это чисто пример
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
                        Addres add = new Addres(Integer.parseInt(parser.getAttributeValue(0)), parser.getAttributeValue(1), parser.getAttributeValue(2), Integer.parseInt(parser.getAttributeValue(3)), Integer.parseInt(parser.getAttributeValue(4)), Integer.parseInt(parser.getAttributeValue(5)));
                        addressBook.add(add);
                    }
                }
                for (Addres addres : addressBook) {
                    addres.prin();
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
