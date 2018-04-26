package ru.roman.popovnin.petclinic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.model.PetOwner;
import ru.roman.popovnin.petclinic.repository.PetRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional
    public void createPet(String name){
        Pet pet = new Pet();
        pet.setName(name);

        petRepository.save(pet);
    }

    @Transactional
    public Pet getPet(int id){

        return petRepository.getOne(id);
    }

    @Transactional
    public void buyPet(Pet pet, PetOwner petOwner) {

        pet.getOwners().add(petOwner);

        log.info("pet to str: {}", pet);

        petRepository.save(pet);

    }

}
