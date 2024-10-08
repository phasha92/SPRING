package org.example.exception;

public class DatabaseDriverNotFoundException extends RuntimeException {
    public DatabaseDriverNotFoundException(Throwable cause) {
        super(cause);
    }
}
