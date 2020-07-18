package com.allanimt.springboot.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorMessages> handleApiExceptions(ApiBaseException apiBaseException, WebRequest request) {
        ErrorMessages messages = new ErrorMessages(apiBaseException.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(messages, apiBaseException.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //ex.getBindingResult().getFieldError();
        ValidationError validationError = new ValidationError();
        validationError.setUri(request.getDescription(false));
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            validationError.addError(fieldError.getDefaultMessage());
        }
        //return super.handleMethodArgumentNotValid(ex, headers, status, request);
        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}
