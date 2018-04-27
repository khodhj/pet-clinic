package ru.roman.popovnin.petclinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such disease")
public class DiseaseNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "User-friendly exception message. Something wrong with disease getting.";
    }
}
