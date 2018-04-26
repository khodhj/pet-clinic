package ru.roman.popovnin.petclinic.model;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @OneToMany(mappedBy = "clinic")
    private List<Pet> patientPets;

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

    public List<Pet> getPatientPets() {
        return patientPets;
    }

    public void setPatientPets(List<Pet> patientPets) {
        this.patientPets = patientPets;
    }
}
