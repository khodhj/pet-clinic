package ru.roman.popovnin.petclinic.exceptions;

public class PetAlreadyRegisteredException extends RuntimeException {

    private int petId;

    @Override
    public String getMessage() {
        String message = "Pet was already registered at this clinic. Pet Id = " + this.petId;
        return message;
    }

    public PetAlreadyRegisteredException(int petId) {
        this.petId = petId;
    }

    public int getPetId() {
        return petId;
    }
}