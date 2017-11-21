package by.tr.parser.service;


import by.tr.parser.service.impl.TariffServiceImpl;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    private TariffService tariffService = new TariffServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public TariffService getTariffService(){
        return tariffService;
    }
}
