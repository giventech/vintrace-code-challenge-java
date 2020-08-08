package devproblem.exception;

public class WineException extends RuntimeException {

    private static final long serialVersionUID = -8460356990632230194L;

    private final ErrorCode code;

    public WineException(ErrorCode code) {
        super();
        this.code = code;
    }

    public WineException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public WineException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public WineException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }
}


