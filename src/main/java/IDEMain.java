import action.CounterPeopleOnFloor;
import action.PeopleOnFlatnumber;
import object.Client;
import parser.XMLParser;
import utils.AddresAndClientBase;

import java.io.File;

import static utils.AddresAndClientBase.listPeopleOnFlatnumber;
import static utils.AddresAndClientBase.number;


public class IDEMain {
    public static void main(String[] args) throws InterruptedException {
        XMLParser xmlParser = new XMLParser();
        xmlParser.parse(new File("address.xml"), new File("client.xml"));
        AddresAndClientBase.printListClientBook();
        System.out.println(" ");
        CounterPeopleOnFloor counterPeopleOnFloor = new CounterPeopleOnFloor();
        PeopleOnFlatnumber peopleOnFlatnumber = new PeopleOnFlatnumber();
        Thread processConterPeopleOnFloor = new Thread(counterPeopleOnFloor);
        Thread processPeopleOnFlatnumber = new Thread(peopleOnFlatnumber);
        processConterPeopleOnFloor.start();
        processPeopleOnFlatnumber.start();
        processConterPeopleOnFloor.join();
        for (Client client : listPeopleOnFlatnumber) {
            System.out.println(client.address.floor);
            System.out.println(client.toString());

        }
        System.out.println(" ");
        processPeopleOnFlatnumber.join();
        System.out.println(number);
    }
}