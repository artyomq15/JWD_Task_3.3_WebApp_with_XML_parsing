package by.tr.parser.dao.impl.parse;

import by.tr.parser.constant.ParserType;
import by.tr.parser.dao.impl.parse.impl.dom.TariffDOMParser;
import by.tr.parser.dao.impl.parse.impl.sax.TariffSAXParser;
import by.tr.parser.dao.impl.parse.impl.stax.TariffStAXParser;

import java.util.HashMap;
import java.util.Map;

public class ParseDirector {
    private Map<ParserType, TariffXMLParser> dispatcher = new HashMap<>();

    {
        dispatcher.put(ParserType.SAX, new TariffSAXParser());
        dispatcher.put(ParserType.STAX, new TariffStAXParser());
        dispatcher.put(ParserType.DOM, new TariffDOMParser());
    }

    public TariffXMLParser getParser(ParserType parserType){
        return dispatcher.get(parserType);
    }
}
