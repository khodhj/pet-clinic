package ru.roman.popovnin.petclinic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pets_owners",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    private List<PetOwner> owners = new ArrayList<PetOwner>();

    @ManyToMany
    private List<Disease> diseases;

    @ManyToOne
    private Clinic clinic;

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

    public List<PetOwner> getOwners() {
        return owners;
    }

    public void setOwners(List<PetOwner> owners) {
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

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owners=" + owners +
                ", diseases=" + diseases +
                ", clinic=" + clinic +
                '}';
    }
}
