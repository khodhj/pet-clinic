package ru.roman.popovnin.petclinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.roman.popovnin.petclinic.exceptions.DiseaseNotFoundException;
import ru.roman.popovnin.petclinic.exceptions.PetNotFoundException;
import ru.roman.popovnin.petclinic.service.DiseaseService;

@RestController
@RequestMapping(path = "/disease")
@Slf4j
public class DiseaseController {
    private final DiseaseService diseaseService;

    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createDisease(@RequestParam String name) {
        log.info("Creating new disease with name: {}", name);
        diseaseService.createDisease(name);
        log.info("Creating disease with name {} finished", name);
    }

    @RequestMapping(path = "/infect", method = RequestMethod.POST)
    public void infectPet(@RequestParam int petId, @RequestParam int diseaseId){
        diseaseService.infectPet(petId, diseaseId);
    }
}