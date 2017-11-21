package by.tr.parser.service.impl;

import by.tr.parser.constant.ParserType;
import by.tr.parser.dao.DAOFactory;
import by.tr.parser.dao.exception.DAOException;
import by.tr.parser.entity.Tariff;
import by.tr.parser.service.TariffService;
import by.tr.parser.service.exception.ServiceException;

import java.util.List;

public class TariffServiceImpl implements TariffService {
    @Override
    public List<Tariff> getTariffs(ParserType parserType) throws ServiceException{
        try {
            return DAOFactory.getInstance().getTariffDAO().getTariffs(parserType);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
