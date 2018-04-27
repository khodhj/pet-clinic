package ru.roman.popovnin.petclinic.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import ru.roman.popovnin.petclinic.model.Clinic;
import ru.roman.popovnin.petclinic.model.Pet;

import java.util.*;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.hamcrest.CoreMatchers.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PetRepositoryTest {

    @Autowired
    PetRepository petRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getPetsByAgeFromClinic() {
        Clinic clinic = new Clinic();
        int clinicId = entityManager.persist(clinic).getId();

        Pet pet = createAndPersistPetObject("firstname", 10, clinic);
        Pet oneMorePet = createAndPersistPetObject("onemore", 13, clinic);
        Pet oneMoreAfterOneMorePet = createAndPersistPetObject("onemore", 7, clinic);

        List<Pet> resultPets = petRepository.getPetsByAgeFromClinic(9, clinicId, new Sort(Sort.Direction.ASC, "age"));

        assertThat(resultPets, hasSize(2));
        assertThat(resultPets, contains(pet, oneMorePet));
    }

    private Pet createAndPersistPetObject(String name, int age, Clinic clinic){
        Pet pet = new Pet(name, age, clinic);
        entityManager.persist(pet);
        return pet;
    }
}