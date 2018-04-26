package ru.roman.popovnin.petclinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

}
