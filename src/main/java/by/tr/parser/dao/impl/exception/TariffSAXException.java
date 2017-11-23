package by.tr.parser.dao.impl.exception;


public class TariffSAXException extends TariffXMLParseException {
    private static final long serialVersionUID = -838639732930833774L;

    public TariffSAXException() {
    }

    public TariffSAXException(String message) {
        super(message);
    }

    public TariffSAXException(String message, Throwable cause) {
        super(message, cause);
    }

    public TariffSAXException(Throwable cause) {
        super(cause);
    }
}
