package by.tr.parser.dao.impl.parse;

import by.tr.parser.dao.impl.exception.TariffXMLParseException;
import by.tr.parser.entity.Tariff;
import java.util.List;

public interface TariffXMLParser {
    List<Tariff> parse() throws TariffXMLParseException;
}
