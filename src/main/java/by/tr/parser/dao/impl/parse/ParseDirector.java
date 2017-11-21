package by.tr.parser.dao.impl.parse;

import by.tr.parser.constant.ParserType;
import by.tr.parser.dao.impl.parse.impl.dom.DOMParser;
import by.tr.parser.dao.impl.parse.impl.sax.SAXParser;
import by.tr.parser.dao.impl.parse.impl.stax.StAXParser;

import java.util.HashMap;
import java.util.Map;

public class ParseDirector {
    private Map<ParserType, TariffXMLParser> dispatcher = new HashMap<>();

    {
        dispatcher.put(ParserType.SAX, new SAXParser());
        dispatcher.put(ParserType.STAX, new StAXParser());
        dispatcher.put(ParserType.DOM, new DOMParser());
    }

    public TariffXMLParser getParser(ParserType parserType){
        return dispatcher.get(parserType);
    }
}
