package ru.roman.popovnin.petclinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.roman.popovnin.petclinic.service.PetOwnerService;

@RestController
@RequestMapping(path = "/petowner")
@Slf4j
public class PetOwnerController {

    private final PetOwnerService petOwnerService;

    public PetOwnerController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createPetOwner(@RequestParam String name) {
        log.info("Creating new petOwner with name: {}", name);
        petOwnerService.createPetOwner(name);
        log.info("Creating petOwner with name {} finished", name);
    }

}