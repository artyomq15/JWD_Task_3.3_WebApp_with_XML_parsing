package by.tr.parser.dao.impl.parse.impl.sax;

import by.tr.parser.dao.impl.exception.TariffSAXException;
import by.tr.parser.dao.impl.parse.TariffXMLParser;
import by.tr.parser.dao.impl.parse.constant.FilePath;
import by.tr.parser.entity.Tariff;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class TariffSAXParser implements TariffXMLParser{
    @Override
    public List<Tariff> parse() throws TariffSAXException{
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(this.getClass().getResourceAsStream(FilePath.XML_TARIFF_PATH)));
            return handler.getTariffList();
        } catch (SAXException | IOException e) {
            throw new TariffSAXException(e);
        }

    }
}
