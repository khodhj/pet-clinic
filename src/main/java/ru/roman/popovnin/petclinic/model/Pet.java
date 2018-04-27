package ru.roman.popovnin.petclinic.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @ManyToMany(mappedBy = "pets")
    private List<Owner> owners = new ArrayList<>();

    @ManyToMany(mappedBy = "pets")
    private List<Disease> diseases = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    public Pet() {
    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pet(String name, int age, Clinic clinic) {
        this.name = name;
        this.age = age;
        this.clinic = clinic;
    }

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

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id &&
                Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
