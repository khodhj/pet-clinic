package ru.roman.popovnin.petclinic.service;

import org.springframework.stereotype.Service;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.model.PetOwner;
import ru.roman.popovnin.petclinic.repository.PetOwnerPepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetOwnerService {

    private final PetOwnerPepository petOwnerPepository;

    public PetOwnerService(PetOwnerPepository petOwnerPepository) {
        this.petOwnerPepository = petOwnerPepository;
    }

    @Transactional
    public void createPetOwner(String name) {

        PetOwner petOwner = new PetOwner();
        petOwner.setName(name);

        petOwnerPepository.save(petOwner);

    }

    @Transactional
    public PetOwner getPetOwner(int id){

        return petOwnerPepository.getOne(id);
    }

    @Transactional
    public void buyPet(Pet pet, PetOwner petOwner) {

        List<Pet> pets = new ArrayList<Pet>();
        pets.add(pet);

        petOwner.setPets(pets);

        petOwnerPepository.save(petOwner);

    }


}
