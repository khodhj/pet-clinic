package ru.roman.popovnin.petclinic.service;

import org.springframework.stereotype.Service;
import ru.roman.popovnin.petclinic.model.Disease;
import ru.roman.popovnin.petclinic.repository.DiseaseRepository;

import javax.transaction.Transactional;

@Service
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Transactional
    public void createDisease(String name){

        Disease disease = new Disease();
        disease.setName(name);

        diseaseRepository.save(disease);

    }

}
