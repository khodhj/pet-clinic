package ru.roman.popovnin.petclinic.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.roman.popovnin.petclinic.model.Disease;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.repository.DiseaseRepository;
import ru.roman.popovnin.petclinic.repository.PetRepository;

import java.util.Optional;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiseaseServiceTest {

    @Autowired
    DiseaseService diseaseService;

    @MockBean
    PetRepository petRepository;

    @MockBean
    DiseaseRepository diseaseRepository;

    @Test
    public void createDisease() {
        Disease disease = new Disease();
        disease.setName("tif");

        diseaseService.createDisease("tif");
        verify(diseaseRepository, times(1)).save(eq(disease));
    }

    @Test
    public void getDisease() {
        Disease disease = new Disease();
        disease.setName("tif");

        when(diseaseRepository.findById(eq(1))).thenReturn(Optional.of(disease));
        diseaseService.getDisease(1);
        verify(diseaseRepository, times(1)).findById(eq(1));
    }

    @Test
    public void infectPet() {
        Disease disease = new Disease();
        disease.setName("tif");

        Pet pet = new Pet();
        pet.setName("gera");

        disease.getPets().add(pet);

        when(petRepository.findById(eq(1))).thenReturn(Optional.of(pet));
        when(diseaseRepository.findById(eq(1))).thenReturn(Optional.of(disease));

        diseaseService.infectPet(1,1);

        verify(petRepository, times(1)).findById(eq(1));
        verify(diseaseRepository, times(1)).findById(eq(1));

        verify(diseaseRepository, times(1)).save(eq(disease));

    }
}