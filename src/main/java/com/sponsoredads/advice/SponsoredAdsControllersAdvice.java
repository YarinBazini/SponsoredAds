package com.sponsoredads.advice;

import com.sponsoredads.exceptions.SponsoredAdsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SponsoredAdsControllersAdvice {

    @ExceptionHandler(value = {SponsoredAdsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handler(Exception e){return new ErrorDto(e.getMessage());}
}
