package org.example.exception;

public class InvalidBrowserException extends Exception{

    public InvalidBrowserException() {
        super("Invalid browser type.");
    }

    public InvalidBrowserException(String message) {
        super(message);
    }
}
