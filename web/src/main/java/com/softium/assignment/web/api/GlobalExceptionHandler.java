package com.softium.assignment.web.api;

import com.softium.assignment.service.core.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        return handleException(exception, webRequest, NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest webRequest) {
        return handleException(exception, webRequest, BAD_REQUEST);
    }

    @Order
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleInternalError(Exception exception, WebRequest webRequest) {
        return handleException(exception, webRequest, INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> handleException(Exception exception, WebRequest webRequest, HttpStatus httpStatus) {
        log.error(exception.getMessage(), exception);

        return new ResponseEntity<>(ErrorResponse.of(httpStatus, exception.getMessage(), webRequest.toString()), httpStatus);
    }

}
