package com.app.quantityservice.exception;

public class QmaException extends RuntimeException {

    public QmaException(String message) {
        super(message);
    }

    public QmaException(String message, Throwable cause) {
        super(message, cause);
    }
}
