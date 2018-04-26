package ru.roman.popovnin.petclinic.service;

import org.springframework.stereotype.Service;
import ru.roman.popovnin.petclinic.model.Clinic;
import ru.roman.popovnin.petclinic.repository.ClinicRepository;

import javax.transaction.Transactional;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Transactional
    public void createClinic(String address) {

        Clinic clinic = new Clinic();
        clinic.setAddress(address);

        clinicRepository.save(clinic);

    }
}
