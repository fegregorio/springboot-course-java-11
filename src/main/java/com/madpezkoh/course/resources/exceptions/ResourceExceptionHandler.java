package com.madpezkoh.course.resources.exceptions;

import com.madpezkoh.course.services.exceptions.DatabaseException;
import com.madpezkoh.course.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError>
    resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String errorDescription = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(
                Instant.now(),
                status.value(),
                errorDescription, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError>
    database(DatabaseException e, HttpServletRequest request) {
        String errorDescription = "Database error.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(
                Instant.now(),
                status.value(),
                errorDescription, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
