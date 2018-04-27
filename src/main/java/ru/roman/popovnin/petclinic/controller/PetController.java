package ru.roman.popovnin.petclinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.roman.popovnin.petclinic.exceptions.PetNotFoundException;
import ru.roman.popovnin.petclinic.model.Owner;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.service.PetService;

import java.util.List;

@RestController
@RequestMapping(path = "/pet")
@Slf4j
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createPet(@RequestParam String name) {
        log.info("Creating new pet with name: {}", name);
        petService.createPet(name);
        log.info("Creating pet with name {} finished", name);
    }

    @RequestMapping(path = "/get", method = RequestMethod.POST)
    public void getPet(@RequestParam int id) {
        log.info("pet getting by id: {}", id);
        Pet pet = petService.getPet(id);
        log.info("pet getting finished by id: {}", id);
        for (Owner owner : pet.getOwners()) {
            log.debug("ownerId = {}, ownerName = {}", owner.getId(), owner.getName());
        }
    }

    @RequestMapping(path="/set", method = RequestMethod.POST)
    public void setAge(@RequestParam int id, @RequestParam int age) {
        petService.setAge(id, age);
    }

    @RequestMapping(path="/getbyage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Pet>> getPetByAgeFromClinic(@RequestParam int age, @RequestParam int clinicId) {
        List<Pet> petListGettedByAgeFromClinic = petService.getPetsByAgeFromClinic(age, clinicId);
        return new ResponseEntity<>(petListGettedByAgeFromClinic, HttpStatus.OK);
    }
}
