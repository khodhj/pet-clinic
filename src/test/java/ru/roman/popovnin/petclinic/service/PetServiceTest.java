package ru.roman.popovnin.petclinic.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetServiceTest {

    @Autowired
    private PetService petService;

    @MockBean
    private PetRepository petRepository;

    @Test
    public void testNewPetCreation() {
        Pet expectedPet = new Pet();
        expectedPet.setName("petName");

        //when(petRepository.save(eq(expectedPet))).thenReturn(expectedPet);
        //when(petRepository.findById(3)).thenReturn(Optional.of(expectedPet));

        petService.createPet("petName");

        verify(petRepository, times(1)).save(eq(expectedPet));
    }

    @Test
    public void getClinic() {
        Pet pet = new Pet();
        pet.setName("gera");

        when(petRepository.findById(eq(2))).thenReturn(Optional.of(pet));
        Pet actualPet = petService.getPet(2);
        verify(petRepository, times(1)).findById(eq(2));

        Assert.assertEquals(pet, actualPet);
    }

    @Test
    public void getPetsByAgeFromClinic() {
        List<Pet> petNames = new ArrayList<Pet>();
        Pet pet = new Pet("firstname",10);
        petNames.add(pet);

        when(petRepository.getPetsByAgeFromClinic(anyInt(), anyInt(), isA(Sort.class))).thenReturn(petNames);

        List<Pet> testList = petService.getPetsByAgeFromClinic(7,1);

        verify(petRepository, times(1)).getPetsByAgeFromClinic(anyInt(), anyInt(), isA(Sort.class));

        Assert.assertEquals(petNames, testList);
    }
}