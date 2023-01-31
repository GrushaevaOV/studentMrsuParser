
import parser.AddresAndClientBase;
import parser.XMLParser;

import java.io.File;


public class IDEMain {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        xmlParser.parse(new File("address.xml"), new File("client.xml"));
        AddresAndClientBase.printListClientBook();
        AddresAndClientBase.listPeopleOnFlatnumber();
        AddresAndClientBase.numberPeopleOnFloor();
       }
}
