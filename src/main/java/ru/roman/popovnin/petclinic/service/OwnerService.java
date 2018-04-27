package ru.roman.popovnin.petclinic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.roman.popovnin.petclinic.exceptions.OwnerNotFoundException;
import ru.roman.popovnin.petclinic.exceptions.PetNotFoundException;
import ru.roman.popovnin.petclinic.model.Owner;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.repository.OwnerRepository;
import ru.roman.popovnin.petclinic.repository.PetRepository;

@Service
public class OwnerService {

    private final OwnerRepository petOwnerRepository;
    private final PetRepository petRepository;

    public OwnerService(OwnerRepository petOwnerRepository, PetRepository petRepository) {
        this.petOwnerRepository = petOwnerRepository;
        this.petRepository = petRepository;
    }

    @Transactional
    public void createPetOwner(String name) {
        petOwnerRepository.save(new Owner(name));
    }

    @Transactional(readOnly = true)
    public Owner getPetOwner(int id) {
        return petOwnerRepository
                .findById(id)
                .orElse(null);
    }

    @Transactional
    public void buyPet(int petId, int ownerId) {
        Owner owner = petOwnerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException());
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException());

        owner.getPets().add(pet);

        petOwnerRepository.save(owner);
    }


}
