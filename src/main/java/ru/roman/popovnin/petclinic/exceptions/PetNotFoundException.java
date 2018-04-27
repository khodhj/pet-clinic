package ru.roman.popovnin.petclinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such pet")
public class PetNotFoundException extends RuntimeException {

    private int petId;

    public PetNotFoundException(Integer petId){
        this.petId = petId;
    }

    public PetNotFoundException(){
    }

    @Override
    public String getMessage() {
        String message = "User-friendly exception message. There is no pet for you. Pet Id = "+this.petId;
        return message;
    }
}
