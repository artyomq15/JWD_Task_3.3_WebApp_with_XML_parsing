package by.tr.parser.dao.impl.parse.impl.sax;

import by.tr.parser.dao.exception.DAOException;
import by.tr.parser.dao.impl.parse.TariffXMLParser;
import org.xml.sax.SAXException;

import java.io.IOException;


public class MainSax {
    public static void main(String[] args) throws DAOException {
        TariffXMLParser parser = new SAXParser();
        System.out.println(parser.parse());
    }
}
