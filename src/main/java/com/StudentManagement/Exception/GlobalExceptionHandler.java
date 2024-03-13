package com.StudentManagement.Exception;

import com.StudentManagement.Exception.NoSuchCourseFoundException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
@Data
@Getter
@Setter

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchCourseFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchCourseFoundException(NoSuchCourseFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Add more exception handlers as needed

    // Example of ErrorResponse class for consistent error response format
    static class ErrorResponse {
        private int status;
        private Date timestamp;
        private String message;
        private String details;

        public ErrorResponse(int status, Date timestamp, String message, String details) {
            this.status = status;
            this.timestamp = timestamp;
            this.message = message;
            this.details = details;
        }

        // Getters and setters
    }
}
