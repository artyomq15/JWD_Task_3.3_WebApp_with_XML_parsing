package by.tr.parser.dao.impl.parse;

import by.tr.parser.dao.exception.DAOException;
import by.tr.parser.entity.Tariff;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public interface TariffXMLParser {
    List<Tariff> parse() throws DAOException;
}
