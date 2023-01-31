package parser;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface Parser {
    void parse(File... files) throws FileNotFoundException, XMLStreamException;
}

