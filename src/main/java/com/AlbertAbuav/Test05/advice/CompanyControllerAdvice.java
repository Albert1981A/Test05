package com.AlbertAbuav.Test05.advice;

import com.AlbertAbuav.Test05.exception.CompanyCustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CompanyControllerAdvice {

    @ExceptionHandler(value = {CompanyCustomException.class})
    public ErrorDetails handleException(Exception e) {
        return new ErrorDetails("LOL", e.getMessage());
    }

}
