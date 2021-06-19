package ru.arthur.hackathon.medicine.dao.model;

import javax.persistence.*;

@Entity
public class MedicalFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
