package ru.roman.popovnin.petclinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.roman.popovnin.petclinic.exceptions.OwnerNotFoundException;
import ru.roman.popovnin.petclinic.exceptions.PetNotFoundException;
import ru.roman.popovnin.petclinic.service.OwnerService;

@RestController
@RequestMapping(path = "/owner")
@Slf4j
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOwner(@RequestParam String name) {
        log.info("Creating new owner with name: {}", name);
        ownerService.createPetOwner(name);
        log.info("Creating owner with name {} finished", name);
    }

    @RequestMapping(path = "/buy", method = RequestMethod.POST)
    public void buyPet(@RequestParam int petId, @RequestParam int ownerId){
        ownerService.buyPet(petId, ownerId);
    }
}