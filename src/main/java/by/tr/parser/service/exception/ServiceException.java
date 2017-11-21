package by.tr.parser.service.exception;


public class ServiceException extends Exception{
    private static final long serialVersionUID = 4071161735240609338L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
