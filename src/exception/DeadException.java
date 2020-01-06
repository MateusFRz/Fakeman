package exception;

public class DeadException extends Exception {

    public DeadException() {
        super("Player have not enough life");
    }

    public DeadException(String message) {
        super(message);
    }

    public DeadException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeadException(Throwable cause) {
        super(cause);
    }

    protected DeadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
