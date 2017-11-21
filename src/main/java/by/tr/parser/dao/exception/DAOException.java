package by.tr.parser.dao.exception;

public class DAOException extends Exception {
    private static final long serialVersionUID = -5389048080264957036L;

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
