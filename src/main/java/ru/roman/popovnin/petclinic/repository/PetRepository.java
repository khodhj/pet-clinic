package ru.roman.popovnin.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.roman.popovnin.petclinic.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {
}