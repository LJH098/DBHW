package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.common.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcepionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorObject handlerIllgalException(Exception e) {
        return new ErrorObject(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
