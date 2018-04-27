package ru.roman.popovnin.petclinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such clinic")
public class ClinicNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "User-friendly exception message. Clinic with given id not found.";
    }

    public ClinicNotFoundException() {
    }

}