package by.tr.parser.dao;

import by.tr.parser.constant.ParserType;
import by.tr.parser.dao.exception.DAOException;
import by.tr.parser.entity.Tariff;
import java.util.List;

public interface TariffDAO {
    List<Tariff> getTariffs(ParserType parserType) throws DAOException;
}
