package yorku.eecs.logic;

import java.io.IOException;

public class CSVError extends IOException {
    public CSVError(String message) {
        super(message);
    }
    public CSVError(String message, Throwable cause) {
        super(message, cause);
    }
}
