package org.anest.mystore.controller;

import org.anest.mystore.exception.BrandNotFoundException;
import org.anest.mystore.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

//@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleException(Exception e) {
        return "pages/error/error400";
    }

    @ExceptionHandler({ProductNotFoundException.class, BrandNotFoundException.class})
    public String handleNotFoundException(Exception e) {
        return "pages/error/error404";
    }

    @ExceptionHandler(Exception.class)
    public String defaultErrorHandler(Exception e) {
        return "pages/error/error500";
    }
}
