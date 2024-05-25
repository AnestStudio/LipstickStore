package org.anest.mystore.controller;

import org.anest.mystore.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleExceptionA(Exception e) {
        return "error400";
    }

    @ExceptionHandler(Exception.class)
    public String handleUnwantedException(Exception e) {
        return "error500";
    }
}
