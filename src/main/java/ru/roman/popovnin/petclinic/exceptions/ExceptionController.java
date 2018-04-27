package ru.roman.popovnin.petclinic.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClinicNotFoundException.class)
    public void clinicNotFoundException(ClinicNotFoundException ex) {
        log.error(ex.getMessage());
    }

    @ExceptionHandler(PetNotFoundException.class)
    public void petNotFoundException(PetNotFoundException ex) {
        ResponseEntity<PetNotFoundException> responseEntity = new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
        log.error(responseEntity.toString());
        log.error(ex.getMessage());
    }

    @ExceptionHandler(DiseaseNotFoundException.class)
    public void diseaseNotFound(DiseaseNotFoundException ex) {
        log.error(ex.getMessage());
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    public void ownerNotFoundException(OwnerNotFoundException ex) {
        log.error(ex.getMessage());
    }

    @ExceptionHandler(PetAlreadyRegisteredException.class)
    public ResponseEntity<MinimizedClientException> petAlreadyRegisteredExceptionMethod(PetAlreadyRegisteredException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new MinimizedClientException(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class MinimizedClientException {
        private String message;
    }
}
