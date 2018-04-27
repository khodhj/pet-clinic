package ru.roman.popovnin.petclinic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.roman.popovnin.petclinic.exceptions.DiseaseNotFoundException;
import ru.roman.popovnin.petclinic.exceptions.PetNotFoundException;
import ru.roman.popovnin.petclinic.model.Disease;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.repository.DiseaseRepository;
import ru.roman.popovnin.petclinic.repository.PetRepository;

@Slf4j
@Service
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;
    private final PetRepository petRepository;

    public DiseaseService(DiseaseRepository diseaseRepository, PetRepository petRepository) {
        this.diseaseRepository = diseaseRepository;
        this.petRepository = petRepository;
    }

    @Transactional
    public void createDisease(String name) {
        diseaseRepository.save(new Disease(name));
    }

    @Transactional(readOnly = true)
    public Disease getDisease(int id) {
        return diseaseRepository
                .findById(id)
                .orElse(null);
    }

    @Transactional
    public void infectPet(int petId, int diseaseId) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException());
        Disease disease = diseaseRepository.findById(diseaseId).orElseThrow(() -> new DiseaseNotFoundException());

        disease.getPets().add(pet);

        diseaseRepository.save(disease);
    }

}
