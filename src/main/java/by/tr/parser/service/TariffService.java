package by.tr.parser.service;

import by.tr.parser.constant.ParserType;
import by.tr.parser.entity.Tariff;
import by.tr.parser.service.exception.ServiceException;

import java.util.List;

public interface TariffService {
    List<Tariff> getTariffs(ParserType parserType) throws ServiceException;
}
