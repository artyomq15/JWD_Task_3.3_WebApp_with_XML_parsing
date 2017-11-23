package by.tr.parser.dao.impl.parse.impl.stax;

import by.tr.parser.dao.impl.exception.TariffStAXException;
import by.tr.parser.dao.impl.parse.TariffXMLParser;
import by.tr.parser.dao.impl.parse.constant.FilePath;
import by.tr.parser.entity.Tariff;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.List;

public class TariffStAXParser implements TariffXMLParser {
    @Override
    public List<Tariff> parse() throws TariffStAXException{
        XMLInputFactory instance = XMLInputFactory.newInstance();
        InputStream inputStream = this.getClass().getResourceAsStream(FilePath.XML_TARIFF_PATH);
        try{
            XMLStreamReader reader = instance.createXMLStreamReader(inputStream);
            return StAXHandler.parse(reader);
        } catch (XMLStreamException ex){
            throw new TariffStAXException(ex);
        }
    }
}
