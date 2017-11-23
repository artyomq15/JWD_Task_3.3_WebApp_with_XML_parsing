package by.tr.parser.dao.impl.exception;

public class TariffXMLParseException extends Exception {
    private static final long serialVersionUID = -2798158444270333836L;

    public TariffXMLParseException() {
    }

    public TariffXMLParseException(String message) {
        super(message);
    }

    public TariffXMLParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public TariffXMLParseException(Throwable cause) {
        super(cause);
    }
}
