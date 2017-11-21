package by.tr.parser.dao;

import by.tr.parser.dao.impl.TariffDAOImpl;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();

    private TariffDAO tariffDAO = new TariffDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getInstance(){return instance;}

    public TariffDAO getTariffDAO(){
        return tariffDAO;
    }

}
