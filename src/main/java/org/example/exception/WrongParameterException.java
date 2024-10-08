package org.example.exception;

public class WrongParameterException extends RuntimeException {
    public WrongParameterException(Throwable cause) {
        super(cause);
    }
}
