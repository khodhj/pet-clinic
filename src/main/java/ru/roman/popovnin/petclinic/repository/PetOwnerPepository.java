package ru.roman.popovnin.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.roman.popovnin.petclinic.model.PetOwner;

@Repository
public interface PetOwnerPepository extends JpaRepository<PetOwner, Integer>{

}