package by.tr.parser.dao.impl;

import by.tr.parser.constant.ParserType;
import by.tr.parser.dao.TariffDAO;
import by.tr.parser.dao.exception.DAOException;
import by.tr.parser.dao.impl.exception.TariffXMLParseException;
import by.tr.parser.dao.impl.parse.ParseDirector;
import by.tr.parser.dao.impl.parse.TariffXMLParser;
import by.tr.parser.entity.Tariff;
import java.util.List;

public class TariffDAOImpl implements TariffDAO{
    @Override
    public List<Tariff> getTariffs(ParserType parserType) throws DAOException{
        ParseDirector parseDirector = new ParseDirector();
        TariffXMLParser parser = parseDirector.getParser(parserType);
        try {
            return parser.parse();
        } catch (TariffXMLParseException e) {
            throw new DAOException(e);
        }
    }
}
