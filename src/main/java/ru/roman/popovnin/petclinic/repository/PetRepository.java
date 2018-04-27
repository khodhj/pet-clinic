package ru.roman.popovnin.petclinic.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.roman.popovnin.petclinic.model.Pet;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {
    @Query("select p from Pet p where p.age > :age and p.clinic.id = :clinicId")
    List<Pet> getPetsByAgeFromClinic(@Param("age") int age, @Param("clinicId") int clinicId, Sort sort);
}