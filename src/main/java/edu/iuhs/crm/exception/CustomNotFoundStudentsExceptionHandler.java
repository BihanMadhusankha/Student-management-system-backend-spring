package edu.iuhs.crm.exception;

public class CustomNotFoundStudentsExceptionHandler extends RuntimeException {
    public CustomNotFoundStudentsExceptionHandler(String message) {
        super(message);
    }
}
