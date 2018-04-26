package ru.roman.popovnin.petclinic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "owners")
    private List<Pet> pets = new ArrayList<>();

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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetOwner petOwner = (PetOwner) o;
        return id == petOwner.id &&
                Objects.equals(name, petOwner.name) &&
                Objects.equals(pets, petOwner.pets);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, pets);
    }
}
