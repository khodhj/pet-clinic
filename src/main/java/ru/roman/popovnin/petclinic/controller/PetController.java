package ru.roman.popovnin.petclinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.model.PetOwner;
import ru.roman.popovnin.petclinic.service.PetOwnerService;
import ru.roman.popovnin.petclinic.service.PetService;

@RestController
@RequestMapping(path = "/pet")
@Slf4j
public class PetController {

    private PetService petService;
    @Autowired
    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    private PetOwnerService petOwnerService;
    @Autowired
    public void setPetOwnerService(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
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
    }

    @RequestMapping(path = "/buy", method = RequestMethod.POST)
    public void buyPet(@RequestParam int pet_id, @RequestParam int pet_owner_id){

        log.info("pet getting by id: {}", pet_id);
        Pet pet = petService.getPet(pet_id);
        log.info("pet getting finished by id: {}", pet_id);

        log.info("petOwner getting by id: {}", pet_owner_id);
        PetOwner petOwner = petOwnerService.getPetOwner(pet_owner_id);

        log.info("pet buying id: {}", pet_id);
        petService.buyPet(pet, petOwner);
        log.info("pet has buy. pet id: {}", pet_id);
    }

}
