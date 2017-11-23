package by.tr.parser.dao.impl.exception;


public class TariffDOMException extends TariffXMLParseException {
    private static final long serialVersionUID = 4642877850772177186L;

    public TariffDOMException() {
    }

    public TariffDOMException(String message) {
        super(message);
    }

    public TariffDOMException(String message, Throwable cause) {
        super(message, cause);
    }

    public TariffDOMException(Throwable cause) {
        super(cause);
    }
}
