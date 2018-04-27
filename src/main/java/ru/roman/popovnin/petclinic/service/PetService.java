package ru.roman.popovnin.petclinic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.roman.popovnin.petclinic.exceptions.PetNotFoundException;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.repository.PetRepository;

import java.util.List;

@Slf4j
@Service
public class PetService {

    private final PetRepository petRepository;

    private final static Sort SORT_ASC = new Sort(Sort.Direction.ASC, "age");

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional
    public void createPet(String name) {
        petRepository.save(new Pet(name));
    }

    @Transactional(readOnly = true)
    public Pet getPet(int id) {
        return petRepository.findById(id).orElseThrow(() -> new PetNotFoundException());
    }

    @Transactional
    public void setAge(int id, int age) {
        Pet pet = getPet(id);
        pet.setAge(age);
        petRepository.save(pet);
    }

    @Transactional
    public List<Pet> getPetsByAgeFromClinic(int age, int clinicId) {
        return petRepository.getPetsByAgeFromClinic(age, clinicId, SORT_ASC);
    }
}
