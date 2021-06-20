package ru.arthur.hackathon.medicine.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String treatment; //Рекомендации лечения. При сохранении сохраняется в завершенный (новый) прием
    private String complaint; //Жалобы пациента. При сохранении сохраняется в завершенный (новый)  прием

    @Enumerated(EnumType.STRING)
    private DiseaseStatus diseaseStatus;
    @OneToOne
    private Client client;
    @OneToOne
    private Doctor doctor;
    @OneToOne
    private MedicalFacility medicalFacility;
    @OneToOne
    private Criteria criteria;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reception> receptions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PatientCriteriaCheckListRelation> checkList; //Здесь хранятся отчеты по проделанным процедурам


    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Disease that = (Disease) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2051386866;
    }
}
