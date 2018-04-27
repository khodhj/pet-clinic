package ru.roman.popovnin.petclinic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.roman.popovnin.petclinic.exceptions.ClinicNotFoundException;
import ru.roman.popovnin.petclinic.exceptions.PetAlreadyRegisteredException;
import ru.roman.popovnin.petclinic.exceptions.PetNotFoundException;
import ru.roman.popovnin.petclinic.model.Clinic;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.repository.ClinicRepository;
import ru.roman.popovnin.petclinic.repository.PetRepository;

@Service
public class ClinicService{

    private final ClinicRepository clinicRepository;
    private final PetRepository petRepository;

    public ClinicService(ClinicRepository clinicRepository, PetRepository petRepository) {
        this.clinicRepository = clinicRepository;
        this.petRepository = petRepository;
    }

    @Transactional
    public void createClinic(String address) {
        clinicRepository.save(new Clinic(address));
    }

    @Transactional
    public void registerPet(int petId, int clinicId) {

        Pet pet = petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException());

        Clinic clinic = getClinic(clinicId);

        // pet has already registered at this clinic
        if(clinic.getPatientPets().contains(pet)){
            throw new PetAlreadyRegisteredException(petId);
        } else {
            clinic.getPatientPets().add(pet);
            pet.setClinic(clinic);
        }

        clinicRepository.save(clinic);
        petRepository.save(pet);
    }

    @Transactional(readOnly = true)
    public Clinic getClinic(int clinicId) {
         return clinicRepository.findById(clinicId).orElseThrow(() -> new ClinicNotFoundException());
    }
}