package org.anest.mystore.controller;

import org.anest.mystore.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

//@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleException(Exception e) {
        return "error400";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handProductNotFoundException(Exception e) {
        return "error400";
    }

    @ExceptionHandler(Exception.class)
    public String defaultErrorHandler(Exception e) {
        return "error500";
    }
}
