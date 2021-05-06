package com.madpezkoh.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super(String.format("[ID: %s] Resource not found.", id));
    }
}
