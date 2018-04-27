package ru.roman.popovnin.petclinic.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.roman.popovnin.petclinic.exceptions.PetAlreadyRegisteredException;
import ru.roman.popovnin.petclinic.model.Clinic;
import ru.roman.popovnin.petclinic.model.Pet;
import ru.roman.popovnin.petclinic.repository.ClinicRepository;
import ru.roman.popovnin.petclinic.repository.PetRepository;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClinicServiceTest {

    @Autowired
    ClinicService clinicService;

    @MockBean
    ClinicRepository clinicRepository;

    @MockBean
    PetRepository petRepository;

    @Test
    public void createClinic() {
        Clinic clinic = new Clinic();
        clinic.setAddress("street, 123");
        clinicService.createClinic("street, 123");
        verify(clinicRepository, times(1)).save(eq(clinic));
    }

    @Test(expected = PetAlreadyRegisteredException.class)
    public void registerPet(){

        Clinic clinic = new Clinic();
        clinic.setAddress("clinicaddress");

        Pet pet = new Pet();
        pet.setName("petname");

        clinic.getPatientPets().add(pet);

        when(clinicRepository.findById(eq(1))).thenReturn(Optional.of(clinic));
        when(petRepository.findById(eq(1))).thenReturn(Optional.of(pet));

        clinicService.registerPet(1,1);

        verify(clinicRepository, times(1)).findById(eq(1));
        verify(petRepository, times(1)).findById(eq(1));

        verify(clinicRepository, times(1)).save(eq(clinic));
        verify(petRepository, times(1)).save(eq(pet));
    }

    @Test
    public void getClinic() {

        Clinic clinic = new Clinic();
        clinic.setAddress("infectedpethospitaladdress");

        Pet pet = new Pet();
        pet.setName("gera");

        clinic.getPatientPets().add(pet);
        Optional<Clinic> clinicOptional = Optional.of(clinic);

        when(clinicRepository.findById(eq(2))).thenReturn(clinicOptional);
        Clinic actualClinic = clinicService.getClinic(2);
        verify(clinicRepository, times(1)).findById(eq(2));

        Assert.assertEquals(clinic, actualClinic);

    }
}