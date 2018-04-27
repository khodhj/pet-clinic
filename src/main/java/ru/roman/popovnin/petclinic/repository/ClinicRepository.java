package ru.roman.popovnin.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.roman.popovnin.petclinic.model.Clinic;
import ru.roman.popovnin.petclinic.model.Pet;

import java.util.List;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

}
