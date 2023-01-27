
import parser.AddresAndClientBase;
import parser.XMLParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class IDEMain {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        xmlParser.parse(new File("address.xml"),new File("client.xml"));
        AddresAndClientBase base = new AddresAndClientBase();
        base.printClientBook();

        // xmlParser.;


    }
}
