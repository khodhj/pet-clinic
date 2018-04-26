package ru.roman.popovnin.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.roman.popovnin.petclinic.model.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Integer> {
}
