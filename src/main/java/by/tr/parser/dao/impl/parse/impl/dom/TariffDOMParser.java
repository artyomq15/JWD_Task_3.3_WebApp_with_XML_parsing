package by.tr.parser.dao.impl.parse.impl.dom;

import by.tr.parser.dao.impl.exception.TariffDOMException;
import by.tr.parser.dao.impl.parse.TariffXMLParser;
import by.tr.parser.entity.Tariff;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;


public class TariffDOMParser implements TariffXMLParser {
    @Override
    public List<Tariff> parse() throws TariffDOMException{
        try {
            return DOMHandler.doParsing();
        } catch (IOException | SAXException e) {
            throw new TariffDOMException(e);
        }
    }
}
