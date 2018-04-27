package ru.roman.popovnin.petclinic.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private Set<Pet> patientPets = new HashSet<>();

    public Clinic() {
    }

    public Clinic(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Pet> getPatientPets() {
        return patientPets;
    }

    public void setPatientPets(Set<Pet> patientPets) {
        this.patientPets = patientPets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return id == clinic.id &&
                Objects.equals(address, clinic.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, address);
    }
}
