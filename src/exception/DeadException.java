package exception;


/**
 * Exception throw when a player already died and your try to kill kim again
 *
 * @see Exception
 * */
public class DeadException extends Exception {

    private static final String DEFAULT_EXCEPTION_MESSAGE = "Player have not enough life";

    public DeadException() {
        super(DEFAULT_EXCEPTION_MESSAGE);
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
