package ru.roman.popovnin.petclinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.roman.popovnin.petclinic.exceptions.ClinicNotFoundException;
import ru.roman.popovnin.petclinic.exceptions.PetAlreadyRegisteredException;
import ru.roman.popovnin.petclinic.exceptions.PetNotFoundException;
import ru.roman.popovnin.petclinic.model.Clinic;
import ru.roman.popovnin.petclinic.service.ClinicService;

@RestController
@RequestMapping(path = "/clinic")
@Slf4j
public class ClinicController {
    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createClinic(@RequestParam String address) {
        log.info("Creating new clinic with address: {}", address);
        clinicService.createClinic(address);
        log.info("Creating clinic with address {} finished", address);
    }

    @RequestMapping(path="/register", method = RequestMethod.POST)
    public void registerPet(@RequestParam int petId, @RequestParam int clinicId){
        log.info("register pet {} at clinic {}", petId, clinicId);
        clinicService.registerPet(petId, clinicId);
    }

    @RequestMapping(path="/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Clinic> getClinic(@PathVariable("id") int id) {
        Clinic clinic = clinicService.getClinic(id);
        return new ResponseEntity<>(clinic, HttpStatus.OK);
    }
}
