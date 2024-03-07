package yorku.eecs.controller;

public class ControllerError extends Throwable {
    public ControllerError(String errorMessage) {
        super(errorMessage);
    }
    public ControllerError(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
