package ru.roman.popovnin.petclinic.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "diseases")
    private List<Pet> diseasePets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getDiseasePets() {
        return diseasePets;
    }

    public void setDiseasePets(List<Pet> diseasePets) {
        this.diseasePets = diseasePets;
    }
}
