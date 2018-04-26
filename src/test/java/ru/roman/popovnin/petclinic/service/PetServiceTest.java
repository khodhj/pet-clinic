package ru.roman.popovnin.petclinic.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.repository.PetRepository;

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
}