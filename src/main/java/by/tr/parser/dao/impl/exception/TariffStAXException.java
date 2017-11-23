package by.tr.parser.dao.impl.exception;

public class TariffStAXException extends TariffXMLParseException {
    private static final long serialVersionUID = -5920393958083584264L;

    public TariffStAXException() {
    }

    public TariffStAXException(String message) {
        super(message);
    }

    public TariffStAXException(String message, Throwable cause) {
        super(message, cause);
    }

    public TariffStAXException(Throwable cause) {
        super(cause);
    }
}
